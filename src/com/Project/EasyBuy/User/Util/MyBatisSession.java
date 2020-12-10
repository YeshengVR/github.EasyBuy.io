package com.Project.EasyBuy.User.Util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisSession {
    private static SqlSessionFactory factory;
    static {
        //0.5创建读取配置的输入流
        try(InputStream inputStream = Resources.class.getClassLoader().getResourceAsStream("mybatis-config.xml")) {
            //0创建Bulider对象
            SqlSessionFactoryBuilder bulider = new SqlSessionFactoryBuilder();
            //1.创建SqlSessionFactory对象
            factory = bulider.build(inputStream,"development");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //无参就调用无参的方法构建session，无参的进行数据库操作，默认是不提交的，需要手动提交
    public static SqlSession openSession() {
        //2.创建SqlSession对象
        return factory.openSession();
    }
    //有参就调用有参的方法构建session，true为自动提交；false：为非自动提交
    public static SqlSession openSession(boolean autoCommit){
        return factory.openSession(autoCommit);
    }
    public static void close(SqlSession session){
        session.close();
    }
}
