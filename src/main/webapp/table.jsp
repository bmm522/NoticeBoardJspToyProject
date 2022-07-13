<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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
					<h2 class="heading-section">Table #01</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="table-wrap">
						<table class="table">
						  <thead class="thead-primary">
						    <tr>
						      <th>글번호</th>
						      <th>글제목</th>
						      <th>작성자</th>
						      <th>작성날짜</th>
						      <th>조회수</th>
						    </tr>
						  </thead>
						  <tbody>
						    <c:forEach var="t" items="${table}">
						    <tr>
						      <th scope="row">${t.id}</th>
						      <td>${t.title}</td>
						      <td>${t.writer_id}</td>
						      <td>${t.regdate}</td>
						      <td>${t.hit}</td>
						    </tr>
						    </c:forEach>
						  </tbody>
						</table>
						
					</div>
					<a href="writer.jsp" class="btn btn-primary pull-right">글쓰기</a>
				</div>
			</div>
		</div>
	</section>

	<script src="js/jquery.min.js"></script>
  <script src="js/popper.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/main.js"></script>

	</body>
</html>

