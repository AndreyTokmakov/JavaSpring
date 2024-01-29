/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* Main.java class
*
* @name    : Main.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 17, 2021
****************************************************************************/

package service.demo1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main 
{
    public static void main( String[] args )
    {
        /** Method 1: **/
        // ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        /** Method 2: **/
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
         
        EmployeeManager empManager = ctx.getBean(EmployeeManager.class);
        Employee emp = empManager.create();
         
        System.out.println(emp);
    }
}