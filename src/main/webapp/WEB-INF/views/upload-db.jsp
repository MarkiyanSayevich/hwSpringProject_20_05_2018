<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!--<form:form action="/upload/db" modelAttribute="uploadFileModel" method="POST" enctype="multipart/form-data">
	
		<input type="file" name="uploadFile"> <br>
		<button type="submit" > Upload </button>
	
	</form:form>  -->
	
	<form:form action="/upload/db" modelAttribute="uploadFileModel" method="POST" enctype="multipart/form-data">
	
		
		<form:input path="file" type="file"/>
		
		<button type="submit" > Upload </button>
	
	</form:form>

</body>
</html>