<%--
  Created by IntelliJ IDEA.
  User: dongmin
  Date: 24. 1. 9.
  Time: 오전 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Page</title>
    <link rel="stylesheet" href="style.css" />
</head>
<body>
<table>
    <tbody>
    <tr>
        <th>status_code</th>
        <td>${status_code}</td>
    </tr>
    <tr>
        <th>exception_type</th>
        <td>${exception_type}</td>
    </tr>
    <tr>
        <th>message</th>
        <td>${message}</td>
    </tr>
    <tr>
        <th>exception</th>
        <td>${exception}</td>
    </tr>
    <tr>
        <th>request_uri</th>
        <td>${request_uri}</td>
    </tr>
    </tbody>

</table>
</body>
</html>
