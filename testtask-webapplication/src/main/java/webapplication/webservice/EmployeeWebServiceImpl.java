package webapplication.webservice;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * Created by comp on 30.07.2017.
 */
@Service
public class EmployeeWebServiceImpl implements EmployeeWebService{

    private final static String EMPLOYE_REST_URL=
            "http://localhost:8080/testtask-restservice-1.0-SNAPSHOT/rest";

    @Autowired
    private RestTemplate restTemplate;

    public Integer getMidSalary(int id){
        return restTemplate.getForObject(EMPLOYE_REST_URL+"/employees/midsalary/"+id, Integer.class);
    }

    public List<Employee> getAllByDepartment(int department_id) {
        return Arrays.asList(restTemplate.getForObject(
                EMPLOYE_REST_URL+"/employees/"+department_id,Employee[].class));
    }
}
