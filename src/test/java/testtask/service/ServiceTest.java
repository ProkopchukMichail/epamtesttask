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
import static testtask.TestData.DEPARTMENTS;

/**
 * Created by comp on 26.07.2017.
 */
@ContextConfiguration("classpath:spring/spring-db.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("hsql")
public class ServiceTest {

    @Autowired
    private DepartmentServiceImpl departmentService;

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Test
    public void serviceTest(){
        Assert.assertEquals(employeeService.getAll(), EMPLOYEES);
        //get one
        Assert.assertEquals(employeeService.get(5),ADMIN1);
        //update
        employeeService.update(HR_FOR_UPDATE);
        Assert.assertEquals(employeeService.getAll(), EMPLOYEES_AFTER_UPDATE);
        //delete
        employeeService.delete(10);
        Assert.assertEquals(employeeService.getAll(), Arrays.asList(ADMIN1, ADMIN2,DEV1,DEV2,FINANCIER));
        //create
        employeeService.create(HR);
        Assert.assertEquals(employeeService.getAll(), EMPLOYEES);
        //getAll
        Assert.assertEquals(departmentService.getAll(), DEPARTMENTS);
        //get one
        Assert.assertEquals(departmentService.get(1), ADMINISTRATION);
        //update
        departmentService.update(HR_DEPARTMENT_FOR_UPDATE);
        Assert.assertEquals(departmentService.getAll(), DEPARTMENTS_AFTER_UPDATE);
        //delete
        departmentService.delete(4);
        Assert.assertEquals(departmentService.getAll(), Arrays.asList(ADMINISTRATION, FINANCE, IT));
        //create
        departmentService.create(HR_DEPARTMENT);
        Assert.assertEquals(departmentService.getAll(), DEPARTMENTS);
    }
}
