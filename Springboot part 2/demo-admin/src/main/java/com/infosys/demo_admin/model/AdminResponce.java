package com.infosys.demo_admin.model;

import org.springframework.http.HttpStatusCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminResponce {

    private HttpStatusCode httpStatusCode;
    private String httpMessage;

}
