package com.vedant.config;

import com.vedant.beans.Course;
import com.vedant.beans.Student;
import com.vedant.beans.UniversityService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.vedant"})
public class AppConfig {
 @Bean
    public Student student(){
        return new Student();
    }
 @Bean
    public Course course(){

        return new Course();
    }
 @Bean
    public UniversityService universityService(){
        return new UniversityService();
    }
}