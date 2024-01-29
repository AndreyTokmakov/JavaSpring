/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* TeacherService.java class
*
* @name    : TeacherService.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 25, 2020
****************************************************************************/

package autowired.demo2;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TeacherService {

    public void teach(Student student) {
        log.info("TeacherService::teach() : Teaching " + student);
    }
}
