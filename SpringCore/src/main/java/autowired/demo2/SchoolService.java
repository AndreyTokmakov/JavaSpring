/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* SchoolService.java class
*
* @name    : SchoolService.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 25, 2020
****************************************************************************/

package autowired.demo2;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SchoolService {

    @Autowired
    private TeacherService teacherService;

    private PrincipalService principalService;

    private final ClassService classService;

    public SchoolService(ClassService classService) {
        this.classService = classService;
    }

    public void teachStudents() {
        List<Student> students = classService.getStudents();
        students.forEach(teacherService::teach);
        principalService.administer();
    }

    @Autowired
    public void setPrincipalService(PrincipalService principalService) {
        this.principalService = principalService;
        log.info("setPrincipalService() called.");
    }
}
