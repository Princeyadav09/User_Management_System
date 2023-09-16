package com.cafe.management.system.service;

import com.cafe.management.system.model.request.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
     ResponseEntity<Object> signUp(UserDto userDto);

     ResponseEntity<Object> logIn(UserDto userDto);
}
