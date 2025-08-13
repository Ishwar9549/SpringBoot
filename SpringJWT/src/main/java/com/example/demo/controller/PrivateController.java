package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private")
public class PrivateController {

    private static final Logger logger = LoggerFactory.getLogger(PrivateController.class);

    @GetMapping
    public String privateFunctionOne() {
        logger.info("Private endpoint accessed.");
        return "private function one";
    }
}
