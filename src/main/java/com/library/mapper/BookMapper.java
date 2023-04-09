package com.library.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper {

    @Select("select * from book")
    List<Book> getBookList();

    @Select("select * from book where bookname like concat('%',#{name},'%') or author like concat('%',#{name},'%')   ")
    List<Book> getByName(@Param("name") String name);

    @Insert("INSERT INTO book(bookname, author, publisher, price, borrowed) " +
            "VALUES (#{bookname}, #{author}, #{publisher}, #{price}, #{borrowed})")
    int insertBook(Book book);

    @Delete("DELETE FROM book WHERE bookname = #{name}")
    int deleteBookByName(@Param("name") String name);

    @Update("UPDATE book SET borrowed = CASE borrowed " +
            "WHEN '未借出' THEN '已借出' " +
            "WHEN '已借出' THEN '未借出' " +
            "END " +
            "WHERE bookname = #{name}")
    int updateBorrowedStatus(@Param("name") String bookname);


}


