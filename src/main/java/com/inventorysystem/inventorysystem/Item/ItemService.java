package com.inventorysystem.inventorysystem.Item;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService{

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public List<Item> getItems(){
        return itemRepository.findAll();
    }

    public void createNewItem(Item newItem){
        Optional<Item> found = itemRepository.findItemByUPC(newItem.getUPC());
        if(found.isPresent()){
            throw new IllegalStateException("Item already exists");
        }
        itemRepository.save(newItem);
    }

    public Optional<Item> getItemByUPC(String upc){
        Optional<Item> found = itemRepository.findItemByUPC(upc);
        return found;
    }

    public Optional<Item> getItemByID(long id){
        return itemRepository.findItemByID(id);
    }
}