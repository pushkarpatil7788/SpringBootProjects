package com.infosys.User_Rest.controller;

import com.infosys.User_Rest.model.UserInfo;
import com.infosys.User_Rest.model.ResponseDto;
import com.infosys.User_Rest.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServiceInterface userService;

    @PostMapping("/adduser")
    public ResponseEntity<UserInfo> saveUser(@RequestBody UserInfo userInfo) {
        UserInfo savedUser = userService.saveUser(userInfo);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getUserDetails(@PathVariable("id") Long userId) {
        ResponseDto responseDto = userService.getUser(userId);
        return ResponseEntity.ok(responseDto);
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<ResponseDto> getUserById(@PathVariable("id") Long userId) {
        ResponseDto responseDto = userService.getUser(userId);
        return ResponseEntity.ok(responseDto);
    }

//    @GetMapping("/user/{id}")
//    public UserInfo getUserDetails1(@PathVariable("id") Long userid) {
//    return userService.getUser(userid);
//    }
}
