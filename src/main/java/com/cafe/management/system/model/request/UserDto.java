package com.cafe.management.system.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class UserDto {
    private String name;
    private String contactNumber;
    private String email;
    private String password;
    private String status;
    private String role;
}
