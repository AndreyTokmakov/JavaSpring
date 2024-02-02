package service_mongodb.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import service_mongodb.repositories.BookRepository;

import java.util.concurrent.TimeUnit;

@Log4j2
@Configuration
@EnableMongoRepositories(basePackageClasses = BookRepository.class)
public class MongoConfig {

    public MongoConfig() {
        log.info("* * * * " + this.getClass().getName() + " created! * * * * ");
    }

    @Bean
    MongoClient mongoClient() {
        ConnectionString connectionString  = new ConnectionString("mongodb://mongoadmin:secret@localhost:27017");

        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .applyToConnectionPoolSettings(builder -> builder.maxSize(20)
                        .minSize(10)
                        .maxWaitTime(2000, TimeUnit.MILLISECONDS)
                        .build())
                .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, "testdb");
    }
}