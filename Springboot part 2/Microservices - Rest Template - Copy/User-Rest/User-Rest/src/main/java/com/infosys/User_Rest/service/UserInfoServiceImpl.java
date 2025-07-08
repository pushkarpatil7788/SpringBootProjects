package com.infosys.User_Rest.service;

import com.infosys.User_Rest.model.DepartmentDto;
import com.infosys.User_Rest.model.ResponseDto;
import com.infosys.User_Rest.model.UserInfo;
import com.infosys.User_Rest.model.UserInfoDto;
import com.infosys.User_Rest.repository.UserInterfaceRepository;
import org.antlr.v4.runtime.misc.NotNull;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    private UserInterfaceRepository urepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UserInfo saveUser(UserInfo userInfo) {
        return urepository.save(userInfo);
    }

    @Override
    public ResponseDto getUser(Long userId) {
        UserInfo user = urepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        UserInfoDto userdto = mapToUser(user);

        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
                "http://localhost:8080/api/departments/" + user.getDepartmentId(), DepartmentDto.class);

        DepartmentDto departmentDto = responseEntity.getBody();

        ResponseDto responseDto = new ResponseDto();
        responseDto.setUser(userdto);
        responseDto.setDepartmentDto(departmentDto);

        return responseDto;
    }


    @Override
    public UserInfo getDetail(Long userId) {
        return urepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
    }

    private UserInfoDto mapToUser(UserInfo user) {
        UserInfoDto userdto = new UserInfoDto();
        userdto.setId(user.getId());
        userdto.setFirstName(user.getFirstName());
        userdto.setLastName(user.getLastName());
        userdto.setEmail(user.getEmail());
        userdto.setDepartmentId(user.getDepartmentId()); // This was missing earlier
        return userdto;
    }



}
