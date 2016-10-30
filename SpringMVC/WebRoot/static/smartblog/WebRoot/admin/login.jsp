<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title><s:text name="form.login"/></title>
    <link rel="stylesheet" type="text/css" media="all" href="../styles/simplicity/theme.css" />
    <link rel="stylesheet" type="text/css" media="print" href="../styles/simplicity/print.css" />
	<link rel="stylesheet" type="text/css" media="all" href="../styles/simplicity/layout-1col.css" />
	<script type="text/javascript" src="../js/prototype.js"></script>
  </head>
<body id="login">
    <div id="page">
        <%@ include file="adminHeader.jsp" %>
        <s:if test="hasFieldErrors()">
        	<div class="error" id="errorMessage">
        		<s:iterator value="fieldErrors">
        			<s:iterator value="value"><s:property escape="false"/><br/></s:iterator>
        		</s:iterator>
        		
        	</div>
        </s:if>
        <s:if test="hasActionErrors()">
        	<div class="error" id="errorMessage">
        		<s:iterator value="actionErrors">
        			<s:property escape="false"/><br/>
        		</s:iterator>
        	</div>
        </s:if>
        
    <div id="content" class="clearfix">
    	<div id="main">
             <h1><s:text name="menu.login"/></h1>
         <form method="post" id="loginForm" action="userAction_checkLogin.action">
         
			<fieldset>
			<ul>
			    <li>
			       <label for="username" class="desc"> <s:text name="login.username"/> <span class="req">*</span></label>
			        <input type="text" class="text medium" name="username" id="username" tabindex="1" value=""/>
			    </li>
			    <li>
			        <label for="password" class="desc"> <s:text name="login.password"/> <span class="req">*</span></label>
			        <input type="password" class="text medium" name="password" id="password" tabindex="2" value=""/>
			    </li>
			    <li>
			    	<label for="code" class="desc"><s:text name="login.code"/> <span class="req">*</span>
						<img src="<%=request.getContextPath() %>/identifyingCode" alt="Identifying Code" onclick="this.src='<%=request.getContextPath() %>/identifyingCode?now=' + new Date().getTime()" />
			        </label>
			        <input type="text" class="text medium" name="code" id="code" tabindex="3" />
			    </li>
			    <li>
			        <input type="checkbox" class="checkbox" name="rememberme" id="rememberme" value="forever" tabindex="4"/>
			        <label for="rememberMe" class="choice"><s:text name="login.remember"/></label>
			    </li>
			    <li>
			        <input type="submit" class="button" name="login" value="<s:text name="login.submit"/>" tabindex="5" />
			    </li>
			</ul>
			</fieldset>
		</form>
        </div>
        </div>
        <%@ include file="adminFooter.jsp" %>
    </div>
</html>
