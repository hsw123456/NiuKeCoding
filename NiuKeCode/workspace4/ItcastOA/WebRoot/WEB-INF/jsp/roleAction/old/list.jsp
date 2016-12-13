<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	 $(function(){
		 
		$("#delete").click(function(){
			
			var flag = confirm("确定要删除吗？");
				if(flag){
					this.action.submit();
				}
			return false;
			
		});
	 })

</script>
</head>
<body>
			<s:iterator value="#roleList">
				<s:property value="id"/>
				<s:property value="name"/>
				<s:property value="description"/>
				
				<s:a action="role_delete?id=%{id}" id="delete" >删除</s:a>
				<s:a action="role_editUI?id=%{id}">修改</s:a>
				</br>
			</s:iterator>
				</br>
			<s:a action="role_addUI">添加</s:a>
</body>
</html>