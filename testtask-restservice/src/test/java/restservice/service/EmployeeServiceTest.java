package restservice.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static restservice.TestData.*;

/**
 * Created by comp on 26.07.2017.
 */
@ContextConfiguration("classpath:spring/spring-db.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("hsql")
public class EmployeeServiceTest {
    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testGetAll(){
        Assert.assertEquals(employeeService.getAll(), EMPLOYEES);
    }

    @Test
    public void testGet(){
        Assert.assertEquals(employeeService.get(5),ADMIN1);
    }

    @Test
    public void testDelete(){
        employeeService.delete(10);
        Assert.assertEquals(employeeService.getAll(), Arrays.asList(ADMIN1, ADMIN2,DEV1,DEV2,FINANCIER));
    }

    @Test
    public void testUpdate(){
        employeeService.update(HR_FOR_UPDATE);
        Assert.assertEquals(employeeService.getAll(), EMPLOYEES_AFTER_UPDATE);
    }

    @Test
    public void testCreate(){
        employeeService.create(HR);
        Assert.assertEquals(employeeService.getAll(), EMPLOYEES);
    }
}
