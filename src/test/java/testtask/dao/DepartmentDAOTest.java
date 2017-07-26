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
public class DepartmentDAOTest {
    @Autowired
    private DepartmentDAO departmentDAO;

    @Test
    public void testGetAll(){
        Assert.assertEquals(departmentDAO.getAll(), DEPARTMENTS);
    }

    @Test
    public void testGet(){
        Assert.assertEquals(departmentDAO.get(1), ADMINISTRATION);
    }

    @Test
    public void testUpdate(){
        departmentDAO.save(HR_DEPARTMENT_FOR_UPDATE);
        Assert.assertEquals(departmentDAO.getAll(), DEPARTMENTS_AFTER_UPDATE);
    }

    @Test
    public void testDelete(){
        departmentDAO.delete(4);
        Assert.assertEquals(departmentDAO.getAll(), Arrays.asList(ADMINISTRATION, FINANCE, IT));
    }

    @Test
    public void testCreate(){
        departmentDAO.save(HR_DEPARTMENT);
        Assert.assertEquals(departmentDAO.getAll(), DEPARTMENTS);
    }
}
