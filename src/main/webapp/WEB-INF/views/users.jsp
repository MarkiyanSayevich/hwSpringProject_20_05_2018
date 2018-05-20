<%@ include file="/WEB-INF/taglib.jsp" %>
	
	<form:form action="/users/filter" method="GET" modelAttribute="filterModel">
		First Name: <form:input path="firstName"/> 
		Last Name: <form:input path="lastName"/> 
		Email: <form:input path="email"/>
		Login: <form:input path="login"/>
		
		<button type="submit">Search</button>
	</form:form>

	<ul>
		<c:forEach items="${ userDtoListModel }" var="user">
			<li>
				${ user.id } | ${ user.firstName } | ${ user.lastName } | ${ user.email } | ${ user.login } |
			</li>
		</c:forEach>
	</ul>