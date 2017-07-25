package testtask.dao;

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
import testtask.model.Department;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by comp on 23.07.2017.
 */
@Repository
@Transactional
public class DepartmentDAO {

    private final static RowMapper<Department> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Department.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertDepartment;

    @Autowired
    public DepartmentDAO(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertDepartment = new SimpleJdbcInsert(dataSource)
                .withTableName("department")
                .usingGeneratedKeyColumns("id");

        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    public List<Department> getAll() {
        return jdbcTemplate.query("SELECT * FROM department ORDER BY departmentName", ROW_MAPPER);
    }

    public Department get(int id) {
        return DataAccessUtils.singleResult(
                jdbcTemplate.query("SELECT * FROM department WHERE id=?", ROW_MAPPER, id));
    }

    @Transactional
    public boolean delete(int id) {
        return jdbcTemplate.update("DELETE FROM department WHERE id=?", id) != 0;
    }

    @Transactional
    public Department save(Department department) {
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(department);
        try {
            if (department.isNew()) {
                department.setId(insertDepartment.executeAndReturnKey(parameterSource).intValue());

            } else
                namedParameterJdbcTemplate.update(
                        "UPDATE department SET departmentName=:departmentName WHERE id=:id", parameterSource);
        } catch (DuplicateKeyException e) {
        }
        return department;
    }
}
