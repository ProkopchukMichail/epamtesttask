package restservice.dao.jdbc;

import model.Department;
import model.util.DepartmentWithSalary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import restservice.dao.DepartmentDAO;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

/**
 * Created by comp on 23.07.2017.
 */
@Repository
@Transactional(readOnly = true)
public class JdbcDepartmentDAOImpl implements DepartmentDAO {

    private final static RowMapper<Department> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Department.class);
    private final static RowMapper<DepartmentWithSalary> ROW_MAPPER2 = BeanPropertyRowMapper.newInstance(DepartmentWithSalary.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertDepartment;

    @Autowired
    public JdbcDepartmentDAOImpl(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertDepartment = new SimpleJdbcInsert(dataSource)
                .withTableName("departments")
                .usingGeneratedKeyColumns("id");

        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }



    public List<DepartmentWithSalary> getAll() {
        return jdbcTemplate.query("SELECT d.id, d.departmentName, AVG(e.salary) AS salary " +
                        "FROM departments d  LEFT JOIN employees e ON d.id=e.department_id" +
                        " GROUP BY d.id"
                , ROW_MAPPER2);
    }

    public Department get(int id) {
        return DataAccessUtils.singleResult(
                jdbcTemplate.query("SELECT * FROM departments WHERE id=?", ROW_MAPPER, id));
    }

    @Transactional
    public boolean delete(int id) {
        return jdbcTemplate.update("DELETE FROM departments WHERE id=?", id) != 0;
    }

    @Transactional
    public Department save(Department department) {
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(department);
        try {
            if (department.getId() == 0) {
                department.setId(insertDepartment.executeAndReturnKey(parameterSource).intValue());

            } else
                namedParameterJdbcTemplate.update(
                        "UPDATE departments SET departmentName=:departmentName WHERE id=:id", parameterSource);
        } catch (DuplicateKeyException e) {
        }
        return department;
    }

    public String getDepartmentName(int department_id) {
        return DataAccessUtils.singleResult(jdbcTemplate.query(
                "SELECT * FROM departments WHERE department_id=?", ROW_MAPPER, department_id)).getDepartmentName();
    }
}
