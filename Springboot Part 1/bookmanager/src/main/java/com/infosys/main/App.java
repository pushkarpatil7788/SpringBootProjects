package com.infosys.main;

import com.infosys.config.AppConfig;
import com.infosys.service.LibraryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        LibraryService libraryService = context.getBean(LibraryService.class);
        libraryService.showBooks();
    }
}
