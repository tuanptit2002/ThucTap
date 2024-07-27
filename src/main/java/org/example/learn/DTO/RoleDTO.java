package org.example.learn.DTO;

import lombok.Data;

import java.util.List;
import java.util.UUID;
@Data
public class RoleDTO {

    private UUID id;
    private String name;
    private List<UserDTO> users;
}
