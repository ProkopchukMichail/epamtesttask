package webapplication.jspcontrollers;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import webapplication.util.EmployeeWithDepartmentName;
import webapplication.webservice.DepartmentWebService;
import webapplication.webservice.EmployeeWebService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by comp on 31.07.2017.
 */
@Controller
public class JspEmployeeController {

    @Autowired
    EmployeeWebService employeeWebService;


    @GetMapping("/employees")
    public String getAllByDepartment(HttpServletRequest request, Model model){
        /*List<EmployeeWithDepartmentName> employeesWithDepartment=new ArrayList<EmployeeWithDepartmentName>();
        String departmentName=departmentWebService.getDepartmentName(getDepartmentId(request));
        List<Employee> employees=employeeWebService.getAllByDepartment(getDepartmentId(request));
        for(Employee e:employees){
            employeesWithDepartment.add(new EmployeeWithDepartmentName(
                    e.getId(),departmentName,e.getFullname(),e.getBirthday(),e.getSalary()
            ));
        }*/
        model.addAttribute("employees",employeeWebService.getAllByDepartment(getDepartmentId(request)));
        return "employees";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }
    private int getDepartmentId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("department_id"));
        return Integer.valueOf(paramId);
    }
}
