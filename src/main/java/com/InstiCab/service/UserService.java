package com.InstiCab.service;

import com.InstiCab.dto.UserDto;
import com.InstiCab.model.User;
import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}