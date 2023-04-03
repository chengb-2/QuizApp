<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<link rel="stylesheet"  href="/css/button.css">
<link rel="stylesheet"  href="/css/input.css">
<link rel="stylesheet"  href="/css/table.css">
<link rel="stylesheet"  href="/css/topnav.css">

<head>
    <title>Signup</title>
</head>

<body>
<div>
    <%@include file="navbar.jsp"%>
</div>

<%-- div is for grouping items --%>
<div>
    <form method="post" action="/signup">
        <div>
            <label>Username</label>
            <input type="text" name="username">
        </div>
        <div>
            <label>Password</label>
            <input type="password" name="password">
        </div>
        <div>
            <label>firstname</label>
            <input type="text" name="firstname">
        </div>
        <div>
            <label>lastname</label>
            <input type="text" name="lastname">
        </div>
        <div>
            <label>phone</label>
            <input type="text" name="phone">
        </div>
        <div>
            <label>address</label>
            <input type="text" name="address">
        </div>
        <div>
            <label>email</label>
            <input type="text" name="email">
        </div>
        <p style="color:orangered">${prompt}</p>
        <button type="submit">Submit</button>
    </form>
</div>


</body>

</html>
