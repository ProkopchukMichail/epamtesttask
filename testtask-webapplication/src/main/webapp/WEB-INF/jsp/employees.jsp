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
<a href="employees/create">Create</a>
<button onclick="window.history.back()">Cancel</button>
<table>
    <tr>
        <td>
            <form method="post" action="find">
                <dl>
                    <dt>Birthday</dt>
                    <dd><input type="datetime" name="date"></dd>
                </dl>
                <button type="submit">Find</button>
            </form>
        </td>
        <td>
            <form method="post" action="between">
                <dl>
                    <dt>
                        From date
                    </dt>
                    <dd><input type="datetime" name="start"></dd>
                </dl>
                <dl>
                    <dt>
                        To date
                    </dt>
                    <dd><input type="datetime" name="end"></dd>
                </dl>
                <button type="submit">Find</button>
            </form>
        </td>
    </tr>
</table>

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
</body>
</html>
