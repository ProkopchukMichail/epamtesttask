package dao.jdbc;

import dao.EmployeeDAO;
import model.Employee;
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


import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by comp on 25.07.2017.
 */
@Repository("JdbcEmployeeDAOImpl")
@Transactional
public class JdbcEmployeeDAOImpl implements EmployeeDAO {

    private final static RowMapper<Employee> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Employee.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertEmployee;

    @Autowired
    public JdbcEmployeeDAOImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.insertEmployee = new SimpleJdbcInsert(dataSource)
                .withTableName("employees")
                .usingGeneratedKeyColumns("id");
    }


    public List<Employee> getAllByDepartment(int id){
        return jdbcTemplate.query(
                "SELECT * FROM employees WHERE department_id=?",ROW_MAPPER,id);
    }

    public Employee get(int id){
        return DataAccessUtils.singleResult(
                jdbcTemplate.query("SELECT * FROM employees WHERE id=?",ROW_MAPPER,id)
        );
    }

    public List<Employee> getByDate(int department_id, LocalDateTime dateTime){
        List<Employee> list= jdbcTemplate.query(
                "SELECT * FROM employees WHERE department_id=? AND birthday=?",ROW_MAPPER,department_id,dateTime);
        return list;
    }

    public List<Employee> getByDates(int department_id, LocalDateTime startDate, LocalDateTime endDate) {
        return jdbcTemplate.query(
                "SELECT * FROM employees WHERE department_id=? AND birthday BETWEEN ? AND ?",ROW_MAPPER,department_id,startDate,endDate);
    }

    @Transactional
    public boolean delete(int id){
        return jdbcTemplate.update("DELETE FROM employees WHERE id=?",id)!=0;
    }

    @Transactional
    public Employee save(Employee employee) {
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(employee);
        try {
            if (employee.isNew() || employee.getId()==0) {
                employee.setId(insertEmployee.executeAndReturnKey(parameterSource).intValue());

            } else
                namedParameterJdbcTemplate.update(
                        "UPDATE employees SET" +
                                " department_id=:department_id," +
                                " fullname=:fullname," +
                                " birthday=:birthday," +
                                " salary=:salary" +
                                " WHERE id=:id", parameterSource);
        } catch (DuplicateKeyException e) {
        }
        return employee;
    }

    public Integer getMidSalary(int id) {
        List<Employee> salaries = getAllByDepartment(id);
        if(salaries.size()==0) return 0;
        Integer midsalary=0;
        for(Employee s: salaries) midsalary+=s.getSalary();
        return midsalary/ salaries.size();
    }
}
