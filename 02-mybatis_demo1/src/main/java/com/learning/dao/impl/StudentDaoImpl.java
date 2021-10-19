package com.learning.dao.impl;

import com.learning.dao.StudentDao;
import com.learning.entity.Student;
import com.learning.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> selectStudent() {
        SqlSession sqlSession = MybatisUtil.getSqlsession();
        String sqlID = "com.learning.dao.StudentDao.selectStudent";
        List<Student> students =  sqlSession.selectList(sqlID);
        sqlSession.close();
        return students;
    }

    @Override
    public int insertStudent(Student student) {
        SqlSession sqlSession = MybatisUtil.getSqlsession();
        String sqlID = "com.learning.dao.StudentDao.insertStudent";
        int res = sqlSession.insert(sqlID,student);
        sqlSession.commit();
        sqlSession.close();
        return res;
    }

}
