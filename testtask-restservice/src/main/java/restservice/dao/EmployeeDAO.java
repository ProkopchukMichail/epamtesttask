package restservice.dao;


import model.Employee;

import java.util.List;

/**
 * Created by comp on 26.07.2017.
 */
public interface EmployeeDAO {

    List<Employee> getAllByDepartment(int id);
    Employee get(int id);
    boolean delete(int id);
    Employee save(Employee employee);
    Integer getMidSalary(int id);
}
