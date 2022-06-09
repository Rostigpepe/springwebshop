package com.example.thymeleafdemo.controller;

import com.example.thymeleafdemo.service.FrontendItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class FrontendItemController {

    private final FrontendItemService frontendItemService;

    @Autowired
    public FrontendItemController(FrontendItemService frontendItemService){
        this.frontendItemService = frontendItemService;
    }


    //Method to get
    @GetMapping
    public String getItems(Model model){
        //Adds list of all items from item service into the model
        model.addAttribute(
                "items",
                frontendItemService.getAllItems());

        return "items";
    }
}
