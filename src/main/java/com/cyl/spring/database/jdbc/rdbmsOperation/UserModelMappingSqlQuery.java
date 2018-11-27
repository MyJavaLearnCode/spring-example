package com.cyl.spring.database.jdbc.rdbmsOperation;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import com.cyl.spring.database.jdbc.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class UserModelMappingSqlQuery extends MappingSqlQuery<UserModel> {
    public UserModelMappingSqlQuery(JdbcTemplate jdbcTemplate) {
        super.setDataSource(jdbcTemplate.getDataSource());
        super.setSql("SELECT * FROM test WHERE name=:name");
        super.declareParameter(new SqlParameter("name", Types.VARCHAR));
        compile();
    }

    @Override
    protected UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserModel userModel = new UserModel();
        userModel.setId(rs.getInt("id"));
        userModel.setMyName(rs.getString("name"));
        return userModel;
    }


}
