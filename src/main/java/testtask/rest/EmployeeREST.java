package testtask.rest;

import org.springframework.web.bind.annotation.*;
import testtask.model.Employee;

import java.util.List;

import static testtask.rest.EmployeeREST.EMPLOYE_REST_URL;

/**
 * Created by comp on 25.07.2017.
 */
@RestController
@RequestMapping(value = EMPLOYE_REST_URL)
public class EmployeeREST extends AbstractEmployeeController {

    static final String EMPLOYE_REST_URL = "/rest/employees";

    @GetMapping("/{id}")
    public Employee get(@PathVariable int id) {
        return super.get(id);
    }

    @GetMapping
    public List<Employee> getAll() {
        return super.getAll();
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
        return super.delete(id);
    }

    @PutMapping
    public Employee update(Employee employee) {
        return super.update(employee);
    }

    @PostMapping
    public Employee create(Employee employee) {
        return super.create(employee);
    }
}
