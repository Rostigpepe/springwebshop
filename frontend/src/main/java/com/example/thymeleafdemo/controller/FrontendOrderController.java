package com.example.thymeleafdemo.controller;

import com.example.thymeleafdemo.service.FrontendItemService;
import com.example.thymeleafdemo.service.FrontendOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class FrontendOrderController {

    private final FrontendOrderService frontendOrderService;

    @Autowired
    public FrontendOrderController(FrontendOrderService frontendOrderService){
        this.frontendOrderService = frontendOrderService;
    }


    //Method to get
    @GetMapping
    public String getOrders(Model model){
        //Adds list of all items from item service into the model
        model.addAttribute(
                "orders",
                frontendOrderService.getAllOrders());

        return "orders";
    }
}
