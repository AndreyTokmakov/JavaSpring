/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* Application.java class
*
* @name    : Application.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 25, 2020
****************************************************************************/

package autowired.demo2;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(SchoolConfiguration.class);

        SchoolService schoolService = applicationContext.getBean(SchoolService.class);
        schoolService.teachStudents();

        applicationContext.close();
    }
}
