package com.infosys.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.infosys.*")
@EnableAspectJAutoProxy
public class AppConfig {


}
