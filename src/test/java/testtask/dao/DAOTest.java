package testtask.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static testtask.TestData.*;
import static testtask.TestData.DEPARTMENTS;
import static testtask.TestData.HR_DEPARTMENT;

/**
 * Created by comp on 26.07.2017.
 */
@ContextConfiguration("classpath:spring/spring-db.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("hsql")
public class DAOTest {
    @Autowired
    private EmployeDAO employeDAO;
    @Autowired
    private DepartmentDAO departmentDAO;

    @Test
    public void daoTest(){
        //getALL
        Assert.assertEquals(employeDAO.getAll(),EMPLOYES);
        //get one
        Assert.assertEquals(employeDAO.get(5),ADMIN1);
        //update
        employeDAO.save(HR_FOR_UPDATE);
        Assert.assertEquals(employeDAO.getAll(), EMPLOYES_AFTER_UPDATE);
        //delete
        employeDAO.delete(10);
        Assert.assertEquals(employeDAO.getAll(), Arrays.asList(ADMIN1, ADMIN2,DEV1,DEV2,FINANCIER));
        //save
        employeDAO.save(HR);
        Assert.assertEquals(employeDAO.getAll(),EMPLOYES);
        //getAll
        Assert.assertEquals(departmentDAO.getAll(), DEPARTMENTS);
        //get one
        Assert.assertEquals(departmentDAO.get(1), ADMINISTRATION);
        //update
        departmentDAO.save(HR_DEPARTMENT_FOR_UPDATE);
        Assert.assertEquals(departmentDAO.getAll(), DEPARTMENTS_AFTER_UPDATE);
        //delete
        departmentDAO.delete(4);
        Assert.assertEquals(departmentDAO.getAll(), Arrays.asList(ADMINISTRATION, FINANCE, IT));
        //save
        departmentDAO.save(HR_DEPARTMENT);
        Assert.assertEquals(departmentDAO.getAll(), DEPARTMENTS);
    }
}
