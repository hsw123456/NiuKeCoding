<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<title>部门设置</title>
	 <%@include file="/WEB-INF/jsp/public/common.jsp" %>
</head>
<body>



    <s:form action="department_%{id == null ? 'add' : 'edit'}">
        <s:hidden name="id"></s:hidden>
        <!-- 表单内容显示 -->
                <table cellpadding="0" cellspacing="0" >
                    <tr><td width="100">上级部门</td>
                        <td>
	                        <s:select name="parentId" cssClass="SelectStyle"
	                      list="#departmentList" listKey="id" listValue="name"
	              			headerKey="" headerValue="==请选择部门=="/>
                        </td>
                    </tr>
                    <tr><td>部门名称</td>
                        <td><s:textfield  name="name" /> *</td>
                    </tr>
                    <tr><td>职能说明</td>
                        <td><s:textarea name="description" ></s:textarea></td>
                    </tr>
                </table>
        
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="${pageContext.request.contextPath}/style/images/save.png"/>
            <a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/style/images/goBack.png"/></a>
        </div>
    </s:form>
</div>

<div class="Description">
	说明：<br />
	1，上级部门的列表是有层次结构的（树形）。<br/>
	2，如果是修改：上级部门列表中不能显示当前修改的部门及其子孙部门。因为不能选择自已或自已的子部门作为上级部门。<br />
</div>

</body>
</html>
