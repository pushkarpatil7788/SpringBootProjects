package com.infosys.User_Rest.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long departmentId;
}
