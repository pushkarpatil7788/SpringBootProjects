package com.infosys.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Developer {
    private String developerName;
    private String teamName;
    @Autowired
    private Project project;

    //construction injection
    @Autowired
    public Developer(Project project)
    {
        System.out.println("Developer bean is created");
        this.project = project;
    }


    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
