<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看日志</title>
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<style type="text/css">
body{  
   background:url("${pageContext.request.contextPath}/imgs/caption_1.jpg") repeat center;
}
#query_blog{
   width:650px;; 
   margin:0 auto;
}
.table_query{
  width:100%;
  text-align: center;
  background-color:rgba(207,207,207,0.5);
}
.result_div{
  width:650px;
  margin:0 auto;
}
#show_blogList tr th,#show_blogList tr td{
  border:1px solid white;
}
.table_blog{
  width:100%;
  text-align: center;
  background-color:rgba(207,207,207,0.5);
}
</style>
</head>
<body>
	<div id="query_blog">
	<form id="form1" name="form1" action="${pageContext.request.contextPath}/bookadmin/searchLog" method="post">
		<table id="query_tj" class="table_query">
		    <caption><font size="5px">查看日志信息</font></caption>
		    <tr>
				<td>用户id:</td>
				<td><input type="number" id="inuid" name="puid" value="${page.puid}" /></td>
				<td>图书id:</td>
				<td><input type="number" id="inbid" name="pbid" value="${page.pbid}" /></td>
				<td>类型:</td>
				<td><select name="pbtype">
						<option value="0">全部</option>
						<option value="1">借阅</option>
						<option value="2">归还</option>
				</select></td>
				<td><input type="submit" name="query" value="查询"></td>
			</tr>
		</table>
	</form>
	</div>
	<div class="result_div">
		<table id="show_blogList" class="table_blog"
			style="table-layout: fixed;">
			<tr>
				<th align="center">用户名</th>
				<th align="center">书名</th>
				<th align="center">操作</th>
				<th align="center">时间</th>
			</tr>
			<c:forEach items="${bllist}" var="bl">
				<tr>
					<td align="center">${bl.user.username}</td>
					<td align="center">${bl.book.bname}</td>
					<td align="center"><c:if test="${bl.btype==1}">借阅</c:if>
						<c:if test="${bl.btype==2}">归还</c:if></td>
					<td align="center"><fmt:formatDate value="${bl.time}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>
			</c:forEach>
		</table>
		<div style="text-align:center;margin:10px 0;">
		<span style="background-color:rgba(207,207,207,0.5);">
		<label>第${page.currentPage}/${page.totalPage}页 共${page.totalRows}条</label>
		<a href="${pageContext.request.contextPath}/bookadmin/searchLog?currentPage=0">首页</a>
        <a href="${pageContext.request.contextPath}/bookadmin/searchLog?currentPage=${page.currentPage-1}" onclick="return checkFirst()">上一页</a>
        <a href="${pageContext.request.contextPath}/bookadmin/searchLog?currentPage=${page.currentPage+1}" onclick="return checkNext()">下一页</a>
        <a href="${pageContext.request.contextPath}/bookadmin/searchLog?currentPage=${page.totalPage}">尾页</a>
              跳转到: <input type="text" style="width: 30px" id="turnPage" />页 
           <input type="button" onclick="startTurn()" value="跳转" />
           </span>
           </div>
	</div>
<script type="text/javascript">

 function checkFirst(){
	if(${page.currentPage>1}){
		return true;
	}
    alert("已到页首,无法加载更多");
   
  return false;
}


function checkNext(){
    
	if(${page.currentPage<page.totalPage}){
		return true;
	}
    alert("已到页尾，无法加载更多页");
    return false;
    
    }
 function startTurn(){
    
    var turnPage=document.getElementById("turnPage").value;
    
    if(${page.totalPage}<turnPage){
    
      alert("对不起已超过最大页数");
      return false;
    }
    
    var shref="${pageContext.request.contextPath}/bookadmin/searchLog?currentPage="+turnPage;
    
    window.location.href=shref;
}
</script>
</body>
</html>