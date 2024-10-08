/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* Example.java class
*
* @name    : Example.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 27, 2020
****************************************************************************/

package demo_max_simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Example {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Example.class, args);
    }
}