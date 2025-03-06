<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 3/6/2025
  Time: 2:13 PM
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

choose the credit card:
<c:forEach var="item" items="${cardNumbers}">
    <p>${item}</p>
</c:forEach>

<form action="/customer/changePass" method="post">


<label for="passType">Choose password to change:</label>
<select name="passType" id="passType">
    <option value="firstPass">First Password</option>
    <option value="secondPass">Second Password</option>
</select>

<label for="oldPass">Old Password:</label>
<input type="text" id="oldPass" name="oldPass" placeholder="Enter old password"/>

<label for="newPass">New Password:</label>
<input type="text" id="newPass" name="newPass" placeholder="Enter new password"/>

<label for="cardNum">Card Number:</label>
<input type="text" id="cardNum" name="cardNum" placeholder="Enter card number"/>


<button type="submit">Submit</button>


</body>
</html>
