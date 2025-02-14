package rate_limiter;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("rate_limiter.properties")
@ComponentScan(basePackages = "rate_limiter")
public class AppMain
{
    public static void main(String[] args)
    {
        ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppMain.class);
        TestService service = applicationContext.getBean(TestService.class);
        service.runTest();
        applicationContext.close();
    }
}
