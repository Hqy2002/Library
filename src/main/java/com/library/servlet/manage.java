package com.library.servlet;



import com.library.mapper.Book;
import com.library.mapper.BookEntity;
import com.library.utils.ServletUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.IOException;
import java.util.List;

@WebServlet("/manage")
public class manage extends HttpServlet {
    TemplateEngine engine;
    Context context;
    List<Book> bookList;

    @SneakyThrows
    @Override
    public void init() {
        engine = new ServletUtil().getEngine();
        context = new Context();
        bookList = new BookEntity().getBooks();

        context.setVariable("bookList",bookList);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        engine.process("manage.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        bookList =new BookEntity().getByName(req.getParameter("bookname"));
        context.setVariable("bookList",bookList);
        TemplateEngine engine =new ServletUtil().getEngine();
        engine.process("manage.html", context, resp.getWriter());


    }

}
