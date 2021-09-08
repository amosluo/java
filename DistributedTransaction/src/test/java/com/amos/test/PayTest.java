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
    public void payTest(){
// 获取数据库的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Pay pay = null;
        try {
            // 获取要调用的接口类
            PayDao mapper = sqlSession.getMapper(PayDao.class);
            // 调用方法开始执行
            pay = mapper.find(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        System.out.println(pay);
    }
}
