package com.inventorysystem.inventorysystem.Location;

import java.util.HashMap;
import java.util.Map;

import com.inventorysystem.inventorysystem.Item.Item;

public class Location{

    private String name;
    private Map<Item, Integer> items;
 
    public Location(String name){
        this.name = name;
        items = new HashMap<>();
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void addItem(Item newItem, Integer amount){
        items.put(newItem, amount);
    }

    public void removeItemByUPC(String UPC){
        for(Item key : items.keySet()){
            if(key.getUPC().equalsIgnoreCase(UPC)){
                items.remove(key);
                return;
            }
        }
    }

    public void clearItems(){
        items.clear();
    }

}