/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* ClassService.java class
*
* @name    : ClassService.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 25, 2020
****************************************************************************/

package autowired.demo2;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ClassService {

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student("John"));
        students.add(new Student("Sarah"));
        return students;
    }
}