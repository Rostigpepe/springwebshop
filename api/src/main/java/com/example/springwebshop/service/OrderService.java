package com.example.springwebshop.service;

import com.example.springwebshop.repository.CustomerRepository;
import com.example.springwebshop.repository.ItemRepository;
import com.example.springwebshop.repository.OrderRepository;
import com.example.springwebshop.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    //We need the other repos to check that the item and customer exists when creating a new order
    private final ItemRepository itemRepository;
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(
            ItemRepository itemRepository,
            CustomerRepository customerRepository,
            OrderRepository orderRepository){

        this.itemRepository = itemRepository;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public Orders getOrder(Long orderId) {
        //If it exists, returns it, otherwise throws exception
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalStateException(
                        "Order with id " + orderId + " does not exist"));
    }

    public List<Orders> getAllCustomerOrders(Long customerId) {
        return orderRepository.findAllByCustomerId(customerId)
                .orElseThrow(() -> new IllegalStateException(
                        "Customer with id " + customerId + " either doesnt exist or does not have any orders"));
    }

    //Method to add a new order, trying to minimize imports
    public void addNewOrder(Map<String, Long> json) {
        if(!json.containsKey("customerId") || !json.containsKey("itemId")){
            throw new IllegalStateException("Incorrect body");
        }

        Long customerId = json.get("customerId");
        Long itemId = json.get("itemId");

        //Checks if customer and item exists, if they don't, the program throws a fit
        if(!customerRepository.existsById(customerId)){
            throw new IllegalStateException("This customer does not exist");
        }
        if(!itemRepository.existsById(itemId)){
            throw new IllegalStateException("This item does not exist");
        }

        orderRepository.save(new Orders(customerId, itemId));
    }
}
