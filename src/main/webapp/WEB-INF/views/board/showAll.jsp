<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>showAll</title>
</head>
<body>
<h1>게시글 목록을 보여주는 중.....</h1>
<form action="/logOut" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="logout">
</form>
</body>
</html>
