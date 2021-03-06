package com.cyl.spring.database.jdbc;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 利用可变参数和自动装拆箱实现更更简洁的代码
 * 4.x中已删除
 * query及queryForXXX方法、update及batchUpdate方法
 */
public class SimpleJdbcTemplateTest {


    private static JdbcTemplate jdbcTemplate;

    @BeforeClass
    public static void setUpClass() {
        String url = "jdbc:hsqldb:mem:test";
        String userName = "sa";
        String passWord = "";
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url,userName,passWord);
        dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Before
    public void setUp() {
        String creatTableSql = "create memory table test " +
                "(id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, name varchar(100))";
        jdbcTemplate.update(creatTableSql);
    }

    @After
    public void tearDown() {
        String dropTableSql = "drop table test";
        jdbcTemplate.update(dropTableSql);
    }

    @Test
    public void test() {
        System.out.println("4.x 中被删除");
    }


}
