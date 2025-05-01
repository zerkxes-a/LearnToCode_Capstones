package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//WHATS A TRANSACTION DEFINE WHAT IT IS
public class Transaction {


    private LocalDateTime now;
    private String description;
    private String vendor;
    private float price;


    //CONSTRUCTOR METHOD(USED TO CREATE INSTANCE OF OBJECT FROM INPUT IN MENU) AUTOMATICALLY SETS VALUES
    public Transaction(String description, String vendor, float price){
        this.now = LocalDateTime.now();
        this.description = description;
        this.vendor = vendor;
        this.price = price;
    }
    public Transaction(LocalDateTime dateTime, String description, String vendor, float price){
        this.now = dateTime;
        this.description = description;
        this.vendor = vendor;
        this.price = price;
    }
    public LocalDateTime getNow() {
        return now;
    }

    public float getPrice() {
        return price;
    }

    public String getVendor() {
        return vendor;
    }

    public String getDescription() {
        return description;
    }



    @Override
    //GETS ALL THE VALUES AND MAKES IT INTO A STRING
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd | HH:mm:ss | ");
        return String.format("%s%s | %s | %.2f\n", now.format(formatter), description, vendor, price);
    }
}
