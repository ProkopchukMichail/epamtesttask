package webapplication.webservice;

import model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by comp on 29.07.2017.
 */
@Service
public class DepartmentWebService {

    private static final String DEPARTMENT_REST_URL=
            "http://localhost:8080/testtask-restservice-1.0-SNAPSHOT/rest/departments";

    @Autowired
    private RestTemplate restTemplate;

    public List<Department> getAll(){
        return Arrays.asList(restTemplate.getForObject(DEPARTMENT_REST_URL,Department[].class));
    }

    public Department get(int id){
        return restTemplate.getForObject(DEPARTMENT_REST_URL+"/"+id,Department.class);
    }
}
