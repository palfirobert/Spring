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
<form:form action="processForm"
           modelAttribute="student"> <!-- trebuie sa fie acelasi nume cu atributul din controler -->

    First name:<form:input path="firstName"/><!-- asta se intampla de la getteri de la clasa trimisa de controler-->
    <br><br>
    Last name: <form:input path="lastName"/>
    <br><br>
    Country:
<!--
form:select path="country">

    form:option value="Romania" label="Romania"/>
    form:option value="France" label="France"/>
    form:option value="Germany" label="Germany"/>    asta e varianta hardcoded
    form:option value="Spain" label="Spain"/>
/form:select>

-->
    <form:select path="country">
        <form:options items="${student.countryOptions}"/>
    </form:select>
    <br><br>
    Favorite programming language
    <br><br>
    Java <form:radiobutton path="favoriteProgrammingLanguage" value="Java"/>
    C <form:radiobutton path="favoriteProgrammingLanguage" value="C"/>
    Python <form:radiobutton path="favoriteProgrammingLanguage" value="Python"/>
    PHP <form:radiobutton path="favoriteProgrammingLanguage" value="PHP"/>
    <br><br>
    Operating systems:
    Linux <form:checkbox path="operatingSystems" value="Linux"/>
    Windows <form:checkbox path="operatingSystems" value="Windows"/>
    Mac <form:checkbox path="operatingSystems" value="Mac"/>
    <br><br>

    <input type="submit" value="Submit"><!-- asta se intampla de la setterii de la clasa trimisa de controler-->

</form:form>
</body>
</html>
