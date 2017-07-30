package restservice.rest;

import model.Employee;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import restservice.service.EmployeeService;

import java.util.List;

/**
 * Created by comp on 26.07.2017.
 */
public class AbstractEmployeeController {

    private final Logger logger=Logger.getLogger(getClass());

    @Autowired
    private EmployeeService employeeService;

    public Employee get(int id){
        logger.debug("get employee "+id);
        return employeeService.get(id);
    }

    public List<Employee> getAll(){
        logger.debug("get all employees");
        return employeeService.getAll();
    }

    public boolean delete(int id){
        logger.debug("delete employee "+id);
        return employeeService.delete(id);
    }

    public Employee update(Employee employee){
        logger.debug("update employee "+employee.getId());
        return employeeService.update(employee);
    }

    public Employee create(Employee employee){
        logger.debug("create employee "+employee);
        return employeeService.create(employee);
    }

    public Integer getMidSalary(int id) {
        logger.debug("get mid salary fo department "+id);
        return employeeService.getMidSalary(id);
    }
}
