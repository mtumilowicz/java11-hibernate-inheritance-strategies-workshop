package app;

import app.mappedsuperclass.Tag;
import app.mappedsuperclass.TagRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Java11HibernateInheritanceStrategiesWorkshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(Java11HibernateInheritanceStrategiesWorkshopApplication.class, args);
    }

    @Bean
    public ApplicationRunner demoData(TagRepository repo) {
        return args -> {
                    repo.save(Tag.builder().name("tag1").build());
        };
    }

}
