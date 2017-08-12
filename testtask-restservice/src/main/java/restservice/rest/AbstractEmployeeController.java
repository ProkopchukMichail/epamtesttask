package restservice.rest;

import model.Employee;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import restservice.service.EmployeeService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by comp on 26.07.2017.
 */
public abstract class AbstractEmployeeController {

    private final Logger logger=Logger.getLogger(getClass());

    @Autowired
    private EmployeeService employeeService;

    public Employee get(int id){
        logger.debug("get employee "+id);
        return employeeService.get(id);
    }

    public List<Employee> getAllByDepartment(int id){
        logger.debug("get all employees by department "+id);
        return employeeService.getAllByDepartment(id);
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
        logger.warn(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+employee.toString());
        logger.warn(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+employee.getId());
        return employeeService.create(employee);
    }

    public Integer getMidSalary(int id) {
        logger.debug("get mid salary fo department "+id);
        return employeeService.getMidSalary(id);
    }

    public List<Employee> getByDate(int department_id, LocalDateTime dateTime) {
        logger.debug(">>>>>>>>>>>>>>>>>>>get by date "+dateTime+"  "+department_id);
        return employeeService.getByDate(department_id,dateTime);
    }

    public List<Employee> getByDates(int department_id, LocalDateTime startDate, LocalDateTime endDate) {
        logger.debug("get by dates "+startDate+':'+endDate);
        return  employeeService.getByDates(department_id,startDate,endDate);
    }
}
