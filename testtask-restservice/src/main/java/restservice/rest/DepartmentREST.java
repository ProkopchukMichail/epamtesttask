package restservice.rest;

import model.Department;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by comp on 23.07.2017.
 */
@RestController()
@RequestMapping(value = DepartmentREST.DEPARTMENT_REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
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

    @PutMapping("/{id}")
    public Department create(Department department) {
        return super.create(department);
    }

    @PostMapping
    public Department update(Department department) {
        return super.update(department);
    }

}
