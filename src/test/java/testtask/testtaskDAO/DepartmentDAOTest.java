package testtask.testtaskDAO;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import testtask.TestData;
import testtask.dao.DepartmentDAO;

import java.util.Arrays;

import static testtask.TestData.*;

/**
 * Created by comp on 24.07.2017.
 */
@ContextConfiguration("classpath:spring/spring-db.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("hsql")
public class DepartmentDAOTest {

    @Autowired
    private DepartmentDAO departmentDAO;

    @Test
    public void testGetAll() {
        Assert.assertEquals(departmentDAO.getAll(), DEPARTMENTS);
    }

    @Test
    public void testGet() {
        Assert.assertEquals(departmentDAO.get(1), ADMINISTRATION);
    }

    @Test
    public void testDelete() {
        departmentDAO.delete(1);
        Assert.assertEquals(departmentDAO.getAll(), Arrays.asList(FINANCE, HR, IT));
    }

    @Test
    public void testSave() {
        departmentDAO.save(ADMINISTRATION);
        Assert.assertEquals(departmentDAO.getAll(), DEPARTMENTS);
    }
}
