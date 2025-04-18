package bean.bean_resolution;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "bean.bean_resolution")
public class AppMain
{
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppMain.class);
        ctx.refresh();


        BeenKeeper keeper = ctx.getBean(BeenKeeper.class);
        keeper.info();;

        // Product product = ctx.getBean(Product.class);
        // System.out.println(product);
    }
}
