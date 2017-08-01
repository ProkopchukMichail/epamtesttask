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
            "http://localhost:8080/testtask-restservice-1.0-SNAPSHOT//rest/departments";

    @Autowired
    private RestTemplate restTemplate;

    public Integer getMidSalary(int id){
        return restTemplate.getForObject(EMPLOYE_REST_URL+'/'+id+"/employees/midsalary", Integer.class);
    }

    public List<Employee> getAllByDepartment(int department_id) {
        return Arrays.asList(restTemplate.getForObject(
                EMPLOYE_REST_URL+'/'+department_id+"/employees",Employee[].class));
    }

    public void delete(int department_id,int id) {
        restTemplate.delete(
                EMPLOYE_REST_URL+'/'+department_id+"/employees/"+id+"/delete");
    }

    public Employee get(int department_id,int id) {
        return restTemplate.getForObject(
                EMPLOYE_REST_URL+'/'+department_id+"/employee/"+id,Employee.class);
    }

    public void update(Employee employee) {
        restTemplate.postForObject(
                EMPLOYE_REST_URL+'/'+employee.getDepartment_id()+"/employees/update", employee, Employee.class
        );
    }

    public void create(Employee employee) {
        restTemplate.put(
                EMPLOYE_REST_URL+'/'+employee.getDepartment_id()+"/employees/create",employee,Employee.class
        );
    }
}

