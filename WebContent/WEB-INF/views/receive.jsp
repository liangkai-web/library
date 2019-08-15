<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin.css" />
<title>收取欠款</title>
<style type="text/css">
body{  
   background:url("${pageContext.request.contextPath}/imgs/caption_1.jpg") repeat center;
}
</style>
</head>
<body>
	<div class="admin_div">
		<form action="${pageContext.request.contextPath}/bookadmin/selectfine"
			method="post">
			<div class="form_div">
				<table>
					<tr>
						<td><strong>查欠款金额：</strong></td>
						<td></td>
					</tr>
					<tr>
						<td class="adm_t">用户id：</td>
						<td><input type="text" name="uid" required="required"
							value="${uid}" /></td>
					</tr>
				</table>
				<div class="adm_btn">
					<input type="submit" id="submit" value="查询" />
				</div>
				<span class="msg_t">${msg}</span>
			</div>
		</form>
		<br> <br>
		<form action="${pageContext.request.contextPath}/bookadmin/receive"
			method="post">
			<div class="form_div">
				<table>
					<tr>
						<td><strong>&nbsp;缴纳欠款：</strong></td>
						<td></td>
					</tr>
					<tr>
						<td class="adm_t">用户id：</td>
						<td><input type="text" name="uid2" required="required" /></td>
					</tr>
					<tr>
						<td class="adm_t">输入金额：</td>
						<td><input type="text" name="fine" required="required" /></td>
					</tr>
				</table>
				<div class="adm_btn">
					<input type="submit" id="submit" value="提交" />
				</div>
				<span class="msg_t">${msg2}</span>
			</div>
		</form>
	</div>
</body>
</html>