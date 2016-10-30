<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=path %>/static/css/common.css">
  </head>
  
  <body>
  Welcome：${sessionScope.currentUser.name }
  <hr>
  ====用户列表====<br>
    <c:forEach items="${userList }" var="ul">
    <%--这个userList是一个map，不是list，应该先取value --%>
    key:${ul.key}<br>
    <a href="user/view/${ul.value.id}">name: ${ul.value.name }</a>
   <br>
   pwd:${ul.value.pwd }<br>
   <a href="user/update/${ul.value.id}">修改</a><br><!-- 这里的id传到了update页面 -->
   <a href="user/delete/${ul.value.id}">删除</a><br>
   ------------------------------<br>
    </c:forEach>
    <a href="user/add">add</a>
  </body>
</html>
