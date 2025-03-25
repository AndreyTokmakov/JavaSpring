package primary_qualifier.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import primary_qualifier.IService;
import primary_qualifier.services.BackupService;
import primary_qualifier.services.MainService;


@Log4j2
public class ServiceConfig
{
    public ServiceConfig() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    @Primary
    @Bean(name = "MainServiceBean")
    public IService createMainService() {
        return new MainService();
    }

    @Bean(name = "BackupServiceBean")
    public IService createSmsNotificationSender() {
        return new BackupService();
    }
}
