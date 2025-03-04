<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 3/4/2025
  Time: 1:44 PM
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

<c:forEach var="item" items="${accounts}">
    <p>${item}</p>
</c:forEach>

</body>
</html>
