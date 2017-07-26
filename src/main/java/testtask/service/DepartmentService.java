package testtask.service;

import testtask.model.Department;

import java.util.List;

/**
 * Created by comp on 26.07.2017.
 */
public interface DepartmentService {
    List<Department> getAll();
    Department get(int id);
    boolean delete(int id);
    Department create(Department department);
    Department update(Department department);
}
