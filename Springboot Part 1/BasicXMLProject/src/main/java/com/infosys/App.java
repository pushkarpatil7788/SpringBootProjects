package com.infosys;

import com.infosys.beans.Department;
import com.infosys.beans.Employee;
import com.infosys.beans.Project;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Employee emp = (Employee) context.getBean("emp");
        System.out.println("Employee ID: " + emp.getEmpId());
        System.out.println("Employee Name: " + emp.getEmpName());

        Department department = (Department) context.getBean("depart1");
        System.out.println(department);

        Project project=context.getBean(Project.class);
        System.out.println(project.toString());

//        Project project1 = (Project) context.getBean("project1");
//        System.out.println(project1);

        project.showResources();


    }
}
