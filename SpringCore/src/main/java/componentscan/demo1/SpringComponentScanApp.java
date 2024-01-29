/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* SpringComponentScanApp.java class
*
* @name    : SpringComponentScanApp.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 24, 2020
****************************************************************************/

package componentscan.demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import componentscan.ExampleBean;

@Configuration
@ComponentScan
// @ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = Rose.class))
// @ComponentScan(basePackages = "com.baeldung.componentscan.springapp")
// @ComponentScan(basePackages = "com.baeldung.componentscan.springapp.animals")
// @ComponentScan (excludeFilters = @ComponentScan.Filter(type=FilterType.REGEX,pattern="com\\.baeldung\\.componentscan\\.springapp\\.flowers\\..*"))
public class SpringComponentScanApp {

    private static ApplicationContext applicationContext;

    @Bean
    public ExampleBean exampleBean() {
        return new ExampleBean();
    }

    public static void main(String[] args) {
        applicationContext = new AnnotationConfigApplicationContext(SpringComponentScanApp.class);

        for (String beanName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
    }

}