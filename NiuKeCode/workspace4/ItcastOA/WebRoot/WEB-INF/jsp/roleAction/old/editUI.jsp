<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>'
		<s:debug></s:debug>
		<s:form action="role_edit">
			<s:hidden name="id"></s:hidden>
			岗位名称：<s:textfield name="name"></s:textfield>
			</br></br>
			岗位说明：<s:textarea name="description"></s:textarea>
			</br></br>
			<s:submit name="提交"></s:submit>
		</s:form>
</body>
</html>