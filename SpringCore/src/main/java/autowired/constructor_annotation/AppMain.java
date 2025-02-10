package autowired.constructor_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain
{
    public static void main(String[] args)
    {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigurationClass.class);
        ServiceController controller = ctx.getBean(ServiceController.class);
        controller.test();
    }
}
