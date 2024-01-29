/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* AppConfig.java class
*
* @name    : AppConfig.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 17, 2021
****************************************************************************/

package bean.demo2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "bean.demo2")
public class AppConfig {
     
}