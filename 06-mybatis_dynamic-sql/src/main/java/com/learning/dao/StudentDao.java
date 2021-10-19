package com.learning.dao;

import com.learning.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    //动态sql要使用java对象做参数
    List<Student> selectStudentIf(Student student);
    //where
    List<Student> selectStudentWhere(Student student);
    //foreach 用法1
    List<Student> selectStudentForeachOne(List<Integer> idlist);
    //foreach 用法2
    List<Student> selectStudentForeachTwo(List<Student> stulist);
    //使用pagehelper分页数据
    List<Student> selectALL();
}
