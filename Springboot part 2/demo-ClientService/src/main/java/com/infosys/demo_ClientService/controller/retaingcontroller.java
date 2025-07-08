package com.infosys.demo_ClientService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class retaingcontroller {

    @GetMapping("/home")
    public String home(){
        return "please rate our services";
    }
}