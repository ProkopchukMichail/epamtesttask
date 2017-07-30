package webapp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import webapplication.webservice.DepartmentWebService;

import static webapp.TestData.*;

/**
 * Created by comp on 29.07.2017.
 */
@ContextConfiguration("classpath:spring-app.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DepartmentWebServiceTest {

    @Autowired
    private DepartmentWebService departmentWebService;

    @Test
    public void testGetAll(){
        Assert.assertEquals(departmentWebService.getAll(), DEPARTMENTS);
    }

    @Test
    public void testGet(){
        Assert.assertEquals(departmentWebService.get(1), ADMINISTRATION);
    }
}
