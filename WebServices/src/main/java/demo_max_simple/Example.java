/****************************************************************************
* Copyright 2020 (C) Andrei Tokmakov
* Example.java class
*
* @name    : Example.java
* @author  : Tokmakov Andrei
* @version : 1.0
* @since   : Dec 27, 2020
****************************************************************************/

package demo_max_simple;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

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