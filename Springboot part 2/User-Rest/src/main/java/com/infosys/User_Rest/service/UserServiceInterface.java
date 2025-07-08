package com.infosys.User_Rest.service;


import com.infosys.User_Rest.model.UserInfo;
import com.infosys.User_Rest.model.ResponseDto;

public interface UserServiceInterface {
    UserInfo saveUser(UserInfo userInfo);
    ResponseDto getUser(Long userId);

}