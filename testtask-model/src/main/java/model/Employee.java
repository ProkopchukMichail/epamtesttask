package model;



import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import model.json.LocalDateTimeDeserializer;
import model.json.LocalDateTimeSerializer;

import java.time.LocalDateTime;

/**
 * Created by comp on 25.07.2017.
 */
public class Employee extends HasId{
    private Integer department_id;
    private String fullname;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime birthday;
    private Integer salary;

    public Employee(Integer id, Integer department_id, String fullname, LocalDateTime birthday, Integer salary) {
        super(id);
        this.department_id = department_id;
        this.fullname = fullname;
        this.birthday = birthday;
        this.salary = salary;
    }

    public Employee(Integer department_id, String fullname, LocalDateTime birthday, Integer salary) {
        this.department_id = department_id;
        this.fullname = fullname;
        this.birthday = birthday;
        this.salary = salary;
    }

    public Employee() {
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (department_id != null ? !department_id.equals(employee.department_id) : employee.department_id != null)
            return false;
        if (fullname != null ? !fullname.equals(employee.fullname) : employee.fullname != null) return false;
        if (birthday != null ? !birthday.equals(employee.birthday) : employee.birthday != null) return false;
        return salary != null ? salary.equals(employee.salary) : employee.salary == null;
    }

    @Override
    public int hashCode() {
        int result = department_id != null ? department_id.hashCode() : 0;
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "department_id=" + department_id +
                ", fullname='" + fullname + '\'' +
                ", birthday=" + birthday +
                ", salary=" + salary +
                '}';
    }
}
