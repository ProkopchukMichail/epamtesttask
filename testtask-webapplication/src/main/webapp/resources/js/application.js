var API_PATH = "/testtask-restservice-1.0-SNAPSHOT/rest/";
$(document).ready(function () {

    loadDepartmentsPage(function () {
        createDepartment();
        showEmployees();
        updateDepartment();
        deleteDepartment();
    });
});
function updateDepartment() {
    $(".btn-department-edit").click(function () {
        var departmentId = $(this).attr("data-id");

        loadDepartmentPageUpdate(departmentId, function () {
            $('input[name="updateDepartmentId"]').val(departmentId);
        })
    });
}
function createDepartment() {
    $("#btn-department-create").click(function () {
        showDepartmentPageCreate()
    });
}

function saveDepartment() {
    var department = {id: 0, departmentName: $('input[name="departmentName"]').val()};
    $.ajax({
        url: API_PATH + "departments/create",
        type: "PUT",
        data: JSON.stringify(department),
        dataType: "json",
        contentType: "application/json",
        success: reloadDepartmentsPage
    });
}


function changeDepartment(id) {
    var department = {id: id, departmentName: $('input[name="departmentName"]').val()};
    $.ajax({
        url: API_PATH + "departments/" + id + "/update",
        type: "POST",
        data: JSON.stringify(department),
        dataType: "json",
        contentType: "application/json",
        success: reloadDepartmentsPage
    });
}

function deleteDepartment() {
    $(".btn-department-delete").click(function () {
        var departmentId = $(this).attr("data-id");
        $.ajax({
            url: API_PATH + "departments/" + departmentId + "/delete",
            type: "DELETE",
            success: reloadDepartmentsPage
        });
    })
}

function showEmployees() {
    $(".btn-department-employees").click(function () {
        var departmentId = $(this).attr("data-id");
        loadEmployeesPage(departmentId, function () {
            deleteEmployees(departmentId);
            createEmployee(departmentId);
            updateEmployee(departmentId);
            findByBirthday(departmentId);
            findBetweenDates(departmentId);
        });
    })
}

function deleteEmployees(departmentId) {
    $(".btn-employee-delete").click(function () {
        var employeeId = $(this).attr("data-id");
        $.ajax({
            url: API_PATH + "departments/" + departmentId + "/employees/" + employeeId + "/delete",
            type: "DELETE",
            success: reloadEmployeesPage(departmentId)
        });
    })
}

function createEmployee(departmentId) {
    $("#btn-employee-create").click(function () {
        showEmployeePageCreate(function () {
            $('input[name="department_id"]').val(departmentId);
        })
    });
}

function saveEmployee(departmentId) {
    var employee = {
        department_id: departmentId,
        id: 0,
        fullname: $('input[name="fullname"]').val(),
        birthday:$('input[name="birthday"]').val(),
        salary: $('input[name="salary"]').val()
    };
    $.ajax({
        url: API_PATH + "departments/" + departmentId + "/employees/create",
        type: "PUT",
        data: JSON.stringify(employee),
        dataType: "json",
        contentType: "application/json",
        success: reloadEmployeesPage(departmentId)
    });
}

function updateEmployee(departmentId) {
    $(".btn-employee-edit").click(function () {
        var employeeId = $(this).attr("data-id");
        loadEmployeePageUpdate(departmentId, employeeId, function () {
            $('input[name="department_id"]').val(departmentId);
            $('input[name="id"]').val(employeeId);
        })
    });
}

function changeEmployee(departmentId, id) {
    var employee = {
        department_id: departmentId,
        id: id,
        fullname: $('input[name="fullname"]').val(),
        birthday:$('input[name="birthday"]').val(),
        salary: $('input[name="salary"]').val()
    };
    $.ajax({
        url: API_PATH + "departments/" + departmentId + "/employee/" + id + "/update",
        type: "POST",
        data: JSON.stringify(employee),
        dataType: "json",
        contentType: "application/json",
        success: reloadEmployeesPage(departmentId)
    });
}

function findByBirthday(department_id) {
    $("#btn-employee-findByDate").click(function () {
        var birthday = $('input[name="exactDate"]').val();
        loadEmployeesFindByDatePage(department_id, birthday, function (employees) {
            $(this).html(employees);
        });

    });
}

function findBetweenDates(department_id) {
    $("#btn-employee-findBetweenDates").click(function () {
        var from = $('input[name="fromDate"]').val();
        var to = $('input[name="toDate"]').val();
        loadEmployeesFindBetweenDatesPage(department_id, from, to, function (employees) {
            $(this).html(employees);
        });

    });
}


function loadDepartmentPageUpdate(id, done) {
    $.get(API_PATH + "departments/" + id, function (department) {
        showPage("resources/html/page-departmentUpdate.html", {department: department}, done)
    })
}

function loadEmployeePageUpdate(departmentId, id, done) {
    $.get(API_PATH + "departments/" + departmentId + "/employee/" + id, function (employee) {
        showPage("resources/html/page-employeeUpdate.html", {employee: employee}, done)
    })
}
function showDepartmentPageCreate(done) {
    showPage("resources/html/page-departmentCreate.html", null, done)
}

function showEmployeePageCreate(done) {
    showPage("resources/html/page-employeeCreate.html", null, done)
}

function loadDepartmentsPage(done) {
    $.get(API_PATH + "departments", function (departments) {
        showPage("resources/html/page-departments.html", {departments: departments}, done);

    });
}

function loadEmployeesPage(department_id, done) {
    $.get(API_PATH + "departments/" + department_id + "/employees", function (employees) {
        showPage("resources/html/page-employees.html", {employees: employees}, done);
    })
}

function loadEmployeesFindByDatePage(department_id, birthday, done) {
    $.get(API_PATH + "departments/" + department_id + "/employees/find/" + birthday, function (employees) {
        showPage("resources/html/page-findEmployees.html", {employees: employees}, done);
    });
}

function loadEmployeesFindBetweenDatesPage(department_id, from, to, done) {
    $.get(API_PATH + "departments/" + department_id + "/employees/from/" + from + "/to/" + to, function (employees) {
        showPage("resources/html/page-findEmployees.html", {employees: employees}, done);
    });
}

function reloadDepartmentsPage() {
    loadDepartmentsPage(function () {
        createDepartment();
        showEmployees();
        updateDepartment();
        deleteDepartment();
    });
}

function reloadEmployeesPage(departmentId) {
    loadEmployeesPage(departmentId, function () {
        loadEmployeesPage(departmentId, function () {
            deleteEmployees(departmentId);
            createEmployee(departmentId);
            updateEmployee(departmentId);
            findByBirthday(departmentId);
            findBetweenDates(departmentId);
        });
    });
}

function showPage(pagePath, context, done) {
    $.get(pagePath, function (template) {
        var output = Mustache.render(template, context);

        $("#content").html(output);

        done && done();
    });
}