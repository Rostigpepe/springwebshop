package com.example.thymeleafdemo.service;

import com.example.thymeleafdemo.model.Customer;
import com.example.thymeleafdemo.model.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.example.thymeleafdemo.Utility.ApiURL;

@Service
public class FrontendCustomerService {

    private final RestTemplate restTemplate = new RestTemplate();

    //Method to get all the items from the api
    public List<Customer> getAllCustomers(){

        //Creating a response entity from the APIs JSON
        ResponseEntity<Customer[]> response =
                restTemplate.getForEntity(
                        ApiURL + "/customers",
                        Customer[].class);

        //Converting into an array
        Customer[] customers = response.getBody();

        //In case that there was nothing in the api, then we'll return nothing
        if(customers == null){
            return Collections.emptyList();
        }

        //Finally, if the array isn't empty, stream it into a list and return that bad boy
        return Arrays.stream(customers).toList();
    }

}
