package com.amos.test;

import com.amos.bean.Pay;
import com.amos.dao.PayDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class PayTest {

    String resource;
    InputStream inputStream = null;
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void init(){
        // 根据全局配置文件创建出SqlSessionFactory
        // SqlSessionFactory:负责创建SqlSession对象的工厂
        resource = "mybatis-config.xml";
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    //通过ID查询
    public void testFind(){
// 获取数据库的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Pay pay = null;
        try {
            // 获取要调用的接口类
            PayDao mapper = sqlSession.getMapper(PayDao.class);
            // 调用方法开始执行
            pay = mapper.find(1);
            System.out.println(pay);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        System.out.println(pay);
    }

    @Test
    //多参数查询
    public void testFindMultiParam(){
        // 获取数据库的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Pay> pay = null;
        try {
            // 获取要调用的接口类
            PayDao mapper = sqlSession.getMapper(PayDao.class);
            // 调用方法开始执行
            pay = mapper.findByAmountAndCreatedBy(null, "customer");
            System.out.println(pay);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        System.out.println(pay);
    }

    @Test
    //实体查询
    public void testFindByPay(){
        // 获取数据库的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Pay> pay = null;
        try {
            // 获取要调用的接口类
            PayDao mapper = sqlSession.getMapper(PayDao.class);
            // 调用方法开始执行
            pay = mapper.findByPay(new Pay(null,null, "lx"));
            System.out.println(pay);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        System.out.println(pay);
    }

    @Test
    public void testAdd() {

        // SqlSession:表示跟数据库建议的一次会话

        // 获取数据库的会话(默认不自动提交，也可以在这里设置自动提交)
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            // 获取要调用的接口类
            PayDao mapper = sqlSession.getMapper(PayDao.class);
            Integer add = mapper.add(new Pay(123.21, new Date(),"customer33"));
            Integer add2 = mapper.add(new Pay(Double.parseDouble("aaa"), new Date(),"customer"));
            System.out.println("save受影响的行数:" + add);
            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
