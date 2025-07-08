package com.infosys.main;

import com.infosys.Beans.Employee;
import com.infosys.Beans.Project;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context =new AnnotationConfigApplicationContext(com.infosys.config.config.class);

        Employee emp =context.getBean(Employee.class);
        emp.setEmployeeId(101);
        emp.setEmployeeName("Pushkar");
        System.out.println(emp.getEmployeeId() +"\t"+emp.getEmployeeName());


        Employee emp1=new Employee("Ram",102);
        System.out.println(emp1.getEmployeeId() +"\t"+emp1.getEmployeeName());
        System.out.println(emp1.toString());

        Project project=context.getBean(Project.class);
        project.setProjectName("Java-lombok-Project");
        project.setProjectTeamName("bahubali-Team");
        System.out.println(project.getProjectName() +"\t"+ project.getProjectTeamName());
        System.out.println(project.toString());

    }
}
