<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>

	<div align="center">
		<table border="1">
			<tr>
				<td>用户名</td>
				<td>真实名</td>
			</tr>
			<s:iterator value="userList">
			<tr>
				<td>${userName }</td>
				<td>${realName }</td>
			</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>