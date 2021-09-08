package com.amos.reflect;

import com.amos.entity.Emp;
import com.amos.util.OracleUtil;
import oracle.sql.NUMBER;
import oracle.sql.OracleJdbc2SQLInput;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseDaoImpl {

    public static void main(String[] args) throws Exception {
        BaseDaoImpl bdi = new BaseDaoImpl();
        List rows = bdi.getRows("select EMPNO,ENAME,HIREDATE,SAL from EMP where ENAME=?", new Object[]{"lux"}, Emp.class);
        for(Iterator iterator = rows.iterator();iterator.hasNext();){
            Emp emp = (Emp)iterator.next();
            System.out.println(emp);
        }
    }

    public List getRows(String sql, Object[] params, Class clazz) throws Exception {
        List list = new ArrayList();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = OracleUtil.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            resultSet = preparedStatement.executeQuery();

            //获取结果集合的元数据对象
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            //结果集合中包含多少列
            int columnCount = resultSetMetaData.getColumnCount();

            while (resultSet.next()) {

                Object o = clazz.newInstance();

                for (int i = 0; i < columnCount; i++) {
                    //从结果集合中获取单一列的值
                    Object objValue = resultSet.getObject(i + 1);
                    //获取列名
                    String columnName = resultSetMetaData.getColumnName(i + 1).toLowerCase();
                    //获取类中的属性
                    Field declaredField = clazz.getDeclaredField(columnName);
                    //获取类中属性对应的set方法
                    Method method = clazz.getDeclaredMethod(getSetMethodName(columnName), declaredField.getType());
                    if (objValue instanceof Number) {
                        Number number = (Number) objValue;
                        String fieldTypeName = declaredField.getType().getName();
                        if ("int".equals(fieldTypeName) || "java.lang.Integer".equals(fieldTypeName)) {
                            method.invoke(o, number.intValue());
                        } else if ("byte".equals(fieldTypeName) || "java.lang.Byte".equals(fieldTypeName)) {
                            method.invoke(o, number.byteValue());
                        } else if ("short".equals(fieldTypeName) || "java.lang.Short".equals(fieldTypeName)) {
                            method.invoke(o, number.shortValue());
                        } else if ("long".equals(fieldTypeName) || "java.lang.Long".equals(fieldTypeName)) {
                            method.invoke(o, number.longValue());
                        } else if ("float".equals(fieldTypeName) || "java.lang.Float".equals(fieldTypeName)) {
                            method.invoke(o, number.floatValue());
                        } else if ("double".equals(fieldTypeName) || "java.lang.Double".equals(fieldTypeName)) {
                            method.invoke(o, number.doubleValue());
                        }
                    } else {
                        method.invoke(o, objValue);
                    }
                }
                list.add(o);
            }
        } catch (Exception ex) {

        } finally {
            OracleUtil.closeConnection(connection,preparedStatement,resultSet);
        }

        return list;

    }

    public String getSetMethodName(String name) {
        return "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}
