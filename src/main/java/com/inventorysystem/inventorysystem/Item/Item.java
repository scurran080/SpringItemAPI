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
    private Double msrp;
    private Double salePrice;
    private Double salePerc;
    private Integer packageSize;
    private String manufacturer;
    private String distrubuter;

    // Default constructor required.
    public Item() {
    }

    public Item(String upc, String name, String description, Double weight, Double msrp, Double salePerc,
            Integer packageSize, String manufacturer,
            String distributer) {
        this.upc = upc;
        this.name = name;
        this.description = description;
        this.msrp = msrp;
        this.salePerc = salePerc;
        this.setSalePrice(this.msrp);
        this.weight = weight;
        this.packageSize = packageSize;
        this.manufacturer = manufacturer;
        this.distrubuter = distributer;
    }

    public long getID() {
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

    public void setMSRP(Double msrp) {
        this.msrp = msrp;
    }

    public Double getSalePrice() {
        return this.salePrice;
    }

    public void setSalePrice(Double msrp) {
        if (!(msrp.doubleValue() > 0) && !(this.salePerc.doubleValue() > 0)) {
            this.calculateDiscount();
        } else {
            this.salePrice = this.msrp;
        }
    }

    public Double getSalePerc() {
        return this.salePerc;
    }

    public void setSalePerc(Double salePerc) {
        this.salePerc = salePerc;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getMSRP() {
        return this.msrp;
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

    public void calculateDiscount() {
        if (!(this.salePerc.doubleValue() > 0.00)) {
            setSalePrice(this.msrp);
        } else {
            this.setSalePrice(Double.valueOf(this.msrp - (this.msrp * (this.salePerc / 100))));
        }
    }

    public void resetPrice() {
        this.salePrice = this.msrp;
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