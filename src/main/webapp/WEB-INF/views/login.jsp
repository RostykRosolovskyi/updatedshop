<%--
  Created by IntelliJ IDEA.
  User: юзер
  Date: 23.09.2019
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<div>${errorMsg}</div>
<form action="login" method="post">
    <div>
        <h3>Let's create a new User!</h3>
        <p>Please fill sigh up.</p>
        <hr>
        <label for="login"><b>Login</b></label>
        <input type="text" placeholder="Enter login" name="login" id="login" value="${prevLogin}" required>

        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" id="psw" value="${prevPsw}" required>

        <button type="submit"> Login</button>
    </div>
    <p>Don't have an account? <a href="registration">Sign up</a></p>
</form>
</body>
</html>
