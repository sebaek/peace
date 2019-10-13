<%@ attribute name="current" %>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href=<c:url value="/" />>처음으로 </a><br>
<c:forEach begin="${current - 5 > 0 ? current - 5 : 1 }" end="${current+4 }" var="i">
<c:url value="/" var="thisUrl">
<c:param name="page" value="${i }" />
</c:url>
<a href="${thisUrl }">
${i }
</a>
</c:forEach>

