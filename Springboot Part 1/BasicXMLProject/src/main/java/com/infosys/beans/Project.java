package com.infosys.beans;

import java.util.List;
import java.util.Map;

public class Project {
    private List<Employee> employeeList;
    private Employee lead;
    private String projectName;
    private Department department;
    private Map<String, Integer> resources;

    public Project(List<Employee> employeeList, Employee lead) {
        this.employeeList = employeeList;
        this.lead = lead;
    }

    // Setters used by Spring
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setResources(Map<String, Integer> resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "Project{" +
                "employeeList=" + employeeList +
                ", lead=" + lead +
                ", projectName='" + projectName + '\'' +
                ", department=" + department +
                '}';
    }

    public void showResources() {
        for (Map.Entry<String, Integer> resource : resources.entrySet()) {
            System.out.println(resource.getKey() + " - " + resource.getValue());
        }
    }
}
