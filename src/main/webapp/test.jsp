<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 3/3/2025
  Time: 2:10 AM
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

<% if (request.getAttribute("customer") != null){ %>
      <h3>
          customer:<%= request.getAttribute("customer") %>
      </h3>
<% } %>

<% if (request.getAttribute("employee") != null){ %>
<h3>
    employee:<%= request.getAttribute("employee") %>
</h3>
<% } %>

</body>
</html>
