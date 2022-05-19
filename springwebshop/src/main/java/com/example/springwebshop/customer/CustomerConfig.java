package com.example.springwebshop.customer;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class CustomerConfig {

    //Using a bean commandlinerunner since spring automatically runs these after context load
    @Bean
    CommandLineRunner customerCreation(CustomerRepository repo){

        return args -> {
            List<Customer> customerList = new ArrayList<>();

            Customer robin = new Customer(
                    "Robin",
                    "Robin@gmail.com",
                    LocalDate.of(2001, Month.JANUARY, 27)
            );
            customerList.add(robin);

            Customer erin = new Customer(
                    "Erin",
                    "Erin@gmail.com",
                    LocalDate.of(2003, Month.SEPTEMBER, 3)
            );
            customerList.add(erin);

            Customer david = new Customer(
                    "David",
                    "David@gmail.com",
                    LocalDate.of(1997, Month.MARCH, 11)
            );
            customerList.add(david);

            Customer jakob = new Customer(
                    "Jakob",
                    "Jakob@gmail.com",
                    LocalDate.of(2001, Month.AUGUST, 15)
            );
            customerList.add(jakob);

            repo.saveAll(customerList);
        };
    }
}
