package webapplication.util;

/**
 * Created by comp on 30.07.2017.
 */
public class DepartmentWithSalary {
    private Integer id;
    private String departmentName;
    private Integer salary;

    public DepartmentWithSalary(Integer id, String departmentName, Integer salary) {
        this.id = id;
        this.departmentName = departmentName;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
