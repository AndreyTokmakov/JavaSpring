/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* AppMain.java class
*
* @name    : AppMain.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 15, 2021
****************************************************************************/

package web_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppMain {
    public static void main(String[] args) {
        SpringApplication.run(AppMain.class, args);
    }
}

// http://127.0.0.1:8080/hello