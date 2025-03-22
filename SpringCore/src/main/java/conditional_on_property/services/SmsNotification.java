package conditional_on_property.services;

import conditional_on_property.NotificationSender;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SmsNotification implements NotificationSender
{
    public SmsNotification() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    @Override
    public String send(String message) {
        return "SMS Notification: " + message;
    }
}