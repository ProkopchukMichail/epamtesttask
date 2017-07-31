
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${department.id==null?'Create department':'Update department'}</title>
</head>
<body>
<jsp:useBean id="department" scope="request" class="model.Department"/>
<h3>${department.id==null ? 'Create':'Update'}</h3>
<form method="post" action="post">
    <input type="hidden" name="id" value="${department.id==null? 0:department.id}">
    <dl>
        <dt>Department Name</dt>
        <dd><input type="text" value="${department.departmentName}" name="departmentName"></dd>
    </dl>
    <button type="submit">Save</button>
    <button onclick="window.history.back()">Cancel</button>
</form>
</body>
</html>
