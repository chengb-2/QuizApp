<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<style>
    table { border-collapse: collapse; }
    tr { border: none; }
    td {
        border-right: solid 1px #000;
        border-left: solid 1px #000;
    }

</style>


<head>
    <title>feedback</title>
</head>
<div>
    <%@include file="navbar.jsp"%>
</div>

<body>

<h3>Feedback Page</h3>
<div>
    <p>Give feedback:</p>
    <form method="post" action="/feedback">
        <div>
            Message
            <input type="text"
                   name="message"/>

            Rating (1-5)
            <input type="number"
                   min="0"
                   max="5"
                   step="1"
                   name="rating"/>
        </div>
        <br>
        <button type="submit">Submit Feedback</button>
    </form>
</div>

</body>
</html>
