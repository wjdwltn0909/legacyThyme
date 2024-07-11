<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user/auth" method="post">
    <div>
        <label for="username">아이디</label>
        <input type="text" name="username" id="username">
    </div>
    <div>
        <label for="password">비밀번호</label>
        <input type="password" name="password" id="password">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    </div>
    <div>
        <input type="submit" value="로그인">
    </div>
    <div>
        <a href="/user/register">회원가입</a>
    </div>
</form>
</body>
</html>
