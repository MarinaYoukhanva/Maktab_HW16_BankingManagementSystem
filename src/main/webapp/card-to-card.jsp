<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 3/4/2025
  Time: 5:28 PM
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

<form action="/customer/cardToCard" method="post">

    <label for="sourceCardNumber">Source Card Number:</label>
    <input type="text" id="sourceCardNumber" name="sourceCardNumber" placeholder="Enter source card number"/>

    <label for="destinationCardNumber">Destination Card Number:</label>
    <input type="text" id="destinationCardNumber" name="destinationCardNumber" placeholder="Enter destination card number"/>

    <label for="amount">Amount:</label>
    <input type="text" id="amount" name="amount" placeholder="Enter amount"/>

    <label for="secondPass">Second Pass:</label>
    <input type="text" id="secondPass" name="secondPass" placeholder="Enter second pass"/>

    <label for="cvv2">cvv2:</label>
    <input type="text" id="cvv2" name="cvv2" placeholder="Enter cvv2"/>

    <label for="expiryDate">Expiry Date:</label>
    <input type="date" id="expiryDate" name="expiryDate" placeholder="Enter expiry date"/>

    <button type="submit">Submit</button>
</form>
</body>
</html>
