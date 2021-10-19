package com.learning.dao;

import com.learning.entity.MyStudent;
import com.learning.entity.Student;
import com.learning.vo.QueryParam;
import com.learning.vo.ViewStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    public Student selectStudentByID(@Param("studentId") int id);
    public List<Student> selectMulitParam(@Param("myname") String name,@Param("myage") int age);
    ViewStudent selectStudentReturnViewStudent(@Param("studentId") Integer id);
    int countStudent ();
    Map<Object,Object> selectMapById(int id);
    List<Student> selectAllStudent();
    List<MyStudent> selectDifColPropety();
    //第一种模糊查询
    List<Student> selectlikeOne(String name);
    List<Student> selectlike(String name);
}
