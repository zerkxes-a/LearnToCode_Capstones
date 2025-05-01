package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

//ARRAY LIST
public class ListParse {

    public static ArrayList<Transaction> loadTransactions() {
        try {
            FileReader fileReader = new FileReader("src/main/resources/transactions.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList<Transaction> listParse = new ArrayList<>();
            String input;
            //ignores first line from transactions.csv
            while ((input = bufferedReader.readLine()) != null) {
                if (input.startsWith("date")) {
                    continue;//dont need this rn, keep for later maybe
                }
                //READS FROM TRANSACTIONS.CSV TO SORT IN DIFFERENT WAYS

                String[] items = input.split(" \\| ");
                LocalDateTime dateTime = LocalDateTime.parse(items[0] + " | " + items[1], DateTimeFormatter.ofPattern("yyyy-MM-dd | HH:mm:ss"));
                String description = items[2];
                String vendor = items[3];
                float price = Float.parseFloat(items[4]);
                listParse.add(new Transaction(dateTime, description, vendor, price));
            }
            listParse.sort(Comparator.comparing(Transaction::getNow).reversed());

            return listParse;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //todo HOW TO GET TO SORT BY DATE, ASK HELP RESEARCH. WANT SORT BY DATE BEFORE DO OTHER THINGS
        //TODO NEED ONEBEFORE CLOSE OUT SO THAT EVERYTHING IS PRINTED FROM NEWEST TO OLDEST
    }
}
    //return sort


