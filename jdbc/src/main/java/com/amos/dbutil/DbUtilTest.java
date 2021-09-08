package com.amos.dbutil;

import com.amos.entity.Emp;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class DbUtilTest {
    static Connection connection;

    public static void main(String[] args) throws SQLException {
//        testQuery();
//        testQueryList();
//        testQueryArray();
//        testQueryArrayList();
//        testQueryScalar();
//        testCustomDefinedHandler();
//        insert();
        update();
    }

    private static void testQuery() throws SQLException {
        connection = DbUtil.getConnection();
        String sql = "select * from emp where ename=?";
        QueryRunner runner = new QueryRunner();
        Emp emp = runner.query(connection, sql, new BeanHandler<Emp>(Emp.class), "zhangsan2");
        System.out.println(emp);
        connection.close();
        test(1,2,3);
    }
    private static void testQueryList() throws SQLException {
        connection = DbUtil.getConnection();
        String sql = "select * from emp where ename=?";
        QueryRunner runner = new QueryRunner();
        List<Emp> empList = runner.query(connection, sql, new BeanListHandler<Emp>(Emp.class), "zhangsan2");
        empList.forEach(System.out::println);
        connection.close();
    }

    private static void testQueryArray() throws SQLException {
        connection = DbUtil.getConnection();
        String sql = "select * from emp where ename=?";
        QueryRunner runner = new QueryRunner();
        Object[] array = runner.query(connection, sql, new ArrayHandler(), "zhangsan2");
        Arrays.stream(array).forEach(System.out::println);
        connection.close();
    }

    private static void testQueryArrayList() throws SQLException {
        connection = DbUtil.getConnection();
        String sql = "select * from emp where ename=?";
        QueryRunner runner = new QueryRunner();
        List<Object[]> list = runner.query(connection, sql, new ArrayListHandler(), "zhangsan2");
        for (Object[] objects : list) {
            System.out.println(objects[0] + ":" + objects[1]);
        }
        connection.close();
    }

    private static void testQueryScalar() throws SQLException {
        connection = DbUtil.getConnection();
        String sql = "select count(*) from emp";
        QueryRunner runner = new QueryRunner();
        Object obj = runner.query(connection, sql, new ScalarHandler<>());
        System.out.println(obj);
        connection.close();
    }

    private static void testCustomDefinedHandler() throws SQLException {
        connection = DbUtil.getConnection();
        String sql = "select * from emp where ename=?";
        QueryRunner runner = new QueryRunner();
        Emp emp = runner.query(connection, sql, new ResultSetHandler<Emp>() {
            @Override
            public Emp handle(ResultSet resultSet) throws SQLException {
                if (resultSet.next()) {
                    Emp emp = new Emp();
                    emp.setEmpno(resultSet.getInt("empno"));
                    return emp;
                }
                return null;
            }
        }, "lux");
        connection.close();
        System.out.println(emp);
    }

    private static void insert() throws SQLException {
        connection = DbUtil.getConnection();
        String sql = "insert into emp(empno,ename) values(?,?)";
        QueryRunner queryRunner = new QueryRunner();
        queryRunner.update(connection, sql,3,"lisi");
        connection.close();
    }

    private static void update() throws SQLException {
        String sql = "update emp set ename=? where empno=?";
        QueryRunner queryRunner = new QueryRunner();
        queryRunner.update(DbUtil.getConnection(), sql,"wangwu",3);
    }

    static void test(int ... a){
        System.out.println(a);
    }
}
