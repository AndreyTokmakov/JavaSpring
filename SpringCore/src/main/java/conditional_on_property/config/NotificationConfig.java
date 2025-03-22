package conditional_on_property.config;

import conditional_on_property.NotificationSender;
import conditional_on_property.services.DefaultSender;
import conditional_on_property.services.EmailNotification;
import conditional_on_property.services.SmsNotification;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

// https://www.baeldung.com/spring-conditionalonproperty

@Log4j2
public class NotificationConfig
{
    public NotificationConfig() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    @Bean(name = "defaultNotification")
    @ConditionalOnProperty(prefix = "notification", name = "service", matchIfMissing = true)
    public NotificationSender createDefaultSender() {
        return new DefaultSender();
    }

    @Bean(name = "emailNotification")
    @ConditionalOnProperty(prefix = "notification", name = "service", havingValue = "email")
    public NotificationSender createEmailNotificationSender() {
        return new EmailNotification();
    }

    @Bean(name = "smsNotification")
    @ConditionalOnProperty(prefix = "notification", name = "service", havingValue = "sms")
    public NotificationSender createSmsNotificationSender() {
        return new SmsNotification();
    }
}
