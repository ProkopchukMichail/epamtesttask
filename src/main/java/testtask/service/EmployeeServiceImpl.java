package testtask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testtask.dao.jdbc.JdbcEmployeeDAO;
import testtask.model.Employee;

import java.util.List;

/**
 * Created by comp on 25.07.2017.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private JdbcEmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(JdbcEmployeeDAO employeDAO) {
        this.employeeDAO = employeDAO;
    }

    public List<Employee> getAll(){return employeeDAO.getAll();}

    public Employee get(int id){return employeeDAO.get(id);}

    public boolean delete(int id){return employeeDAO.delete(id);}

    public Employee create(Employee employee){ return employeeDAO.save(employee);}

    public Employee update(Employee employee){return employeeDAO.save(employee);}
}
