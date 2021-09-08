package com.amos.bean;
import com.amos.dao.StudentDao;
import com.amos.service.StudentService;
import com.amos.service.TeacherService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
//        Person person = applicationContext.getBean("person", Person.class);
//        Person person2 = applicationContext.getBean("person2", Person.class);
//        Person person3 = applicationContext.getBean("person2", Person.class);
//        System.out.println(person2 == person3);
//        ((ClassPathXmlApplicationContext)applicationContext).close();
//        Person person2 = applicationContext.getBean("person3", Person.class);

        //通过静态工厂类获取
        //Person person2 = applicationContext.getBean("person4", Person.class);

        //通过实例工厂获取
//        Person person2 = applicationContext.getBean("person5",Person.class);

//        Person person2 = applicationContext.getBean("factoryBean",Person.class);
//        Person person3 = applicationContext.getBean("factoryBean",Person.class);
//
//        System.out.println(person2 == person3);

        //容器管理第三方类
//        DruidDataSource dataSource = applicationContext.getBean("dataSource",DruidDataSource.class);
//        DruidPooledConnection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        try {
//             connection = dataSource.getConnection();
//             preparedStatement = connection.prepareStatement("select * from test2");
//             resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                System.out.println(resultSet.getString("name"));
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        finally {
//            try {
//                resultSet.close();
//                preparedStatement.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//
//        }

        StudentService studentService = context.getBean("studentService",StudentService.class);
        studentService.save();

        TeacherService teacherService = context.getBean("teacherService",TeacherService.class);
        teacherService.save();
    }
}
