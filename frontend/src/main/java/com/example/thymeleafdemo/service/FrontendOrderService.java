package com.example.thymeleafdemo.service;

import com.example.thymeleafdemo.model.Item;
import com.example.thymeleafdemo.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.example.thymeleafdemo.Utility.ApiURL;

@Service
public class FrontendOrderService {

    private final RestTemplate restTemplate = new RestTemplate();

    //Method to get all the items from the api
    public List<Order> getAllOrders(){

        //Creating a response entity from the APIs JSON
        ResponseEntity<Order[]> response =
                restTemplate.getForEntity(
                        ApiURL + "/orders",
                        Order[].class);

        //Converting into an array
        Order[] orders = response.getBody();

        //In case that there was nothing in the api, then we'll return nothing
        if(orders == null){
            return Collections.emptyList();
        }

        //Finally, if the array isn't empty, stream it into a list and return that bad boy
        return  Arrays.stream(orders).toList();
    }
}
