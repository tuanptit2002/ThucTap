package org.example.learn.Service;

import lombok.AllArgsConstructor;
import org.example.learn.DTO.RoleDTO;
import org.example.learn.DTO.UserDTO;
import org.example.learn.Entity.Role;
import org.example.learn.Entity.User;
import org.example.learn.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public User login(UserDTO userDTO){
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        List<Role> roles = new ArrayList<>();
        for (RoleDTO roleDTO : userDTO.getRoles()){
            Role role = new Role();
            role.setId(roleDTO.getId());
            roles.add(role);
        }
        user.setRoles(roles);
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = (UserDetails) userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }
}
