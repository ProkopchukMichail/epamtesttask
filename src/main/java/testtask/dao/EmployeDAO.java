package testtask.dao;

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
import testtask.model.Employe;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by comp on 25.07.2017.
 */
@Repository
@Transactional
public class EmployeDAO {

    private final static RowMapper<Employe> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Employe.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertEmploye;

    public EmployeDAO(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.insertEmploye = new SimpleJdbcInsert(dataSource)
                .withTableName("employe")
                .usingGeneratedKeyColumns("id");
    }

    public List<Employe> getAll() {
        return jdbcTemplate.query("SELECT * FROM employe", ROW_MAPPER);
    }

    public Employe get(int id){
        return DataAccessUtils.singleResult(
                jdbcTemplate.query("SELECT * FROM employe WHERE id=?",ROW_MAPPER,id)
        );
    }

    @Transactional
    public boolean delete(int id){
        return jdbcTemplate.update("DELETE FROM employe WHERE id=?",id)!=0;
    }

    @Transactional
    public Employe save(Employe employe) {
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(employe);
        try {
            if (employe.isNew()) {
                employe.setId(insertEmploye.executeAndReturnKey(parameterSource).intValue());

            } else
                namedParameterJdbcTemplate.update(
                        "UPDATE employe SET" +
                                " departmentName=:departmentName," +
                                " fullname=:fullname," +
                                " birthday=:birthday," +
                                " salary=:salary" +
                                " WHERE id=:id", parameterSource);
        } catch (DuplicateKeyException e) {
        }
        return employe;
    }


}
