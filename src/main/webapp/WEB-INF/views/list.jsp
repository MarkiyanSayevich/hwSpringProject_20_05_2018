<%@ include file="/WEB-INF/taglib.jsp"%>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>Id</th>
			<th>Make</th>
			<th>Model</th>
			<th>Year</th>
			<th>FuelType</th>
			<th>BodyType</th>
		</tr>
	</thead>

	<tbody>

		<c:forEach items="${ allData }" var="make">
			<tr>
				<td>${ make.id }</td>
				<td>${ make.name }</td>
			</tr>
			<c:forEach items="${ make.models }" var="model">
				<tr>
					<td></td>
					<td></td>
					<td>${ model.name }</td>
					<td>${ model.year }</td>
					<td>${ model.fuelType }</td>
					<td>${ model.bodyType }</td>
				</tr>
			</c:forEach>
		</c:forEach>
	</tbody>
</table>