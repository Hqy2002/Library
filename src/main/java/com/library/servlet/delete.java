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

@WebServlet("/delete")
public class delete extends HttpServlet {
    TemplateEngine engine;
    Context context;

    @Override
    public void init() {
        engine = new ServletUtil().getEngine();
        context = new Context();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        engine.process("delete.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String bookname = req.getParameter("bookname");
        BookEntity bookEntity = new BookEntity();
        int a = bookEntity.deleteBook(bookname);
        context.setVariable("success", a);
        engine.process("delete.html", context, resp.getWriter());

    }

}
