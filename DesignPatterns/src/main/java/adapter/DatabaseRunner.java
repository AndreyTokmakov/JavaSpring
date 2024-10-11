package adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabaseRunner implements CommandLineRunner
{
    @Autowired
    @Qualifier("javaToDatabaseAdapter")
    // @Qualifier("JavaToDatabaseAdapterEx")
    private IDatabase database;

    public static void main(String[] args) {
        SpringApplication.run(DatabaseRunner.class);
    }

    @Override
    public void run(String... args) throws Exception
    {
        database.insert(new Object());
        database.update(new Object());
        database.select();
        database.remove();
    }
}
