package com.example.bamcoreport.services.Impl;

import com.example.bamcoreport.dto.model.UserDto;
import com.example.bamcoreport.entities.User;

import java.util.List;

public interface IUserService {

    List<UserDto> getUsers();
    void postUser(User user);
    void deleteUser(Long userId);
}
