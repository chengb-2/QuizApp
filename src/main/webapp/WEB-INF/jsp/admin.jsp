<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>

<link rel="stylesheet"  href="/css/button.css">
<link rel="stylesheet"  href="/css/input.css">
<link rel="stylesheet"  href="/css/table.css">
<link rel="stylesheet"  href="/css/topnav.css">


<head>
    <title>admin</title>
</head>
<div>
    <%@include file="admin-navbar.jsp"%>
</div>

<body>

<h3>Admin Home</h3>
<div>
    <div>
        <button onclick="location.href = '/user-profile'">See User Profile</button>
        <button onclick="location.href = '/view-question'">View Question</button>
        <button onclick="location.href = '/view-feedback'">View Feedback</button>
    </div>

    <div>
        <p>All quizzes:</p>
        <form method="post" action="/admin">
            <div>
                Category
                <input type="text"
                       name="filterCategory"/><br>

                Username
                <input type="text"
                       name="filterUsername"/><br>

                <button type="submit">Search</button>
            </div>
        </form>
    </div>
    <table class="my-table">
        <thead>
        <tr>
            <th>Quiz ID</th>
            <th>Quiz Name</th>
            <th>Category</th>
            <th>User Full Name</th>
            <th>Date Taken</th>
            <th>No. of question</th>
            <th>Score</th>
            <th>Link to Result Page</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${filteredQuizzes}" var="filteredQuizzes">
            <tr>
                <td>${filteredQuizzes.id}</td>
                <td>${filteredQuizzes.quizname}</td>
                <td>${filteredQuizzes.quizname.split("-")[1]}</td>
                <td>${filteredQuizzes.username}</td>
                <td>${filteredQuizzes.time_start}</td>
                <td>5</td>
                <td>${filteredQuizzes.score}</td>
                <td>
                    <form method="get" action="/quiz-result">
                        <button type="submit" name="quizRecord" value="${filteredQuizzes.id}">See Result</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
