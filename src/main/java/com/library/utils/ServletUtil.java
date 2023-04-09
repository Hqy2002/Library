package com.library.utils;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.nio.charset.StandardCharsets;

public class ServletUtil {

    TemplateEngine engine;
    Context context;
    public ServletUtil(){

        engine = new TemplateEngine();
        ClassLoaderTemplateResolver r = new ClassLoaderTemplateResolver();
        r.setCharacterEncoding(StandardCharsets.UTF_8.name());
        engine.setTemplateResolver(r);


    }

    public TemplateEngine getEngine(){
        return engine;
    }




}
