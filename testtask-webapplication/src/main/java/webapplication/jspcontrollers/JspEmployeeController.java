package webapplication.jspcontrollers;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import webapplication.util.EmployeeWithDepartmentName;
import webapplication.webservice.DepartmentWebService;
import webapplication.webservice.EmployeeWebService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Created by comp on 31.07.2017.
 */
@Controller
public class JspEmployeeController {

    /*@Autowired
    EmployeeWebService employeeWebService;


    @GetMapping("/employees")
    public String getAllByDepartment(HttpServletRequest request, Model model){
        *//*List<EmployeeWithDepartmentName> employeesWithDepartment=new ArrayList<EmployeeWithDepartmentName>();
        String departmentName=departmentWebService.getDepartmentName(getDepartmentId(request));
        List<Employee> employees=employeeWebService.getAllByDepartment(getDepartmentId(request));
        for(Employee e:employees){
            employeesWithDepartment.add(new EmployeeWithDepartmentName(
                    e.getId(),departmentName,e.getFullname(),e.getBirthday(),e.getSalary()
            ));
        }*//*
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
    }*/

    @Autowired
    EmployeeWebService employeeWebService;
    private final static Logger logger=Logger.getLogger("model");


    @GetMapping("/departments/{department_id}/employees")
    public String getAllByDepartment(@PathVariable int department_id, HttpServletRequest request, Model model){
        logger.warning(">>>>>>>>>>>>>>>>>>>>>>>>>>>>"+department_id);
        model.addAttribute("employees",employeeWebService.getAllByDepartment(department_id));
        return "employees";
    }

    @GetMapping("/departments/{department_id}/employees/{id}/delete")
    public String delete(@PathVariable int department_id,@PathVariable int id){
       /* employeeWebService.delete(getId(request));*/
        employeeWebService.delete(id);
        return "employees";
    }

    @GetMapping("/departments/{department_id}/employees/update")
    public String update(Model model,@PathVariable int department_id, HttpServletRequest request) {
        model.addAttribute("employee", employeeWebService.get(getId(request)));
        /*model.addAttribute("employee", employeeWebService.get(id));*/
        return "employee";
    }

    @GetMapping("/departments/{department_id}/employees/create")
    public String create(Model model,@PathVariable int department_id) {
        Employee employee=new Employee();
        employee.setDepartment_id(department_id);
        model.addAttribute("employee", employee);
        return "employee";
    }

    @PostMapping(value = "/departments/{department_id}/employees/postemployee", produces = MediaType.APPLICATION_JSON_VALUE)
    public String createOrUpadate(@PathVariable int department_id,HttpServletRequest request) {
        Employee employee=new Employee();
        employee.setId(getId(request));
        employee.setDepartment_id(getDepartmentId(request));
        employee.setFullname(request.getParameter("fullname"));
        LocalDate birthday=LocalDate.parse(request.getParameter("birthday"));
        employee.setBirthday(LocalDateTime.of(birthday, LocalTime.of(0,0)));
        employee.setSalary(Integer.valueOf(request.getParameter("salary")));
        if (employee.getId() != 0) employeeWebService.update(employee);
        else employeeWebService.create(employee);
        return "redirect:/departments/"+employee.getDepartment_id()+"/employees";
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
