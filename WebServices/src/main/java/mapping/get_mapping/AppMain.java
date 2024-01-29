/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* AppMain.java class
*
* @name    : AppMain.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 15, 2021
****************************************************************************/

package mapping.get_mapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
//@EnableWebMvc
public class AppMain {
    public static void main(String[] args) {
        SpringApplication.run(AppMain.class, args);
    }
}