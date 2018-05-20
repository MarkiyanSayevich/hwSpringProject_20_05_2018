<%@ include file="/WEB-INF/taglib.jsp"%>

<form:form cssClass="form-horizontal" modelAttribute="carModel"
	method="POST" action="/add/model">
	<fieldset>

		<legend>Add Model</legend>

		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Model
				Name: </label>
			<div class="col-md-5">
				<form:input path="name" cssClass="form-control input-md"
					placeholder="Model Name" />

			</div>
		</div>

		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Model
				Year: </label>
			<div class="col-md-5">
				<form:input path="year" cssClass="form-control input-md"
					placeholder="Model Year" />
			</div>
		</div>




		<div class="form-group">
			<label class="col-md-4 control-label" for="selectbasic">Select
				Make</label>
			<div class="col-md-5">
				<form:select path="make" cssClass="form-control">
					<form:options items="${ makeList }" itemLabel="name" />
				</form:select>
			</div>
		</div>

		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Fuel Type: </label>
			<div class="col-md-5">
				<form:radiobuttons path="fuelType" items="${ fuelList }"/>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-4 control-label" for="selectbasic"> Body Type: </label>
			<div class="col-md-5">
				<form:select path="bodyType" cssClass="form-control">
					<form:options items="${ bodyList }" />
				</form:select>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-6 control-label"></label>
			<div class="col-md-4">
				<button type="submit" class="btn btn-warning">Add Make</button>
			</div>
		</div>

	</fieldset>
</form:form>