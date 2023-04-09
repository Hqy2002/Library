package com.library.mapper;

import com.library.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class UserEntity {

    UserMapper userMapper;


    public UserEntity() throws IOException {


        SqlSession sqlSession = MybatisUtil.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    public int addUser(String username,String password){
        //检查用户是否存在

        int flag = userMapper.checkUser(username);
        if(flag==0){

            User user = new User(username,password);
            userMapper.insertUser(user);
            return 1;
        }
        return 0;
    }


    public static void main(String[] args) throws IOException {

        UserEntity userEntity = new UserEntity();
        System.out.println(userEntity.addUser("21231305", "21231303"));

    }
}
