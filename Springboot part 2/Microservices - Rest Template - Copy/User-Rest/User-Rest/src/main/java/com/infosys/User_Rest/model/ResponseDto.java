package com.infosys.User_Rest.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    private DepartmentDto departmentDto;
    private UserInfoDto user;

}
