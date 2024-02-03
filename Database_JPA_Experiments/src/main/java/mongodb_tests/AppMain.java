package mongodb_tests;

import mongodb_tests.tests.Tester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;


public class AppMain
{
    Tester tester = new Tester();

    public static void main(String[] args) {
        SpringApplication.run(AppMain.class, args);
    }

    @Bean
    public CommandLineRunner CommandLineRunnerBean() {
        return (args) ->
        {
            tester.readDevice();
        };
    }
}
