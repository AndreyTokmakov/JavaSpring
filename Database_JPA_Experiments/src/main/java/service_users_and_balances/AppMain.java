package service_users_and_balances;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Configuration:
 *  Database configuration: Database_JPA_Experiments/src/main/resources/application.properties
 * How to run:
 *  1. cd Projects/JavaSpring/Database_JPA_Experiments
 *  2. mvn exec:java -Dexec.mainClass="service_users_and_balances.AppMain"
 **/

// @EnableJpaRepositories("service_users_and_balances.model.*")
// @ComponentScan("service_users_and_balances.*")
@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class,
                       basePackages = "service_users_and_balances.model")
public class AppMain {
    public static void main(String[] args) {
        SpringApplication.run(AppMain.class);
    }
}


// Swagger: http://localhost:8001/swagger-ui/index.html

