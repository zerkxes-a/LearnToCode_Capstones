package com.pluralsight;

import java.time.LocalDateTime;

public class Deposit {
    private String description;
    private String vendor;
    private float price;
    public Deposit(String description, String vendor, float price){
        this.description = description;
        this.vendor = vendor;
        this.price = price;
    }
    public Deposit() {
        this.description = "";
        this.vendor = "";
        this.price = 0.0f;
    }

    public String getDescription() {
        return description;
    }

    public String getVendor() {
        return vendor;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", description, vendor,price);
    }
}
