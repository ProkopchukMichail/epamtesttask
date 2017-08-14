package restservice;

import model.Department;
import model.util.DepartmentWithSalary;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static org.springframework.http.MediaType.*;

/**
 * Created by comp on 23.07.2017.
 */
@RestController()
@RequestMapping(value = DepartmentREST.REST_URL, produces = APPLICATION_JSON_VALUE)
public class DepartmentREST extends AbstractDepartmentController{

    static final String REST_URL = "/rest/departments";

    @GetMapping
    public List<DepartmentWithSalary> getAll() {
        return super.getAll();
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable int id) {
        return super.get(id);
    }
    @DeleteMapping("/{id}/delete")
    public boolean delete(@PathVariable int id) {
        return super.delete(id);
    }

    @PutMapping(value = "/create", consumes = APPLICATION_JSON_VALUE)
    public Department create(@RequestBody Department department) {
        return super.create(department);
    }

    @PostMapping(value = "/{id}/update", consumes = APPLICATION_JSON_VALUE)
    public Department update(@RequestBody Department department, @PathVariable int id) {
         return super.update(department);
    }

    @GetMapping("/{department_id}/name")
    public String getDepartmentName(@PathVariable int department_id){
        return super.getDepartmentName(department_id);
    }

}
