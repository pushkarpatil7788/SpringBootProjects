package com.infosys.beans;

import org.springframework.stereotype.Component;

@Component
public class Address {
    private String street = "35 Ramchandra Spring Road";
    private String city = "Pune";
    private String state = "Maharashtra";
    private String zipcode = "411001";

    public String getFullAddress() {
        return street + ", " + city + ", " + state + " - " + zipcode;
    }
}
