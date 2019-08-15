<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin.css" />
<title>删除图书</title>
<style type="text/css">
body{  
   background:url("${pageContext.request.contextPath}/imgs/caption_1.jpg") repeat center;
}
</style>
</head>
<body>
	<div class="admin_div">
		<form action="${pageContext.request.contextPath}/bookadmin/deleteBook"
			method="post">
			<div class="form_div">
				<table>
					<caption>
						<font size="5px;">删除图书</font>
					</caption>
					<tr>
						<td class="adm_t">图书id：</td>
						<td><input type="text" name="bid" required="required" /></td>
					</tr>

				</table>
				<div class="adm_btn">
					<input type="submit" id="submit" value="删除" />
				</div>
				<span class="msg_t">${msg}</span>
			</div>
		</form>
	</div>
</body>
</html>