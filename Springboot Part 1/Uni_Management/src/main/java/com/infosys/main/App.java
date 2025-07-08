package com.infosys.main;

import com.infosys.config.AppConfig;
import com.infosys.service.UniversityService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {   // Renamed from UniversityService

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UniversityService service = context.getBean(UniversityService.class);
        service.enrollStudent();
    }
}
