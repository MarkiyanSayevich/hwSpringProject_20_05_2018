<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.red{
		color: white;
		font-size: 5;
		background-color: black;
	}
</style>
</head>
<body>

	<form:form action="/add/user" method="POST" modelAttribute="userDTOModel">
	<form:errors path="*" cssClass="red"/>
	<br>
	
		First Name: <form:input path="firstName"/><br>
		<form:errors path="firstName" cssClass="red"/> <br>
		
		Last Name: <form:input path="lastName"/><br>
		<form:errors path="lastName" cssClass="red"/><br>
	
		Email: <form:input path="email"/><br>
		<form:errors path="email" cssClass="red" /><br>
		
		Login: <form:input path="login"/><br>
		<form:errors path="login" cssClass="red" /><br>
		
		Password: <form:password path="password"/><br>
		<form:errors path="password" cssClass="red" /><br>
		
		
		Password Confirm: <form:password path="passwordConfirm"/><br>
		<form:errors path="passwordConfirm" cssClass="red"/><br>
		
		
		<button type="submit"> Add User </button>
	</form:form>

</body>
</html>