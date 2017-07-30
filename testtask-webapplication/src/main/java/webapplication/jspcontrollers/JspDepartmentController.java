package webapplication.jspcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import webapplication.webservice.DepartmentWebService;

/**
 * Created by comp on 30.07.2017.
 */
@Controller()
public class JspDepartmentController {

    @Autowired
    private DepartmentWebService departmentWebService;

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/departments")
    public String getAll(Model model){
        model.addAttribute("departments",departmentWebService.getAll());
        return "departments";
    }
}
