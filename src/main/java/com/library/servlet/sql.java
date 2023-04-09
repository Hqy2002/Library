package com.library.servlet;

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
import java.sql.SQLException;

@WebServlet("/sql")
public class sql extends HttpServlet {

    TemplateEngine engine;
    Context context;

    @Override
    public void init() {
        engine = new ServletUtil().getEngine();
        context = new Context();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        engine.process("sql.html", context, resp.getWriter());
    }
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String sql = req.getParameter("sql");
        executeSQL execute = new executeSQL();
        String result = execute.getResult(sql);
        context.setVariable("result",result);
        engine.process("sql.html", context, resp.getWriter());

    }

}
