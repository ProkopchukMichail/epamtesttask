package testtask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import testtask.dao.DepartmentDAO;
import testtask.model.Department;

import java.util.List;

/**
 * Created by comp on 23.07.2017.
 */
@Service
public class DepartmentService {

    private DepartmentDAO departmentDAO;

    @Autowired
    public DepartmentService(DepartmentDAO departmentDAO){
        this.departmentDAO=departmentDAO;
    }

    public List<Department> getAll(){
       return departmentDAO.getAll();
    }

    public Department get(int id) {
        return departmentDAO.get(id);
    }
}
