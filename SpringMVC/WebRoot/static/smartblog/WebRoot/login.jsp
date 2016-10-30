<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form action="helloAction.action" method="post">
		<table border="1" align="center" width="400" cellpadding=6 cellspacing=0>
			<tr>
				<td colspan="2"><font size="12">登录图书管理系统</font></td>
			</tr>
			<tr>
				<td bgcolor="plum"><B>用户名： </B></td>
				<td><input type="text" name="userName" /></td>
			</tr>
			<tr>
				<td bgcolor="plum"><B>密码： </B></td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"  value="登录" /></td>
			</tr>
			<tr>
				<td colspan="2" ><b><font color="red"><s:property value="message"/></font></b></td>
			</tr>
		</table>
	</form>
  </body>
</html>
