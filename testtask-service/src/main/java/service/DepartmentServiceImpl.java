package service;

import dao.DepartmentDAO;
import model.Department;
import model.util.DepartmentWithSalary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * Created by comp on 23.07.2017.
 */
@Service("DepartmentServiceImpl")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDAO departmentDAO;

    public List<DepartmentWithSalary> getAll() {
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

    public String getDepartmentName(int department_id) {
        return departmentDAO.getDepartmentName(department_id);
    }
}
