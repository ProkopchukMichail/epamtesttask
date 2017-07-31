package webapplication.util;

import java.time.LocalDateTime;

/**
 * Created by comp on 31.07.2017.
 */
public class EmployeeWithDepartmentName {
    private Integer id;
    private String departmentName;
    private String fullname;
    private LocalDateTime birthday;
    private Integer salary;

    public EmployeeWithDepartmentName(Integer id, String departmentName, String fullname, LocalDateTime birthday, Integer salary) {
        this.id = id;
        this.departmentName = departmentName;
        this.fullname = fullname;
        this.birthday = birthday;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
