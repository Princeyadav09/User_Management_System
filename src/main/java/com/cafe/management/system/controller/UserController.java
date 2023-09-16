package com.cafe.management.system.controller;

import com.cafe.management.system.model.request.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/api/v1/user")
public interface UserController {

    @PostMapping(path = "/signup")
    public ResponseEntity<Object> signUp(@RequestBody UserDto userDto);


    @PostMapping(path = "/login")
    public ResponseEntity<Object> logIn(@RequestBody UserDto userDto);

    @GetMapping(path = "/profile")
    public String profile();
}
