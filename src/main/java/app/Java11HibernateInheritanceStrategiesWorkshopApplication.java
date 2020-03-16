package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Java11HibernateInheritanceStrategiesWorkshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(Java11HibernateInheritanceStrategiesWorkshopApplication.class, args);
    }

//    @Bean
//    public ApplicationRunner demoData(TagRepository tagRepository,
//                                      RectangleRepository rectangleRepository,
//                                      CircleRepository circleRepository,
//                                      PetRepository petRepository,
//                                      WildRepository wildRepository,
//                                      EmployeeRepository employeeRepository,
//                                      EmployerRepository employerRepository) {
//        return args -> {
//            tagRepository.save(Tag.builder().name("tag1").build());
//
//            Circle circle = new Circle();
//            circle.setRadius(40);
//            circleRepository.save(circle);
//
//            Rectangle rectangle = new Rectangle();
//            rectangle.setLength(10);
//            rectangle.setWidth(30);
//            rectangleRepository.save(rectangle);
//
//            Pet pet = new Pet();
//            pet.setName("pet");
//            petRepository.save(pet);
//
//            Wild wild = new Wild();
//            wild.setEndangered(true);
//            wildRepository.save(wild);
//
//            Employee employee = new Employee();
//            employee.setSalary(1000);
//            employeeRepository.save(employee);
//
//            Employer employer = new Employer();
//            employer.setBudget(1_000_000);
//            employerRepository.save(employer);
//        };
//    }

}
