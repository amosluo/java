package com.amos.pool.c3p0;

import com.mchange.v2.c3p0.DataSources;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class UnpooledTest {
    public static void main(String[] args) throws SQLException {
        //不使用连接池的数据源
//        DataSource ds = DataSources.unpooledDataSource();
//        Connection connection =ds.getConnection();
//        System.out.println(connection);
//        connection.close();//close()会关闭数据库连接

        DataSource ds = DataSources.pooledDataSource(DataSources.unpooledDataSource());
        Connection connection =ds.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
