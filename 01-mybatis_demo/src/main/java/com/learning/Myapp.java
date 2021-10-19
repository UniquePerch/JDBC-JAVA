package com.learning;

import com.learning.Utils.MybatisUtil;
import com.learning.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Myapp {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = MybatisUtil.getSqlsession();
        String sqlID = "com.learning.Dao.StudentDao" + "." + "selectstu";
        List<Student> studentList = sqlSession.selectList(sqlID);
        studentList.forEach(student -> System.out.println(student));
        sqlSession.close();
    }
}
