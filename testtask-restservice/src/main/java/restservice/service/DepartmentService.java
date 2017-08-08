package restservice.service;

import model.Department;
import model.util.DepartmentWithSalary;

import java.util.List;

/**
 * Created by comp on 26.07.2017.
 */
public interface DepartmentService {
    List<DepartmentWithSalary> getAll();
    Department get(int id);
    boolean delete(int id);
    Department create(Department department);
    Department update(Department department);
    String getDepartmentName(int department_id);
}
