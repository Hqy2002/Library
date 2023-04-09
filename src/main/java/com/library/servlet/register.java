package com.library.servlet;


import com.library.mapper.UserEntity;
import com.library.utils.Judge;
import com.library.utils.ServletUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.IOException;
import java.util.Objects;


@WebServlet("/register")
public class register extends HttpServlet {
    TemplateEngine engine;
    Context context;

    @Override
    public void init() {
        engine = new ServletUtil().getEngine();
        context = new Context();
        context.setVariable("url", "library.jpg");
        context.setVariable("isFalse", false);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
        resp.setHeader("Pragma", "no-cache"); // HTTP 1.0
        resp.setHeader("Expires", "0"); // Proxies
        engine.process("register.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserEntity userEntity = new UserEntity();
        int a = userEntity.addUser(req.getParameter("username"), req.getParameter("password"));
        if (a == 0) {
            context.setVariable("isFalse", true);
            engine.process("register.html", context, resp.getWriter());
        } else {
            resp.sendRedirect("main");
        }
    }
}
