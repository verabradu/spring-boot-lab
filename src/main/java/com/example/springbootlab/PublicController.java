package com.example.springbootlab;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Acces liber: fara autentificare!";
    }

}
