package com.lifepill.authenticationservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployerController {

    @GetMapping("/employer")
    public String employer() {
        return "Employer";
    }
}
