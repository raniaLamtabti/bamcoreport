package com.example.bamcoreport.services;

import com.example.bamcoreport.dto.model.UserDto;
import com.example.bamcoreport.dto.services.IMapClassWithDto;
import com.example.bamcoreport.entities.User;
import com.example.bamcoreport.repositories.UserRepository;
import com.example.bamcoreport.services.Impl.IUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    IMapClassWithDto<User, UserDto> userMapping;


    @Override
    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        return userMapping.convertListToListDto(users,UserDto.class);
    }

    public void postUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        boolean exists =  userRepository.existsById(userId);

        if (!exists) {
            log.error("user not found");
            throw new IllegalStateException("user not found");
        }

        userRepository.deleteById(userId);
    }
}

