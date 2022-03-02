package com.greetings.greetingsname;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetController {

    public static final String template = "Hello, %s";
    public final AtomicLong counter = new AtomicLong();

    @GetMapping("greet")
    public Greet greet(@RequestParam(value = "name", defaultValue = "Azar") String name) {
        return new Greet(counter.incrementAndGet(), String.format(template,name));
    }
}
