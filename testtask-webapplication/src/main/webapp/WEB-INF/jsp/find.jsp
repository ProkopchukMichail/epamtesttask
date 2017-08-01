<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: comp
  Date: 01.08.2017
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find employees</title>
</head>
<body>
<button onclick="window.history.back()">Cancel</button>
<table>
    <thead>
    <tr>
        <th>
            Full name
        </th>
        <th>
            Birthday
        </th>
        <th>
            Salary
        </th>
    </tr>
    </thead>
    <c:forEach items="${employees}" var="employee">
        <jsp:useBean id="employee" scope="page" type="model.Employee"/>
        <tr>
            <td>
                    ${employee.fullname}
            </td>
            <td>
                    ${employee.birthday.toLocalDate()}
            </td>
            <td>
                    ${employee.salary}
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
