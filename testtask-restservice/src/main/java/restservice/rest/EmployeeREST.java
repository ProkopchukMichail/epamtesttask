package restservice.rest;

import model.Employee;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import model.json.DateTimeConverter;

import java.util.List;

/**
 * Created by comp on 25.07.2017.
 */
@RestController
@RequestMapping(value = "/rest/departments", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeREST extends AbstractEmployeeController {

    @GetMapping("/{department_id}/employee/{id}")
    public Employee get(@PathVariable int department_id, @PathVariable int id) {
        return super.get(id);
    }

    @GetMapping("/{department_id}/employees/midsalary")
    public Integer getMidSalary(@PathVariable int department_id){
        return super.getMidSalary(department_id);
    }

    @GetMapping("/{department_id}/employees")
    public List<Employee> getAllByDepartment(@PathVariable int department_id) {
        return super.getAllByDepartment(department_id);
    }

    @GetMapping("/{department_id}/employees/find/{date}")
    public List<Employee> getByDate(@PathVariable int department_id, @PathVariable String date){
        return super.getByDate(department_id, DateTimeConverter.convert(date));
    }

    @GetMapping("/{department_id}/employees/from/{startDate}/to/{endDate}")
    public List<Employee> getByDates(@PathVariable int department_id, @PathVariable String startDate, @PathVariable String endDate){
        return super.getByDates(department_id, DateTimeConverter.convert(startDate),DateTimeConverter.convert(endDate));
    }

    @DeleteMapping("/{department_id}/employees/{id}/delete")
    public boolean delete(@PathVariable int department_id,@PathVariable int id) {
        return super.delete(id);
    }

    @PostMapping(value = "/{department_id}/employees/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employee update(@PathVariable int department_id,@RequestBody Employee employee) {
        return super.update(employee);
    }

    @PutMapping(value = "/{department_id}/employees/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employee create(@PathVariable int department_id,@RequestBody Employee employee) {
        return super.create(employee);
    }
}
