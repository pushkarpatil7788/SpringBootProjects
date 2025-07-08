package com.infosys.main;

import com.infosys.beans.Employee;
import com.infosys.config.AppConfig;
import com.infosys.services.EmployeeRepo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Employee employee=context.getBean(Employee.class);
        employee.joiningDate();
        employee.promotionDate("01-04-2025");
        employee.endDate();
        employee.showDetails();
    }
}
