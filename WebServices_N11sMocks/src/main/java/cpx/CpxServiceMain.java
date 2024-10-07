/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* CpxServiceMain.java class
*
* @name    : CpxServiceMain.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 25, 2021
****************************************************************************/

package cpx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CpxServiceMain {
    public static void main(String[] args) {
        SpringApplication.run(CpxServiceMain.class, args);
    }
}