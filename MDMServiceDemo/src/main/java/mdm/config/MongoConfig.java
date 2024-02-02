package mdm.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.extern.log4j.Log4j2;
import mdm.repositories.DeviceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.concurrent.TimeUnit;

@Log4j2
@Configuration
@EnableMongoRepositories(basePackageClasses = DeviceRepository.class)
public class MongoConfig {

    public MongoConfig() {
        log.info("* * * * " + this.getClass().getName() + " created! * * * * ");
    }

    @Bean
    MongoClient mongoClient() {
        ConnectionString connectionString  = new ConnectionString("mongodb://admin:admin@localhost:27017");

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
        return new MongoTemplate(mongoClient, "mdm");
    }
}