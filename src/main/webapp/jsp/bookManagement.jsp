<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,com.libraryManagement.web.model.BookModel" %>
    
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
		<title>Books Management Form</title>
		
		<style>
			table,th,td{
				border: 1px solid black;
  				border-collapse: collapse;
			}
			th, td{
				align-self: center;
			}
		</style>
	</head>
	
	<body>
		
		<%
					response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
					
					 String username = (String)session.getAttribute("user");
					 
					 
					if(username == null){
						response.sendRedirect("index.jsp");
					}
				%>
		<div>
			<header>
				<div class="heading">
					<div class="col-10" align="center"><!-- <h4>Header goes here</h4> --></div>
					<div class="col-2">
						<form class="form-inline my-2 my-lg-0" action="logout" method="post">
							<div class="username">
								Welcome <%=username%>
							</div>
							<button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Logout</button>
						</form>
					</div>
				</div>
			</header>
		</div>
		
		
		<div class="heading" style="margin-top: 20px">
			<div class="col-10" align="center"><h4><b>Books Listing</b></h4></div>
			<div class="col-3">
				<form action="/new">
					<div class="col-sm-8"><button type="submit" class="btn btn-primary">Add a book</button></div>
				</form>
			</div>
			
		</div>
		
		
		<!-- Display Table -->
		<div>
			
			<table class="table table-bordered" style="margin-left: 20px; width:95%; margin-top: 20px;">
				<thead>
					<tr>
						<th>Book Code</th>
						<th>Book Name</th>
						<th>Author</th>
						<th>Data Added</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<%
						List<BookModel> books = (List) request.getAttribute("books");
									
						for(BookModel book: books){
					%>
					
						<tr>
							<td><%=book.getBookCode() %></td>
							<td><%=book.getBookName() %></td>
							<td><%=book.getAuthor() %></td>
							<td><%=book.getUpdatedOn() %></td>
							<td>
								<a href="/edit?bookCode=<%=book.getBookCode() %>" class="btn btn-outline-primary col-sm-offset-2 col-sm-3">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="/delete?bookCode=<%=book.getBookCode() %>" class="btn btn-outline-danger col-sm-offset-2 col-sm-3">Delete</a>
							</td>
						</tr>
					<%
						}
					%>
				</tbody>
				
			</table>
		
		</div>
		
	</body>
	
	
</html>







