package com.example.springwebshop.service;

import com.example.springwebshop.model.Customer;
import com.example.springwebshop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    //Gets a specific customer based on their id
    public Customer getCustomer(Long customerId){

        //Optional if exists statement, throws if the customer does not exist
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalStateException(
                        "Customer with id " + customerId + " does not exist"));
    }

    //Adds a new customer
    public void addNewCustomer(Customer customer) {
        //If the passed email already exists an optional customer is going to be present
        Optional<Customer> customerOptional = customerRepository
                .findCustomerByEmail(customer.getEmail());

        //If the customer IS present, we'll just send back an error message
        if(customerOptional.isPresent()){
            throw new IllegalStateException("Email taken");
        }

        //If nothing went wrong, the customer is saved
        customerRepository.save(customer);
    }
}
