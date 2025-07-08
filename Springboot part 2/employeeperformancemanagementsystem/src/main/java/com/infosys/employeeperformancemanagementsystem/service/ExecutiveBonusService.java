package com.infosys.employeeperformancemanagementsystem.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ExecutiveBonusService implements BonusServiceInterface {

    @Value("${bonus.executive.multiplier}")
    private double multiplier;

    @Override
    public double calculateBonus(int rating, double salary) {
        return rating * multiplier * salary;
    }
}
