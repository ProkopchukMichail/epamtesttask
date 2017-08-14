package dao;

import model.Department;
import model.util.DepartmentWithSalary;

import java.util.List;

/**
 * Created by comp on 26.07.2017.
 */
public interface DepartmentDAO {

    List<DepartmentWithSalary> getAll();
    Department get(int id);
    boolean delete(int id);
    Department save(Department department);
    String getDepartmentName(int department_id);
}
