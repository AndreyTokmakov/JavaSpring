package aspect_oriented_programming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopOverviewApplication
{
    // https://medium.com/@ankithahjpgowda/what-is-aspect-oriented-programming-aop-in-spring-e7a845d904e
    public static void main(String[] args)
    {
        ApplicationContext context = SpringApplication.run(AopOverviewApplication.class, args);
        MainController controller = context.getBean(MainController.class);
        try{
            controller.getStudentDetail(20);
            System.out.println("\n==========================================");
            System.out.println("Calling method that throws error");
            controller.getStudentError();
        }
        catch (Exception e) {
            System.out.println("handled error:"+e.getMessage());
        }
    }
}
