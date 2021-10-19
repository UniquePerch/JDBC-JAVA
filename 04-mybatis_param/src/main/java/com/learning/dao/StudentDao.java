package com.learning.dao;

import com.learning.entity.Student;
import com.learning.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    public Student selectStudentByID(int id);
    public List<Student> selectMulitParam(@Param("myname") String name,@Param("myage") int age);
    public List<Student> selectMultiObject(QueryParam queryParam);
    public List<Student> selectMultiPosition(String name,int age);
    public List<Student> selectMultiByMAP(Map<String,Object> map);
    public List<Student> selectUse$(String name);
    public List<Student> selectUse$Order(String colName);
}
