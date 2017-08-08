package webapplication.webservice;

import model.Department;
import model.util.DepartmentWithSalary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

/**
 * Created by comp on 29.07.2017.
 */
@Service
public class DepartmentWebServiceImpl implements DepartmentWebService{

    private static final String DEPARTMENT_REST_URL=
            "http://localhost:8080/testtask-restservice-1.0-SNAPSHOT/rest/departments";

    @Autowired
    private RestTemplate restTemplate;

    public List<DepartmentWithSalary> getAll(){
        return Arrays.asList(restTemplate.getForObject(DEPARTMENT_REST_URL,DepartmentWithSalary[].class));
    }

    public Department get(int id){
        return restTemplate.getForObject(DEPARTMENT_REST_URL+"/"+id,Department.class);
    }

    public void delete(int id){
        restTemplate.delete(DEPARTMENT_REST_URL+'/'+id+"/delete");
    }

    public void update(Department department){
        restTemplate.postForObject(DEPARTMENT_REST_URL+'/'+department.getId()+"/update",department,Department.class);
    }

    public void create(Department department) {
        restTemplate.put(DEPARTMENT_REST_URL+"/create", department, Department.class);
    }

    public String getDepartmentName(int department_id) {
        return restTemplate.getForObject(DEPARTMENT_REST_URL+'/'+department_id+"/name/",String.class);
    }
}
