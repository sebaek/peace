<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>회원 가</title>
</head>
<body>
<form action="" method="post" >
id : <input type="text" name="id" value="${user.id }" required> <br>
pw : <input type="password" name="password" value="${user.password }" required> <br>
pw-confirm : <input type="password" value="${user.password }" required> <br>
nickname <input type="text" name="nick-name" value="${user.nickName }" required><br>
email <input type="email" name="email" value="${user.email }"> 

<input type="submit" value="가입 " >
</form>
</body>
</html>