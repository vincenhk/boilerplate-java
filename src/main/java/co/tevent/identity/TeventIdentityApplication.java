package co.tevent.identity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class TeventIdentityApplication {
    public static void main(String[] args) {
        SpringApplication.run(TeventIdentityApplication.class, args);
        System.out.println("Success Running Identity Service");
    }
}
