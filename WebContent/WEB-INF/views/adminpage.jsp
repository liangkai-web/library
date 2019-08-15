<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>系统管理员首页</title>
</head>
<frameset rows="80,*">
    <frame src="${pageContext.request.contextPath }/granduser/frmtop" name="adminfrmtop" scrolling="no" noresize="noresize" id="adminfrmtop"/>
    <frameset cols="25%,*">
        <frame src="${pageContext.request.contextPath }/granduser/frmleft" name="adminfrmleft" scrolling="1" scrolling="no" id="adminfrmleft" />
        <frame src="${pageContext.request.contextPath }/granduser/frmcon" name="adminfrmcontent"scrolling="1" noresize="noresize" id="adminfrmcontent" />
    </frameset>
</frameset>
</html>