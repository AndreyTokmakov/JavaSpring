package primary_qualifier;

import conditional_on_property.NotificationSender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import primary_qualifier.config.ServiceConfig;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimaryQualifierTest
{
    private final ApplicationContextRunner contextRunner
            = new ApplicationContextRunner();

    @Test
    public void CreateEmailNotificationSender()
    {
        this.contextRunner.withUserConfiguration(ServiceConfig.class)
            .run(context -> {
                final IService service = context.getBean(IService.class);
                Assertions.assertEquals("Main-Result", service.invoke());
            });

        /**
         * If ServiceConfig::createMainService() will not be annotated with @Primary will be an Error
         *
         * No qualifying bean of type 'primary_qualifier.IService' available: expected single matching bean but found 2:
         * MainServiceBean,BackupServiceBean
         **/
    }
}
