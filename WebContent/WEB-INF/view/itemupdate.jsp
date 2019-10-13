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
<form action="<c:url value="/item/update" />" method="post">
<input name="title" value="${item.title }"><br>
<textarea name="body">${item.body }</textarea><br>
<input type="submit" value="수정">
</form>

<c:url value="/item/delete" var="deleteUrl" >
<c:param name="id" value="${item.id }" />
</c:url>
<a href="${deleteUrl }" onclick="return confirm('정말로 삭제 하시겠습니까?')">삭제 </a>
${error }
</body>
</html>