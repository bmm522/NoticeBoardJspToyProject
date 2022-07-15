<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
        	<form method= "post" action="LoginController">
        		<p class = "id">ID: <input type="text" name = "User_Id" /></p>
        		<p class = "pw">PW: <input type="password" name = "User_Pwd"/></p>
        		<p class = "button"><input type="submit" value="로그인하기"></p>
        	</form>
        	
        	
        	<p><input type = "button" class="button" onClick="location.href='makeidpage.jsp'" value="회원가입" ></p>
        	
        	
        <hr>
    </div>
</body>
</html>