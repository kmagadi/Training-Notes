package com.accoliteLearning.LMS;

import com.accoliteLearning.LMS.model.Book;
import com.accoliteLearning.LMS.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LmsApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BookRepository repository) {
        return (args) -> {
            // This runs as soon as the app starts
            repository.save(new Book(null, "The Java Pro", "Education", "Karthik Magadi"));
            repository.save(new Book(null, "Spring Boot in Action", "Tech", "Craig Walls"));
            System.out.println("Demo data initialized in H2 database!");
        };
    }
}