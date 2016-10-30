<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" isErrorPage="true"%><%
String contextPath = request.getContextPath();
if(contextPath.equals("/")){
	contextPath = "";
}
%><html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN" xml:lang="zh-CN">
<head>
	<!-- HTTP 1.1 -->
	<meta http-equiv="Cache-Control" content="no-store"/>
	<!-- HTTP 1.0 -->
	<meta http-equiv="Pragma" content="no-cache"/>
	<!-- Prevents caching at the Proxy Server -->
	<meta http-equiv="Expires" content="0"/>
	<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=utf-8" />
	<meta http-equiv="Content-Language" content="zh-CN" />
	<link href="<%=contextPath %>/css/style.css" rel="stylesheet" type="text/css" />
	<title>The server error 500</title>
</head>
<body>
<div id="header">
  <dl id="globalnav">
		<dt id="smarblog-logo"><a href="/">返回首页(Return Home)</a></dt>
		<dd id="account-menu">
		</dd>
	</dl>
</div>

<div id="content">
	<div class="clear"></div>
	<div>
		<div id="container">
	<div id="main">
      <div class="centerblock">
		<p>您好！页面出错了，请检查原因</p>
		</div>
     </div>
		</div>
	</div>
</div>
<div id="footer">
	<dl id="bottomnav">
		<dd id="bottom-menu">
			<ul class="menu">
				<li><a href="/">首页(Home)</a></li>
			</ul>
		</dd>
		<dt id="copyright">
		</dt>
	</dl>
</div>
</body>
</html>