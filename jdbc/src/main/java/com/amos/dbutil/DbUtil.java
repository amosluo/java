package com.amos.dbutil;

import java.sql.*;

public class DbUtil {
    private static final String driver = "oracle.jdbc.driver.OracleDriver";
    private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String username = "lx";
    private static final String password = "lx";

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    public static void closeConnection(Connection connection, Statement satement, ResultSet resultSet) {
        try {
            if (satement != null)
                satement.close();
            if (resultSet != null)
                resultSet.close();
            if (connection != null)
                connection.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
