<%--
  Created by IntelliJ IDEA.
  User: palfi
  Date: 9/25/2022
  Time: 6:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Student registration form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">  <!-- trebuie sa fie acelasi nume cu atributul din controler -->

First name:<form:input path="firstName"/><!-- asta se intampla de la getteri de la clasa trimisa de controler-->
    <br><br>
Last name: <form:input path="lastName"/>
    <br><br>
<input type="submit" value="Submit"><!-- asta se intampla de la setterii de la clasa trimisa de controler-->
</form:form>
</body>
</html>
