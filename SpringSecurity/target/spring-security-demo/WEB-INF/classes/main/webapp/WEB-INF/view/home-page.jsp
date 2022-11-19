<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<h2>Home page</h2>
Welcome to home page
User: <security:authentication property="principal.username"/>
Role: <security:authentication property="principal.authorities"/>
<hr>
<security:authorize access="hasRole('MANAGER')">
<p>
    <a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
</p>
</security:authorize>
<hr>
<security:authorize access="hasRole('ADMIN')">
<p>
    <a href="${pageContext.request.contextPath}/systems">Admin Meeting</a>
</p>
</security:authorize>
<hr>
<form:form action="${pageContext.request.contextPath}/logout"
method="post">
    <input type="submit" value="Logout">
</form:form>
</body>
</html>
