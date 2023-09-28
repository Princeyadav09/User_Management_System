package com.cafe.management.system.controller.impl;

import com.cafe.management.system.constants.CafeContest;
import com.cafe.management.system.controller.UserController;
import com.cafe.management.system.model.request.UserDto;
import com.cafe.management.system.service.UserService;
import com.cafe.management.system.utils.CafeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public ResponseEntity<Object> signUp(UserDto userDto) {
        try{
            userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
            return userService.signUp(userDto);
        } catch (Exception ex){
            log.error("Exception Occurred in {}",ex.getMessage());
        }
        return CafeUtils.getResponseEntity(CafeContest.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<Object> logIn(UserDto userDto){
            return userService.logIn(userDto);
    }

    @Override
    public String profile(){
        return "here is your profile";
    }

    @Override
    public ResponseEntity<Object> getAllUsers(int pageNo,int pageSize,String sortBy,String sortDir){
            return userService.getAllUsers(pageNo,pageSize,sortBy,sortDir);
    }

    @Override
    public ResponseEntity<Object> searchByName(String name){
        return userService.searchByName(name);
    }
}
