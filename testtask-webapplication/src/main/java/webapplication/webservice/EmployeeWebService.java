package webapplication.webservice;

import model.Employee;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by comp on 31.07.2017.
 */
public interface EmployeeWebService {


    Integer getMidSalary(int id);

    List<Employee> getAllByDepartment(int department_id);

    void delete(int department_id,int id);

    Employee get(int department_id,int id);

    void update(Employee employee);

    void create(Employee employee);

    List<Employee> getByDate(int department_id,LocalDateTime dateTime);

    List<Employee> getByDates(int department_id, LocalDateTime startDate, LocalDateTime endDate);
}
