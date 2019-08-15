<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/upage.css" />
<title>用户首页</title>
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<style type="text/css">
body{
  height: 100vh;
  background:url(${pageContext.request.contextPath}/imgs/upage_1.jpg) no-repeat center;
  background-size: cover;
  overflow-y:hidden;
  overflow-x:hidden;
}

</style>
</head>
<body>
	<div class="user_top">
		<h1>您好${sessionScope.user.username}!!欢迎使用图书管理系统！！</h1>
	</div>
	<hr>
	<div class="history_link">
		<a href="javascript:history(${sessionScope.user.uid})">历史借书记录</a> 
		<a href="${pageContext.request.contextPath}/login.jsp">注销登陆</a>
	</div>
	<div id="query_book">
		<form id="querybook_form" submit="return false" action="##"
			method="post">
			<table id="query_tj" class="table_query">
				<tr>
					<td>书类：</td>
					<td><select name="typeid" id="typeid" class="quer_sr">
							<c:forEach var="booktype" items="${requestScope.btList}">
								<option value="${booktype.typeid}">${booktype.typename}</option>
							</c:forEach>
					</select></td>
					<td>书目名:</td>
					<td><input type="text" name="iname" id="iname" class="quer_sr" /></td>
					<td>作者关键字:</td>
					<td><input type="text" name="author" id="author"
						class="quer_sr" /></td>
					<td><input type="button" value="查询" onclick="query_Book()"></td>
				</tr>
			</table>
		</form>
	</div>
	<div  id="tip_m">${msg}</div>
	<div id="q_msg" style="visibility: hidden;"><span id="qmsg" style="background-color:rgba(207,207,207,0.5);"></span></div>
	<div id="query_result" class="result_div" style="display:none">
		<table id="show_bookList" class="table_query" style="table-layout: fixed;">
			<thead>
				<tr>
					<th>书类</th>
					<th>书目名</th>
					<th>作者</th>
					<th>出版社</th>
					<th>库存量</th>
					<th></th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
	
	<!-- 查询个人历史借书记录 -->
	<div id="history_List" class="result_div" style="display:none">
	     <table id="show_historyList" class="table_query" style="table-layout: fixed;">
			<thead>
				<tr>
					<th>图书编号</th>
					<th>书名</th>
					<th>书籍状态</th>
					<th>时间</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
	<!-- 查看书目详情 -->
	<div id="det_book" style="display:none;">
		<div class="show_det" style="background-color:rgba(204,204,204,0.8);padding:10px;">
		<form name="itemInfo"
			action="${pageContext.request.contextPath}/item/updateItemNum"
			method="post">
			<span id="p_book"></span>
			<input type="hidden" name="uid"
					value="${sessionScope.user.uid }">
			<input type="hidden" name="yjnum"
					value="${sessionScope.user.yjnum}">
			<input type="hidden" name="kjnum"
					value="${sessionScope.user.kjnum}">
		    <input type="hidden" name="fine"
					value="${sessionScope.user.fine}">		
			<table style="display: inline-block; width: 80%; word-wrap: break-word; white-space: normal">
				<tbody></tbody>
			</table>
			<div class="det_btn_div">
			<input type="submit" class="det_btn" value="借出 ">&nbsp;&nbsp;
			<input type="button" class="det_btn" value="关闭" onclick="close_det()">
		    </div>
		</form>
		</div>
	</div>
	<script type="text/javascript">
	setTimeout("$('#tip_m').empty()", 1500 );
    var msg = document.getElementById("qmsg");
    var qbList = document.getElementById("query_result");
    var qhList = document.getElementById("history_List");
    var bDetail = document.getElementById("det_book");
    
	function query_Book() {
		window.event.returnValue = false;
		msg.style.visibility = "hidden";
		qhList.style.display="none";
		qbList.style.display = "block";
		$("#show_bookList tbody").empty();
		var typeid = $("#typeid").val();
		var iname = $("#iname").val();
		var author = $("#author").val();
		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath}/user/queryBook",
			data : {
				"typeid" : typeid,
				"iname" : iname,
				"author" : author
			},
			dataType : "json",
			success : function(data) {

				if (data.length == 0) {
                    msg.innerHTML="未查询到相关书籍";
					msg.style.visibility = "visible";
				} else {
					$.each(data, function(index, item) {
						var typename = $("<td></td>").append(
								item.booktype.typename);
						var iname = $("<td></td>").append(item.iname);
						var author = $("<td></td>").append(item.author);
						var publish = $("<td></td>").append(item.publish);
						var kcnum = $("<td></td>").append(item.kcnum);
						var btn1 = $(
								"<button onclick='show_detail(" +item.itemid
										+ ")'></button>").append("查看详情");
						var button = $("<td></td>").append(btn1);
						$("<tr></tr>").append(typename).append(iname).append(
								author).append(publish).append(kcnum).append(
								button).appendTo("#show_bookList tbody");
					});
				}

			},
			error : function(data) {
				console.log(data);
			}

		});

	}
	//查询历史个人历史借书记录
	function history(uid){
		$("#show_historyList tbody").empty();//再次进行记录查询之前清空内容
		msg.style.visibility = "hidden";
		qbList.style.display = "none";
		qhList.style.display="block";
		$.ajax({
			dataType:"json",
			type:"POST",
			url:"${pageContext.request.contextPath}/user/history",
			data:{"uid":uid},
			success:function(data){
				if (data.length == 0) {
					msg.innerHTML="您还未借阅过图书";
					msg.style.visibility = "visible";
				} else {
					$.each(data, function(index, blog) {
						var bid = $("<td></td>").append(
								blog.book.bid);
						var bookname = $("<td></td>").append(
								blog.book.bname);
						var type;
						if(blog.btype==1){
							type ="借阅中";
						}else{
							type ="已归还";
						}
						var btype = $("<td></td>").append(type);
						var time = $("<td></td>").append(blog.time);
						$("<tr></tr>").append(bid).append(bookname).append(btype).append(
								time).appendTo("#show_historyList tbody");
					});
				}

			},error:function(data){
				alert("fail")
			}
		});
		
	}


	function show_detail(itemid) {
		$.ajax({
			dataType:"json",
			type:"POST",
			url:"${pageContext.request.contextPath}/item/getItemInfo",
			data:{"itemid":itemid},
			success:function(data){
				$.each(data, function(index, item) {
					var itemid = $("<td></td>").append("<input type='hidden' name='itemid' value='"+item.itemid+"'>");
					var vkcnum = $("<td></td>").append("<input type='hidden' name='kcnum' value='"+item.kcnum+"'>");
					
					var iname = $("<td></td>").append("书名："+
							item.iname);
					var author = $("<td></td>").append("作者："+
							item.author);
					var typename = $("<td></td>").append("类型："+
							item.booktype.typename);
					var des = $("<td></td>").append("简介："+
							item.description);
					var publish = $("<td></td>").append("出版社："+
							item.publish);
					var kcnum = $("<td></td>").append("库存数量："+
							item.kcnum);
					$("#p_book").append("<img alt='图片加载失败' src='/files/"+item.iname+".jpg' height='200px' weight='130px' />");
					$("<tr></tr>").append(itemid).appendTo("#det_book tbody");
					$("<tr></tr>").append(vkcnum).appendTo("#det_book tbody");
					$("<tr></tr>").append(iname).appendTo("#det_book tbody");
					$("<tr></tr>").append(author).appendTo("#det_book tbody");
					$("<tr></tr>").append(typename).appendTo("#det_book tbody");
					$("<tr></tr>").append(des).appendTo("#det_book tbody");
					$("<tr></tr>").append(publish).appendTo("#det_book tbody");
					$("<tr></tr>").append(kcnum).appendTo("#det_book tbody");
				});
				bDetail.style.display="block";	
			},error:function(data){
				alert("fail")
			}
		});
	}
	function close_det(){
		bDetail.style.display="none";
		$("#det_book tbody").empty();
		$("#p_book").empty();
		
	}
</script>
</body>
</html>