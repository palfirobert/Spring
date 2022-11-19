<%--
  Created by IntelliJ IDEA.
  User: palfi
  Date: 9/26/2022
  Time: 6:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer Confirmation</title>
</head>
<body>
The customer is confirmed: ${customer.lastName} ${customer.firstName}
<br><br>
Number of passes: ${customer.freePasses}
<br><br>
Postal code: ${customer.postalCode}
<br><br>
Course code: ${customer.courseCode}
</body>
</html>
