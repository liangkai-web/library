<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin.css" />
<title>添加书类</title>
<style type="text/css">
body{  
   background:url("${pageContext.request.contextPath}/imgs/caption_1.jpg") repeat center;
}
</style>
</head>
<body>
<div class="admin_div">
	<form action="${pageContext.request.contextPath}/bookadmin/addBookType"
		method="post">
		<div class="form_div">
		<table>
			<caption><font size="6px;">添加书类</font></caption>
			<tr>
				<td class="adm_t">书类名：</td>
				<td><input type="text" name="typename" required="required" /></td>
			</tr>
		</table>
		<div class="adm_btn">
		    <input type="submit" id="submit" value="添加" />
		</div>
		</div>
	</form>
	<span class="msg_t">${msg}</span>
</div>
</body>
</html>