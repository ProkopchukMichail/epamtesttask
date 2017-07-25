package testtask.model;

import java.util.Date;

/**
 * Created by comp on 25.07.2017.
 */
public class Employe  extends HasId{
    private String departmentName;
    private String fullname;
    private Date birthday;
    private Integer salary;

    public Employe(String departmentName, String fullname, Date birthday, Integer salary) {
        this.departmentName = departmentName;
        this.fullname = fullname;
        this.birthday = birthday;
        this.salary = salary;
    }

    public Employe() {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
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

        Employe employe = (Employe) o;

        if (departmentName != null ? !departmentName.equals(employe.departmentName) : employe.departmentName != null)
            return false;
        if (fullname != null ? !fullname.equals(employe.fullname) : employe.fullname != null) return false;
        if (birthday != null ? !birthday.equals(employe.birthday) : employe.birthday != null) return false;
        return salary != null ? salary.equals(employe.salary) : employe.salary == null;
    }

    @Override
    public int hashCode() {
        int result = departmentName != null ? departmentName.hashCode() : 0;
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "departmentName='" + departmentName + '\'' +
                ", fullname='" + fullname + '\'' +
                ", birthday=" + birthday +
                ", salary=" + salary +
                '}';
    }
}
