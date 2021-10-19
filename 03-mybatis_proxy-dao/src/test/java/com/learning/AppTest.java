package com.learning;

import static org.junit.Assert.assertTrue;

import com.learning.dao.StudentDao;
import com.learning.entity.Student;
import com.learning.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest{
    @Test
    public void testSelectStudent(){
        SqlSession sqlSession = MybatisUtil.getSqlsession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> list =  dao.selectStudent();
        for(Student student:list){
            System.out.println(student);
        }
    }
    @Test
    public void testInsertStudent(){
        SqlSession sqlSession = MybatisUtil.getSqlsession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(1008);
        student.setName("lyh");
        student.setEmail("123@qq.cm");
        student.setAge(20);
        int res = dao.insertStudent(student);
        sqlSession.commit();
        System.out.println(res);
    }
}
