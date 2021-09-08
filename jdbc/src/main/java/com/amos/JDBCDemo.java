package com.amos;

import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1、加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");

        //2、建立连接
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@10.126.72.118:1521:toismod", "toisapp", "Ti#7550os");

        //3、定义SQL语句
        String sql = "select * from c_ml_sorting where rownum <20";

        //4、准备静态处理块对象，将sql语句放到静态处理快中
        Statement statement = connection.createStatement();

        //5、执行SQL语句
        ResultSet resultSet = statement.executeQuery(sql);

        //6、处理结果
        while (resultSet.next()){
            String reel_id = resultSet.getString("REEL_ID");
            System.out.println(reel_id);
        }

        //7、关闭连接
        statement.close();
        connection.close();

    }

}
