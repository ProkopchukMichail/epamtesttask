package testtask.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
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

    private final static RowMapper<Department> ROW_MAPPER= BeanPropertyRowMapper.newInstance(Department.class);

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


    public List<Department> getAll(){
        return jdbcTemplate.query("SELECT departmentName FROM department ORDER BY departmentName",ROW_MAPPER);
    }

    public Department get(int id) {
        return DataAccessUtils.singleResult(
                jdbcTemplate.query("SELECT departmentName FROM department WHERE id=?",ROW_MAPPER,id));
    }

    @Transactional
    public boolean delete(int id) {
        return jdbcTemplate.update("DELETE FROM department WHERE id=?", id) != 0;
    }

    @Transactional
    public Department save(Department department) {
    /*    MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", department.getId())
                .addValue("departmentName",department.getDepartmentName());

        if (department.isNew()) {
            Number newId = insertMeal.executeAndReturnKey(map);
            department.setId(newId.intValue());
        } else {
            if (namedParameterJdbcTemplate.update("" +
                            "UPDATE department departmentName" +
                            "   SET departmentName=:depa" +
                            " WHERE id=:id",map)==0) return null;
        }
        return department;*/
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(department);

        if (department.isNew()) {
            Number newKey = insertDepartment.executeAndReturnKey(parameterSource);
            department.setId(newKey.intValue());
        } /*else {
            namedParameterJdbcTemplate.update(
                    "UPDATE department SET departmentName=:departmentName WHERE id=:id", parameterSource);
        }*/
        return department;
    }
}
