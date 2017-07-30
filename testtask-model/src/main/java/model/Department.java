package model;

/**
 * Created by comp on 23.07.2017.
 */
public class Department extends HasId{
    private String departmentName;

    public Department(int id, String departmentName){
        super(id);
        this.departmentName=departmentName;
    }

    public Department( String departmentName) {

        this.departmentName = departmentName;
    }
    public Department(){}



    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{id='" +getId()+"',"+
                " departmentName='" + departmentName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;


        return departmentName != null ? departmentName.equals(that.departmentName) : that.departmentName == null;
    }

    @Override
    public int hashCode() {
        return departmentName != null ? departmentName.hashCode() : 0;
    }
}
