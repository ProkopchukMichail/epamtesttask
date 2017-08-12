$(document).ready(function () {

    loadDepartmentsPage(function () {
        $("#btn-department-create").click(createDepartment);
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
    showDepartmentPageCreate()
}

function saveDepartment() {
    var department=new Object();
    department.id=0;
    department.departmentName=$('input[name="departmentName"]').val();
    $.ajax({
        url: "/testtask-restservice-1.0-SNAPSHOT/rest/departments/create",
        type: "PUT",
        data: JSON.stringify(department),
        dataType:"json",
        contentType: "application/json",
        success: loadDepartmentsPage(location.reload())
    })
}

function changeDepartment(id) {
    var department=new Object();
    department.id=id;
    department.departmentName=$('input[name="departmentName"]').val();
    $.ajax({
        url: "/testtask-restservice-1.0-SNAPSHOT/rest/departments/"+id+"/update",
        type: "POST",
        data: JSON.stringify(department),
        dataType:"json",
        contentType: "application/json",
        success: loadDepartmentsPage(location.reload())
    })
}

function deleteDepartment() {
    $(".btn-department-delete").click(function () {
        var departmentId = $(this).attr("data-id");
        $.ajax({
            url: "/testtask-restservice-1.0-SNAPSHOT/rest/departments/" + departmentId + "/delete",
            type: "DELETE",
            success: location.reload(),
        })
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
        });
    })
}

function deleteEmployees(departmentId) {
    $(".btn-employee-delete").click(function () {
        var employeeId = $(this).attr("data-id");
        $.ajax({
            url: "/testtask-restservice-1.0-SNAPSHOT/rest/departments/" + departmentId +"/employees/"+employeeId+ "/delete",
            type: "DELETE",
            success: loadEmployeesPage(departmentId, location.reload())
        })
    })
}

function createEmployee(departmentId) {
    $("#btn-employee-create").click(function () {
        showEmployeePageCreate( function () {
            $('input[name="department_id"]').val(departmentId);
        })
    });
}

function saveEmployee(departmentId) {
    var employee=new Object();
    employee.department_id=departmentId;
    employee.id=0;
    employee.fullname=$('input[name="fullname"]').val();
    employee.birthday=$('input[name="birthday"]').val();
    employee.salary=$('input[name="salary"]').val();
    $.ajax({
        url: "/testtask-restservice-1.0-SNAPSHOT/rest/departments/"+departmentId+"/employees/create",
        type: "PUT",
        data: JSON.stringify(employee),
        dataType:"json",
        contentType: "application/json",
        success: loadDepartmentsPage(location.reload())
    })
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
    var employee=new Object();
    employee.department_id=departmentId;
    employee.id=id;
    employee.fullname=$('input[name="fullname"]').val();
    employee.birthday=$('input[name="birthday"]').val();
    employee.salary=$('input[name="salary"]').val();
    $.ajax({
        url: "/testtask-restservice-1.0-SNAPSHOT/rest/departments/"+departmentId+"/employee/"+id+"/update",
        type: "POST",
        data: JSON.stringify(employee),
        dataType:"json",
        contentType: "application/json",
        success: loadDepartmentsPage(location.reload())
    })
}

function findByBirthday(department_id) {
    $("#exactDate").on("input",function () {
        /*var birthday=$('input[name="exactDate"]').val();
         $.get("/testtask-restservice-1.0-SNAPSHOT/rest/departments/"+department_id+"/employees/find/"+birthday, function (employees) {
         showPage("resources/html/page-findEmployees.html", {employees:employees}, done);
         })*/
        var birthday=stringToDate($('input[name="exactDate"]').val());
        $('#employeesTable tr').each(function () {
                var row=$(this);
            var date = stringToDate(row.find("td").eq(1).text());
            var show = true;
            if (date == birthday)
                show = false;
            if (show)
                row.show();
            else
                row.hide();
            }
        )
    })
}
function stringToDate(s) {
    var ret = NaN;
    var parts = s.split("T")[0].split("-");
    var date=new Date({
        year:parts[0],
        month:parts[1],
        day:parts[2]
    });
    if (!isNaN(date.getTime())) {
        ret = date;
    }
    return ret;
}

function loadDepartmentPageUpdate(id, done) {
    $.get("/testtask-restservice-1.0-SNAPSHOT/rest/departments/" + id, function (department) {
        showPage("resources/html/page-departmentUpdate.html", {department:department}, done)
    })
}

function loadEmployeePageUpdate(departmentId, id, done) {
    $.get("/testtask-restservice-1.0-SNAPSHOT/rest/departments/"+departmentId+"/employee/"+id, function (employee) {
        showPage("resources/html/page-employeeUpdate.html", {employee:employee}, done)
    })
}
function showDepartmentPageCreate(done) {
    showPage("resources/html/page-departmentCreate.html", null, done)
}

function showEmployeePageCreate(done) {
    showPage("resources/html/page-employeeCreate.html", null, done)
}

function loadDepartmentsPage(done) {
    $.get("/testtask-restservice-1.0-SNAPSHOT/rest/departments", function (departments) {
        showPage("resources/html/page-departments.html", {departments: departments}, done);

    });
}

function loadEmployeesPage(department_id, done) {
    $.get("/testtask-restservice-1.0-SNAPSHOT/rest/departments/"+department_id+"/employees", function (employees) {
        showPage("resources/html/page-employees.html", {employees:employees}, done);
    })
}


function showPage(pagePath, context, done) {
    $.get(pagePath, function (template) {
        var output = Mustache.render(template, context);

        $("#content").html(output);

        done && done();
    });
}