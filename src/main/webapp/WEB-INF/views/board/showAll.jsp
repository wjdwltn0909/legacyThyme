<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>showAll</title>
</head>
<body>
<h1>게시글 목록을 보여주는 중.....</h1>
<sec:authentication property="principal" var="principle"/>
${principle}
<sec:authorize access="hasRole('ADMIN')">
    <h1>관리자님 안녕하세요</h1>
</sec:authorize>
<form action="/logOut" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="logout">
</form>
</body>
</html>
