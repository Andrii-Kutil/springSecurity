<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>allHumans</title>
</head>
<body>
<h2>All humans</h2>
<security:authorize access="hasRole('HR')">
    <input type="button" value="Info"
           onclick="window.location.href = 'hrs/info'">
    Only for HR stuff
</security:authorize>
<br>
<security:authorize access="hasRole('MANAGER')">
<input type="button" value="Info"
       onclick="window.location.href = 'managers/info'">
Only for Managers
</security:authorize>
</body>
</html>
