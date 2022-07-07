<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

 
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
    <form method="post" action="NoticeBoardMakeMemberController">
      아이디확인<br>
      	
	      <input type="text" name="user_ID" placeholder="아이디 입력" >
	      
	      <br>
	      비밀번호<br> 
	      <input type="password" name="user_PW"><br>
	     
      <br><br>
     	이름<br>  <input type="text" name="user_Name" value=""> <br>
    	핸드폰번호<br>  <input type="text" name="user_Phonenum" value=""> <br>
    	이메일<br>  <input type="text" name="user_Email" value=""> <br>
    		<input type = "submit" value ="생성">
    
    </form>
  </section>
  
  
</body>
</html>