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

/**
 * Created by comp on 26.07.2017.
 */
@ContextConfiguration("classpath:spring/spring-db.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("hsql")
public class EmployeeDAOTest {
    @Autowired
    private EmployeeDAO employeeDAO;

    @Test
    public void testGetAll(){
        Assert.assertEquals(employeeDAO.getAll(), EMPLOYEES);
    }

    @Test
    public void testGet(){
        Assert.assertEquals(employeeDAO.get(5),ADMIN1);
    }

    @Test
    public void testDelete(){
        employeeDAO.delete(10);
        Assert.assertEquals(employeeDAO.getAll(), Arrays.asList(ADMIN1, ADMIN2,DEV1,DEV2,FINANCIER));
    }

    @Test
    public void testUpdate(){
        employeeDAO.save(HR_FOR_UPDATE);
        Assert.assertEquals(employeeDAO.getAll(), EMPLOYEES_AFTER_UPDATE);
    }

    @Test
    public void testCreate(){
        employeeDAO.save(HR);
        Assert.assertEquals(employeeDAO.getAll(), EMPLOYEES);
    }
}
