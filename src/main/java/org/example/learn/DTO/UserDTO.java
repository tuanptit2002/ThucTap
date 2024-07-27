package org.example.learn.DTO;

import lombok.Data;

import java.util.List;
import java.util.UUID;


@Data
public class UserDTO {

    private UUID id;

    private String username;
    private String password;

    private List<RoleDTO> roles;
}
