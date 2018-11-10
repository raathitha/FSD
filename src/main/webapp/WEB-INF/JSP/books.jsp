<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Books</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<h3>Book Modification!!!</h3>

	<form:form method="post" action="/book" modelAttribute="book">
	<div class="table-responsive">
		<table class="table table-bordered" style="width: 300px">
			<tr>
				<td>Id :</td>
				<td><form:input type="text" path="bookid" /></td>
			</tr>
			<tr>
				<td>Title :</td>
				<td><form:input type="text" path="title" /></td>
			</tr>
			<tr>
				<td>Price :</td>
				<td><form:input type="text" path="price" /></td>
			</tr>
			<tr>
				<td>Volume :</td>
				<td><form:input type="text" path="volume" /></td>
			</tr>
			
			<tr>
				<td>Published Date (YYYY-MM-DD):</td>
				<td><form:input type="text" path="publisheddate" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="btn btn-primary btn-sm" type="submit" value="Submit" /></td>
				
			</tr>
		</table>
		</div>
	</form:form>
	<br>
	<br>
	<a href="/subjects">Modify Subject?</a><br>
	<h3>List of Books</h3>
	<table class="table table-bordered" style="wbookidth: 300px">
		<tr>
			<th>bookid</th>
			<th>title</th>
			<th>price</th>
			<th>volume</th>
			<th>publisheddate</th>
			<th>Edit/Delete</th>
		</tr>
		<c:forEach items="${bookList}" var="book">

			<tr>
				<td wbookidth="60" align="center">${book.bookid}</td>
				<td wbookidth="60" align="center">${book.title}</td>
				<td wbookidth="60" align="center">${book.price}</td>
				<td wbookidth="60" align="center">${book.volume}</td>
				<td wbookidth="60" align="center">${book.publisheddate}</td>
				<td wbookidth="60" align="center"><a href="editBook/${book.bookid}">Edit</a>/<a href="deleteBook/${book.bookid}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<h3>Search Book!!!</h3>
	<form:form method="post" action="/searchBook" modelAttribute="book">
	<div class="table-responsive">
		<table class="table table-bordered" style="width: 300px">
			<tr>
				<td>Id :</td>
				<td><form:input type="text" path="bookid" /></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input class="btn btn-primary btn-sm" type="submit" value="Submit" /></td>
				
			</tr>
		</table>
		</div>
	</form:form>
		<c:if test="${showTable=='true'}">
	<table class="table table-bordered" style="wbookidth: 300px">
		<tr>
			<th>bookid</th>
			<th>title</th>
			<th>price</th>
			<th>volume</th>
			<th>publisheddate</th>
			<th>Edit/Delete</th>
		</tr>
			<tr>
				<td wbookidth="60" align="center">${bookFound.bookid}</td>
				<td wbookidth="60" align="center">${bookFound.title}</td>
				<td wbookidth="60" align="center">${bookFound.price}</td>
				<td wbookidth="60" align="center">${bookFound.volume}</td>
				<td wbookidth="60" align="center">${bookFound.publisheddate}</td>
				<td wbookidth="60" align="center"><a href="editBook/${bookFound.bookid}">Edit</a>/<a href="deleteBook/${bookFound.bookid}">Delete</a></td>
			</tr>
	</table>
	</c:if>
</body>
</html>