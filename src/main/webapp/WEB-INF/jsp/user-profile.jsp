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

<body>
<h3>User Profile Page</h3>
<div>
    <table class="my-table">
        <thead>
        <tr>
            <th>User ID</th>
            <th>Username</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Primary Address</th>
            <th>Primary Email</th>
            <th>Primary Phone number</th>
            <th>Status</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${userList}" var="userList">
            <tr>
                <td>${userList.id}</td>
                <td>${userList.username}</td>
                <td>${userList.firstname}</td>
                <td>${userList.lastname}</td>
                <td>${userList.address}</td>
                <td>${userList.email}</td>
                <td>${userList.phone}</td>
                <td>${userList.is_active ? "Active" : "Suspended"}</td>
                <c:if test="${!userList.is_active}">
                    <td>
                        <form method="post" action="/user-profile">
                            <button type="submit" name="activateUser" value="1,${userList.id}">Activate User</button>
                        </form>
                    </td>
                </c:if>
                <c:if test="${userList.is_active}">
                    <td>
                        <form method="post" action="/user-profile">
                            <button type="submit" name="activateUser" value="0,${userList.id}">Suspend User</button>
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
<div>
    <button onclick="location.href = '/admin'">Return Admin Home</button>
</div>
</body>
</html>


