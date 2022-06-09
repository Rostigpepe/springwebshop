package com.example.thymeleafdemo.controller;

import com.example.thymeleafdemo.service.FrontendCustomerService;
import com.example.thymeleafdemo.service.FrontendItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class FrontendCustomerController {

    private final FrontendCustomerService frontendCustomerService;

    @Autowired
    public FrontendCustomerController(FrontendCustomerService frontendCustomerService){
        this.frontendCustomerService = frontendCustomerService;
    }


    //Method to get
    @GetMapping
    public String getCustomers(Model model){
        //Adds list of all items from item service into the model
        model.addAttribute(
                "customers",
                frontendCustomerService.getAllCustomers());

        return "customers";
    }
}