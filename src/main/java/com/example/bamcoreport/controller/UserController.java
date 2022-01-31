package com.example.bamcoreport.controller;

import com.example.bamcoreport.dto.model.UserDto;
import com.example.bamcoreport.entities.User;
import com.example.bamcoreport.services.Impl.IUserService;
import com.example.bamcoreport.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    IUserService userService;

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> userDto = userService.getUsers();
        return ResponseEntity.ok(userDto);
    }

    @PostMapping
    public void postUser(@RequestBody User user) {
        userService.postUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        log.warn("user deleted");
        userService.deleteUser(userId);
    }

}
