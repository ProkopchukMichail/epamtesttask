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

    public static final DepartmentWithSalary ADMINISTRATION_WITH_SALARY=new DepartmentWithSalary(1,"Administration",1025);
    public static final DepartmentWithSalary IT_WITH_SALARY=new DepartmentWithSalary(2,"IT",1100);
    public static final DepartmentWithSalary FINANCE_WITH_SALARY=new DepartmentWithSalary(3,"Finance",550);
    public static final DepartmentWithSalary HR_DEPARTMENT_WITH_SALARY=new DepartmentWithSalary(4,"HR_DEPARTMENT",600);
    public static final DepartmentWithSalary HR_DEPARTMENT_AFTER_UPDATE_WITH_SALARY=new DepartmentWithSalary(4,"HR_DEPARTMENT_UPDATE",600);

    public static final List<DepartmentWithSalary> DEPARTMENTS_WITH_SALARIES= Arrays.asList(ADMINISTRATION_WITH_SALARY, IT_WITH_SALARY,FINANCE_WITH_SALARY, HR_DEPARTMENT_WITH_SALARY);
    public static final List<DepartmentWithSalary> DEPARTMENTS_AFTER_UPDATE_WITH_SALARIES= Arrays.asList(ADMINISTRATION_WITH_SALARY, IT_WITH_SALARY,FINANCE_WITH_SALARY, HR_DEPARTMENT_AFTER_UPDATE_WITH_SALARY);

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
    public static final Employee HR2=new Employee(4,"hr2",
            of(1992,Month.SEPTEMBER,9,0,0),600);
    public static final Employee HR_FOR_UPDATE=new Employee(6,4, "hr_update",
            of(1992,Month.SEPTEMBER,9,0,0),600);

    public static final List<Employee> EMPLOYEES =Arrays.asList(ADMIN1,ADMIN2,DEV1,DEV2,FINANCIER,HR);
    public static final List<Employee> EMPLOYEES_AFTER_UPDATE =Arrays.asList(ADMIN1,ADMIN2,DEV1,DEV2,FINANCIER,HR_FOR_UPDATE);


}
