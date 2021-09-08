package com.amos.pool.dbcp;


import oracle.jdbc.pool.OracleDataSource;
import java.sql.*;

public class DBCPTest {
    public static void main(String[] args) throws SQLException {
        OracleDataSource ods = new OracleDataSource();
//        basicDataSource.set("oracle.jdbc.driver.OracleDriver");
//        basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
//        basicDataSource.setUsername("lx");
//        basicDataSource.setPassword("lx");
        ods.setDriverType ( "thin" ); // type of driver
        ods.setNetworkProtocol("tcp"); // tcp is the default anyway
        ods.setServerName ( "127.0.0.1" ); // database server name
        ods.setDatabaseName("xe"); // Oracle SID
        ods.setPortNumber(1521); // listener port number
        ods.setUser("lx"); // username
        ods.setPassword("lx"); // password

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = ods.getConnection();
            String sql = "select * from emp";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("ename"));
            }
        }
        catch (Exception ex){

        }
        finally {
            connection.close();
        }
    }
}
