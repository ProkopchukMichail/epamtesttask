package testtask.service;

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
public class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;

    @Test
    public void testGetAll(){
        Assert.assertEquals(departmentService.getAll(), DEPARTMENTS);
    }

    @Test
    public void testGet(){
        Assert.assertEquals(departmentService.get(1), ADMINISTRATION);
    }

    @Test
    public void testUpdate(){
        departmentService.update(HR_DEPARTMENT_FOR_UPDATE);
        Assert.assertEquals(departmentService.getAll(), DEPARTMENTS_AFTER_UPDATE);
    }

    @Test
    public void testDelete(){
        departmentService.delete(4);
        Assert.assertEquals(departmentService.getAll(), Arrays.asList(ADMINISTRATION, FINANCE, IT));
    }

    @Test
    public void testCreate(){
        departmentService.create(HR_DEPARTMENT);
        Assert.assertEquals(departmentService.getAll(), DEPARTMENTS);
    }
}
