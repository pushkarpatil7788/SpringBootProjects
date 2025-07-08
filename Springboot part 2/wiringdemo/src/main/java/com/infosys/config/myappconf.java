package com.infosys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class myappconf {

    @Bean
    public Project project() {
        Project p = new Project();
        p.setProjectName("Finacle");
        return p;
    }

    // developer bean has dependency on project bean
    @Bean
    public Developer devloper() {
        Developer dev = new Developer();
        dev.setDevloper("Soham");
        dev.setTeamName("Architecture");
        dev.setProject(project());
        return dev;
    }
}


