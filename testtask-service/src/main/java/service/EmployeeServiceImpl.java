package service;

import dao.EmployeeDAO;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by comp on 25.07.2017.
 */
@Service("EmployeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public List<Employee> getAllByDepartment(int id){return employeeDAO.getAllByDepartment(id);}

    public Employee get(int id){return employeeDAO.get(id);}

    public boolean delete(int id){return employeeDAO.delete(id);}

    public Employee create(Employee employee){ return employeeDAO.save(employee);}

    public Employee update(Employee employee){return employeeDAO.save(employee);}

    public Integer getMidSalary(int id) {
        return employeeDAO.getMidSalary(id);
    }

    public List<Employee> getByDate(int department_id, LocalDateTime dateTime) {
        return employeeDAO.getByDate(department_id,dateTime);
    }

    public List<Employee> getByDates(int department_id, LocalDateTime startDate, LocalDateTime endDate) {
        return employeeDAO.getByDates(department_id,startDate,endDate);
    }
}
