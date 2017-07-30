package webapplication.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by comp on 30.07.2017.
 */
@Service
public class EmployeWebService {

    private final static String EMPLOYE_REST_URL=
            "http://localhost:8080/testtask-restservice-1.0-SNAPSHOT/rest/employees";

    @Autowired
    private RestTemplate restTemplate;

    public Integer getMidSalary(int id){
        return restTemplate.getForObject(EMPLOYE_REST_URL+"/midsalary/"+id, Integer.class);
    }

}
