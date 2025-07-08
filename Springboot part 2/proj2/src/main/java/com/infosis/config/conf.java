package com.infosis.config;

import org.springframework.context.annotation.Bean;

@Configuration
public class conf {
    @Bean
    Student student() {
        Student s1 = new Student(); // create student bean object
        s1.setStudentId(102);
        s1.setStudentName("Aayush");
        return s1;
    }

    @Bean(name = "student103")
    Student student1() {
        Student s1 = new Student(); // create student bean object
        s1.setStudentId(103);
        s1.setStudentName("Shravani");
        return s1;
    }

    Student student2() {
        Student s1 = new Student(); // create student bean object
        s1.setStudentId(104);
        s1.setStudentName("Kiran");
        return s1;
    }
}
