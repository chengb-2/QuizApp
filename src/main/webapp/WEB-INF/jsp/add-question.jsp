<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>add question</title>
</head>


<body>
<div>
    <button onclick="location.href = '/admin'">Return Admin Home</button>
</div>
<h3>Add Question Page</h3>
<div>
    <form method="post" action="/add-question">
        <p>Category: <input type="text" name="question_category" value=""/></p>
        <p>Statement: <input type="text" name="question_statement" value=""/></p>

        <table>
            <thead>
            <tr>
                <th>Choice Statement</th>
                <th>Is Correct</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach begin="0" end="3" varStatus="i">
                <tr>
                    <td><input type="text" name="statement_${i.index}" value=""/></td>
                    <td><input type="radio" name="correct" value="${i.index}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div>
            <button>Add</button>
        </div>
    </form>
    <div>
        <form method="get" action="/add-question">
            <button>Reset</button>
        </form>
    </div>
</div>



<br>
<br>
</body>
</html>


