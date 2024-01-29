package lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Configuration
public class BeanConfiguration {

    @Bean(destroyMethod = "destroy", initMethod = "initialize")
    public CustomMethodsService withCustomMethodsService() {
        return new CustomMethodsService();
    }

    @Bean(destroyMethod = "customDestroy", initMethod = "customInit")
    public MixedService mixedService() {
        return new MixedService();
    }
}
