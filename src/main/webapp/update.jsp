<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="NoticeBoardProject.entity.ViewEntity" %>
<!DOCTYPE html>
<%
List<ViewEntity> list = new ArrayList<>();
list = (List<ViewEntity>)request.getAttribute("update");
%>
<html>
 <head>
  	<title>Table 01</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="css/style.css">

	</head>
	<body>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">글작성</h2>
				</div>
			</div>
			<div>
			<c:forEach var="u" items="${update}">
				<form method ="post" action = "Writer">
					<td><input type="text" class="form-control" placeholder ="${u.title}" name="title" maxlength="50"></td>
				 	<td><textarea type="text" class="form-control" placeholder="${u.content}" name="content" maxlength="2048" style ="height: 350px;"></textarea> 
					<input type="submit" class="btn btn-primary pull-right" value ="글등록"/>
				</form>
			</c:forEach>
			</div>
		</div>
	</section>

	<script src="js/jquery.min.js"></script>
  <script src="js/popper.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/main.js"></script>

	</body>
</html>

