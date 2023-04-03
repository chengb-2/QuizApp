<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>


<jsp:useBean id="current" class="java.util.Date" />

<html>

<link rel="stylesheet"  href="/css/button.css">
<link rel="stylesheet"  href="/css/topnav.css">
<link rel="stylesheet"  href="/css/quiz.css">


<head>
    <title>Quiz</title>
</head>

<body>

<div>
<%--    <p>Counter: </p>--%>
<%--    <p>Time start: ${time_start}</p>--%>
<%--    <p>Time end: ${time_end}</p>--%>
<%--&lt;%&ndash;    <p>Time left: ${time_end - current.time}</p>&ndash;%&gt;--%>
<%--    <p>Time now: ${current.time}</p>--%>
</div>

<form method="post" action="/quiz">
<div class="page-content">
    <div class="tabbed">
        <input class = "need-hide" type="radio" id="tab1" name="css-tabs" checked>
        <input class = "need-hide" type="radio" id="tab2" name="css-tabs">
        <input class = "need-hide" type="radio" id="tab3" name="css-tabs">
        <input class = "need-hide" type="radio" id="tab4" name="css-tabs">
        <input class = "need-hide" type="radio" id="tab5" name="css-tabs">

        <ul class="tabs">
            <c:forEach begin="0" end="4" varStatus="i">
                <li class="tab"><label for="tab${i.index+1}">${i.index+1}</label></li>
            </c:forEach>
        </ul>

        <p>${quizCategory}</p>
            <c:forEach begin="0" end="4" varStatus="i">
                <div class="tab-content">
                    <h4>Question ${i.index+1}: ${questionList.get(i.index).getStatement()}</h4>
                    <div>
                        <c:forEach begin="0" end="3" varStatus="j">
                            <div>
                                <input type="radio"
                                       name="selectedChoiceId_${i.index}"
                                       value="${choiceList.get(i.index).get(j.index).getId()}"/>
                                    ${choiceList.get(i.index).get(j.index).getStatement()}
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </c:forEach>
        </div>
    <br>
    <br>
    <button type="submit">Submit</button>
</div>
</form>
</body>
</html>
