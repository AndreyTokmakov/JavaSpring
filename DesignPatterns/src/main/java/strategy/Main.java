package strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import strategy.publicator.PublicatorResolver;
import strategy.model.PublicatorType;

@SpringBootApplication
public class Main implements CommandLineRunner
{
    @Autowired
    public PublicatorResolver publicatorResolver;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        publicatorResolver.getPublicator(PublicatorType.POST).publish();
        publicatorResolver.getPublicator(PublicatorType.STORY).publish();
        publicatorResolver.getPublicator(PublicatorType.REELS).publish();
    }
}
