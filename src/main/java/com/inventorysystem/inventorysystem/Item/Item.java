package com.inventorysystem.inventorysystem.Item;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Item {

    // @Id
    // @GeneratedValue(generator = "system-uuid")
    // @GenericGenerator(name = "system-uuid", strategy = "uuid")

    @Id
    @SequenceGenerator(name = "item_sequence", sequenceName = "item_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_sequence")
    private long id;
    // new method.
    private String upc;
    private String name;
    private String description;
    private Double weight;
    private Integer packageSize;
    private String manufacturer;
    private String distrubuter;

    // Default constructor required.
    public Item() {
    }

    public Item(String upc, String name, String description, Double weight, Integer packageSize, String manufacturer,
            String distributer) {
        this.upc = upc;
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.packageSize = packageSize;
        this.manufacturer = manufacturer;
        this.distrubuter = distributer;
    }

    public long getID(){
        return this.id;
    }

    public String getUPC() {
        return this.upc;
    }

    public void setUPC(String upc) {
        this.upc = upc;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getWeight() {
        return this.weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getPackageSize() {
        return this.packageSize;
    }

    public void setPackageSize(Integer packageSize) {
        this.packageSize = packageSize;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDistributer() {
        return this.distrubuter;
    }

    public void setDistributer(String distributer) {
        this.distrubuter = distributer;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final Item comp = (Item) obj;
        if (this.upc == comp.upc) {
            return true;
        } else {
            return false;
        }
    }
}