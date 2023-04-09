package com.library.mapper;

import com.library.utils.MybatisUtil;

import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class BookEntity {


    private List<Book> bookList;
    BookMapper bookMapper;

    public BookEntity() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        bookMapper = sqlSession.getMapper(BookMapper.class);
        bookList = bookMapper.getBookList();
    }

    public List<Book> getBooks() {
        return bookList;
    }

    public List<Book> getByName(String name) {

        bookList = bookMapper.getByName(name);
        return bookList;

    }

    public int addBook(String bookName, String author, String publisher, float price, String borrowed) {
        Book book = new Book(bookName,author,publisher,price,borrowed);
        return bookMapper.insertBook(book);

    }

    public int deleteBook(String bookName){
        return bookMapper.deleteBookByName(bookName);
    }

    public int setBook(String bookName){
        return  bookMapper.updateBorrowedStatus(bookName);
    }


    public static void main(String[] args) throws IOException {
    }


}
