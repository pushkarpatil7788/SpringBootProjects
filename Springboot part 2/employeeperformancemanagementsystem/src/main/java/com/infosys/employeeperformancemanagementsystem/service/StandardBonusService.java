package com.infosys.employeeperformancemanagementsystem.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("standardBonusService")
@Primary
public class StandardBonusService implements BonusServiceInterface {

    @Value("${bonus.standard.multiplier}")
    private double multiplier;

    @Override
    public double calculateBonus(int rating, double salary) {
        return rating * multiplier * salary;
    }
}
