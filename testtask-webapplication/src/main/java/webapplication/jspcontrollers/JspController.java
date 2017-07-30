package webapplication.jspcontrollers;

import model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import webapplication.util.DepartmentWithSalary;
import webapplication.webservice.DepartmentWebService;
import webapplication.webservice.EmployeWebService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by comp on 30.07.2017.
 */
@Controller()
@RequestMapping()
public class JspController {

    @Autowired
    private DepartmentWebService departmentWebService;

    @Autowired
    private EmployeWebService employeWebService;


    @GetMapping
    public String root() {
        return "index";
    }

    @GetMapping("/departments")
    public String getAll(Model model) {
        List<DepartmentWithSalary> departmentWithSalaries = new ArrayList<DepartmentWithSalary>();
        for (Department d : departmentWebService.getAll()) {
            Integer salary = employeWebService.getMidSalary(d.getId());
            departmentWithSalaries.add(new DepartmentWithSalary(
                    d.getId(), d.getDepartmentName(), salary
            ));
        }
        model.addAttribute("departments", departmentWithSalaries);
        return "departments";
    }

    @GetMapping("/departments/delete")
    public String delete(HttpServletRequest request) {
        departmentWebService.delete(getId(request));
        return "redirect:/departments";
    }

    @GetMapping("/departments/update")
    public String update(HttpServletRequest request, Model model) {
        model.addAttribute("department", departmentWebService.get(getId(request)));
        return "department";
    }

    @GetMapping("/departments/create")
    public String create(Model model) {
        model.addAttribute("department", new Department());
        return "department";
    }

    @PostMapping(value = "/departments/post", produces = MediaType.APPLICATION_JSON_VALUE)
    public String createOrUpadate(HttpServletRequest request) {
        Department department = new Department();
        department.setDepartmentName(request.getParameter("departmentName"));
        department.setId(getId(request));
        if (department.getId() != 0) departmentWebService.update(department);
        else departmentWebService.create(department);
        return "redirect:/departments";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }
}
