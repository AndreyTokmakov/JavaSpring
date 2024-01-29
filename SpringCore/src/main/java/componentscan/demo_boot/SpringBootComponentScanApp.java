/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* SpringBootComponentScanApp.java class
*
* @name    : SpringBootComponentScanApp.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 24, 2020
****************************************************************************/

package componentscan.demo_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import componentscan.ExampleBean;
import componentscan.annotation_filters.Animal;


@SpringBootApplication
// @ComponentScan(basePackages = "com.baeldung.componentscan.springbootapp.animals")
// @ComponentScan ( excludeFilters = @ComponentScan.Filter(type=FilterType.REGEX,pattern="com\\.baeldung\\.componentscan\\.springbootapp\\.flowers\\..*"))
// @ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = Rose.class))
public class SpringBootComponentScanApp {
    private static ApplicationContext applicationContext;

    @Bean
    public ExampleBean exampleBean() {
        return new ExampleBean();
    }

    public static void main(String[] args) {
        applicationContext = SpringApplication.run(SpringBootComponentScanApp.class, args);
        checkBeansPresence("cat", "dog", "rose", "exampleBean", "springBootApp");

    }

    private static void checkBeansPresence(String... beans) {
        for (String beanName : beans) {
            System.out.println("Is " + beanName + " in ApplicationContext: " + applicationContext.containsBean(beanName));
        }
    }
}