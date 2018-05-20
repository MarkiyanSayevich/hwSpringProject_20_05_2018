<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="/resources/css/style.css" rel="stylesheet">
</head>
<body>

	<tiles:insertAttribute name="header" />

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<tiles:insertAttribute name="sidebar"/>
			</div>
			<div class="col-sm-10 text-left">
				<tiles:insertAttribute name="body"/>
			</div>
		</div>
	</div>
	
	<tiles:insertAttribute name="footer"/>
	
</body>
</html>