package com.library.servlet;

import com.library.mapper.BookEntity;
import com.library.mapper.BorrowEntity;
import com.library.utils.ServletUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import  java.io.IOException;


@WebServlet("/set")
public class set extends HttpServlet {

    TemplateEngine engine;
    Context context;

    @Override
    public void init() {
        engine = new ServletUtil().getEngine();
        context = new Context();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        engine.process("set.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String bookname = req.getParameter("bookname");
        String username =  req.getParameter("username");
        BookEntity bookEntity = new BookEntity();
        BorrowEntity borrowEntity = new BorrowEntity();
        borrowEntity.setBook(bookname,username);
        int a = bookEntity.setBook(bookname);
        context.setVariable("success", a);
        engine.process("set.html", context, resp.getWriter());

    }

}
