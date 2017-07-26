package testtask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testtask.dao.jdbc.JdbcDepartmentDAO;
import testtask.model.Department;

import java.util.List;

/**
 * Created by comp on 23.07.2017.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{

    private JdbcDepartmentDAO departmentDAO;

    @Autowired
    public DepartmentServiceImpl(JdbcDepartmentDAO departmentDAO){
        this.departmentDAO=departmentDAO;
    }

    public List<Department> getAll(){
       return departmentDAO.getAll();
    }

    public Department get(int id) {
        return departmentDAO.get(id);
    }

    public boolean delete(int id){
        return departmentDAO.delete(id);
    }

    public Department create(Department department){
        return departmentDAO.save(department);
    }

    public Department update(Department department) {
        return departmentDAO.save(department);
    }
}
