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
<a href="departments/create">Create</a>
<table>
    <thead>
    <tr>
        <th>
            Departments
        </th>
        <th>
            Salary
        </th>
    </tr>
    </thead>
    <c:forEach items="${departments}" var="department">
        <jsp:useBean id="department" scope="page" type="webapplication.util.DepartmentWithSalary"/>
        <tr>
            <td>
                ${department.departmentName}
            </td>
            <td>
                ${department.salary}
            </td>
            <td>
                <a href="departments/delete?id=${department.id}">Delete</a>
            </td>
            <td>
                <a href="departments/update?id=${department.id}">Update</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
