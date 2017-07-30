<%--
  Created by IntelliJ IDEA.
  User: comp
  Date: 29.07.2017
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>EPAM test task</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>
            Departments
        </th>
    </tr>
    </thead>
    <c:forEach items="${departments}" var="department">
        <jsp:useBean id="department" scope="page" type="model.Department"/>
        <tr>
            <td>
                ${department.departmentName}
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
