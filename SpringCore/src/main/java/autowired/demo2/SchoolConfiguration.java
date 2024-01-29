/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* SchoolConfiguration.java class
*
* @name    : SchoolConfiguration.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 25, 2020
****************************************************************************/

package autowired.demo2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Configuration
public class SchoolConfiguration {

    @Bean
    public SchoolService schoolService() {
        return new SchoolService(classService());
    }

    @Bean
    public ClassService classService() {
        return new ClassService();
    }

    @Bean
    public TeacherService teacherService() {
        return new TeacherService();
    }

    @Bean
    public PrincipalService principalService() {
        return new PrincipalService();
    }
}
