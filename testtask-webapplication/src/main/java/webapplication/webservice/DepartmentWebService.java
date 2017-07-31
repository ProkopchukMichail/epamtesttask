package webapplication.webservice;

import model.Department;

import java.util.List;

/**
 * Created by comp on 31.07.2017.
 */
public interface DepartmentWebService {

    List<Department> getAll();
    Department get(int id);
    void delete(int id);
    void update(Department department);
    void create(Department department);

    String getDepartmentName(int department_id);
}
