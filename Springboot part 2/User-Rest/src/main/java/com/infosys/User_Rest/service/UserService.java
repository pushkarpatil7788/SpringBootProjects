package com.infosys.User_Rest.service;

import com.infosys.User_Rest.model.DepartmentDto;
import com.infosys.User_Rest.model.ResponseDto;
import com.infosys.User_Rest.model.UserInfo;
import com.infosys.User_Rest.model.UserInfoDto;
import com.infosys.User_Rest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class UserService implements UserServiceInterface{

    @Autowired
    public UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UserInfo saveUser(UserInfo userInfo) {
        return userRepo.save(userInfo);
    }

    @Override
    public ResponseDto getUser(Long userId) {
        ResponseDto responseDto = new ResponseDto();

        Optional<UserInfo> optionalUser = userRepo.findById(userId);
        if (optionalUser.isEmpty()) {
            return null;
        }

        UserInfo userInfo = optionalUser.get();
        UserInfoDto userDto = new UserInfoDto(
                userInfo.getId(),
                userInfo.getFirstName(),
                userInfo.getLastName(),
                userInfo.getEmail(),
                userInfo.getDepartmentId()
        );
        DepartmentDto departmentDto = restTemplate.getForObject(
                "http://localhost:8084/api/department/" + userInfo.getDepartmentId(),
                DepartmentDto.class
        );

        responseDto.setUser(userDto);
        responseDto.setDepartment(departmentDto);

        return responseDto;
    }
}
