package testtask.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import testtask.dao.jdbc.JdbcDepartmentDAO;
import testtask.dao.jdbc.JdbcEmployeeDAO;

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
    private JdbcEmployeeDAO employeeDAO;
    @Autowired
    private JdbcDepartmentDAO departmentDAO;

    @Test
    public void daoTest(){
        //getALL
        Assert.assertEquals(employeeDAO.getAll(), EMPLOYEES);
        //get one
        Assert.assertEquals(employeeDAO.get(5),ADMIN1);
        //update
        employeeDAO.save(HR_FOR_UPDATE);
        Assert.assertEquals(employeeDAO.getAll(), EMPLOYEES_AFTER_UPDATE);
        //delete
        employeeDAO.delete(10);
        Assert.assertEquals(employeeDAO.getAll(), Arrays.asList(ADMIN1, ADMIN2,DEV1,DEV2,FINANCIER));
        //create
        employeeDAO.save(HR);
        Assert.assertEquals(employeeDAO.getAll(), EMPLOYEES);
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
        //create
        departmentDAO.save(HR_DEPARTMENT);
        Assert.assertEquals(departmentDAO.getAll(), DEPARTMENTS);
    }
}
