<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<link rel="stylesheet"  href="/css/button.css">
<link rel="stylesheet"  href="/css/input.css">
<link rel="stylesheet"  href="/css/table.css">
<link rel="stylesheet"  href="/css/topnav.css">

<head>
    <title>view question</title>
</head>

<body>
<div>
    <button onclick="location.href = '/admin'">Return Admin Home</button>
    <button onclick="location.href = '/add-question'">Add New Question</button>
</div>
<h3>View Question Page</h3>
<div>
    <table class="my-table">
        <thead>
        <tr>
            <th>Question ID</th>
            <th>Category</th>
            <th>Statement</th>
            <th>Status</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${questionList}" var="question">
            <tr>
                <td>${question.id}</td>
                <td>${question.category}</td>
                <td>${question.statement}</td>
                <td>${question.is_active() ? "Active" : "Not Active"}</td>
                <td>
                    <form method="post" action="/view-question">
                        <button type="submit" name="question_id" value="${question.id}">Edit</button>
                    </form>
                </td>
                <c:if test="${!question.is_active()}">
                    <td>
                        <form method="post" action="/view-question">
                            <button type="submit" name="activateQuestion" value="1,${question.id}">Activate Question</button>
                        </form>
                    </td>
                </c:if>
                <c:if test="${question.is_active()}">
                    <td>
                        <form method="post" action="/view-question">
                            <button type="submit" name="activateQuestion" value="0,${question.id}">Disable Question</button>
                        </form>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>



<br>
<br>
</body>
</html>


