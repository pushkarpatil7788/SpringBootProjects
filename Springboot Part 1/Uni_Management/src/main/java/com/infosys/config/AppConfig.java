package com.infosys.config;
import com.infosys.beans.Student;
import com.infosys.beans.Course;
import com.infosys.service.UniversityService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.infosys"})
public class AppConfig {
    @Bean
    public Student student() {
        Student s = new Student();
        s.setName("Pushkar ");
        s.setRollNumber(101);
        return s;
    }
    @Bean
    public Course course() {
        Course c = new Course();
        c.setCourseName("Spring");
        c.setInstructor("Dr. Patil");
        return c;
    }
    @Bean
    public UniversityService universityService() {
        UniversityService service = new UniversityService();
        service.setStudent(student());  // Setter Injection
        service.setCourse(course());    // Setter Injection
        return service;
    }
}
