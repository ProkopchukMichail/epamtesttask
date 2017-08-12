package restservice;



import model.Department;
import model.Employee;
import model.util.DepartmentWithSalary;

import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.time.LocalDateTime.of;

/**
 * Created by comp on 24.07.2017.
 */
public class TestData {
    public static final Department ADMINISTRATION=new Department("Administration");
    public static final Department IT=new Department("IT");
    public static final Department FINANCE=new Department("Finance");
    public static final Department HR_DEPARTMENT =new Department(0,"HR_DEPARTMENT");
    public static final Department HR_DEPARTMENT_FOR_UPDATE=new Department(4,"HR_DEPARTMENT_UPDATE");

    public static final List<Department> DEPARTMENTS= Arrays.asList(ADMINISTRATION,FINANCE, HR_DEPARTMENT,IT);
    public static final List<Department> DEPARTMENTS_AFTER_UPDATE= Arrays.asList(ADMINISTRATION,FINANCE, HR_DEPARTMENT_FOR_UPDATE,IT);

    public static final Employee ADMIN1=new Employee(1,"admin1",
            of(1970, Month.MAY,5,0,0),1000);
    public static final Employee ADMIN2=new Employee(1,"admin2",
            of(1971, Month.MAY,5,0,0),1050);
    public static final Employee DEV1=new Employee(2,"dev1",
            of(1990,Month.JANUARY,1,0,0),700);
    public static final Employee DEV2=new Employee(2,"dev2",
            of(1991,Month.FEBRUARY,2,0,0),1500);
    public static final Employee FINANCIER=new Employee(3,"financier",
            of(1985,Month.JUNE,6,0,0),550);
    public static final Employee HR=new Employee(4,"hr",
            of(1992,Month.SEPTEMBER,9,0,0),600);
    public static final Employee HR_FOR_UPDATE=new Employee(10,4, "hr_update",
            of(1992,Month.SEPTEMBER,9,0,0),600);

    public static final List<Employee> EMPLOYEES =Arrays.asList(ADMIN1,ADMIN2,DEV1,DEV2,FINANCIER,HR);
    public static final List<Employee> EMPLOYEES_AFTER_UPDATE =Arrays.asList(ADMIN1,ADMIN2,DEV1,DEV2,FINANCIER,HR_FOR_UPDATE);

    public final static List<DepartmentWithSalary> DEPARTMENT_WITH_SALARIES=Arrays.asList(new DepartmentWithSalary(1,"qwe",400));

}
