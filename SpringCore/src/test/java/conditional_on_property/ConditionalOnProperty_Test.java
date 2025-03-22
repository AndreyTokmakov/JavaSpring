package conditional_on_property;

import conditional_on_property.config.NotificationConfig;
import conditional_on_property.services.DefaultSender;
import conditional_on_property.services.EmailNotification;
import conditional_on_property.services.SmsNotification;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import static org.assertj.core.api.Assertions.assertThat;


//
/**
 * https://www.baeldung.com/spring-boot-context-runner
 *
 *  https://github.com/eugenp/tutorials/blob/master/spring-boot-modules/spring-boot-autoconfiguration/
 *              src/test/java/com/baeldung/conditionalonproperty/NotificationUnitTest.java
 *
 **/

public class ConditionalOnProperty_Test {
    private static final String NOTIFICATION_CONFIG_PARAMETER = "notification.service";

    private final ApplicationContextRunner contextRunner
            = new ApplicationContextRunner();

    private String createProperty(String serviceType) {
        return NOTIFICATION_CONFIG_PARAMETER + "=" + serviceType;
    }

    @Test
    public void CreateEmailNotificationSender()
    {
        final String messageText = "Hello world";
        final String responseExpected = "Email Notification: " + messageText;

        this.contextRunner.withPropertyValues(createProperty("email"))
                .withUserConfiguration(NotificationConfig.class)
                .run(context ->
                {
                    assertThat(context).hasBean("emailNotification");
                    assertThat(context).hasBean("defaultNotification");
                    assertThat(context).doesNotHaveBean("smsNotification");

                    NotificationSender notificationSender = context.getBean(EmailNotification.class);
                    assertThat(notificationSender.send(messageText))
                            .isEqualTo(responseExpected);
                });
    }

    @Test
    public void CreateSmsNotificationSender()
    {
        final String messageText = "Hello world";
        final String responseExpected = "SMS Notification: " + messageText;

        this.contextRunner.withPropertyValues(createProperty("sms"))
                .withUserConfiguration(NotificationConfig.class)
                .run(context ->
                {
                    assertThat(context).hasBean("smsNotification");
                    assertThat(context).hasBean("defaultNotification");
                    assertThat(context).doesNotHaveBean("emailNotification");

                    final NotificationSender sender = context.getBean(SmsNotification.class);
                    assertThat(sender.send(messageText)).isEqualTo(responseExpected);
                });
    }

    @Test
    public void CreateDefaultNotificationSender()
    {
        final String messageText = "Hello world";
        final String responseExpected = "Default: " + messageText;

        this.contextRunner.withUserConfiguration(NotificationConfig.class)
            .run(context ->  {
                assertThat(context).hasBean("defaultNotification");
                assertThat(context).doesNotHaveBean("smsNotification");
                assertThat(context).doesNotHaveBean("emailNotification");


                final NotificationSender sender = context.getBean(DefaultSender.class);
                assertThat(sender.send(messageText)).isEqualTo(responseExpected);
        });
    }
}

