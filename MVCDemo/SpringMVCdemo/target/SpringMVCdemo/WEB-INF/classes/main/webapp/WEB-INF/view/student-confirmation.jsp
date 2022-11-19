<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- checkboxes write some code part 1-->
<%--
  Created by IntelliJ IDEA.
  User: palfi
  Date: 9/25/2022
  Time: 9:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student confirmation</title>
</head>
<body>
The student is confirmed: ${student.firstName} ${student.lastName}
<br><br>
Country of provenience: ${student.country}
<br><br>
Programming language: ${student.favoriteProgrammingLanguage}
<br><br>
Operating Systems:
<ul>
    <c:forEach var="temp" items="${student.operatingSystems}">
        <li>${temp}</li>
    </c:forEach>
</ul>
</body>
</html>
