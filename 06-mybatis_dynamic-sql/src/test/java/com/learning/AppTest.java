package com.learning;
import com.github.pagehelper.PageHelper;
import com.learning.dao.StudentDao;
import com.learning.entity.Student;
import com.learning.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AppTest{
    @Test
    public void testSelectStudentIf(){
        SqlSession sqlSession = MybatisUtil.getSqlsession(true);
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("李四");
        student.setAge(20);
        List<Student> list = dao.selectStudentIf(student);
        for(Student student1 : list){
            System.out.println(student1);
        }
    }
    @Test
    public void testSelectStudentWhere(){
        SqlSession sqlSession = MybatisUtil.getSqlsession(true);
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        //student.setName("李四");
        //student.setAge(1);
        List<Student> list = dao.selectStudentWhere(student);
        for(Student student1 : list){
            System.out.println(student1);
        }
    }
    @Test
    public void testFror(){
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        //String sql = "select * from student where id in(1001,1002,1003)";
        String sql = "select * from student where id in";
        StringBuffer builder = new StringBuffer("");
        int init = 0;
        int len = list.size();
        builder.append("(");
        for(int i : list){
            builder.append(i).append(",");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append(")");
        sql = sql+builder.toString();
        System.out.println(sql);
    }
    @Test
    public void testSelectStudentForeach(){
        SqlSession sqlSession = MybatisUtil.getSqlsession(true);
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        List<Student> students = dao.selectStudentForeachOne(list);
        for(Student student : students){
            System.out.println(student);
        }
    }
    @Test
    public void testSelectStudentForeachTwo(){
        SqlSession sqlSession = MybatisUtil.getSqlsession(false);
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = new ArrayList<>();
        Student s1 = new Student();
        s1.setId(1002);
        studentList.add(s1);
        Student s2 = new Student();
        s2.setId(1005);
        studentList.add(s2);
        try {
            List<Student> students = dao.selectStudentForeachTwo(studentList);
            sqlSession.commit();
            for(Student student : students){
                System.out.println(student);
            }
            sqlSession.close();
        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        }
    }
    @Test
    public void testPageHelper(){
        SqlSession sqlSession = MybatisUtil.getSqlsession(true);
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //pageNum第几页，从1开始，pageSize表示一页中有多少行数据
        PageHelper.startPage(3,3);
        List<Student> students = dao.selectALL();
        for(Student student : students){
            System.out.println(student);
        }
    }
}
