<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Subjects</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<h3>Subject Modification!!!</h3>

	<form:form method="post" action="/subject" modelAttribute="subject">
	<div class="table-responsive">
		<table class="table table-bordered" style="width: 300px">
			<tr>
				<td>Id :</td>
				<td><form:input type="text" path="subjectid" /></td>
			</tr>
			<tr>
				<td>Title :</td>
				<td><form:input type="text" path="title" /></td>
			</tr>
			<tr>
				<td>Duration :</td>
				<td><form:input type="text" path="duration" /></td>
			</tr>
			<tr>
				<td>Books :(Add comma separated Values)</td>
				<td><form:input type="text" path="books" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="btn btn-primary btn-sm" type="submit" value="Submit" /> </td>
			</tr>
		</table>
		</div>
	</form:form>
	<br>
	<br>
	<a href="/books">Modify Book?</a><br>
	<h3>List of Subjects</h3>
	<table class="table table-bordered" style="width: 300px">
		<tr>
			<th>subjectid</th>
			<th>title</th>
			<th>duration</th>
			<th>books</th>
			<th>Edit/Delete</th>
		</tr>
		<c:forEach items="${subjectList}" var="subject">

			<tr>
				<td width="60" align="center">${subject.subjectid}</td>
				<td width="60" align="center">${subject.title}</td>
				<td width="60" align="center">${subject.duration}</td>
				<td width="60" align="center">${subject.books}</td>
				<td width="60" align="center"><a href="editSubject/${subject.subjectid}">Edit</a>/<a href="deleteSubject/${subject.subjectid}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<h3>Search Subject!!!</h3>
	<form:form method="post" action="/searchSubject" modelAttribute="subject">
	<div class="table-responsive">
		<table class="table table-bordered" style="width: 300px">
			<tr>
				<td>Id :</td>
				<td><form:input type="text" path="subjectid" /></td>
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
			<th>subjectid</th>
			<th>title</th>
			<th>duration</th>
			<th>books</th>
			<th>Edit/Delete</th>
		</tr>
			<tr>
				<td width="60" align="center">${subjectFound.subjectid}</td>
				<td width="60" align="center">${subjectFound.title}</td>
				<td width="60" align="center">${subjectFound.duration}</td>
				<td width="60" align="center">${subjectFound.books}</td>
				<td width="60" align="center"><a href="editSubject/${subjectFound.subjectid}">Edit</a>/<a href="deleteSubject/${subjectFound.subjectid}">Delete</a></td>
			</tr>
	</table>
	</c:if>
</body>
</html>