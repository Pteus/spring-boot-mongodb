package com.pteus.springbootmongodb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class SpringBootMongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongodbApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentRepository studentRepository) {
        return args -> {
            Address address = new Address("Portugal", "Lisboa", "0000");

            Student student = new Student(
                    "Foo",
                    "Bar",
                    "foo@bar.com",
                    Gender.MALE,
                    address,
                    List.of("Computer Science","Maths"),
                    BigDecimal.TEN,
                    LocalDateTime.now()
            );

            studentRepository.insert(student);
        };


    }

}
