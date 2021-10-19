package com.learning;

import static org.junit.Assert.assertTrue;

import com.learning.dao.StudentDao;
import com.learning.dao.impl.StudentDaoImpl;
import com.learning.entity.Student;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest{
    @Test
    public void testSelectStudent(){
        StudentDao dao = new StudentDaoImpl();
        List<Student> list = dao .selectStudent();
        for (Student stu:list){
            System.out.println(stu);
        }
    }
    @Test
    public void testInsertstudent(){
        StudentDao dao = new StudentDaoImpl();
        Student student = new Student(1007,"顿山","123456@qq.com",15);
        int num = dao.insertStudent(student);
        System.out.println(num);
    }
}
