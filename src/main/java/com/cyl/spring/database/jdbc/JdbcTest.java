package com.cyl.spring.database.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 传统的数据库执行操作
 */
public class JdbcTest {

    @Test
    public void traditionJdbc() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnect();
            String sql = "select * from INFORMATION_SCHEMA.SYSTEM_TABLES";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            process(resultSet);
            closeResultSet(resultSet);
            closeStatement(preparedStatement);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private void process(ResultSet resultSet) {

    }

    private void closeResultSet(ResultSet resultSet) {
    }

    private void closeStatement(PreparedStatement preparedStatement) {

    }

    private Connection getConnect() {
        return null;
    }
}
