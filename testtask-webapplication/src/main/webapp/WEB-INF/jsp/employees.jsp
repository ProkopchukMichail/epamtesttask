<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: comp
  Date: 31.07.2017
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Employees</title>
</head>
<body>

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
            <td>
                <a href="employees/${employee.id}/delete">Delete</a>
            </td>
            <td>
                <a href="employees/update?id=${employee.id}">Update</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="employees/create">Create</a>

</body>
</html>
