package com.example.springwebshop.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Setting the api path
@RequestMapping(path = "orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping
    public List<Orders> getAllOrder(){
        return orderService.getAllOrders();
    }


    //Wanted to check specific orders, since "orders/:id" is reserved for customer orders, this is the path instead
    @GetMapping(path = "/order/{orderId}")
    public Orders getOrder(@PathVariable("orderId") Long orderId){
        return orderService.getOrder(orderId);
    }

    @GetMapping(path = "{customerId}")
    public List<Orders> getCustomerOrders(@PathVariable("customerId") Long customerId){
        return orderService.getAllCustomerOrders(customerId);
    }
}
