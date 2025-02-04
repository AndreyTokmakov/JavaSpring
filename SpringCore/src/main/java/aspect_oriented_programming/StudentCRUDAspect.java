package aspect_oriented_programming;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component // will not work without @Component
public class StudentCRUDAspect
{
    //  point-cut expression
    @Before("execution(* aspect_oriented_programming.MainController.getStudentDetail(..)) and args(studentId)")
    public void logBefore(JoinPoint joinPoint, Integer studentId)
    {
        System.out.println("-Before advice: MainController-> " + joinPoint.getSignature().getName());
    }

    @After("execution(* aspect_oriented_programming.MainController.getStudentDetail(..)) and args(studentId)")
    public void logAfter(JoinPoint joinPoint, Integer studentId)
    {
        System.out.println("-After advice: MainController-> " + joinPoint.getSignature().getName());
    }

    @Around("execution(* aspect_oriented_programming.MainController.getStudentDetail(..)) and args(studentId)")
    public void logAround(ProceedingJoinPoint joinPoint, Integer studentId) throws Throwable {
        System.out.println("-Around advice: before");

        joinPoint.proceed(); //continue to call method (MainController.getStudentDetail)

        System.out.println("-Around advice: after");
    }

    @AfterReturning("execution(* aspect_oriented_programming.MainController.getStudentDetail(..)) and args(studentId)")
    public void logAfterReturning(JoinPoint joinPoint, Integer studentId)
    {
        System.out.println("-AfterReturning advice: MainController-> " + joinPoint.getSignature().getName());
    }

    @AfterThrowing(value = "execution(* aspect_oriented_programming.MainController.getStudentError(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Exception ex)
    {
        System.out.println("-AfterThrowing advice: -> " + joinPoint.getSignature().getName());
        System.out.println("Exception is:" + ex.getMessage());
    }
}