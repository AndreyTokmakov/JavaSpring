package email_templates_maker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AppMain {
    public static void main(String[] args) {
        SpringApplication.run(AppMain.class, args);
    }
}

/**
 <!-- FreeMarker -->
 <dependency>
 <groupId>org.springframework.boot</groupId>
 <artifactId>spring-boot-starter-freemarker</artifactId>
 </dependency>

 <!-- Java Mailer -->
 <dependency>
 <groupId>org.springframework.boot</groupId>
 <artifactId>spring-boot-starter-mail</artifactId>
 </dependency>
**/


/**
spring:
   mail:
      host: 'smtp.gmail.com'
      port: 587
      username: 'XXXXXXXXXXX'
      password: 'xxxxxxx'

      properties:
         mail:
            smtp:
                auth: true
                connectiontimeout: 5000
                timeout: 5000
                writetimeout: 5000
                starttls:
                    enable: true
 **/