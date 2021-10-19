package com.learning.Dao;

import com.learning.entity.Student;

import java.util.List;

public interface StudentDao {
    //查询student表的所有数据
    public List<Student> selectstu();
    //插入方法
    public int insertStu(Student student);
}
