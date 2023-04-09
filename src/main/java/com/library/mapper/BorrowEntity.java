package com.library.mapper;

import com.library.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import java.io.IOException;
import java.util.List;

public class BorrowEntity {


    BorrowMapper borrowMapper;

    public BorrowEntity() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        borrowMapper = sqlSession.getMapper(BorrowMapper.class);
    }

    public void add(String username, String bookname){


        int bid = borrowMapper.getBid()+1;
        Borrow borrow =new Borrow(bid,username,bookname);
        borrowMapper.insertUser(borrow);
    }

    public int del(String bookname){

        return borrowMapper.returnBook(bookname);
    }

    public List<String> getBorrowedBook(String username){

        return borrowMapper.selectBooksByUsername(username);
    }

    public int getCount(String bookname){

        return borrowMapper.selectCount(bookname);
    }

    public void setBook(String username,String bookname){


        //
        if(this.getCount(bookname)==0){
            this.add(username,bookname);
        }
        else {
            this.del(bookname);
        }


    }


    public static void main(String[] args) throws IOException {

        BorrowEntity borrowEntity = new BorrowEntity();
        System.out.println(borrowEntity.getCount("红梦"));


    }
}
