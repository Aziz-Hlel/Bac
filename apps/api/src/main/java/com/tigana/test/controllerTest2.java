package com.tigana.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class controllerTest2 {

    private final serviceTest serviceTest;

    @GetMapping("")
    public String createTest() {
        serviceTest.createTest("name");
        return "index";
    }
}
