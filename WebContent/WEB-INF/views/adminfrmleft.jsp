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
  height:40px;
  line-height:40px;
  margin:50px 0;
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
       <a href="${pageContext.request.contextPath }/granduser/add" target="adminfrmcontent">添加各类型用户</a>
       </li>
       <li>
       <a href="${pageContext.request.contextPath }/granduser/up" target="adminfrmcontent">修改用户有效性</a>
       </li>
       <li>
       <a href="${pageContext.request.contextPath }/granduser/can" target="adminfrmcontent">修改默认可借数</a>
       </li>
       <li>
       <a href="${pageContext.request.contextPath}/login.jsp" target="_parent">注销登陆</a>
       </li>
    </ul>
</body>
</html>