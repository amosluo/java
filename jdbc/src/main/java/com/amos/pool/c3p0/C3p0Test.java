package com.amos.pool.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class C3p0Test {

    static Connection connection = null;
    static ComboPooledDataSource cpds;
    static void getConnection(){
        cpds = new ComboPooledDataSource();
    }
    static {
        getConnection();
    }
    public static void main(String[] args) throws Exception {
//        ComboPooledDataSource cpds = new ComboPooledDataSource();
        //连接配置改为设置文件
//        cpds.setDriverClass("oracle.jdbc.driver.OracleDriver");
//        cpds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
//        cpds.setUser("lx");
//        cpds.setPassword("lx");

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        connection = cpds.getConnection();
        preparedStatement = connection.prepareStatement("select * from emp");
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
            System.out.println(resultSet.getString("ename"));
        connection.close();
        cpds.close();
    }
}
