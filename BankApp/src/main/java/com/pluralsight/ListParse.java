package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//todo hoW TO GET ARRAY LIST TO
public class ListParse {
    private static ArrayList <Transaction> listParse = new ArrayList<>();

    //TODO PROBLEMS: HAVE DEPOSIT AND PAYMENT BOTH WRITING TO .CSV
    //TODO NEED TO PARSE BOTH TO READ
    public static void loadProducts(){
        try{
            FileReader fileReader = new FileReader("src/main/resources/transactions.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String input;
            //ignores first line from transactions.csv
            while((input = bufferedReader.readLine()) != null) {
                if (input.startsWith("date")) {
                    continue;//dont need this rn, keep for later maybe
                }
            }
            while((input = bufferedReader.readLine()) != null){

                String[] items = input.split("\\|");
                String date = items[0];
                String time = items[1];
                String description = items[2];
                String vendor = items[3];
                float price = Float.parseFloat(items[4]);
                listParse.add(new Transaction(date, time, description, vendor, price));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ;
    }
}

