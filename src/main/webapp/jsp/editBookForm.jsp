<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,com.libraryManagement.web.model.BookModel,com.libraryManagement.web.model.AuthorModel" %>
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
		<title>Edit Book Form</title>
	</head>
	<body>
		<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			
			String username = (String)session.getAttribute("user");
		%>
		<div>
			<header>
				
				<div class="heading">
					<div class="col-10" align="center"></div>
					<div class="col-2">
						<form class="form-inline my-2 my-lg-0" action="logout">
		
							<div class="username">
								Welcome <%=username%>
							</div>
							<button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Logout</button>
						</form>
					</div>
					
				</div>
				
			</header>
		</div>
		
		
		<div id="input-box" style="margin-top: 40px">
			
			<!-- Login Heading -->
			<div id="login-heading" align="center"><h4><b>Add Book Details</b></h4></div>
			
			<!-- Div for User input for login credential  -->
			<div id="login-credential">
				<%
					BookModel book = (BookModel) request.getAttribute("book");
					session.setAttribute("bookCode", book.getBookCode());
				%>
				<form class="form-horizontal" action="/update">
					
					<div class="input-row">
						<div class="col-sm-3">Book Code</div>
						<div class="col-sm-7"><%=book.getBookCode()%></div>
					</div>
					<div class="input-row">
						<div class="col-sm-3">Book Name</div>
						<div class="col-sm-7">
							<input type="text" name="newBookName" value="<%=book.getBookName()%>" class="form-control">
						</div>
					</div>
					<div class="input-row">
						<div class="col-sm-3">Author</div>
						<div class="col-sm-7">
							<%-- <input type="text" name="newAuthor" value="<%=book.getAuthor() %>" class="form-control"> --%>
							<select name="newAuthor" class="form-control">
								<option value="<%=book.getAuthor()%>" selected hidden>"<%=book.getAuthor()%>"</option>
								<%
									List<AuthorModel> authors = (List) request.getAttribute("authors");
															for(AuthorModel author: authors){
								%>
								<option><%=author.getAuthorName() %></option>
								<%
									}
								%>
							</select>
						</div>
					</div>
					<div class="input-row">
						<div class="col-sm-3">Added On</div>
						<div class="col-sm-7">
							<%=book.getUpdatedOn() %>
						</div>
					</div>
										
					<!-- Login button field -->
					<div class="form-group" style="display: flex">
						<div class="col-sm-offset-2 col-sm-3" style="padding-top: 5px;">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
						<div class="col-sm-offset-2 col-sm-2" style="padding-top: 5px;">
							<a href="/books" class="btn btn-danger">Cancel</a> 
						</div>
					</div>
					
				</form>    <!-- End form tag -->

			</div>
		</div>
		
	</body>
</html>