package testtask.dao;

import model.Department;

import java.util.List;

/**
 * Created by comp on 26.07.2017.
 */
public interface DepartmentDAO {

    List<Department> getAll();
    Department get(int id);
    boolean delete(int id);
    Department save(Department department);
}
