<%@ include file="/WEB-INF/taglib.jsp"%>

<div class="container">
	<div class="row">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Login</th>
					<th>Salary</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ userListByPage }" var="user">
					<tr>
						<td>${ user.id }</td>
						<td>${ user.firstName }</td>
						<td>${ user.lastName }</td>
						<td>${ user.email }</td>
						<td>${ user.login }</td>
						<td>${ user.salary }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>