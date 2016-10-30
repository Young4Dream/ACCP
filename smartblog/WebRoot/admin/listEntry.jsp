<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="menu" content="EntryMenu"/>
    <link rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath() %>/styles/simplicity/theme.css" />
    <link rel="stylesheet" type="text/css" media="print" href="<%=request.getContextPath() %>/styles/simplicity/print.css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/prototype.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/admin.js"></script>
    <title>后台管理控制面板</title>
</head>
<body>
    <div id="page">
       <%@ include file="adminHeader.jsp" %>
        <div id="content" class="clearfix">
            <div id="main">
                <h1>日志管理</h1>
<div style="float:right">
<div class="pages"><p><span>共3页</span><span class="current">1</span><a href="listEntry.jsp?p=2">2</a><a href="listEntry.jspx?p=3">3</a><a href="listEntry.jspx?p=2">下一页 &#187;</a></p></div>
</div>
<div>
<table cellpadding="0" cellspacing="0" class="table" id="entry">
<thead>
	<th class="sortable">标题</th><th class="sortable">发表时间</th><th class="sortable">操作</th>
</thead>
<tbody>
<tr class="odd">
	<td><img src="../img/stop.png" alt="draft entry" title="This entry is draft"/>SSH安装</td>
	<td>2012-01-11 14:09:00</td>
	<td><a href="<%=request.getContextPath() %>/admin/editEntry.jspx?id=8a80801e34cb608d0134cb64a2ce0004"><img alt="Edit this entry" title="Edit this entry" src="<%=request.getContextPath() %>/img/page_white_edit.png"/></a>&nbsp;<a href="editEntry.jspx?id=8a80801e34cb608d0134cb64a2ce0004&amp;save=remove" onclick="return confirmDel('SSH安装')"><img alt="Delete this entry" title="Delete this entry" src="<%=request.getContextPath() %>/img/delete.png"></a></td>
</tr>
<tr class="even">
	<td>Java日志10配置环境变量。</td>
	<td>2012-01-05 17:06:00</td>
	<td><a href="<%=request.getContextPath() %>/admin/editEntry.jspx?id=8a80801e34a7f6d30134a7f8da570004"><img alt="Edit this entry" title="Edit this entry" src="<%=request.getContextPath() %>/img/page_white_edit.png"/></a>&nbsp;<a href="editEntry.jspx?id=8a80801e34a7f6d30134a7f8da570004&amp;save=remove" onclick="return confirmDel('Java日志10配置环境变量。')"><img alt="Delete this entry" title="Delete this entry" src="<%=request.getContextPath() %>/img/delete.png"></a></td>
</tr>
<tr class="odd">
	<td>Java日志8</td>
	<td>2012-01-05 16:52:00</td>
	<td><a href="<%=request.getContextPath() %>/admin/editEntry.jspx?id=8a80801e34a7dada0134a7ebd4210012"><img alt="Edit this entry" title="Edit this entry" src="<%=request.getContextPath() %>/img/page_white_edit.png"/></a>&nbsp;<a href="editEntry.jspx?id=8a80801e34a7dada0134a7ebd4210012&amp;save=remove" onclick="return confirmDel('Java日志8')"><img alt="Delete this entry" title="Delete this entry" src="<%=request.getContextPath() %>/img/delete.png"></a></td>
</tr>
<tr class="even">
	<td>Java日志7，关于SSH配置的问题。</td>
	<td>2012-01-05 16:51:00</td>
	<td><a href="<%=request.getContextPath() %>/admin/editEntry.jspx?id=8a80801e34a7dada0134a7ea4d3a000d"><img alt="Edit this entry" title="Edit this entry" src="<%=request.getContextPath() %>/img/page_white_edit.png"/></a>&nbsp;<a href="editEntry.jspx?id=8a80801e34a7dada0134a7ea4d3a000d&amp;save=remove" onclick="return confirmDel('Java日志7，关于SSH配置的问题。')"><img alt="Delete this entry" title="Delete this entry" src="<%=request.getContextPath() %>/img/delete.png"></a></td>
</tr>
<tr class="odd">
	<td><img src="<%=request.getContextPath() %>/img/stop.png" alt="draft entry" title="This entry is draft"/>日志2011年总结</td>
	<td>2012-01-05 13:11:00</td>
	<td><a href="<%=request.getContextPath() %>/admin/editEntry.jspx?id=8a80801e34ac3fd40134ac48031e0008"><img alt="Edit this entry" title="Edit this entry" src="<%=request.getContextPath() %>/img/page_white_edit.png"/></a>&nbsp;<a href="editEntry.jspx?id=8a80801e34ac3fd40134ac48031e0008&amp;save=remove" onclick="return confirmDel('日志2011年总结')"><img alt="Delete this entry" title="Delete this entry" src="<%=request.getContextPath() %>/img/delete.png"></a></td>
</tr>
</tbody>
</table>
</div>
            </div>
      <jsp:include page="adminMenu.jsp" flush="true"/>
        </div>
        <%@ include file="adminFooter.jsp" %>
    </div>
</body>
