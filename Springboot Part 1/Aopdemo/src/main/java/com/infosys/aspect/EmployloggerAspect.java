package com.infosys.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
public class EmployloggerAspect {
    Logger logger = Logger.getLogger(EmployloggerAspect.class.getName());


    @Before("execution(*com.infosys.beans.Employee.joiningDate() )")
    public void sendOfferLatter(){
        logger.info("Please accept the offer letter before joining");
    }

    @Around("execution(* com.infosys.beans.Employee.promotionDate(..) )")
    public  void employeePromotion(){
        logger.log(Level.INFO,"hey you performance is exceptional so we are giving you promotion");
    }

    @After("execution(* com.infosys.beans.Employee.endDate() )")
    public void fnfLetter() {
        logger.log(Level.INFO,"Are you sure you want to proceed with full and final settlement?");
    }

}
