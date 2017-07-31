package webapp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import webapplication.webservice.EmployeeWebService;

import java.util.Arrays;

import static webapp.TestData.*;
/**
 * Created by comp on 31.07.2017.
 */
@ContextConfiguration("classpath:spring-app.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeWebServiceTest {

    @Autowired
    EmployeeWebService employeeWebService;

    @Test
    public void testGetAllByDepartment(){
        Assert.assertEquals(employeeWebService.getAllByDepartment(1),
                Arrays.asList(ADMIN1,ADMIN2));
    }
}
