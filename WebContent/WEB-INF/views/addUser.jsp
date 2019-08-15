<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin.css" />
<title>添加用户</title>
<style type="text/css">
body{  
   background:url("${pageContext.request.contextPath}/imgs/caption_1.jpg") repeat center;
}
</style>
</head>
<body>
	<div class="admin_div">
		<form method="post"
			action="${pageContext.request.contextPath}/granduser/addUser">
			<div class="form_div" style="padding-left:0;">
				<table>
					<caption>
						<font size="6px;">添加新用户</font>
					</caption>
					<tr>
						<td class="adm_t"><label>登录名：</label></td>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<td class="adm_t"><label>密码：</label></td>
						<td><input type="password" name="password" id="password"></td>
					</tr>
					<tr>
						<td class="adm_t">请确认密码：</td>
						<td><input type="password" name="userpassword"
							id="newpassword"></td>
					</tr>
					<tr>
						<td class="adm_t"><label>手机号：</label></td>
						<td><input type="text" name="phone"></td>
					</tr>
					<tr>
						<td class="adm_t"><label>类型：</label></td>
						<td><select id="type" name="type">
								<option value="2">1.图书管理员</option>
								<option value="3">2.普通用户</option>
						</select></td>
					</tr>
				</table>
				<div class="adm_btn">
					<input type="submit" id="submit" value="注册"
						onclick="return check();">
				</div>
				<span class="msg_t">${msg}</span>
			</div>
		</form>
	</div>
	<script language="javascript">
		function check() {
			var password = document.getElementById("password").value;
			var newpassword = document.getElementById("newpassword").value;

			if (password != newpassword) {
				alert("密码不一致");
				return false;
			} else if (password.length == 0 || newpassword.length == 0) {
				alert("密码不能为空");
				return false;
			} else {
				return true;
			}
		}
	</script>
</body>
</html>