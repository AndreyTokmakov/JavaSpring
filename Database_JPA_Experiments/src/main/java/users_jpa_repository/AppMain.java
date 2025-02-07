package users_jpa_repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Configuration:
 *  Database configuration: Database_JPA_Experiments/src/main/resources/application.properties
 * How to run:
 *  1. cd Projects/JavaSpring/Database_JPA_Experiments
 *  2. mvn exec:java -Dexec.mainClass="users_jpa_repository.AppMain"
 **/

@SpringBootApplication
public class AppMain {
    public static void main(String[] args) {
        SpringApplication.run(AppMain.class);
    }
}


