package org.example.learn.Controller;

import org.example.learn.Config.JwtTokenProvider;
import org.example.learn.DTO.AuthenticationResponse;
import org.example.learn.DTO.UserDTO;
import org.example.learn.Entity.User;
import org.example.learn.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
    public User registerUser(@RequestBody  UserDTO userDTO) {
        return userService.login(userDTO);
    }

    @PostMapping("/login")
    public AuthenticationResponse loginUser(@RequestBody UserDTO userDTO) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        User user = (User) authentication.getPrincipal();
        String jwt = jwtTokenProvider.generateToken(user);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setAccess_token(jwt);
        authenticationResponse.setEmail(user.getUsername());
        return authenticationResponse;
    }
}
