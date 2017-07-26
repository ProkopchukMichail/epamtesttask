package testtask.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;
import testtask.model.Department;
import testtask.service.DepartmentService;

import java.util.List;

/**
 * Created by comp on 23.07.2017.
 */
@RestController()
@RequestMapping(value = DepartmentREST.REST_URL)
public class DepartmentREST {

    static final  String REST_URL="/rest/";
    private final Logger logger= Logger.getLogger(getClass());
    private DepartmentService departmentService;

    @Autowired
    public DepartmentREST(DepartmentService departmentService){
        this.departmentService=departmentService;
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments(){
        logger.debug("get all");
        return departmentService.getAll();
    }

    @GetMapping("/department/{id}")
    public Department getDepartment(@PathVariable int id){
        logger.debug("get department "+id);
        return departmentService.get(id);
    }




}
