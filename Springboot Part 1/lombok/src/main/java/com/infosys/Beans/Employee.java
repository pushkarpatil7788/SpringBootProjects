package com.infosys.Beans;

import lombok.*;
import org.springframework.stereotype.Component;


@Component
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

    @Getter @Setter
    public String employeeName;
    @Getter @Setter
    public int employeeId;


}
