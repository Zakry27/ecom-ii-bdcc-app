package net.charjaoui.customerservice;

import net.charjaoui.customerservice.entities.Customer;
import net.charjaoui.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository CustomerRepository) {
        return args -> {
            CustomerRepository.save(Customer.builder()
                            .name("Mohamed").email("mohamed@gmail.com")
                    .build());
            CustomerRepository.save(Customer.builder()
                    .name("Imane").email("imane@gmail.com")
                    .build());
            CustomerRepository.save(Customer.builder()
                    .name("Yassine").email("yassine@gmail.com")
                    .build());
            CustomerRepository.findAll().forEach(c -> {
                System.out.println("====================");
                System.out.println(c.getId());
                System.out.println(c.getName());
                System.out.println(c.getEmail());
            });
        };
    }
}
