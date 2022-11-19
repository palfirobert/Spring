<%--
  Created by IntelliJ IDEA.
  User: palfi
  Date: 9/26/2022
  Time: 6:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer Registration form</title>

    <style>
        .error{color:red}
    </style>

</head>
<body>


<form:form action="processForm" modelAttribute="customer"> <!-- trebuie sa fie acelasi nume cu atributul din controler -->

First name:<form:input path="firstName"/><!-- asta se intampla de la getteri de la clasa trimisa de controler-->
<br><br>
Last name (*): <form:input path="lastName"/>
<form:errors path="lastName" cssClass="error"/>

    <br><br>
    Free passes: <form:input path="freePasses"/>
    <form:errors path="freePasses" cssClass="error"/>
    <br><br>
    Postal code: <form:input path="postalCode"/>
    <form:errors path="postalCode" cssClass="error"/>
    <br><br>
    Course code: <form:input path="courseCode"/>
    <form:errors path="courseCode" cssClass="error"/>
    <br><br>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
