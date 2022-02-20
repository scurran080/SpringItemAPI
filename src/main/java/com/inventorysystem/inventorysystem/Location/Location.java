package com.inventorysystem.inventorysystem.Location;

import java.util.HashMap;
import java.util.Map;


//@Entity
//@Table
public class Location {

    // @Id
    private long id;
    private String name;
    private Map<String, Integer> items; // Map consists of the UPC for each Item (String) and the quantity (Integer) of
                                        // each item in that location

    public Location(String name) {
        this.name = name;
        items = new HashMap<>();
    }

    public long getID() {
        return this.id;
    }

    public void setID(long newID) {
        this.id = newID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addItem(String newItem, Integer amount) {
        items.put(newItem, amount);
    }

    public void removeItemByUPC(String UPC) {
        for (String key : items.keySet()) {
            if (key.equalsIgnoreCase(UPC)) {
                items.remove(key);
                return;
            }
        }
    }

    public void clearItems() {
        items.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass() != this.getClass()) {
            return false;
        }
        Location loc = (Location) o;
        if (loc.getID() == this.getID()) {
            return true;
        }
        return false;
    }

}