package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//WHATS A TRANSACTION DEFINE WHAT IT IS
public class Transaction {


    private LocalDateTime now;
    private String description;
    private String vendor;
    private float price;


    //CONSTRUCTOR METHOD(USED TO CREATE INSTANCE OF OBJECT FROM INPUT IN MENU) RECORDS TIME AT ITEM CREATION
    public Transaction(String description, String vendor, float price){
        this.now = LocalDateTime.now();
        this.description = description;
        this.vendor = vendor;
        this.price = price;
    }
    //MAKES THIS.NOW INTO A FORM I CAN USE, CALLS WITH DATETIME
    public Transaction(LocalDateTime dateTime, String description, String vendor, float price){
        this.now = dateTime;
        this.description = description;
        this.vendor = vendor;
        this.price = price;
    }
    // GET METHOD TO USE WHEN SORTING INFO IN DIFFERENT WAYS
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
    //GETS ALL THE DATETIME VALUES AND MAKES IT INTO A STRING
    public String toString() {
        //FORMATS TIME SNAPSHOT INTO SPECIFIED PATTERN
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd | HH:mm:ss | ");
        //FORMATS STRING TO WRITE INTO TRANSACTIONS.CSV USING THE TIME FORMATTER AND USER ENTERED INFORMATION
        return String.format("%s%s | %s | %.2f\n", now.format(dateTimeFormatter), description, vendor, price);
    }
}
