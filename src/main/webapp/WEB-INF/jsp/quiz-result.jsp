<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>


<head>
    <title>Quiz Result</title>
</head>

<body>
<div>
    <button onclick="history.back()">Back</button>
</div>
<div>
    <h3>Username: ${quiz.getUsername()}</h3>
    <h3>User Full Name: ${user.getFirstname()}, ${user.getLastname()}</h3>
    <h3>Quiz Name: ${quiz.getQuizname()}</h3>
    <h3>Start Time: ${quiz.getTime_start()}</h3>
    <h3>End Time: ${quiz.getTime_end()}</h3>
    <h3>Your score is: ${score}</h3>
    <h3>${score >= 3 ? "You passed the quiz!" : "You failed the quiz!"}</h3>
    <c:forEach begin="0" end="4" varStatus="i">
        <div>
            <p>Question ${i.index+1}: ${questionList.get(i.index).getStatement()}</p>
        </div>
        <div>
            <c:forEach begin="0" end="3" varStatus="j">
                <c:if test="${choiceList.get(i.index).get(j.index).getStatement() == selectedChoiceStatements.get(i.index)}">
                    <p><input type="radio" checked disabled/>${choiceList.get(i.index).get(j.index).getStatement()}</p>
                </c:if>
                <c:if test="${choiceList.get(i.index).get(j.index).getStatement() != selectedChoiceStatements.get(i.index)}">
                    <p><input type="radio" disabled/>${choiceList.get(i.index).get(j.index).getStatement()}</p>
                </c:if>
            </c:forEach>
<%--            <p>A. ${choiceList.get(i.index).get(0).getStatement()}</p>--%>
<%--            <p>B. ${choiceList.get(i.index).get(1).getStatement()}</p>--%>
<%--            <p>C. ${choiceList.get(i.index).get(2).getStatement()}</p>--%>
<%--            <p>D. ${choiceList.get(i.index).get(3).getStatement()}</p>--%>

            <p>You answered: ${selectedChoiceStatements.get(i.index)}</p>
            <p>${results.get(i.index) ? "Correct!" : "Incorrect~"}</p>
        </div>
        <br>
        <br>
    </c:forEach>
</div>
<div>
    <button onclick="history.back()">Back</button>
</div>
</body>

</html>