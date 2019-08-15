<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
body{
    background-color:#4f8cc9;
    background:url("${pageContext.request.contextPath}/imgs/caption_1.jpg") repeat center;
}
div{
   height:60px;
   line-height: 80px;
   text-align: center;
}
</style>
</head>
<body>
<div><font size="5" color="black">您好${sessionScope.user.username}&nbsp;&nbsp;欢迎使用图书管理系统</font></div>
</body>
</html>