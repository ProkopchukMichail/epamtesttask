package restservice.rest;

import model.Employee;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static restservice.rest.EmployeeREST.EMPLOYE_REST_URL;

/**
 * Created by comp on 25.07.2017.
 */
@RestController
@RequestMapping(value = EMPLOYE_REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeREST extends AbstractEmployeeController {

    static final String EMPLOYE_REST_URL = "/rest";

    @GetMapping("/employee/{id}")
    public Employee get(@PathVariable int id) {
        return super.get(id);
    }

    @GetMapping("/employees/midsalary/{id}")
    public Integer getMidSalary(@PathVariable int id){
        return super.getMidSalary(id);
    }

    @GetMapping("/employees/{department_id}")
    public List<Employee> getAllByDepartment(@PathVariable int department_id) {
        return super.getAllByDepartment(department_id);
    }

    @DeleteMapping("/employees/delete/{id}")
    public boolean delete(@PathVariable int id) {
        return super.delete(id);
    }

    @PutMapping(value = "/employees/put", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employee update(@RequestBody Employee employee) {
        return super.update(employee);
    }

    @PostMapping(value = "/employees/post", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employee create(@RequestBody Employee employee) {
        return super.create(employee);
    }
}
