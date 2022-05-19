package com.example.springwebshop.item;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ItemConfig {

    //Using a bean commandlinerunner since spring automatically runs these after context load
    @Bean
    CommandLineRunner itemCreation(ItemRepository repo){

        return args -> {
            List<Item> itemList = new ArrayList<>();
            
            Item chair = new Item(
                    "Chair",
                    500
            );
            itemList.add(chair);

            Item fancyChair = new Item(
                    "Fancy Chair",
                    5000
            );
            itemList.add(fancyChair);

            Item mug = new Item(
                    "Mug",
                    50
            );
            itemList.add(mug);

            Item fantasticMug = new Item(
                    "Fantastic Mug",
                    500
            );
            itemList.add(fantasticMug);
            
            repo.saveAll(itemList);
        };
    }
}
