package restservice;

import model.Department;
import model.util.DepartmentWithSalary;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import service.DepartmentService;

import java.util.List;

/**
 * Created by comp on 26.07.2017.
 */
public abstract class AbstractDepartmentController {
    private final Logger logger= Logger.getLogger(getClass());

    @Autowired
    private DepartmentService departmentService;

    public List<DepartmentWithSalary> getAll(){
        List<DepartmentWithSalary> withSalaries=departmentService.getAll();
        logger.debug("get all departments:");
        for(DepartmentWithSalary d:withSalaries){
            logger.debug(">>>>>"+d.getDepartmentName()+" "+d.getSalary() );
        }
        return withSalaries;
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
        logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>create new department "+department);
        return departmentService.create(department);
    }

    public Department update(Department department){
        logger.debug("update department "+department.getId());
        return departmentService.update(department);
    }

    public String getDepartmentName(int department_id) {
        logger.debug("get name for department "+department_id);
        return departmentService.getDepartmentName(department_id);
    }
}
