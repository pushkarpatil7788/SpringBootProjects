package com.vedant.main;

import com.vedant.beans.UniversityService;
import com.vedant.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UniversityService universityService = context.getBean(UniversityService.class);
        universityService.enrollStudent();

    }
}