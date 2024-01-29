/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* ServiceMain.java class
*
* @name    : ServiceMain.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 18, 2021
****************************************************************************/

package authorization_service.service2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceMain {
    public static void main(String[] args) {
        SpringApplication.run(ServiceMain.class, args);
    }
}