package autowired.demo1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Configuration
public class AppConfiguration {
	
    @Bean
    // @Bean(name = "gServiceName") 
    // @Bean(destroyMethod = "customDestroy", initMethod = "customInit")
    @Description("Some bean description! Test!!")
    public Shop getShop() {
        return new Shop();
    }
    
    @Bean
    // @Bean(name = "gServiceName") 
    // @Bean(destroyMethod = "customDestroy", initMethod = "customInit")
    @Description("Some bean description! Test!!")
    public Seller getSeller() {
        return new Seller();
    }
}
