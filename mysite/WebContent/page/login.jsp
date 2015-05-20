<%@ page language="java" contentType="text/html; charset=utf-8" 
pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login Page</title>
</head>
<body>
<s:fielderror/>
<span style="color:red;"><s:property value="#request.errorMsg"/></span>
<s:form action="../user/login" validate="true">
	<s:textfield name="userInfoVO.userAccount" label="帐号"></s:textfield>
	<s:password name="userInfoVO.password" label="密码"></s:password>
	<s:submit value="登录"></s:submit>
</s:form>
</body>
</html>