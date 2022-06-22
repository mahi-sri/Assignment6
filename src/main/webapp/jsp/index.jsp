<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="css/style.css" rel="stylesheet" type="text/css"/>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<link rel="stylesheet"
			href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
			crossorigin="anonymous">
		<title>Login Form</title>
	</head>
	<body>
		<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
		<div id="input-box">
			
			<!-- Login Heading -->
			<div id="login-heading"><h4><b>Login</b></h4></div>
			
			<!-- Div for User input for login credential  -->
			<div id="login-credential">
				<form class="form-horizontal" action="login" method="post">
				
					<!-- Username input field -->
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">Username:</label>
						<div class="col-sm-10">
							<input type="text" name="username" class="form-control" id="inputEmail3" placeholder="Username">
						</div>
					</div>
					
					<!-- Password input field -->
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">Password:</label>
						<div class="col-sm-10">
							<input type="password" name="password" class="form-control" id="inputPassword3" placeholder="Password">
						</div>
					</div>
					
					
					<!-- Login button field -->
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10" align="right">
							<button type="submit" class="btn btn-primary">Login</button>
						</div>
					</div>
					
				</form>    <!-- End form tag -->

			</div>
		</div>
	
	</body>
</html>