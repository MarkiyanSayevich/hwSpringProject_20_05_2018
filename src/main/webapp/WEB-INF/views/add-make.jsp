<%@ include file="/WEB-INF/taglib.jsp"%>

<form:form 
	cssClass="form-horizontal" 
	modelAttribute="carMake"
	method="POST"
	action="/add/make"
	>
	<fieldset>

		<legend>Add Make</legend>

		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Make Name: </label>
			<div class="col-md-5">
				<form:input path="name" cssClass="form-control input-md"/>

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

