<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
//tring token = (String)request.getAttribute("token");

%>   
 
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8"/>
  <title>Cocoon</title>
</head>
<body>
  
  <section>
    <h1>회원가입 페이지</h1>
  </section>
  
  <section>
    <form name="login" action="makeidlogic">
      아이디확인<br>
      	<form action="idcheck">
	      <input type="text" name="user_ID" placeholder="아이디 입력" >
	      <input type="submit" name="user_IDcheck" value="아이디 중복체크">

	     	
	   
	     
	     </form>
      <br>
      비밀번호<br> 
      <input type="password" name="user_PW1"><br>
      비밀번호 재확인<br> 
      <input type="password" name="user_PW2">
      <input type="button" name="user_PWcheck" value="비밀번호 재확인">
      <br><br>
      이름<br>  <input type="text" name="user_name" value=""> <br>
    
    
    
    	<input type = "submit" name = "makebutton" value ="생성">
    
    </form>
  </section>
  
  
</body>
</html>