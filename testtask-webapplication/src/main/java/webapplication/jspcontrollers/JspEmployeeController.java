package webapplication.jspcontrollers;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import webapplication.webservice.EmployeeWebService;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;



/**
 * Created by comp on 31.07.2017.
 */
@Controller
public class JspEmployeeController {

    @Autowired
    EmployeeWebService employeeWebService;

    @GetMapping("/departments/{department_id}/employees")
    public String getAllByDepartment(@PathVariable int department_id, HttpServletRequest request, Model model){
        model.addAttribute("employees",employeeWebService.getAllByDepartment(department_id));
        return "employees";
    }

    @GetMapping("/departments/{department_id}/employees/{id}/delete")
    public String delete(@PathVariable int department_id,@PathVariable int id){
        employeeWebService.delete(department_id,id);
        return "redirect:/departments/"+department_id+"/employees";
    }

    @GetMapping("/departments/{department_id}/employees/update")
    public String update(Model model,@PathVariable int department_id, HttpServletRequest request) {
        model.addAttribute("employee", employeeWebService.get(department_id,getId(request)));
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
        if(getId(request)!=null) employee.setId(getId(request));
        employee.setDepartment_id(getDepartmentId(request));
        employee.setFullname(request.getParameter("fullname"));
        LocalDate birthday;
        try{
            birthday=LocalDate.parse(request.getParameter("birthday"));
        } catch (DateTimeParseException e){
            birthday=LocalDate.of(1900,1,1);
        }
        employee.setBirthday(LocalDateTime.of(birthday, LocalTime.of(0,0)));
        String salary=request.getParameter("salary");
        try{
            employee.setSalary(Integer.valueOf(salary));
        } catch (NumberFormatException e){
            employee.setSalary(500);
        }
        if (employee.getId() != null) employeeWebService.update(employee);
        else employeeWebService.create(employee);
        return "redirect:/departments/"+employee.getDepartment_id()+"/employees";
    }

    private Integer getId(HttpServletRequest request) {
        String paramId = request.getParameter("id");
        if(paramId.equals("")) return null;
        return Integer.valueOf(paramId);
    }
    private int getDepartmentId(HttpServletRequest request) {
        String paramId = request.getParameter("department_id");
        return Integer.valueOf(paramId);
    }
}
