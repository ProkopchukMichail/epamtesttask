package restservice.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.EmployeeService;

import java.time.LocalDateTime;
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
    public void testGetMidSalary(){
        Assert.assertEquals(employeeService.getMidSalary(1), Integer.valueOf(1025));
    }

    @Test
    public void testGetByDate(){
        Assert.assertEquals(employeeService.getByDate(1, LocalDateTime.of(1970,05,05,0,0)),
                Arrays.asList(ADMIN1));
    }
    @Test
    public void getByDates(){
        Assert.assertEquals(employeeService.getByDates(1, LocalDateTime.of(1000,1,1,0,0),
                LocalDateTime.of(3000,1,1,0,0)),
                Arrays.asList(ADMIN1,ADMIN2));
    }

    @Test
    public void testGetAllByDepartment(){
        Assert.assertEquals(employeeService.getAllByDepartment(1),
                Arrays.asList(ADMIN1,ADMIN2));
    }

    @Test
    public void testGet(){
        Assert.assertEquals(employeeService.get(5),FINANCIER);
    }

    @Test
    public void testUpdate(){
        employeeService.update(HR_FOR_UPDATE);
        Assert.assertEquals(employeeService.getAllByDepartment(4), Arrays.asList( HR2,HR_FOR_UPDATE));
    }

    @Test
    public void testDelete(){
        employeeService.delete(7);
        Assert.assertEquals(employeeService.getAllByDepartment(4), Arrays.asList(HR));
    }



    @Test
    public void testCreate(){
        employeeService.create(HR2);
        Assert.assertEquals(employeeService.getAllByDepartment(4), Arrays.asList(HR, HR2));
    }
}
