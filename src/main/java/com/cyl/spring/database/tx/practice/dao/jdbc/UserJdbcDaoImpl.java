package com.cyl.spring.database.tx.practice.dao.jdbc;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import com.cyl.spring.database.tx.practice.dao.IUserDao;
import com.cyl.spring.database.tx.practice.model.UserModel;

public class UserJdbcDaoImpl extends NamedParameterJdbcDaoSupport implements IUserDao {
    private final String INSERT_SQL = "insert into user(name) values(:name)";
    private final String COUNT_ALL_SQL = "select count(*) from user";
    @Override
    public void save(UserModel userModel) {
        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(userModel);
        getNamedParameterJdbcTemplate().update(INSERT_SQL, parameterSource, generatedKeyHolder);
        userModel.setId(generatedKeyHolder.getKey().intValue());
    }

    @Override
    public int countAll() {
        return getJdbcTemplate().queryForList(COUNT_ALL_SQL).size();
    }
}
