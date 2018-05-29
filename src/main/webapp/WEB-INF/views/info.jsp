<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Info </title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>

<div class="container">
      <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
   
   
          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">Info about ${ usirModel.firstName }</h3>
            </div>
            <div class="panel-body">
              <div class="row">
                <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="data:image/png;base64, ${ imgSrc }" class="img-circle img-responsive"> </div>
                <div class=" col-md-9 col-lg-9 "> 
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                        <td>FirstName:</td>
                        <td>${ usirModel.firstName }</td>
                      </tr>
                      <tr>
                        <td>LastName: </td>
                        <td>${ usirModel.lastName }</td>
                      </tr>
                      <tr>
                        <td>Email: </td>
                        <td>${ usirModel.email }</td>
                      </tr>
                      <tr>
                        <td>Login: </td>
                        <td>${ usirModel.login }</td>
                      </tr>
                      <tr>
                        <td>Password: </td>
                        <td>${ usirModel.password }</td>
                      </tr>
                      <tr>
                        <td>Salary: </td>
                        <td>${ usirModel.salary }</td>
                      </tr>
                      <tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

</body>
</html>