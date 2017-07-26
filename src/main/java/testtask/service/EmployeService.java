package testtask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testtask.dao.EmployeDAO;
import testtask.model.Employe;

import java.util.List;

/**
 * Created by comp on 25.07.2017.
 */
@Service
public class EmployeService {

    private EmployeDAO employeDAO;

    @Autowired
    public EmployeService(EmployeDAO employeDAO) {
        this.employeDAO = employeDAO;
    }

    public List<Employe> getAll(){return employeDAO.getAll();}

    public Employe get(int id){return employeDAO.get(id);}

    public boolean delete(int id){return employeDAO.delete(id);}

    public Employe save(Employe employe){ return employeDAO.save(employe);}
}
