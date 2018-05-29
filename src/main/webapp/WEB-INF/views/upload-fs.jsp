<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/upload/fs" method="POST" enctype="multipart/form-data">
		
		<input type="file" name="fileImage" >
		
		<button type="submit" > Upload </button>
	</form>
</body>
</html>