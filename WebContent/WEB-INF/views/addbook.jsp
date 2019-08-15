<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin.css" />
<title>添加图书</title>
<style type="text/css">
body{  
   background:url("${pageContext.request.contextPath}/imgs/caption_1.jpg") repeat center;
}
</style>
</head>
<body>
	<div class="admin_div" style="width: 400px; height: 400px;">
		<form action="${pageContext.request.contextPath}/bookadmin/addBook"
			method="post" enctype="multipart/form-data">
			<div class="form_div">
				<table>
					<caption>
						<font size="6px;">添加图书</font>
					</caption>
					<tr>
						<td class="adm_t">图书封面：</td>
						<td><input type="file" name="image" accept="image/*" /><br></td>
					</tr>
					<tr>
						<td class="adm_t">图书名：</td>
						<td><input type="text" name="bname" required="required" /><br></td>
					</tr>
					<tr>
						<td class="adm_t">图书类型：</td>
						<td><select name="item.typeid">
								<c:forEach items="${btlist}" var="btl">
									<option value="${btl.typeid}">${btl.typename}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td class="adm_t">简介：</td>
						<td><textarea name="item.description" rows="5" cols="20"></textarea></td>
					</tr>
					<tr>
						<td class="adm_t">作者：</td>
						<td><input type="text" name="item.author" />
					</tr>
					<tr>
						<td class="adm_t">出版社：</td>
						<td><input type="text" name="item.publish" />
					</tr>
				</table>
				<div class="adm_btn">
					<input type="submit" id="submit" value="添加" />
				</div>
				<span class="msg_t">${msg}</span>
			</div>
		</form>
	</div>
</body>
</html>