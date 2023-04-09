package com.library.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BorrowMapper {

    @Insert("INSERT INTO borrow (bid,username,book) VALUES (#{bid},#{username}, #{book})")
    int insertUser(Borrow borrow);

    @Delete("DELETE FROM borrow WHERE book = #{name}")
    int returnBook(@Param("name") String name);

    @Select("SELECT MAX(bid) from borrow")
    int getBid();

    @Select("SELECT book FROM borrow WHERE username = #{username}")
    List<String> selectBooksByUsername(@Param("username") String username);

    @Select("SELECT COUNT(*) FROM borrow WHERE book = #{bookname}")
    int selectCount(@Param("bookname") String bookname);
}



