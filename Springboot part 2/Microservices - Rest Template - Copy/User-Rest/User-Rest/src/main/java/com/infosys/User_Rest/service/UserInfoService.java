package com.infosys.User_Rest.service;

import com.infosys.User_Rest.model.ResponseDto;
import com.infosys.User_Rest.model.UserInfo;

public interface UserInfoService {

    UserInfo saveUser(UserInfo userInfo);

    UserInfo getDetail(Long userId);

    ResponseDto getUser(Long userId);
}
