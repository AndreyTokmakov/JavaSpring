package bean.bean_resolution;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanBuilderConfiguration
{
    @Bean
    public Product makeProductPrimary()
    {
        return new Product("Primary");
    }

    //*
    @Bean
    public Product makeProductSecondary()
    {
        return new Product("Secondary");
    }//*/
}
