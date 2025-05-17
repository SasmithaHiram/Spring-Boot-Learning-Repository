package org.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String sayHelloToAdmin() {
        return "Hello Admin";
    }

    @GetMapping("/customer")
    public String sayHelloToCustomer() {
        return "Hello Customer";
    }
}
