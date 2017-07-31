package webapp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import webapplication.webservice.DepartmentWebService;
import webapplication.webservice.DepartmentWebServiceImpl;

import java.util.Arrays;

import static webapp.TestData.*;

/**
 * Created by comp on 29.07.2017.
 */
@ContextConfiguration("classpath:spring-app.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DepartmentWebServiceTest {

    @Autowired
    private DepartmentWebService departmentWebServiceImpl;

    @Test
    public void testGetAll(){
        Assert.assertEquals(departmentWebServiceImpl.getAll(), DEPARTMENTS);
    }

    @Test
    public void testGet(){
        Assert.assertEquals(departmentWebServiceImpl.get(1), ADMINISTRATION);
    }

    @Test
    public void testDelete(){
        departmentWebServiceImpl.delete(4);
        Assert.assertEquals(departmentWebServiceImpl.getAll(), Arrays.asList(ADMINISTRATION, FINANCE, IT));
    }

    @Test
    public void testUpdate(){
        departmentWebServiceImpl.update(HR_DEPARTMENT_FOR_UPDATE);
        Assert.assertEquals(departmentWebServiceImpl.getAll(), DEPARTMENTS_AFTER_UPDATE);
    }
}
