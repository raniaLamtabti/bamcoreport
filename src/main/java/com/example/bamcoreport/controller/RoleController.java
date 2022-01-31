package com.example.bamcoreport.controller;

import com.example.bamcoreport.dto.model.RoleDto;
import com.example.bamcoreport.entities.Role;
import com.example.bamcoreport.services.Impl.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    IRoleService roleService;

    @GetMapping("/")
    public ResponseEntity<List<RoleDto>> getAllRoles(){
        List<RoleDto> roleDto = roleService.getRoles();
        return ResponseEntity.ok(roleDto);
    }

    @PostMapping
    public void postRole(@RequestBody Role role) {
        roleService.postRole(role);
    }
}
