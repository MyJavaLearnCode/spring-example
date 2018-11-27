package com.cyl.spring.database.tx.practice.dao.jdbc;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import com.cyl.spring.database.tx.practice.dao.IAddressDao;
import com.cyl.spring.database.tx.practice.model.AddressModel;

public class AddressJdbcDaoImpl extends NamedParameterJdbcDaoSupport implements IAddressDao {
    private final String INSERT_SQL = "insert into address(province,city,street,user_id) values(:province,:city,:street,:userId)";
    private final String COUNT_All_SQL = "select count(*) from address";
    @Override
    public void save(AddressModel address) {
        KeyHolder generateKeyHolder = new GeneratedKeyHolder();
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(address);
        getNamedParameterJdbcTemplate().update(INSERT_SQL, parameterSource, generateKeyHolder);
        address.setId(generateKeyHolder.getKey().intValue());
    }

    @Override
    public int countAll() {
        return getJdbcTemplate().queryForList(COUNT_All_SQL).size();
    }
}
