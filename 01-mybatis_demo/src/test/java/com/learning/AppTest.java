package com.learning;

import static org.junit.Assert.assertTrue;

import com.learning.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testInsert() throws IOException {
        //访问mybatis中的student数据
        //1.定义mybatis主配置文件的名称，从类路径的跟开始（target/class）
        String config = "mybatis.xml";
        //2.读取这个config文件
        InputStream in = Resources.getResourceAsStream(config);
        //3.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4.创建SqlSessionFactoryBuilder对象
        SqlSessionFactory factory = builder.build(in);
        //5.[重要]从SqlSessionFactory中获取
        SqlSession sqlSession = factory.openSession(true);
        //6.指定要执行sql语句的标识。sql映射文件中的namespace+“.”+标签的id；
        String sqlID = "com.learning.Dao.StudentDao" + "." + "insertStu";
        //7.执行sql语句，通过sqlID找到语句
        int res = sqlSession.insert(sqlID, new Student(1006,"12/3","123456",123));
        //8.输出结果
        System.out.println(res);
        //9.关闭SqlSession对象
        sqlSession.close();
    }
}
