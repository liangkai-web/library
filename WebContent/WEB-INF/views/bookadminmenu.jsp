<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理员首页</title>
<style type="text/css">
body{
   background-color:#4f8cc9;
   background:url("${pageContext.request.contextPath}/imgs/caption_1.jpg") repeat center;
}
a{
  text-decoration: none;
  color:#333;
  display:block;
  height:50px;
  width:100%;
}
ul{
  list-style:none;
  padding: 0;
  text-align:center;
}
ul li{
  height:50px;
  line-height:50px;
  margin:10px 0;
  font-size: 20px;

}
ul li:hover {
	background-color:#fff;
	color:black;
}
</style>
</head>
<body>
  <ul>
    <li>
       <a href="${pageContext.request.contextPath}/bookadmin/showAddType" target="adminfrmcontent">添加书类</a><br>
    </li>
    <li>
       <a href="${pageContext.request.contextPath}/bookadmin/showAddBook" target="adminfrmcontent">添加图书</a><br>
    </li>
    <li>
       <a href="${pageContext.request.contextPath}/bookadmin/showDeleteBook" target="adminfrmcontent">删除图书</a><br>
    </li>
    <li>
       <a href="${pageContext.request.contextPath}/bookadmin/showReturnBook" target="adminfrmcontent">归还图书</a><br>
    </li>
    <li>
       <a href="${pageContext.request.contextPath}/bookadmin/showReceive" target="adminfrmcontent">收取欠款</a><br>
    </li>
    <li>
       <a href="${pageContext.request.contextPath}/bookadmin/showLog" target="adminfrmcontent">查看日志</a><br>
    </li>
    <li>
       <a href="${pageContext.request.contextPath}/login.jsp" target="_parent">注销登陆</a>
    </li>
  </ul>
	
</body>
</html>