package aspect_oriented_programming;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class MainController
{
    public MainController()
    {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    /// method to check all aspects except AfterThrowing
    public String getStudentDetail(Integer studentId)
    {
        // do some processing
        System.out.println("MainController:getStudentDetail() called");
        return "studentDetail";
    }

    /// method to check aspect - AfterThrowing
    public void getStudentError()
    {
        System.out.println("MainController:getStudentError() called");
        Integer res = 50/0;
    }
}
