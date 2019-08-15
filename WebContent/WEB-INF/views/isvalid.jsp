<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin.css" />
<title>修改用户有效性</title>
<style type="text/css">
body{
   background:url("${pageContext.request.contextPath}/imgs/caption_1.jpg") repeat center;
}
</style>
</head>
<body>
	<div class="admin_div">
		<form name="isvalid"
			action="${pageContext.request.contextPath}/granduser/updateUser"
			method="post">
			<div class="form_div">
				<table>
					<tr>
						<td class="adm_t">用户名：</td>
						<td><input type="text" name="username" /></td>
					</tr>
					<tr>
						<td class="adm_t">有效性：</td>
						<td><select id="isvalid" name="isvalid">
								<option value="0">0.用户无效</option>
								<option value="1">1.用户有效</option>
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
</html>