<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
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
  <%-- 这里不写action，则默认调用调用此页面的方法的POST方式 --%>
    <f:form method="post" modelAttribute="user" action="user/add1">
    	id:<f:input path="id"/><f:errors path="id"></f:errors><br>
    	name:<f:input path="name"/><f:errors path="name"></f:errors><br>
    	pwd:<f:input path="pwd"/><f:errors path="pwd"></f:errors><br>
    	<input type="submit" value="提交">
    </f:form>
  </body>
</html>
