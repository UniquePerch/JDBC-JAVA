package com.learning.dao;

import com.learning.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> selectStudent();
    int insertStudent(Student student);
}
