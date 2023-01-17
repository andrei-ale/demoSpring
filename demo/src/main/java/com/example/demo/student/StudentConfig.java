package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@Configuration
public class StudentConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*");
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
                    Student andrei = new Student(
                            1L,
                            "Andrei",
                            "andrei123@gmail.com",
                            LocalDate.of(2000, Month.JANUARY, 5)
                    );

                    Student alex = new Student(
                            "Alex",
                            "alex.ionescu@gmail.com",
                            LocalDate.of(2004, Month.FEBRUARY, 27)
                    );

                    repository.saveAll(
                            List.of(andrei, alex)
                    );
        };
    }
}
