package demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// README: https://spring.io/guides/gs/messaging-stomp-websocket

// https://github.com/spring-guides/gs-messaging-stomp-websocket/tree/main/complete/src/main/java/com/example/messagingstompwebsocket

// TODO: To test open ./WebSockets/src/main/resources/static/index.html

@SpringBootApplication
public class ServerMain {
    public static void main(String[] args) {
        SpringApplication.run(ServerMain.class, args);
    }
}