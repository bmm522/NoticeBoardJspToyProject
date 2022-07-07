<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%
String i = "실패";
i = (String)request.getAttribute("i");
if(i == null || i.length() ==0){
	i = "실패";
} 
//else if(i.equals("성공")){
	//i = "성공";
//}
 %>   

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        .login {
            width: 500px;
            margin: 200px auto auto auto;
        }
        .title{
            margin: 0px 0px 0px 150px;
        }
        .id{
            margin: 20px 0px 0px 160px;
        }
        .pw{
            margin: 20px 0px 0px 160px;
        }
        .button{
            margin: 20px 0px 0px 160px;
        }
    </style>
</head>
<body>
    <div class = "login">
        <h1 class = "title">로그인 페이지</h1>
        <hr>
        	<form action="LoginAction">
        		<p class = "id">ID: <input type="text" name = "checkid" /></p>
        		<p class = "pw">PW: <input type="password" name = "ps"/></p>
        		<p class = "button"><input type="submit" value="로그인하기"></p>
        		
        		<div>
	        		<p>
	        		<%if(i.equals("성공")){%>
	        			<%response.sendRedirect("loginresult.jsp");%>
	        			<%} %>
	        			
	        		
	        		</p>
        		</div>
        	</form>
        	
        	<form action="makeidpagemovelogic">
        	<p><input type = "submit" value="회원가입"></p>
        	
        	</form>
        	
        <hr>
    </div>
</body>
</html>