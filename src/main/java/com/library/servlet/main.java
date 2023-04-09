package com.library.servlet;

import com.library.mapper.Book;
import com.library.mapper.BookEntity;
import com.library.mapper.BorrowEntity;
import com.library.utils.ServletUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import java.io.IOException;
import java.util.List;
@WebServlet("/main")
public class main extends HttpServlet {

    TemplateEngine engine;
    Context context;
    List<Book> bookList;
    String username;
    @SneakyThrows
    @Override
    public void init() throws ServletException {
        username = (String) getServletContext().getAttribute("username");
        engine =new ServletUtil().getEngine();
        context = new Context();
        bookList = new BookEntity().getBooks();
        BorrowEntity borrowEntity = new BorrowEntity();
        List<String> borrowedBook =borrowEntity.getBorrowedBook(username);
        context.setVariable("bookList",bookList);
        context.setVariable("username",username);
        context.setVariable("borrowedBookList",borrowedBook);


    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        bookList = new BookEntity().getBooks();
        TemplateEngine engine =new ServletUtil().getEngine();
        engine.process("main.html", context, resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        bookList =new BookEntity().getByName(req.getParameter("bookname"));
        context.setVariable("bookList",bookList);
        TemplateEngine engine =new ServletUtil().getEngine();
        engine.process("main.html", context, resp.getWriter());



    }
}