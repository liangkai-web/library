<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin.css" />
<title>修改默认可借数</title>
<style type="text/css">
body{
   background:url("${pageContext.request.contextPath}/imgs/caption_1.jpg") repeat center;
}
</style>
</head>
<body>
	<div class="admin_div">
		<form name="kjnum"
			action="${pageContext.request.contextPath}/granduser/cankj"
			method="post">
			<div class="form_div">
				<table>
					<tr>
						<td class="adm_t">用户名：</td>
						<td><input type="text" name="username" /></td>
					</tr>

					<tr>
						<td class="adm_t">用户等级：</td>
						<td><select id="kjnum" name="kjnum">
								<option value="5">普通用户(可借5本)</option>
								<option value="10">高级用户(可借10本)</option>
								<option value="100">超级用户(可借100本)</option>
						</select></td>
					</tr>
				</table>
				<div class="adm_btn">
					<input type="submit" id="submit" value="修改">
				</div>
				<span class="msg_t">${msg}</span>
			</div>
		</form>
	</div>
</body>
<ml>