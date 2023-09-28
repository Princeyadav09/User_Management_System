package com.cafe.management.system.controller;

import com.cafe.management.system.constants.PaginationConstants;
import com.cafe.management.system.model.request.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/api/v1/user")
public interface UserController {

    @PostMapping(path = "/signup")
    public ResponseEntity<Object> signUp(@RequestBody UserDto userDto);


    @PostMapping(path = "/login")
    public ResponseEntity<Object> logIn(@RequestBody UserDto userDto);

    @GetMapping(path = "/profile")
    public String profile();

    @GetMapping(path = "/getAllUsers")
    public ResponseEntity<Object> getAllUsers(
            @RequestParam(value = "pageNo", defaultValue = PaginationConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = PaginationConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = PaginationConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = PaginationConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    );

    @GetMapping(path = "/search")
    public ResponseEntity<Object> searchByName(
            @RequestParam(value = "name") String name
    );
}
