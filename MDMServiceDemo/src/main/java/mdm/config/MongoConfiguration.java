package mdm.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

// TODO: will use settings from srs.main.resources.application.yml

/*
@Configuration
@EnableMongoRepositories(basePackages = "mdm.repositories")
public class MongoConfiguration extends AbstractMongoClientConfiguration {

    @Value("${mongodb.database-name}")
    private String databaseName;

    @Value("${mongodb.connection-string}")
    private String connectionString;

    @Value("${mongodb.username}")
    private String username;

    @Value("${mongodb.password}")
    private String password;

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    @Override
    public MongoClient mongoClient()
    {
        final ConnectionString connectionString = new ConnectionString(this.connectionString);
        final MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .credential(MongoCredential.createCredential(username, databaseName, password.toCharArray()))
                .applyToConnectionPoolSettings(
                        builder -> builder.maxSize(20)
                                .minSize(10)
                                .maxWaitTime(2000, TimeUnit.MILLISECONDS)
                                .build()
                ).build();
        return MongoClients.create(mongoClientSettings);
    }

    @Override
    public Collection getMappingBasePackages() {
        return Collections.singleton("mdm.repositories");
    }
}
*/