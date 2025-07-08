package com.infosys.main;

import com.infosys.beans.Developer;
import com.infosys.config.MyAppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyAppConfig.class);

        Developer dev = context.getBean(Developer.class);
        dev.setTeamName("XYZ");
        dev.setDeveloperName("Soham");



        System.out.println("Dev name: " + dev.getDeveloperName());
        System.out.println("Dev team name: " + dev.getTeamName());
        System.out.println("Dev project name: " + dev.getProject().getProjectName());

        context.close();
    }
}
