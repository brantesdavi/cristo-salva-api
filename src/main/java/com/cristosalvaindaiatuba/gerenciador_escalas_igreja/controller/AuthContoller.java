package com.cristosalvaindaiatuba.gerenciador_escalas_igreja.controller;

import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.user.User;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthContoller {

    private final UserService userService;

    public AuthContoller(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }
}
