<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title></title>
</head>
<body>
	${item.id }
	<br> ${item.title }
	<br>

	<pre>${item.body }</pre>
	<br> ${item.inserted }
	<br> ${item.userNickName }
	<br>


	<a href="<c:url value="/" />">목록으로 </a>
	<br>

	<c:if test="${user.id eq item.userId }">
		<a href="<c:url value="/item/update" />">수정 </a>
	</c:if>
</body>
</html>