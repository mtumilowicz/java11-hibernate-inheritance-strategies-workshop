package com.example.workshop;

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
    public ApplicationRunner demoData(MyEmployeeRepository repo) {
        return args -> {
            var p1 = new MyEmployee();
            p1.setPersonId(1);
            p1.setName("name1");
            p1.setCompany("company1");
            repo.save(p1);
        };
    }

}
