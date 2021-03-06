package com.cyl.spring.database.tx.programmaticTx;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Example {
    private static final String CREAT_TABLE_SQL = "create table test" +
            "(id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, " +
            "name varchar(100))";
    private static final String DROP_TABLE_SQL = "drop table test";
    private static final String INSERT_SQL = "insert into test(name) values(?)";
    private static final String COUNT_SQL = "select count(*) from test";
    private static ApplicationContext context;
    private static PlatformTransactionManager txManager;
    private static DataSource dataSource;
    private static JdbcTemplate jdbcTemplate;

    @BeforeClass
    public static void setUpClass() {
        String[] configLactions = {"spring/jdbc/example/application-resources.xml", "spring/tx/localTx/application-jdbc.xml"};
        context = new ClassPathXmlApplicationContext(configLactions);
        txManager = context.getBean(PlatformTransactionManager.class);
        dataSource = context.getBean(DataSource.class);
        jdbcTemplate = new JdbcTemplate(dataSource);

    }

    /**
     * 高级别的解决方案进行事务管理器
     */
    @Test
    public void testPlateformTransactionManager() {
        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        transactionDefinition.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        transactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = txManager.getTransaction(transactionDefinition);
        jdbcTemplate.execute(CREAT_TABLE_SQL);
        try {
            jdbcTemplate.update(INSERT_SQL, "test");
            txManager.commit(status);
        } catch (RuntimeException e) {
            txManager.rollback(status);
            e.printStackTrace();
        }

        jdbcTemplate.execute(DROP_TABLE_SQL);
    }

    @Test
    public void testPlatformTransactionManagerForLowLevel() {
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        defaultTransactionDefinition.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = txManager.getTransaction(defaultTransactionDefinition);
        Connection connection = DataSourceUtils.getConnection(dataSource);
        try {
            connection.prepareStatement(CREAT_TABLE_SQL).execute();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL);
            preparedStatement.setString(1, "test");
            preparedStatement.execute();
            connection.prepareStatement(DROP_TABLE_SQL).execute();
            txManager.commit(status);
        } catch (Exception e) {
            status.setRollbackOnly();
            txManager.rollback(status);
        }finally {
            DataSourceUtils.releaseConnection(connection,dataSource);
        }
    }

    @Test
    public void testTransactionTemplate() {
        jdbcTemplate.execute(CREAT_TABLE_SQL);
        TransactionTemplate transactionTemplate = new TransactionTemplate(txManager);
        transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                jdbcTemplate.update(INSERT_SQL, "test");
            }
        });
        jdbcTemplate.execute(DROP_TABLE_SQL);
    }

    @Test
    public void testJtaTransactionTemplate() {
        String[] configLocations = {"spring/tx/globalTx/application-AtomikosGlobalTx.xml"};
        context = new ClassPathXmlApplicationContext(configLocations);
        final PlatformTransactionManager jtaTxManager = context.getBean(PlatformTransactionManager.class);
        final DataSource derbyDataSource1 = context.getBean("dataSource1",DataSource.class);
        final DataSource derbyDataSource2 = context.getBean("dataSource2",DataSource.class);
        final JdbcTemplate jdbcTemplate1 = new JdbcTemplate(derbyDataSource1);
        final JdbcTemplate jdbcTemplate2 = new JdbcTemplate(derbyDataSource2);
        TransactionTemplate transactionTemplate = new TransactionTemplate(jtaTxManager);
        transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        jdbcTemplate1.update(CREAT_TABLE_SQL);
        int originalCount = jdbcTemplate1.queryForList(COUNT_SQL).size();
        System.out.println(originalCount);
        try {
            transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                    jdbcTemplate1.update(INSERT_SQL, "test");
//                    jdbcTemplate2.update(INSERT_SQL, "test");
                }
            });
        } catch (RuntimeException e) {
            int count = jdbcTemplate1.queryForList(COUNT_SQL).size();
            System.out.println(count);
            Assert.assertEquals(originalCount,count);
            e.printStackTrace();
        }
        jdbcTemplate1.update(DROP_TABLE_SQL);
    }






}
