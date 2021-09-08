package com.amos.dao.impl;

import com.amos.dao.EmpDao;
import com.amos.entity.Emp;
import com.amos.util.OracleUtil;
import jdk.internal.dynalink.linker.LinkerServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class EmpDaoImpl implements EmpDao {

    public static void main(String[] args) {
        Emp emp = new Emp(1, "lux", new Date(), 20D);
        EmpDao empDao = new EmpDaoImpl();
        empDao.insert(emp);
    }

    public void insert(Emp emp) {

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = OracleUtil.getConnection();
//            statement = connection.createStatement();
//            String sql = "insert into emp(empno,ename,hiredate,sal) values(" + emp.getEmpno() + ",'" + emp.getEname() + "',to_date('" + new java.sql.Date(emp.getHiredate().getTime()) + "','yyyy/MM/dd')," + emp.getSal() + ")";
//            int i = statement.executeUpdate(sql);
            String sql = "insert into emp(empno,ename,hiredate,sal) values(?,?,?,?)";
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < 20; i++) {
                statement.setInt(1,1);
                statement.setString(2,"zhangsan2");
                statement.setDate(3,new java.sql.Date(new Date().getTime()));
                statement.setDouble(4,22.56);
                statement.addBatch();
            }

            System.out.println(sql);
            //执行sql语句，返回受影响的行数
            int[] i = statement.executeBatch();
            System.out.println("受影响的行数:" + i.length);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            OracleUtil.closeConnection(connection, statement, null);
        }
    }

    public void delete(Emp emp) {

    }

    public void update(Emp emp) {

    }

    public Emp getEmpByEmpmo(Integer empno) {
        return null;
    }
}
