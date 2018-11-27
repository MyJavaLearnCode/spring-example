package com.cyl.spring.database.jdbc.example;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UserJdbcDaoImpl extends JdbcDaoSupport implements IUserDao {
    private static final String INSERT_SQL = "INSERT INTO test(name) VALUES(:myName)";
    private static final String COUNT_ALL_SQL = "select * from test";

    @Override
    public void save(UserModel userModel) {
        getJdbcTemplate().update(INSERT_SQL, new BeanPropertySqlParameterSource(userModel));
    }

    @Override
    public int countAll() {
        System.out.println(getJdbcTemplate().queryForList(COUNT_ALL_SQL));;
        return getJdbcTemplate().queryForList(COUNT_ALL_SQL).size();
    }
}
