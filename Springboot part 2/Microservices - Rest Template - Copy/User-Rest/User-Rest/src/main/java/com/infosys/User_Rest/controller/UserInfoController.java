package com.infosys.User_Rest.controller;

import com.infosys.User_Rest.model.ResponseDto;
import com.infosys.User_Rest.model.UserInfo;
import com.infosys.User_Rest.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserInfoController {

    @Autowired
    private UserInfoService userService;

    @PostMapping("/adduser")
    public ResponseEntity<UserInfo> saveUser(@RequestBody UserInfo userInfo) {
        UserInfo saveUser = userService.saveUser(userInfo);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserDetails(@PathVariable("id") Long userid) {
        try {
            ResponseDto responseDto = userService.getUser(userid);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            e.printStackTrace(); // Logs to console
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/user/{id}")
    public UserInfo getUserDetails1(@PathVariable("id") Long userid) {
        return userService.getDetail(userid);
    }
}


