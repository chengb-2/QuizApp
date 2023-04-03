<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<link rel="stylesheet"  href="/css/button.css">
<link rel="stylesheet"  href="/css/input.css">
<link rel="stylesheet"  href="/css/table.css">
<link rel="stylesheet"  href="/css/topnav.css">


<head>
    <title>Homepage</title>
</head>

<body>
<div>
    <%@include file="navbar.jsp"%>11
</div>
<%-- div is for grouping items --%>

<div>
    <p>Available quizzes:</p>
    <table class="my-table">
        <thead>
        <tr>
            <th>category</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${uniqueCategories}" var="uniqueCategories">
            <tr>
                <td>${uniqueCategories}</td>
                <td>
                    <form method="post" action="/home">
                        <button type="submit" name="quizCategory" value="${uniqueCategories}">Take quiz</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div>
    <p>Taken quizzes:</p>
    <table class="my-table">
        <thead>
        <tr>
            <th>Quiz ID</th>
            <th>Quiz Name</th>
            <th>Date Taken</th>
            <th>Link to Result Page</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${takenQuizzes}" var="takenQuizzes">
            <tr>
                <td>${takenQuizzes.id}</td>
                <td>${takenQuizzes.quizname}</td>
                <td>${takenQuizzes.time_start}</td>
                <td>
                    <form method="get" action="/quiz-result">
                        <button type="submit" name="quizRecord" value="${takenQuizzes.id}">See Result</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


</body>

</html>
