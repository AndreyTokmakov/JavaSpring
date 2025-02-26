package email_templates_maker.services;

import email_templates_maker.email.EmailDTO;
import email_templates_maker.email.EmailService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Service
public class ScheduledNotificationService
{
    @Autowired
    private EmailService emailService;

    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("[yyyy-MM-dd HH:mm:ss.SSS] ");

    @Autowired
    public ScheduledNotificationService()
    {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    @Scheduled(cron = "${notifications.cron}", zone = "UTC")
    public void sendNotification() throws IOException
    {
        final String delimiter = "=".repeat(160);
        System.out.println(delimiter);

        log.info("sendNotification: The time is now {}", formatter.format(LocalDateTime.now()));

        EmailDTO email = new EmailDTO();
        email.setTo("andtokmtest@yandex.ru");
        email.setSubject("Welcome Letter via Spring Boot + FreeMarker");

        // Populate the template data
        Map<String, Object> templateData = new HashMap<>();
        templateData.put("name", "Atul Rai");
        // List of team members...
        List<String> teamMembers = Arrays.asList("Tendulkar", "Manish", "Dhirendra");
        templateData.put("teamMembers", teamMembers);
        templateData.put("location", "India");
        email.setEmailData(templateData);

        // Calling email service | But 'sendEmail == False' --> just to print Template
        emailService.sendWelcomeEmail(email, false);

        System.out.println(delimiter);
    }
}