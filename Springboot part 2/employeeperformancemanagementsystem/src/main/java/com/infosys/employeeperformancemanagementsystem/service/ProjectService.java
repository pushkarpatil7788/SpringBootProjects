package com.infosys.employeeperformancemanagementsystem.service;

import com.infosys.employeeperformancemanagementsystem.entity.Project;
import com.infosys.employeeperformancemanagementsystem.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements ProjectServiceInterface {

    @Autowired
    private ProjectRepo projectRepo;

    @Override
    public void addProject(String title, int durationMonths) {
        Project project = new Project();
        project.setTitle(title);
        project.setDurationMonths(durationMonths);
        projectRepo.save(project);
        System.out.println("Project added successfully.");
    }
}
