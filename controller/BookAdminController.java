package com.controller;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pojo.Blog;
import com.pojo.BMapper;
import com.pojo.Book;
import com.pojo.BookType;
import com.pojo.Item;
import com.pojo.Page;
import com.pojo.User;
import com.service.BMapperService;
import com.service.BlogService;
import com.service.BookService;
import com.service.BookTypeService;
import com.service.ItemService;
import com.service.UserService;

@Controller
@RequestMapping("/bookadmin")
public class BookAdminController {
	
	@Autowired
	private BookTypeService btService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BlogService blService;
	
	@Autowired
	private BMapperService bmService;
	
	//登录主页
	@RequestMapping("/index")
	public String showIndex(HttpSession session) {
		session.invalidate();
		return "forward:/login.jsp";
	}
	
	//显示图书管理员首页
	@RequestMapping("/badminpage")
	public String showMenu2() {
		return "bookadminpage";
	}
	
	@RequestMapping("/showMenu")
	public String showMenu() {
		return "bookadminmenu";
	}
	@RequestMapping("/frmcon")
	public String showfrmCon() {
		return "bfrmcon";
	}
	
	//显示添加书类页面
	@RequestMapping("/showAddType")
	public String showAddType() {
		return "addtype";
	}
	
	//显示添加图书页面
	@RequestMapping("/showAddBook")
	public ModelAndView showAddBook() {
		ModelAndView mav = new ModelAndView();
		List<BookType> btList = btService.getBookTypeList();
		mav.addObject("btlist", btList);
		mav.setViewName("addbook");
		return mav;
	}

	//显示删除图书页面
	@RequestMapping("/showDeleteBook")
	public String showDeleteBook() {
		return "deletebook";
	}
	
	//显示收取欠款页面
	@RequestMapping("/showReceive")
	public String showReceive() {
		return "receive";
	}
	
	//显示归还图书页面
	@RequestMapping("/showReturnBook")
	public String showReturnBook() {
		return "returnbook";
	}
	
	//显示借阅日志
	@RequestMapping("/showLog")
	public String showLog() {
		return "showlog";
	}
	
	//添加书类
	@RequestMapping("/addBookType")
	public ModelAndView addBookType(@RequestParam("typename")String typename){
		ModelAndView mav = new ModelAndView();
		Map<String,Object> map = new HashMap<String,Object>();
		BookType booktype = new BookType();
		booktype.setTypename(typename);
		if(btService.getBookType(booktype)!=null) {
			mav.addObject("msg", "该书类已存在");
			mav.setViewName("addtype");
			return mav;	
		}
		map.put("typename", typename);
		btService.addBookType(map);
		mav.addObject("msg","添加成功");
		mav.setViewName("addtype");
		return mav;
	}
	
	//添加图书
	@RequestMapping("/addBook")
	public String addBook(Book book,@RequestParam("image")MultipartFile image,Model model) {
		
		Item item = new Item();
		item.setIname(book.getBname());
		if(itemService.getItem(item)==null) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("iname", book.getBname());
			map.put("typeid",book.getItem().getTypeid());
			map.put("description", book.getItem().getDescription());
			map.put("author", book.getItem().getAuthor());
			map.put("publish", book.getItem().getPublish());
			map.put("jcnum", 0);
			map.put("kcnum", 0);
			itemService.addItem(map);
		}
		Map<String,Object> map2 = new HashMap<String,Object>();
		Map<String,Object> map3 = new HashMap<String,Object>();
		map2.put("bname", book.getBname());
		map2.put("itemid", itemService.getItem(item).getItemid());
		map2.put("rktime", new Date());
		map2.put("status", 0);//设置图书状态，1为已借出，0为未借出
		bookService.addBook(map2);
		map3.put("itemid", itemService.getItem(item).getItemid());
		map3.put("kcnum", itemService.getItem(item).getKcnum()+1);
		itemService.updateItem(map3);
		File targetFile = new File("d:/image",book.getBname()+".jpg");
		if(!targetFile.exists()) {
			targetFile.mkdirs();
		}
		try {
			if(image.getSize()!=0) {
				image.transferTo(targetFile);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("msg", "添加成功");
		return "addbook";
	}
	
	//删除图书
	@RequestMapping("/deleteBook")
	public ModelAndView deleteBook(@RequestParam("bid")int bid) {
		ModelAndView mav = new ModelAndView();
		Book book = new Book();
		book.setBid(bid);
		if(bookService.getBook(book)==null) {
			mav.addObject("msg","请输入正确的图书编号");
			mav.setViewName("deletebook");
			return mav;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> map2 = new HashMap<String,Object>();
		map.put("bid", bid);
		int itemid = bookService.getBook(book).getItemid();
		Item item = new Item();
		item.setItemid(itemid);
		map2.put("itemid", itemid);
		map2.put("kcnum", itemService.getItem(item).getKcnum()-1);
		itemService.updateItem(map2);
		bookService.deleteBook(map);
		mav.addObject("msg","删除成功");
		mav.setViewName("deletebook");
		return mav;
	}
	
	//归还图书
	@RequestMapping("/returnBook")
	public ModelAndView returnBook(@RequestParam("bid")int bid) {
		ModelAndView mav = new ModelAndView();
		Book book = new Book();
		User user = new User();
		Item item = new Item();
		BMapper bmapper = new BMapper();
		Map<String,Object> map = new HashMap<String,Object>();//bmapper
		Map<String,Object> blmap = new HashMap<String,Object>();//blog
		Map<String,Object> umap = new HashMap<String,Object>();//user
		Map<String,Object> bmap = new HashMap<String,Object>();//book
		Map<String,Object> imap = new HashMap<String,Object>();//item
		book.setBid(bid);
		bmapper.setBid(bid);
		//如果图书状态为未借出或找不到该图书，提示输入正确的图书id
		if(bookService.getBook(book)==null||bookService.getBook(book).getStatus()==0) {
			mav.addObject("msg","输入正确的图书编号");
			mav.setViewName("returnbook");
			return mav;
		}
		user.setUid(bmService.getBMapper(bmapper).getUid());
		//查询图书是否超期，并计算罚款，假设罚款一天0.1元
		Date now = new Date();
		Date deadline = bmService.getBMapper(bmapper).getDeadline();
		if(now.after(deadline)) {
			Calendar past = Calendar.getInstance();
			Calendar present = Calendar.getInstance();
			past.setTime(deadline);
			present.setTime(now);
			int i;
			for(i=1;;i++) {
				past.add(Calendar.DAY_OF_YEAR, 1);
				if(past.after(present)) {
					break;
				}
			}
			float fine = i*0.1f;
			umap.put("fine",userService.getUser2(user).getFine()+fine);
		}
		map.put("bid", bid);
		bmService.deleteBMapper(map);
		item.setItemid(bookService.getBook(book).getItemid());
		imap.put("itemid", bookService.getBook(book).getItemid());
		imap.put("kcnum", itemService.getItem(item).getKcnum()+1);
		itemService.updateItem(imap);
		bmap.put("bid", bid);
		bmap.put("status", 0);
		bookService.updateBook(bmap);
		umap.put("uid", user.getUid());
		umap.put("yjnum", userService.getUser2(user).getYjnum()-1);
		userService.updateUser3(umap);
		blmap.put("uid", user.getUid());
		blmap.put("bid", bid);
		blmap.put("btype", 2);
		blmap.put("time", new Date());
		blService.addBLog(blmap);
		mav.addObject("msg","归还成功");
		mav.setViewName("returnbook");
		return mav;
	}
	
	//查询欠款金额
	@RequestMapping("/selectfine")
	public ModelAndView selectFine(@RequestParam("uid")int uid) {
		ModelAndView mav = new ModelAndView();
		User user = new User();
		user.setUid(uid);
		if(userService.getUser2(user)==null) {
			mav.addObject("msg", "用户不存在");
			mav.setViewName("receive");
			return mav;
		}
		float fine = userService.getUser2(user).getFine();
		if(fine<=0) {
			fine = 0;
		}
		mav.addObject("uid", uid);
		mav.addObject("msg","欠款金额为："+fine+"元");
		mav.setViewName("receive");
		return mav;
	}
	//收取欠款
	@RequestMapping("/receive")
	public ModelAndView receive(@RequestParam("uid2")int uid,@RequestParam("fine")float fine) {
		ModelAndView mav = new ModelAndView();
		User user = new User();
		user.setUid(uid);
		if(userService.getUser2(user)==null) {
			mav.addObject("msg2", "用户不存在");
			mav.setViewName("receive");
			return mav;
		}
		if(userService.getUser2(user).getFine()<=0) {
			mav.addObject("msg2", "用户未欠款");
			mav.setViewName("receive");
			return mav;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("uid", uid);
		map.put("fine", userService.getUser2(user).getFine()-fine);
		userService.updateUser3(map);
		mav.addObject("msg2", "欠款缴纳成功");
		mav.setViewName("receive");
		return mav;
	}
	
	//查询日志
	@RequestMapping("searchLog")
	public ModelAndView searchLog(Page page) {
		ModelAndView mav = new ModelAndView();
		Page p = page;
		int pageSize=4;
		p.setPageSize(pageSize);
		int curPage=p.getCurrentPage();
		if (curPage==0) {
            curPage=1;
            p.setCurrentPage(curPage);
        }
		int startRow =page.getStartRow();
		if (!(p.getCurrentPage()==0)) {
            startRow = getStartRowBycurrentPage(curPage, pageSize);
        }
		p.setStartRow(startRow);
		
		List<Blog> blogList = blService.getBLogList(page);
		
		Integer totalCounts = blService.searchTotalCount(page);//总条数
		
		int totalPages=(totalCounts%pageSize==0)?(totalCounts/pageSize):(totalCounts/pageSize+1);//总页数=总条数/页大小+1
        
		p.setTotalPage(totalPages);//总页数
		
		page.setTotalRows(totalCounts);//总行数
		
		mav.addObject("page",page);
		mav.addObject("bllist",blogList);
		mav.setViewName("showlog");
		return mav;		
	}
	
	//根据当前页获取开始行
   public int getStartRowBycurrentPage(int currentPage,int pageSize){
        
        int startRow=0;
        
        if (currentPage==1) {
            
            return startRow=0;
        }
        
        startRow=(currentPage-1)*pageSize;
        
        return startRow;
        
    }


}

