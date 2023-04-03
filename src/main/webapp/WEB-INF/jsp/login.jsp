<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
    <title>Login</title>
    <link rel="stylesheet"  href="../../css/button.css">
    <link rel="stylesheet"  href="../../css/input.css">
    <link rel="stylesheet"  href="../../css/topnav.css">
</head>

<body>
<div>
    <%@include file="navbar.jsp"%>
</div>

<%-- div is for grouping items --%>
<div>
    <form method="post" action="/login">
        <div>
            <label>Username</label>
            <input type="text" name="username">
        </div>
        <div>
            <label>Password</label>
            <input type="password" name="password">
        </div>
        <button type="submit">Login</button>
    </form>
</div>

<div>
    <form method="get" action="/signup">
        <p>Don't have an account?</p>
        <button type="submit">Sign Up</button>
    </form>
</div>

</body>

</html>
