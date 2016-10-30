<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
            <div id="nav">
                <div class="wrapper">

                    <h2 class="accessibility">Navigation</h2>
					<ul id="primary-nav" class="menuList">
    					<li class="pad">&nbsp;</li>
                        <li><a href="admin/index.jspx" class="current" title="主菜单">主菜单</a></li>
                        <li class="menubar">
                        	<a href="admin/editProfile.jspx?id=8a80801e33cef3430133cef3560d0003"  title="用户管理" style="width: 120px">用户管理</a>
                        	<ul>

                        		<li class="last"><a href="admin/editProfile.jspx?id=8a80801e33cef3430133cef3560d0003" title="修改个人信息" >修改个人信息</a></li>
                        	</ul>
                        </li>
						<li class="menubar">
                        	<a href="addEntry.jsp"  title="内容管理" style="width: 120px">内容管理</a>
             				<ul>
             					<li><a href="editSiteConfig.jspx?save=edit" title="站点配置">站点配置</a></li>

             					<li><a href="addEntry.jsp" title="添加日志" >添加日志</a></li>
                                <li><a href="listEntry.jsp" title="日志管理" >日志管理</a></li>
            				</ul>
                        </li>
                        <li class="menubar">
                        	<a href="admin/mail.jspx"  title="其他管理" style="width: 120px">其他管理</a>

                        	<ul>
                        		<li><a href="admin/mail.jspx" title="发送Email">发送Email</a></li>
                        		<li><a href="admin/mail.jspx?save=schedulerSend" title="发送Email队列">发送Email队列</a></li>
                        		<li class="last"><a href="admin/indexView.jspx" title="重建索引">重建索引</a></li>
                        	</ul>
                        </li>
                        <li><a href="admin/logout.jspx" title="退出" >退出</a></li>

                     </ul>
                </div>
                <hr />
            </div>