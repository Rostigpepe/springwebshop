package com.example.springwebshop.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository){

        this.itemRepository = itemRepository;
    }

    //Gets all items in our repository
    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    //Gets a specific item
    public Item getItem(Long itemId) {

        //Uses optional to check whether the item exists, if exists returns, else throws
        return itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalStateException(
                        "Item with id " + itemId + " does not exist"));
    }

    //Adds a new item
    public void addNewItem(Item item) {
        Optional<Item> itemOptional = itemRepository
                .findItemByName(item.getName());

        //I just want to make sure we don't get several items with the same name, since item is very basic
        if(itemOptional.isPresent()){
            throw new IllegalStateException("This item already exists");
        }

        //Once again if nothing goes wrong, the item will simply be added to the repo
        itemRepository.save(item);

    }

}
