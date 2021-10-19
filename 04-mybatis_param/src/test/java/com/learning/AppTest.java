package com.learning;

import static org.junit.Assert.assertTrue;

import com.learning.dao.StudentDao;
import com.learning.entity.Student;
import com.learning.util.MybatisUtil;
import com.learning.vo.QueryParam;
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
    public void testSelectMulitObject(){
        SqlSession sqlSession = MybatisUtil.getSqlsession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectMultiObject(new QueryParam("张三",20));
        for(Student student : students){
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public void testSelectPosition(){
        SqlSession sqlSession = MybatisUtil.getSqlsession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectMultiPosition("李四",20);
        for(Student student : students){
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public void testSelectMap(){
        SqlSession sqlSession = MybatisUtil.getSqlsession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Map<String,Object> map = new HashMap<>();
        map.put("myname","张三");
        map.put("myage",20);
        List<Student> list = dao.selectMultiByMAP(map);
        for(Student student : list){
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public void testSelectUse$(){
        SqlSession sqlSession = MybatisUtil.getSqlsession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> list = dao.selectUse$("'李四'");
        for(Student student : list){
            System.out.println("学生："+student);
        }
        sqlSession.close();
    }
    @Test
    public void testSelectUse$Order(){
        SqlSession sqlSession = MybatisUtil.getSqlsession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> list = dao.selectUse$Order("id ");
        for(Student student : list){
            System.out.println("学生："+student);
        }
        sqlSession.close();
    }

}
