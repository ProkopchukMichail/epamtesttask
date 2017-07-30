package restservice.service;


import model.Employee;

import java.util.List;

/**
 * Created by comp on 26.07.2017.
 */
public interface EmployeeService {

    List<Employee> getAll();
    Employee get(int id);
    boolean delete(int id);
    Employee create(Employee employee);
    Employee update(Employee employee);
    Integer getMidSalary(int id);
}
