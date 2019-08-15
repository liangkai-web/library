<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<title>首页</title>
<style type="text/css">
*{padding: 0;margin: 0;}
body{
   height: 100vh;
   background:url("${pageContext.request.contextPath}/imgs/library_1.jpg") no-repeat center;
   background-size: cover;
   overflow-y:hidden;
   overflow-x:hidden;
   align:center;
 }
 .scroll_title{
   width:60%;
   height:80px;
   position:absolute;
   text-align:center;
   top:15%;
   left:50%;
   transform: translate(-50%, -50%);
 }
.login_div{
  width:260px;
  background-color:#ccc;
  background-color:rgba(189,201,214,0.8);
  border-radius:5px;
  position:absolute;
  padding:10px 0;
  top:50%;
  left:50%;
  transform: translate(-50%, -80%);
}
.login_div table{
  width:230px;
  margin-left:15px;
}
.reg_div{
  width:260px;
  text-align:center;
}
table caption{
  font-size:25px;
  margin-bottom:10px;
}
table tr td{
  height:30px;
  line-height:30px;
}
#submit{
  height:30px;
  width:80%;
  font-size:15px;
  margin:10px 0 10px 26px;
  border-radius:5px;
  border:solid 1px;
}

</style>
</head>
<body>
	<div class="scroll_title">
		<h1>欢迎使用丢雷劳模图书管理系统 请先登陆系统</h1>
	</div>
	<div class="login_div">
		<form name="form" method="post"
			action="${pageContext.request.contextPath}/user/validateUser">
			<table>
				<caption>用户登陆</caption>
				<tr>
					<td class="reg_t"><label>用户名：</label></td>
					<td><input type="text" name="username" required="required" /></td>
				</tr>
				<tr>
					<td class="reg_t"><label>密码：</label></td>
					<td><input type="password" name="password"></td>
				</tr>


			</table>
			<input id="submit" type="submit" value="登录"><br>
            

			<div class="reg_div">
			    <div  id="tip_m" style="color:red;">${msg }</div>
				<span>若您是新用户点击<a href="${pageContext.request.contextPath}/user/showReg">这里</a>注册</span><br>
				<span style="font-size:10px"><a href="${pageContext.request.contextPath}/user/showxgPwd">修改密码</a></span>
			</div>
		</form>
	</div>
<script type="text/javascript">
  setTimeout("$('#tip_m').empty()", 1500 ); 
</script>
</body>
</html>