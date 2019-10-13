<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title></title>
</head>
<body>
<form action="<c:url value="/login" />" method="post">
id : <input type="text" name="id" required><br>
pw : <input type="password" name="password" required><br>
<input type="submit" value="로그인" >
</form>
${error }
</body>
</html>