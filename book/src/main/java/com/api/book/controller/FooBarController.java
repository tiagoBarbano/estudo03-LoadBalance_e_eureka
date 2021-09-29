package com.api.book.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("book-service")
public class FooBarController {
    
    @GetMapping("/foo-bar")
    public String fooBar(){
        var response = new RestTemplate()
            .getForEntity("http://localhost:8080/foo-bar", String.class);
        //return "foo-bar!!!";
        return response.getBody();
    }
}
