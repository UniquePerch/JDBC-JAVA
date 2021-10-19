package com.learning;

import static org.junit.Assert.assertTrue;

import com.learning.dao.StudentDao;
import com.learning.entity.MyStudent;
import com.learning.entity.Student;
import com.learning.util.MybatisUtil;
import com.learning.vo.QueryParam;
import com.learning.vo.ViewStudent;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppTest{
    @Test
    public void testSelectStudentBYID(){
        SqlSession sqlSession = MybatisUtil.getSqlsession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = dao.selectStudentByID(1002);
        System.out.println(student);
        sqlSession.close();
    }
    @Test
    public void testSelectMulitParam(){
        SqlSession sqlSession = MybatisUtil.getSqlsession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectMulitParam("李四",20);
        for(Student student : students){
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public void ViewStudent(){
        SqlSession sqlSession = MybatisUtil.getSqlsession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        ViewStudent student = dao.selectStudentReturnViewStudent(1005);
        System.out.println(student);
        sqlSession.close();
    }
    @Test
    public void countStudent(){
        SqlSession sqlSession = MybatisUtil.getSqlsession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        int cnt = dao.countStudent();
        System.out.println(cnt);
        sqlSession.close();
    }
    @Test
    public void selectMap(){
        SqlSession sqlSession = MybatisUtil.getSqlsession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Map<Object,Object> map = dao.selectMapById(1001);
        System.out.println(map);
    }
    @Test
    public void selectAllStudent(){
        SqlSession sqlSession = MybatisUtil.getSqlsession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectAllStudent();
        for(Student student : students){
            System.out.println(student);
        }
    }
    @Test
    public void selectdiffcol(){
        SqlSession sqlSession = MybatisUtil.getSqlsession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> students = dao.selectDifColPropety();
        for(MyStudent student : students){
            System.out.println(student);
        }
    }
    @Test
    public void selectlike(){
        SqlSession sqlSession = MybatisUtil.getSqlsession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectlikeOne("%李%");
        for(Student student : students){
            System.out.println(student);
        }
    }
    @Test
    public void selectliketwo(){
        SqlSession sqlSession = MybatisUtil.getSqlsession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectlike("张");
        for(Student student : students){
            System.out.println(student);
        }
    }
}
