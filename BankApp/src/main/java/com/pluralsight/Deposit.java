package com.pluralsight;


public class Deposit {
    private String description;
    private String vendor;
    private float price;
    //CONSTRUCTOR METHOD(USED TO CREATE INSTANCE OF OBJECT FROM INPUT IN MENU) AUTOMATICALLY SETS VALUES
    public Deposit(String description, String vendor, float price){
        this.description = description;
        this.vendor = vendor;
        this.price = price;
    }
    @Override
    //GETS ALL THE VALUES AND MAKES IT INTO A STRING
    public String toString() {
        return String.format("%s | %s | %.2f\n", description, vendor, price);
    }
}
