<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<link rel="stylesheet"  href="/css/button.css">
<link rel="stylesheet"  href="/css/input.css">
<link rel="stylesheet"  href="/css/table.css">
<link rel="stylesheet"  href="/css/topnav.css">


<head>
    <title>view feedback</title>
</head>

<body>
<h3>View Feedback Page</h3>
<div>
    <table class="my-table">
        <thead>
        <tr>
            <th>Feedback ID</th>
            <th>Message</th>
            <th>Rating</th>
            <th>Date</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${feedbackList}" var="feedbackList">
            <tr>
                <td>${feedbackList.id}</td>
                <td>${feedbackList.message}</td>
                <td>${feedbackList.rating}</td>
                <td>${feedbackList.date}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


<br>
<br>
<div>
    <button onclick="location.href = '/admin'">Return Admin Home</button>
</div>
</body>
</html>


