package conditional_on_property.services;

import conditional_on_property.NotificationSender;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class EmailNotification implements NotificationSender
{
    public EmailNotification() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    @Override
    public String send(String message) {
        return "Email Notification: " + message;
    }
}