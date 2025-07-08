package com.infosys.beans;


import com.infosys.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {

    @Autowired
    private EmployeeServices employeeServices;

    private String employeeName="Pushkar";
    private int employeeId = 101 ;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }



    public void showDetails(){
        System.out.println("employ name is "+employeeName);
        System.out.println("employee ID is "+employeeId);

    }

    public void joiningDate(){
        employeeServices.joiningDate();
    }


    public void promotionDate(String promotionDate){
        System.out.println("we congrulation you got promoted you promation date will be  "+promotionDate);
    }

    public void endDate(){
        employeeServices.endDate();
    }
}
