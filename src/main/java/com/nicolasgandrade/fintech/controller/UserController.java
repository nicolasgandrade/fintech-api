package com.nicolasgandrade.fintech.controller;

import com.nicolasgandrade.fintech.dto.UserRequest;
import com.nicolasgandrade.fintech.model.User;
import com.nicolasgandrade.fintech.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                userService.createUser(userRequest)
        );
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

}
