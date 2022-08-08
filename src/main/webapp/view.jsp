<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="NoticeBoardProject.Controller.View.ViewController" %>
<%@ page import="NoticeBoardProject.entity.ViewEntity" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<% 
String userId = (String)session.getAttribute("userId");

%>
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
				<div class="row">
			<table class="table talbe-striped" style=" border: 1px solid #ddddd">
				<thead>
				</thead>
				<tbody>
				<c:forEach var="v" items="${view}">
					<tr>
						<td>글제목</td>
						<td colspan="2">${v.title}</td> 
					</tr>
					<tr>
						<td>작성자</td>
						<td colspan="2">${v.writer_id}</td> 
					</tr>
					<tr>
						<td>작성날짜</td>
						<td colspan="2">${v.regdate}</td>
					</tr>
					
					<tr>
						<td>내용</td>
						<td colspan="2" style="padding: 10px; height: auto; min-height: 100px; overflow: auto;">${v.content }</td>
					</tr>
					
					</c:forEach>
				</tbody>
			</table>
			
			<a href="search?page=1&searchKeyword=null" class="btn btn-primary">목록</a>
			<c:if test="${userId eq view[0].writer_id}">
			<a href="updatemove?id=${view[0].id}" class="btn btn-primary">수정</a>
			<a href="delete?id=${view[0].id}" class="btn btn-primary">삭제</a>
			</c:if>
			</div>
			</div>
			
		
	</section>

	<script src="js/jquery.min.js"></script>
  <script src="js/popper.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/main.js"></script>

	</body>
</html>

