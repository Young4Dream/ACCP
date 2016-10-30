<#assign s=JspTaglibs["/WEB-INF/struts-tags.tld"]>

    This is my JSP page. <br>success 
<#macro basePath><#if base=='/'>/<#else>${base}/</#if></#macro>
<@basePath/>rrrrr
<@s.form action="helloAction">
<@s.text name="app.name"/>
<@s.text name="label.about"/>
</@s.form>
<#list ["winter", "spring", "summer", "autumn"] as x>
${x}
</#list>
${userName + ","+userName }

<#macro border>
<table border=4 cellspacing=0 cellpadding=4><tr><td>
<#nested>
</td></tr></table>
</#macro>

<@border>The bordered text</@border>