package com.example.bamcoreport.controller;

import com.example.bamcoreport.dto.model.RoleDto;
import com.example.bamcoreport.entities.Role;
import com.example.bamcoreport.services.Impl.IRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

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

    @DeleteMapping(path = "{roleId}")
    public void deleteRole(@PathVariable("roleId") Long roleId){
        log.warn("role deleted");
        roleService.deleteRole(roleId);
    }
}
