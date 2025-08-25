package com.PEWUE.loyalty_program.controller;

import com.PEWUE.loyalty_program.dto.UserDTO;
import com.PEWUE.loyalty_program.dto.UserRegistrationDTO;
import com.PEWUE.loyalty_program.mapper.UserMapper;
import com.PEWUE.loyalty_program.service.UserService;
import com.PEWUE.loyalty_program.util.CycleAvoidingMappingContext;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;
    private final CycleAvoidingMappingContext context;

    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getAllUsers().stream()
                .map(user -> userMapper.toDto(user, context))
                .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO addUser(@RequestBody UserRegistrationDTO userDTO) {
        return userMapper.toDto(userService.registerUser(userDTO), context);
    }
}
