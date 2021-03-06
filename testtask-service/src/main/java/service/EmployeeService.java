package service;


import model.Employee;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by comp on 26.07.2017.
 */
public interface EmployeeService {

    List<Employee> getAllByDepartment(int id);
    Employee get(int id);
    boolean delete(int id);
    Employee create(Employee employee);
    Employee update(Employee employee);
    Integer getMidSalary(int id);

    List<Employee> getByDate(int department_id, LocalDateTime dateTime);

    List<Employee> getByDates(int department_id, LocalDateTime startDate, LocalDateTime endDate);
}
