package com.example.springwebshop.controller;

import com.example.springwebshop.model.Customer;
import com.example.springwebshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Setting the api path
@RequestMapping(path = "customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    //Default path to get all customers
    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

     //Requests a specific customer with path extension
     @GetMapping(path = "{customerId}")
     public Customer getCustomer(@PathVariable("customerId") Long customerId){
         return customerService.getCustomer(customerId);
     }


     /* Body looks like this
     {
        "name": "name",
        "email": "email",
        "birthday": "yyyy-mm-dd"
    }
    */
    @PostMapping
    public void registerNewCustomer(@RequestBody Customer customer){
        customerService.addNewCustomer(customer);
    }


}
