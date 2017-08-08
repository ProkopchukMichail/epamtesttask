package model.util;

import model.HasId;

/**
 * Created by comp on 30.07.2017.
 */
public class DepartmentWithSalary extends HasId{
    private String departmentName;
    private Integer salary;

    public DepartmentWithSalary(Integer id, String departmentName, Integer salary) {
        super(id);
        this.departmentName = departmentName;
        this.salary = salary;
    }

    public DepartmentWithSalary() {
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
