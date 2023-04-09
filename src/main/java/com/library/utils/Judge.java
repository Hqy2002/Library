package com.library.utils;

import com.library.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class Judge {
    UserMapper userMapper;
    public Judge() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        userMapper= sqlSession.getMapper(UserMapper.class);

    }

   public  boolean isLoginValid(String username, String password) throws IOException {
       int count  = userMapper.getUserCount(username,password);
       return  count==0;
    }
    public static void main(String[] args) throws IOException {


    }

}
