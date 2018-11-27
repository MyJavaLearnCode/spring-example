package com.cyl.spring.database.jdbc;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserModel> {
    @Override
    public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserModel userModel = new UserModel();
        userModel.setId(rs.getInt("id"));
        userModel.setMyName(rs.getString("name"));
        return userModel;
    }
}
