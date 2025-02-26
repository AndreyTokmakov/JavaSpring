package value;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "value.controller")
public class ParseListOfValues
{
    public static void main(String[] args) {
        SpringApplication.run(ParseListOfValues.class, args);
    }
}
