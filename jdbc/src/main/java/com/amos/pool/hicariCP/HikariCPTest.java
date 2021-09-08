package com.amos.pool.hicariCP;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class HikariCPTest {
    public static void main(String[] args) throws SQLException {

        //方式一：通过HikariConfig设置数据源
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
//        config.setUsername("lx");
//        config.setPassword("lx");
//        config.addDataSourceProperty("cachePrepStmts","true");
//        config.addDataSourceProperty("prepStmtCacheSize","250");
//        config.addDataSourceProperty("prepStmtCacheSqlLimit","2048");
//
//        HikariDataSource hikariDataSource = new HikariDataSource(config);
//        Connection connection = hikariDataSource.getConnection();
//        System.out.println(connection);
//        connection.close();

        //方式二：直接设置
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
        hikariDataSource.setUsername("lx");
        hikariDataSource.setPassword("lx");
        Connection connection = hikariDataSource.getConnection();
        System.out.println(connection);
        connection.close();

        //方式三：配置文件

    }
}
