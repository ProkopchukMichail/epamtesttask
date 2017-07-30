package restservice.service;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restservice.dao.EmployeeDAO;

import java.util.List;

/**
 * Created by comp on 25.07.2017.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public List<Employee> getAll(){return employeeDAO.getAll();}

    public Employee get(int id){return employeeDAO.get(id);}

    public boolean delete(int id){return employeeDAO.delete(id);}

    public Employee create(Employee employee){ return employeeDAO.save(employee);}

    public Employee update(Employee employee){return employeeDAO.save(employee);}

    public Integer getMidSalary(int id) {
        return employeeDAO.getMidSalary(id);
    }
}
