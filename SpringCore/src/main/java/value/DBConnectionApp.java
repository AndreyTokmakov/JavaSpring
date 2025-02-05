package value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

@Configuration
@PropertySource(name = "DB_Properties", value = "database.properties")
class DBConnection
{
    @Value("${DB_DRIVER_CLASS}")
    private String driverClass;
    @Value("${DB_URL}")
    private String dbURL;
    @Value("${DB_USERNAME}")
    private String userName;
    @Value("${DB_PASSWORD}")
    private char[] password;

    public DBConnection() {
        // printDBConfigs();
    }

    @PostConstruct
    public void printDBConfigs()
    {
        System.out.println("Driver Class = " + driverClass);
        System.out.println("DB URL = " + dbURL);
        System.out.println("User Name = " + userName);

        // Never do below in production environment :D
        System.out.println("Password = " + String.valueOf(password));
    }
}

public class DBConnectionApp
{
    public static void main(String[] args)
    {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DBConnection.class);
    }
}
