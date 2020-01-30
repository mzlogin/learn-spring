package org.mazhuang.getting.start;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping("/exceptionTest")
    public String testTryAndFinally() throws Exception {
        try {
            boolean condition = true;
            if (condition) {
                throw new Exception("exceptionTest");
            }
//        } catch (Exception e) {
//            System.out.println("catch: " + e.getMessage());
        } finally {
            System.out.println("finally");
        }
        return "OK";
    }
}
