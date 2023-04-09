package com.library;

import com.library.Mybatis.MybatisUtil;
import com.library.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException {

        SqlSession sqlSession= MybatisUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> s= studentMapper.selectAll();
        System.out.println(s);


    }
}
