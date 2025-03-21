/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* ApplConfigForAutowired.java class
*
* @name    : ApplConfigForAutowired.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 14, 2020
****************************************************************************/

package autowired.resolve_by_name;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("autowired.resolve_by_name;")
public class AppConfigForAutowired {
}