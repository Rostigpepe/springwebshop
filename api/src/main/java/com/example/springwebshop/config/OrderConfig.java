package com.example.springwebshop.config;

import com.example.springwebshop.model.Orders;
import com.example.springwebshop.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class OrderConfig {


    //Using a bean commandlinerunner since spring automatically runs these after context load
    @Bean
    CommandLineRunner orderCreations(OrderRepository repo){

        return args -> {
            List<Orders> ordersList = new ArrayList<>();

            Orders orders1 = new Orders(
                    1L,
                    2L,
                    LocalDate.of(2021, Month.JANUARY, 1)
            );
            ordersList.add(orders1);

            Orders orders2 = new Orders(
                    2L,
                    1L,
                    LocalDate.of(2021, Month.AUGUST, 16)
            );
            ordersList.add(orders2);

            Orders orders3 = new Orders(
                    3L,
                    4L,
                    LocalDate.of(2021, Month.FEBRUARY, 23)
            );
            ordersList.add(orders3);

            Orders orders4 = new Orders(
                    4L,
                    3L,
                    LocalDate.of(2021, Month.MAY, 30)
            );
            ordersList.add(orders4);

            Orders orders5 = new Orders(
                    4L,
                    1L,
                    LocalDate.of(2021, Month.DECEMBER, 21)
            );
            ordersList.add(orders5);

            Orders orders6 = new Orders(
                    3L,
                    2L,
                    LocalDate.of(2021, Month.OCTOBER, 11)
            );
            ordersList.add(orders6);

            Orders orders7 = new Orders(
                    2L,
                    3L,
                    LocalDate.of(2021, Month.JULY, 8)
            );
            ordersList.add(orders7);

            Orders orders8 = new Orders(
                    1L,
                    4L,
                    LocalDate.of(2021, Month.JUNE, 17)
            );
            ordersList.add(orders8);

            repo.saveAll(ordersList);
        };
    }

}
