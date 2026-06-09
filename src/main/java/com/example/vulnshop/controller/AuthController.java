package com.example.vulnshop.controller;

import com.example.vulnshop.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password) {

        return service.login(username, password);
    }

    @GetMapping("/reset")
    public String resetToken() {
        return service.generateResetToken();
    }

    @GetMapping("/hash")
    public String hash(@RequestParam String value) {
        return service.md5Hash(value);
    }
}