package com.example.springwebshop.item;

import com.example.springwebshop.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
//Setting the api path
@RequestMapping(path = "items")
public class ItemController {

    private final ItemService itemService;
    //I want to keep order related stuff in the order service
    private final OrderService orderService;

    @Autowired
    public ItemController(
            ItemService itemService,
            OrderService orderService){
        this.itemService = itemService;
        this.orderService = orderService;
    }

    //Using default class path to get all items
    @GetMapping
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }

    //Requests an item id after the default path to determine what exact item you're looking for
    @GetMapping(path = "{itemId}")
    public Item getItem(@PathVariable("itemId") Long itemId){
        return itemService.getItem(itemId);
    }

    /* Body looks like this
    {
        "name": "name",
        "price": "price"
    } */
    @PostMapping
    public void createNewItem(@RequestBody Item item){
        itemService.addNewItem(item);
    }


    /* Body looks like
    {
        "customerId": 1,
        "itemId": 1
    } */
    //I'm just using the orderservice to create a new order, this because I prefer to keep order stuff in order
    @PostMapping(path = "buy")
    //The first long is customerId, the second long is item id
    public void buy(@RequestBody Map<String, Long> json){
        orderService.addNewOrder(json);
    }

}
