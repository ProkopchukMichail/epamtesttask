package testtask;

import testtask.model.Department;
import testtask.model.Employe;

import java.time.Month;
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
    public static final Department HR_DEPARTMENT =new Department("HR_DEPARTMENT");
    public static final Department HR_DEPARTMENT_FOR_UPDATE=new Department(4,"HR_DEPARTMENT_UPDATE");

    public static final List<Department> DEPARTMENTS= Arrays.asList(ADMINISTRATION,FINANCE, HR_DEPARTMENT,IT);
    public static final List<Department> DEPARTMENTS_AFTER_UPDATE= Arrays.asList(ADMINISTRATION,FINANCE, HR_DEPARTMENT_FOR_UPDATE,IT);

    public static final Employe ADMIN1=new Employe("Administration","admin1",
            of(1970, Month.MAY,5,0,0),1000);
    public static final Employe ADMIN2=new Employe("Administration","admin2",
            of(1971, Month.MAY,5,0,0),1050);
    public static final Employe DEV1=new Employe("IT","dev1",
            of(1990,Month.JANUARY,1,0,0),700);
    public static final Employe DEV2=new Employe("IT","dev2",
            of(1991,Month.FEBRUARY,2,0,0),1500);
    public static final Employe FINANCIER=new Employe("Finance","financier",
            of(1985,Month.JUNE,6,0,0),550);
    public static final Employe HR=new Employe("HR_DEPARTMENT","hr",
            of(1992,Month.SEPTEMBER,9,0,0),600);
    public static final Employe HR_FOR_UPDATE=new Employe(10,"HR_DEPARTMENT", "hr_update",
            of(1992,Month.SEPTEMBER,9,0,0),600);

    public static final List<Employe> EMPLOYES=Arrays.asList(ADMIN1,ADMIN2,DEV1,DEV2,FINANCIER,HR);
    public static final List<Employe> EMPLOYES_AFTER_UPDATE=Arrays.asList(ADMIN1,ADMIN2,DEV1,DEV2,FINANCIER,HR_FOR_UPDATE);


}
