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
    <title>${employee.id==null ? 'Create employee':'Update employee'}</title>
</head>
<body>
<jsp:useBean id="employee" scope="request" class="model.Employee"/>
<h3>${employee.id==null ? 'Create':'Update'}</h3>
<form method="post" action="postemployee">
    <input type="hidden" name="id" value="${employee.id==null? null:employee.id}">
    <input type="hidden" name="department_id" value="${employee.department_id}">
    <dl>
        <dt>Full name</dt>
        <dd><input type="text" value="${employee.fullname}" name="fullname"></dd>
    </dl>
    <dl>
        <dt>Birthday (default birthday is 1900-01-01)</dt>
        <dd><input type="datetime" value="${employee.birthday.toLocalDate()}" name="birthday"></dd>
    </dl>
    <dl>
        <dt>Salary (default salary is 500)</dt>
        <dd><input type="number" value="${employee.salary}" name="salary"></dd>
    </dl>
    <button type="submit">Save</button>
    <button onclick="window.history.back()">Cancel</button>
</form>
</body>
</html>