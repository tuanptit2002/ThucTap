package org.example.learn.Controller;

import org.example.learn.DTO.RoleDTO;
import org.example.learn.Entity.Role;
import org.example.learn.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping()
    public Role createRole(@RequestBody RoleDTO role) {
        return roleService.createRole(role);
    }
}
