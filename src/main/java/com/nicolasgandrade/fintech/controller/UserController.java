package com.nicolasgandrade.fintech.controller;

import com.nicolasgandrade.fintech.dto.UserRequest;
import com.nicolasgandrade.fintech.model.User;
import com.nicolasgandrade.fintech.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok().body(
                userService.createUser(userRequest)
        );
    }
}
