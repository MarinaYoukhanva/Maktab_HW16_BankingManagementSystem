<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 3/3/2025
  Time: 12:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login" method="post">
    <label for="userType">Login as:</label>
    <select name="userType" id="userType">
        <option value="customer">Customer</option>
        <option value="employee">Employee</option>
    </select>
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" placeholder="Enter username"/>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" placeholder="Enter password"/>

    <button type="submit">Submit</button>

    <% if (request.getAttribute("message") != null) { %>
    <p style="color:green;"><%= request.getAttribute("message") %>
    </p>
    <% } %>

    <% if (request.getAttribute("error") != null) { %>
    <p style="color:red;"><%= request.getAttribute("error") %>
    </p>
    <% } %>
</form>
</body>
</html>
