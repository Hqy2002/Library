package com.library.servlet;

import com.library.mapper.BookEntity;
import com.library.utils.ServletUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.IOException;

@WebServlet("/add")
public class add extends HttpServlet {

    TemplateEngine engine;
    Context context;

    @Override
    public void init() {
        engine = new ServletUtil().getEngine();
        context = new Context();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        engine.process("add.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String bookname = req.getParameter("bookname");
        String author = req.getParameter("author");
        String publisher = req.getParameter("publisher");
        float price = Float.parseFloat(req.getParameter("price"));
        String borrowed = req.getParameter("borrowed");
        BookEntity bookEntity = new BookEntity();
        int a = bookEntity.addBook(bookname, author, publisher, price, borrowed);
        context.setVariable("success",a);
        engine.process("add.html", context, resp.getWriter());




    }

}
