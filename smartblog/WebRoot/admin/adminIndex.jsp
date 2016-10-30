<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<html>
  <head>
    <title><s:text name="admin.title"/></title>
    <link rel="stylesheet" type="text/css" media="all" href="../styles/simplicity/theme.css" />
    <link rel="stylesheet" type="text/css" media="print" href="../styles/simplicity/print.css" />
	<link rel="stylesheet" type="text/css" media="all" href="../styles/simplicity/layout-1col.css" />
	<script type="text/javascript" src="../js/prototype.js"></script>
	<script type="text/javascript" src="../js/admin.js"></script>
  </head>
<body>
    <div id="page">
		<%@ include file="adminHeader.jsp" %>
        <div id="content" class="clearfix">
            <div id="main">
				<p><s:text name=  "menu.main.message"/></p>
				<p id="check_up"></p>
				<div class="separator"></div>
				<ul class="glassList">
				    <li>
				        <a href="entryAction_getInputForm.action" title="<s:text name="menu.add.entry"/>" ><s:text name="menu.add.entry"/></a>
				    </li>
				    <li>
				    	<a href="listEntry.jsp" title="<s:text name="menu.entry.management"/>" ><s:text name="menu.entry.management"/></a>
				    </li>
				    
				</ul>
            </div>
		 <jsp:include page="adminMenu.jsp" flush="true"/>
        </div>
        <%@ include file="adminFooter.jsp" %>
        </div>
    </div>
<script type="text/javascript">
window.onload = function (){
	  	var url = 'up.jspx';
		var pars = 'up=1';
		var target = 'check_up';
		var myAjax = new Ajax.Updater(target, url, {method: 'get',	parameters: pars, evalScripts: 'yes'});
        /* Initialize menus for IE */
        if ($("primary-nav")) {
            var navItems = $("primary-nav").getElementsByTagName("li");
        
            for (var i=0; i<navItems.length; i++) {
                if (navItems[i].className == "menubar") {
                    navItems[i].onmouseover=function() { this.className += " over"; }
                    navItems[i].onmouseout=function() { this.className = "menubar"; }
                }
            }
        }
}
</script>
</body>
</html>
