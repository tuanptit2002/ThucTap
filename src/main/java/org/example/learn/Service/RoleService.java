package org.example.learn.Service;

import org.example.learn.DTO.RoleDTO;
import org.example.learn.Entity.Role;
import org.example.learn.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role createRole(RoleDTO role) {
        Role roleEntity = new Role();
        roleEntity.setName(role.getName());
        Role saveRole = roleRepository.save(roleEntity);
        return saveRole;
    }
}
