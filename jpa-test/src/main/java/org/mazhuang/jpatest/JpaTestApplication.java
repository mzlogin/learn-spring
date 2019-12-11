package org.mazhuang.jpatest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class JpaTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaTestApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Kim", "Bauer"));

            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            repository.findAll().forEach(customer -> {
                log.info(customer.toString());
            });
            log.info("");

            Customer customer = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("---------------------------------");
            log.info(customer.toString());
            log.info("");

            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer ->{
                log.info(bauer.toString());
            });
            log.info("");

            log.info("Customer found with findByFirstName('Jack'):");
            log.info("--------------------------------------------");
            repository.findByFirstName("Jack").forEach(jack ->{
                log.info(jack.toString());
            });
            log.info("");
        };
    }
}
