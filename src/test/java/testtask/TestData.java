package testtask;

import testtask.model.Department;

import java.util.Arrays;
import java.util.List;

/**
 * Created by comp on 24.07.2017.
 */
public class TestData {
    public static final Department ADMINISTRATION=new Department("Administration");
    public static final Department IT=new Department("IT");
    public static final Department FINANCE=new Department("Finance");
    public static final Department HR=new Department("HR");

    public static final List<Department> DEPARTMENTS= Arrays.asList(ADMINISTRATION,FINANCE,HR,IT);
}
