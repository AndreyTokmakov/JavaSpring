/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* ServiceMain.java class
*
* @name    : ServiceMain.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 18, 2021
****************************************************************************/

package exception_handling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExcServiceMain
{
    public static void main(String[] args)
    {
        System.out.println("TEST=================");
        SpringApplication.run(ExcServiceMain.class, args);
    }
}