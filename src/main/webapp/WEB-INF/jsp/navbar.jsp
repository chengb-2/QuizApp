<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<link rel="stylesheet"  href="/css/button.css">
<link rel="stylesheet"  href="/css/input.css">
<link rel="stylesheet"  href="/css/table.css">
<link rel="stylesheet"  href="/css/topnav.css">


<header class="topnav">
    <a href="http://localhost:8080/home">Home</a>
    <%
        out.println(session.getAttribute("user") != null ?
                "<a href=\"http://localhost:8080/logout\">Logout</a>" :
                "<a href=\"http://localhost:8080/login\">Login</a>\n<a href=\"http://localhost:8080/signup\">Register</a>");
    %>

    <a href="http://localhost:8080/feedback">Feedback</a>
    <a href="https://mail.google.com/mail/u/0/?fs=1&tf=cm&source=mailto&to=admin@example.com">Contact</a>
</header>
</html>
