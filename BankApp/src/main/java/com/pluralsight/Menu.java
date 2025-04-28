package com.pluralsight;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        chooseScreen();
    }

    //MAIN MENU START
    public static void chooseScreen() {
        System.out.println("Welcome to your Personal Banking App! \n");

        //CREATE WHILE LOOP FOR HOMESCREEN MENU SELECTION
        while (true) {

            System.out.println("Please choose from the following options \n");

            System.out.println("What would you like to do?");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make a Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit \n");

            System.out.print("Please enter your letter selection here:  ");

            String choice = scanner.nextLine().toUpperCase();
            switch (choice) {
                case "D": //GO TO FIRST PAGE (ADD DEPOSIT)
                    System.out.println("Continue to Deposit info (Please press Enter):  ");
                    scanner.nextLine();
                    depositInfo();
                    break;
                case "P": //GO TO THE SECOND PAGE (MAKE A PAYMENT)
                    System.out.println("Continue to Payment (Please press Enter):  ");
                    scanner.next();
                    //todo prompt user for debit info and save to csv file
                    break;
                case "L": //CREATE LEDGER MENU TO CALL TO
                    System.out.println("Continue to Ledger Menu (Please press Enter): ");
                    scanner.nextLine();
                    // TODO displayLedger();  CREATE LEDGER MENU BELOW
                case "X": //EXIT OUT OF APP
                    System.exit(0);
                default: //WHOOPSIE WAS DONE, REDO
                    System.out.println("Invalid option selected, please try again \n");
            }
        }
    }
    //DEPOSIT SCREEN
    private static void depositInfo() {

        System.out.print("Please enter the Transaction Description: ");
        String description = scanner.nextLine();
        System.out.print("Please enter the Vendor Name: ");
        String vendor = scanner.nextLine();
        System.out.print("Please enter the Deposit Amount: ");
        float price = scanner.nextFloat();
        scanner.nextLine(); //CONSUME LINE CLRF
        //research what this is Anna!!!!
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/transactions.csv", true))) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd | HH:mm:ss | ");
            //WRITES DEPOSIT INFO TO TRANSACTIONS.CSV
           bufferedWriter.write((now.format(formatter)) + new Deposit(description, vendor, price));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //PAYMENT SCREEN
    //todo ALL OF IT DO IT ALL PLACEHOLDER FOR LATER!!!
    private static void paymentInfo(){

    }
    //LEDGER SCREEN
    private static void ledgerMenu(){
        System.out.println("Welcome to the Leger Menu\n");
        System.out.println("Please choose from the following options: \n");
        System.out.println("A) All - display all transactions");
        System.out.println("D) Deposits");
        System.out.println("P) Payments");
        System.out.println("R) Reports");
        System.out.print("Please enter your selection here: ");

    }
    // CONVIENCE METHODS GO HERE
    //convience method for choosing lettered screen choices
    private static String scanChar () { //todo FUCKING DO BETTER MAKE STRING tHAT ONLY READS FIRST LETTER
        while (!scanner.hasNext()) {
            scanner.nextLine();
            System.out.println("Please ONLY enter a single Letter");
            System.out.print("Enter Single Letter here: ");
        }
        String choice = scanner.nextLine().trim().toUpperCase();
        scanner.nextLine();
        return choice;
    }
    //convience method for reports choice screen
    private static int scanInt(){
        while(!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Please ONLY enter an Interger");
            System.out.print("Enter number here: ");
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
}
