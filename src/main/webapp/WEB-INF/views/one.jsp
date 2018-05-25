<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
	<c:url var="firstUrl" value="/one?page=0" />
	<c:url var="lastUrl" value="/one?page=${ usersList.totalPages }" />

	<c:url var="nextUrl" value="/one?page=${ currentPage + 1 }" />
	<c:url var="prevUrl" value="/one?page=${ currentPage - 1 }" />

	<div class="container">
		<div class="container-fluid text-center">
			<div class="row content">
				<div class="col-sm-3 sidenav">
					<div class="row">
						<div class="col-lg-3 col-md-6 col-md-offset-3 col-lg-offset-0">
							<div class="well">
								<h3 align="center">Lets Find</h3>
								<form:form cssClass="form-horizontal" action="/one/filter"
									method="GET" modelAttribute="filterModel">
									<div class="form-group">
										<form:label path="firstName" for="location1"
											cssClass="control-label">First Name: </form:label>
										<form:input path="firstName" cssClass="form-control" />
									</div>
									<div class="form-group">
										<form:label path="lastName" for="location2"
											cssClass="control-label">Last Name: </form:label>
										<form:input path="lastName" cssClass="form-control" />
									</div>
									<div class="form-group">
										<form:label path="email" for="location3"
											cssClass="control-label">Email: </form:label>
										<form:input path="email" cssClass="form-control" />
									</div>
									<div class="form-group">
										<form:label path="login" for="location4"
											cssClass="control-label">Login: </form:label>
										<form:input path="login" cssClass="form-control" />
									</div>
									<div class="form-group">
										<form:label path="minSalary" for="pricefrom"
											cssClass="control-label">Min Salary</form:label>
										<div class="input-group">
											<div class="input-group-addon" id="basic-addon1">$</div>
											<form:input path="minSalary" cssClass="form-control"/>
										</div>
									</div>
									<div class="form-group">
										<form:label path="maxSalary" for="pricefrom"
											cssClass="control-label">Max Salary</form:label>
										<div class="input-group">
											<div class="input-group-addon" id="basic-addon1">$</div>
											<form:input path="maxSalary" cssClass="form-control"/>
										</div>
									</div>
									
									<div class="form-group">
										<form:label path="size" for="location5"
											cssClass="control-label"> Users on Page: </form:label>
										<form:input path="size" cssClass="form-control" />
									</div>
									
									<p class="text-center">
										<button type="submit"
											class="btn btn-danger glyphicon glyphicon-search"></button>
									</p>
								</form:form>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-9 text-left">


					<div class="row">
						<div class="col-md-9">
							<div class="panel panel-primary">
								<div class="panel-heading">
									<h3 class="panel-title">Pagination</h3>
									<span class="pull-right clickable"><i
										class="glyphicon glyphicon-chevron-up"></i></span>
								</div>
								<div class="panel-body">

									<ul class="pagination">
										<c:choose>
											<c:when test="${ currentPage == 0 }">
												<li class="disabled"><a href="#">&lt;&lt;</a></li>
												<li class="disabled"><a href="#">&lt;</a></li>
												<li class="active"><a href="${ firstUrl }"> 1 </a></li>
											</c:when>
											<c:otherwise>
												<li><a href="${ firstUrl }">&lt;&lt;</a></li>
												<li><a href="${ prevUrl }">&lt;</a></li>
											</c:otherwise>
										</c:choose>

										<c:forEach var="i" begin="${ beginIndex }" end="${ endIndex }">
											<c:url var="pageUrl" value="/one?page=${i}" />
											<c:choose>
												<c:when test="${ i == currentPage }">
													<li class="active"><a href="#">${ i + 1 }</a></li>
												</c:when>

												<c:otherwise>
													<li><a href="${ pageUrl }">${ i + 1 }</a></li>
												</c:otherwise>
											</c:choose>

										</c:forEach>

										<c:choose>
											<c:when test="${ currentPage + 1  == usersList.totalPages}">
												<li class="disabled"><a href="#">&gt;</a></li>
												<li class="disabled"><a href="#">&gt;&gt;</a></li>
											</c:when>

											<c:otherwise>
												<li><a href="${ nextUrl }">&gt;</a></li>
												<li><a href="/one?page=${ usersList.totalPages - 1 }">&gt;&gt;</a>
												</li>
											</c:otherwise>
										</c:choose>

									</ul>

								</div>
							</div>
						</div>
					</div>

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
								<c:forEach items="${ usersPage }" var="user">
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
			</div>
		</div>
	</div>

</body>
</html>