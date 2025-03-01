package com.ankushkunwar.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/Health")
@RestController
public class HealthCheck {
    @GetMapping
    private String healthCheck() {
        return "ok";
    }
}
