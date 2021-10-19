package com.learning.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class  MybatisUtil {

    private static SqlSessionFactory factory = null;
    static {
        String config = "Mybatis.xml";//与项目中的主配置文件一致
        try {
            InputStream in = Resources.getResourceAsStream(config);
            //创建SqlsessionFactory对象，使用SqlsessionFactoryBuild
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取Sqlsession方法
    public static SqlSession getSqlsession(boolean Autocommit){
        SqlSession sqlSession = null;
        if(factory!=null){
            sqlSession = factory.openSession(Autocommit);//非自动提交事务
        }
        return sqlSession;
    }
}
