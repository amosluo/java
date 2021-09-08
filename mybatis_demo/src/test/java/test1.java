import com.amos.bean.Emp;
import com.amos.dao.EmpDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.Date;
import java.util.List;

public class test1 {

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
    public void testFind() {

        // SqlSession:表示跟数据库建议的一次会话

        // 获取数据库的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Emp empByEmpno = null;
        try {
            // 获取要调用的接口类
            EmpDao mapper = sqlSession.getMapper(EmpDao.class);
            // 调用方法开始执行
            empByEmpno = mapper.findByEmpno(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        System.out.println(empByEmpno);
    }

    @Test
    public void find() {

        // SqlSession:表示跟数据库建议的一次会话

        // 获取数据库的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Emp empByEmpno = null;
        try {
            // 获取要调用的接口类
            EmpDao mapper = sqlSession.getMapper(EmpDao.class);
            Emp emp = new Emp();
            emp.setEmpno(8);
            // 调用方法开始执行
            empByEmpno = mapper.find(emp);
            System.out.println(empByEmpno);
            emp.setName("9");
            Thread.sleep(500);
//            sqlSession.clearCache();
            empByEmpno = mapper.find(emp);
            System.out.println(empByEmpno);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testFindDept() {

        // SqlSession:表示跟数据库建议的一次会话

        // 获取数据库的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Emp empByEmpno = null;
        try {
            // 获取要调用的接口类
            EmpDao mapper = sqlSession.getMapper(EmpDao.class);
            // 调用方法开始执行
            empByEmpno = mapper.findDept(7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        System.out.println(empByEmpno);
    }

    @Test
    public void testFindByMultiParam() {

        // SqlSession:表示跟数据库建议的一次会话

        // 获取数据库的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Emp empByEmpno = null;
        try {
            // 获取要调用的接口类
            EmpDao mapper = sqlSession.getMapper(EmpDao.class);
            // 调用方法开始执行
            empByEmpno = mapper.find1ByEmpno(7,"test2");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        System.out.println(empByEmpno);
    }

    @Test
    public void testSelectAll() {

        // SqlSession:表示跟数据库建议的一次会话

        // 获取数据库的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Emp empByEmpno = null;
        try {
            // 获取要调用的接口类
            EmpDao mapper = sqlSession.getMapper(EmpDao.class);
            // 调用方法开始执行
            List<Emp> emps = mapper.selectAll();
            for (Emp emp : emps) {
                System.out.println(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        System.out.println(empByEmpno);
    }


    @Test
    public void testAdd() {

        // SqlSession:表示跟数据库建议的一次会话

        // 获取数据库的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            // 获取要调用的接口类
            EmpDao mapper = sqlSession.getMapper(EmpDao.class);
            Integer add = mapper.save(new Emp("test1", 29, new Date()));
            System.out.println("save受影响的行数:" + add);
            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testUpdate() {

        // SqlSession:表示跟数据库建议的一次会话

        // 获取数据库的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            // 获取要调用的接口类
            EmpDao mapper = sqlSession.getMapper(EmpDao.class);
            Integer update = mapper.update(new Emp(8,"test1", 29, new Date()));
            System.out.println("update受影响的行数:" + update);
            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testDelete() {

        // SqlSession:表示跟数据库建议的一次会话

        // 获取数据库的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            // 获取要调用的接口类
            EmpDao mapper = sqlSession.getMapper(EmpDao.class);
            Integer delete = mapper.deleteByEmpno(6);
            System.out.println("delete受影响的行数:" + delete);
            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
