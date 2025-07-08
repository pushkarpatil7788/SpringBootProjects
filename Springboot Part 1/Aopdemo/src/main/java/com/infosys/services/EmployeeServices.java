package com.infosys.services;

import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class EmployeeServices implements EmployeeRepo {

    @Override
    public void joiningDate() {
        System.out.println("Employee joining date is: " + new Date());

    }

    @Override
    public void endDate() {
        System.out.println("Employee last date: 21-12-2004");
    }
}
