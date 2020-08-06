package com.maheit.expense.controllers;

import java.util.concurrent.atomic.AtomicLong;

import com.maheit.expense.model.Greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingControllers {

    public static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Mahesh") String name) {
        return new Greeting(counter.getAndIncrement(), String.format(template, name));
    }

}