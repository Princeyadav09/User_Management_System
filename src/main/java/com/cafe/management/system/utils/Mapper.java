package com.cafe.management.system.utils;

import com.cafe.management.system.model.entities.User;
import com.cafe.management.system.model.request.UserDto;

public class Mapper {

    public static User UserDtoToUser(UserDto userDto) {
        return new User(userDto);
    }
}
