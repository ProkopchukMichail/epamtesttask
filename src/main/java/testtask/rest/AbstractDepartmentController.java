package testtask.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import testtask.model.Department;
import testtask.service.DepartmentServiceImpl;

import java.util.List;

/**
 * Created by comp on 26.07.2017.
 */
public abstract class AbstractDepartmentController {
    private final Logger logger= Logger.getLogger(getClass());
    private DepartmentServiceImpl departmentService;

    @Autowired
    public AbstractDepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    public AbstractDepartmentController() {
    }

    public List<Department> getAll(){
        logger.debug("get all departments");
        return departmentService.getAll();
    }

    public Department get(int id){
        logger.debug("get department "+id);
        return departmentService.get(id);
    }

    public boolean delete(int id){
        logger.debug("delete department +"+ id);
        return departmentService.delete(id);
    }

    public Department create(Department department){
        logger.debug("create new deaprtment"+department);
        return departmentService.create(department);
    }

    public Department update(Department department){
        logger.debug("update department "+department.getId());
        return departmentService.update(department);
    }
}
