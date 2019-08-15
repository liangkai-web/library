<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<title>注册页面</title>
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
  width:270px;
  background-color:#ccc;
  background-color:rgba(189,201,214,0.8);
  border-radius:5px;
  padding:10px 0;
  position:absolute;
  top:50%;
  left:50%;
  transform: translate(-50%, -80%);
}
.login_div table{
  width:250px;
  margin:0 5px;
}

table caption{
  font-size:25px;
}
table tr td{
  height:30px;
  line-height:30px;
}
.reg_t{
  text-align:right;
}
.reg_btns{
  height:25px;
  width:100%;
  text-align:center;
}
.reg_btn{
  width:60px;
  border-radius: 5px;
}
</style>
</head>

<body>
	<div class="scroll_title">
		<h1>欢迎使用丢雷劳模图书管理系统</h1>
	</div>
	<div class="login_div">
		<form method="post"
			action="${pageContext.request.contextPath}/user/addUser">
			<table>
				<caption>
					<span>用户注册</span>
				</caption>
				<tr>
					<td class="reg_t"><label>登录名：</label></td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td class="reg_t"><label>密码：</label></td>
					<td><input type="password" name="password" id="password"></td>
				</tr>
				<tr>
					<td class="reg_t"><label>确认密码：</label></td>
					<td><input type="password" name="userpassword"
						id="newpassword"></td>
				</tr>
				<tr>
					<td class="reg_t"><label>手机号：</label></td>
					<td><input type="text" name="phone" maxlength="11"
						onkeyup="this.value=this.value.replace(/\D/g,'')"></td>
				</tr>

			</table>
			<div class="reg_btns">
			<input type="submit" class="reg_btn" value="注册" onclick="return check();">&nbsp;&nbsp;
            <input type="button" class="reg_btn" value="返回" onclick="javascrtpt:window.location.href='${pageContext.request.contextPath}/login.jsp'">
		    </div>
		</form>
		<div id="tip_m" style="text-align:center;color:red;">${msg}</div>
		
	</div>
<script language="javascript">
    setTimeout("$('#tip_m').empty()", 1500 );
	function check(){
		var password=document.getElementById("password").value;
		var newpassword=document.getElementById("newpassword").value;	
		if(password!=newpassword){
			alert("密码不一致");
			return false;
		}else if(password.length==0 || newpassword.length==0){
			alert("密码不能为空");
			return false;
		}
		else{
			return true;
		}
	}
</script>
</body>
</html>