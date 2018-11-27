package com.cyl.spring.database.jdbc.rdbmsOperation;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlQuery;
import com.cyl.spring.database.jdbc.UserModel;
import com.cyl.spring.database.jdbc.UserRowMapper;

import java.sql.Types;
import java.util.Map;

public class UserModelSqlQuery extends SqlQuery<UserModel> {
    public UserModelSqlQuery(JdbcTemplate jdbcTemplate) {
        super.setJdbcTemplate(jdbcTemplate);
        super.setSql("SELECT * FROM test WHERE name=?");
        super.declareParameter(new SqlParameter(Types.VARCHAR));
        compile();
    }

    @Override
    protected RowMapper<UserModel> newRowMapper(Object[] parameters, Map context) {
        return new UserRowMapper();
    }
}
