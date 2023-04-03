<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<link rel="stylesheet"  href="/css/button.css">
<link rel="stylesheet"  href="/css/table.css">
<link rel="stylesheet"  href="/css/topnav.css">

<head>
    <title>update question</title>
</head>

<body>
<div>
    <button onclick="location.href = '/admin'">Return Admin Home</button>
</div>
<h3>Update Question Page</h3>
<div>
    <form method="post" action="/update-question">
        <p>Question ID: ${question.id}</p>
        <p>Category: <input type="text" name="question_category" value="${question.category}"/></p>
        <p>Statement: <input type="text" name="question_statement" value="${question.statement}"/></p>

        <table class="my-table">
            <thead>
            <tr>
                <th>Choice ID</th>
                <th>Choice Statement</th>
                <th>Is Correct</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach begin="0" end="3" varStatus="i">
                <tr>
                    <td><input type="text" name="choice_id_${i.index}" value="${choiceList.get(i.index).getId()}" readonly/></td>
                    <td><input type="text" name="statement_${i.index}" value="${choiceList.get(i.index).getStatement()}"/></td>
                    <c:if test="${!choiceList.get(i.index).is_correct()}">
                        <td><input type="radio" name="correct" value="${choiceList.get(i.index).getId()}"/></td>
                    </c:if>
                    <c:if test="${choiceList.get(i.index).is_correct()}">
                        <td><input type="radio" name="correct" value="${choiceList.get(i.index).getId()}" checked/></td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div>
            <button>Update</button>
            <form method="get" action="/update-question">
                <button>Reset</button>
            </form>
        </div>
    </form>
</div>



<br>
<br>
</body>
</html>


