package app;

import app.mappedsuperclass.Tag;
import app.mappedsuperclass.TagRepository;
import app.singletable.Circle;
import app.singletable.CircleRepository;
import app.singletable.Rectangle;
import app.singletable.RectangleRepository;
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
    public ApplicationRunner demoData(TagRepository tagRepository,
                                      RectangleRepository rectangleRepository,
                                      CircleRepository circleRepository) {
        return args -> {
            tagRepository.save(Tag.builder().name("tag1").build());

            Circle circle = new Circle();
            circle.setRadius(40);
            circleRepository.save(circle);

            Rectangle rectangle = new Rectangle();
            rectangle.setLength(10);
            rectangle.setWidth(30);
            rectangleRepository.save(rectangle);
        };
    }

}
