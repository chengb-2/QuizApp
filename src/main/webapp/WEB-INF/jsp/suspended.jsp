<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<link rel="stylesheet"  href="/css/button.css">
<link rel="stylesheet"  href="/css/input.css">
<link rel="stylesheet"  href="/css/table.css">
<link rel="stylesheet"  href="/css/topnav.css">

<head>
    <title>suspended</title>
</head>
<div>
    <%@include file="navbar.jsp"%>
</div>

<body>

<h3>The account you're trying to log in is suspended!</h3>

<div>
    <button onclick="location.href = 'login'">Return to login</button>
</div>
</body>
</html>
