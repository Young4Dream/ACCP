<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<html>
  <head>
    <title><s:text name="admin.title"/></title>
    <link rel="stylesheet" type="text/css" media="all" href="../styles/simplicity/theme.css" />
    <link rel="stylesheet" type="text/css" media="print" href="../styles/simplicity/print.css" />
    <link rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath() %>/jscalendar/calendar-system.css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/jscalendar/calendar_stripped.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/jscalendar/calendar-setup_stripped.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/jscalendar/lang/calendar-en.js"></script>
	<script type="text/javascript" src="../js/prototype.js"></script>
	<script type="text/javascript" src="../js/admin.js"></script>
  </head>
<body>
    <div id="page">
	<%@ include file="adminHeader.jsp" %>
        <div id="content" class="clearfix">
            <div id="main">
                <h1><s:text name= "menu.add.entry"/></h1>
				<%@ include file="templateError.jsp" %>
<form id="entryForm" method="post" action="entryAction_addEntry.action">
<ul>
    <li class="buttonBar right">
    	<input type="hidden" name="save" value="save"/>
        <input type="submit" class="button" name="save" value="<s:text name= "button.save"/>"/>
        <input type="submit" class="button" name="publish" value="<s:text name= "button.publish"/>"/>
        <input type="button" class="button" name="return" onclick="javascript:location.href='adminIndex.jsp'" value="<s:text name= "label.return"/>">
    </li>
    <li>
        <label for="title" class="desc"><s:text name= "entry.title"/> <span class="req">*</span></label>
        <input id="title" name="title" class="text large" type="text" value=""/>
    </li>
    <li>
        <label for="tags" class="desc"><s:text name= "entry.tags"/></label>
        <input id="tags" name="tags" class="text large" type="text" value=""/>
    </li>
    <li>
        <label for="name" class="desc"><s:text name= "entry.name"/></label>
        <input id="name" name="name" class="text" type="text" value=""/>
        <label for="postTime"><s:text name= "entry.postTime"/></label>
        <input id="postTime" name="postTime" class="text" size="15" type="text" value=""/>
        <img id="img_postTime" alt="choose postTime" src="<%=request.getContextPath() %>/images/calendar.png"/>
<script type="text/javascript">
    Calendar.setup({
        inputField     :    "postTime",     // id of the input field
        ifFormat       :    "%Y-%m-%d %H:%M",
        button         :    "img_postTime",  // trigger for the calendar (button ID)
        singleClick    :    true,
        showsTime      :    true,
        timeFormat     :    24
    });
</script>
    </li>
    <li>
        <label for="quotes" class="desc"><s:text name= "entry.quotes"/></label>
        <input id="quotes" name="quotes" class="text large" type="text" value=""/>
    </li>
    <li>
        <label for="cates" class="desc"><s:text name= "entry.category"/> <span class="req">*</span></label>
        <s:iterator value="categories">
        <input type="checkbox" name="cates" value="${category.id}"/>${name}&nbsp;
        </s:iterator>
    </li>
    <div id="xToolbar"></div>
    <li class="editor">
        <label for="content" class="desc"><s:text name= "entry.content"/> <span class="req">*</span></label>
        <textarea id="content" name="content" rows="20" cols="70"></textarea>
    </li>
    <li class="editor">
        <label for="summary" class="desc"><s:text name= "entry.summary"/></label>
        <textarea id="summary" name="summary" rows="8" cols="70"></textarea>
    </li>
    <li class="buttonBar bottom">
        <input type="submit" class="button" name="save" value="<s:text name= "button.save"/>"/>
        <input type="submit" class="button" name="publish" value="<s:text name= "button.publish"/>"/>
        <input type="button" class="button" name="return" onclick="javascript:location.href='adminIndex.jsp'" value="<s:text name= "label.return"/>">
    </li>
</ul>
</form>
            </div>
		<jsp:include page="adminMenu.jsp" flush="true"/>
        </div>
        <%@ include file="adminFooter.jsp" %>
        </div>
    </div>
</body>
<script type="text/javascript" src="<%=request.getContextPath() %>/FCK/fckeditor.js"></script>
<script type="text/javascript">
window.onload = function (){
  var oFCKeditor = new FCKeditor('content');
  oFCKeditor.BasePath = "<%=request.getContextPath() %>/FCK/";
  oFCKeditor.Config["CustomConfigurationsPath"] = "<%=request.getContextPath() %>/FCK/adminconfig.js"  ;
  oFCKeditor.Config[ 'ToolbarLocation' ] = 'Out:xToolbar' ;
  oFCKeditor.CheckBrowser = true ;
  oFCKeditor.ReplaceTextarea() ;
  
  oFCKeditor = new FCKeditor('summary');
  oFCKeditor.BasePath = "<%=request.getContextPath() %>/FCK/";
  oFCKeditor.Config["CustomConfigurationsPath"] = "<%=request.getContextPath() %>/FCK/adminconfig.js"  ;
  oFCKeditor.Config[ 'ToolbarLocation' ] = 'Out:xToolbar' ;
  oFCKeditor.Height = 100 ;
  oFCKeditor.CheckBrowser = true ;
  oFCKeditor.ReplaceTextarea() ;
}
</script>
</html>
