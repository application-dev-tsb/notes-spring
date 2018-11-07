package com.practice.spring.spasecurity.resource.controller;

import com.practice.spring.spasecurity.resource.model.Message;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ResourceController {

    @RequestMapping("/")
    @CrossOrigin(
            origins = "*",
            maxAge = 3600,
            allowedHeaders={"x-auth-token", "x-requested-with"}
    )
    public Message home() {
        return new Message("Hello World");
    }

}
