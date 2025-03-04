<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 3/4/2025
  Time: 12:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<% if (request.getAttribute("message") != null) { %>
<p style="color:green;"><%= request.getAttribute("message") %>
</p>
<% } %>

<% if (request.getAttribute("error") != null) { %>
<p style="color:red;"><%= request.getAttribute("error") %>
</p>
<% } %>

<form action="/employee/createAccount" method="post">

    <label for="firstname">Firstname:</label>
    <input type="text" id="firstname" name="firstname" placeholder="Enter firstname"/>

    <label for="lastname">Lastname:</label>
    <input type="text" id="lastname" name="lastname" placeholder="Enter lastname"/>

    <label for="nationalCode">National Code:</label>
    <input type="text" id="nationalCode" name="nationalCode" placeholder="Enter national code"/>

    <label for="phoneNumber">Phone Number:</label>
    <input type="text" id="phoneNumber" name="phoneNumber" placeholder="Enter phone number"/>

    <label for="accountType">Account Type:</label>
    <select name="accountType" id="accountType">
        <option value="GHRAZOLHASANE">Gharzolhasane</option>
        <option value="KOOTAH_MODAT">Kootah modat</option>
        <option value="BOLAND_MODAT">Boland Modat</option>
        <option value="JARI">Jari</option>
    </select>

<%--    <label for="bankBranchId">Bank Branch Id:</label>--%>
<%--    <input type="text" id="bankBranchId" name="bankBranchId" placeholder="Enter bank branch id"/>--%>

    <label for="balance">Account Balance:</label>
    <input type="text" id="balance" name="balance" placeholder="Enter balance"/>

    <button type="submit">Submit</button>
</form>
</body>
</html>
