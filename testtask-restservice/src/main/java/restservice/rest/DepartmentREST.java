package restservice.rest;

import model.Department;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static org.springframework.http.MediaType.*;

/**
 * Created by comp on 23.07.2017.
 */
@RestController()
@RequestMapping(value = DepartmentREST.DEPARTMENT_REST_URL, produces = APPLICATION_JSON_VALUE)
public class DepartmentREST extends AbstractDepartmentController{

    static final String DEPARTMENT_REST_URL = "/rest/departments";

    @GetMapping
    public List<Department> getAll() {
        return super.getAll();
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable int id) {
        return super.get(id);
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id) {
        return super.delete(id);
    }

    @PutMapping(value = "/put", consumes = APPLICATION_JSON_VALUE)
    public Department create(@RequestBody Department department) {
        return super.create(department);
    }

    @PostMapping(value = "/post", consumes = APPLICATION_JSON_VALUE)
    public Department update(@RequestBody Department department) {
         return super.update(department);
    }

    @GetMapping("/name/{department_id}")
    public String getDepartmentName(@PathVariable int department_id){
        return super.getDepartmentName(department_id);
    }

}
