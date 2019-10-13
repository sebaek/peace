<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title></title>
</head>
<body>
	<div id="page-header"></div>

	<div id="items-table-container">
		<table id="items-table">
			<tr>
				<th>no.</th>
				<th>title</th>
				<th>date</th>
			</tr>
			<c:forEach items="${items }" var="item">
				<c:url value="/item" var="path">
					<c:param name="id">${item.id }</c:param>
				</c:url>
				<tr>
					<td>${item.id }</td>
					<td><a href="${path }">${item.title }</a></td>
					<td>${item.inserted }</td>
				</tr>
			</c:forEach>
		</table>

		<my:page current="${current }">바디 내용 ${current } 바디 내용 </my:page>


	</div>

	<c:choose>
		<c:when test="${not empty user }">
			<a href="<c:url value="/item/insert" />">글쓰기 </a>
			<br>
			<a href="<c:url value="/user" />">회원정보 </a>
			<br>
			
			<a href="<c:url value="/logout" />">로그아웃 </a>
			<br>
		</c:when>
		<c:otherwise>
			<a href="<c:url value="/login" />">로그인</a>
			<br>
			<a href="<c:url value="/signup" />">회원가입 </a>
			<br>
		</c:otherwise>
	</c:choose>




	<div id="page-footer"></div>
</body>
</html>