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
                    scanner.nextLine();
                    paymentInfo();
                    break;
                case "L": //CREATE LEDGER MENU TO CALL TO
                    System.out.println("Continue to Ledger Menu (Please press Enter): ");
                    scanner.nextLine();
                    displayLedger();
                case "X": //EXIT OUT OF APP
                    System.exit(0);
                default: //WHOOPSIE WAS DONE, REDO
                    System.out.println("Invalid option selected, please try again \n");
            }
        }
    }

    // TODO WHAT IS THIS WHY HEREprivate static void displayLedger() {
    //}

    //DEPOSIT SCREEN
    private static void depositInfo() {

        System.out.println("Please enter some info to record a Deposit: \n");
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
    private static void paymentInfo(){

        System.out.println("Please fill out some info to record a payment: \n");
        System.out.print("Please enter the Item Purchased: ");
        String description = scanner.nextLine();
        System.out.print("Please enter the Vendor Name: ");
        String vendor = scanner.nextLine();
        System.out.print("Please enter the Payment Amount: ");
        float price = scanner.nextFloat();
        scanner.nextLine();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/transactions.csv", true))) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd | HH:mm:ss | ");
            //WRITES PAYMENT INFO TO TRANSACTIONS.CSV
            bufferedWriter.write((now.format(formatter)) + new Payment(description, vendor, price));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //LEDGER SCREEN todo will need to call reader method to read from transactions.csv
    private static void displayLedger(){
        System.out.println("Welcome to the Leger Menu\n");
        System.out.println("Please choose from the following options: \n");
        System.out.println("A) All - display all transactions");
        System.out.println("D) Deposits");
        System.out.println("P) Payments");
        System.out.println("R) Reports");
        System.out.print("Please enter your letter selection here: ");
        String choice = scanner.nextLine().toUpperCase();

        switch (choice) {
            case "A": //DISPLAY ALL TRANSACTIONS
                System.out.println("Continue to full Ledger Display (Please press Enter):  ");
                scanner.nextLine();
                displayAllEntries(); //STILL DOES NOTHING IMPLEMTN THING
                //TODO SHOW ALL INFO FROM NEWEST TO OLDEST, RETURN FILE rEADER????
                break;
            case "D": //DISPLAY ONLY DEPOSITS
                System.out.println("Continue Deposit Display (Please press Enter):  ");
                scanner.nextLine();
                displayDeposits(); //DOES NOTHING RN
                break;
            case "P": //DISPLAY ONLY PAYMENTS
                System.out.println("Continue to Payment Display (Please press Enter): ");
                scanner.nextLine();
                displayPayments(); //DOES NOTHING RN
                //TODO CREATE LEDGER MENU BELOW
            case "R": //GOES TO DISPLAY REPORTS SELECTOR
                System.out.println("Continue to Reports Screen (Please press Enter): ");
                scanner.nextLine();
                displayReports();
            default: //WHOOPSIE WAS DONE, REDO
                System.out.println("Invalid option selected, please try again \n");
        }
    }
    //toDO ALL OF THESE JUST BUILDING OUT BONES TO FILL OUT  ALL MUST READ FROM BOTTOM TO TOP TO SHOW NEWEST FIRST???
    //ALL LEDGER ENTRIES SCREEN
    public static void displayAllEntries(){
        System.out.println("Newest Entries Shown first");
        System.out.println("date | time | description | vendor | amount");
        //TODO GET TO READ FROM BOTTOM TO TOP, BOTTOM HAS NEWEST ENTRIES
        }
    //DEPOSIT DISPLAY SCREEN
    public static void displayDeposits(){
        System.out.println("Newest Entries Shown First");
        System.out.println("date | time | description | vendor | amount");
        }
    //PAYMENT DISPLAY SCREEN
    public static void displayPayments(){
        System.out.println("Newest Entries Shown First");
        System.out.println("date | time | description | vendor | amount");
    }
    //REPORTS SCREEN
    public static void displayReports(){
    while (true) {
        System.out.println("Welcome to the Reports Screen");
        System.out.println("Please choose from the following Report Options\n");
        System.out.println("1) Month To Date");
        System.out.println("2) Previous Month");
        System.out.println("3) Year To Date");
        System.out.println("4) Previous Year");
        System.out.println("5) Search by Vendor");
        System.out.println("0) Back - Return to the Ledger Screen\n"); //TODO ASK TOPHER IF TYPO IN INSTURCTINOS
        System.out.print("Please enter your Number Selection Here:  /");

        switch(scanInt()){
            case 1: //TODO DISPLAY MTD REPORT
                break;
            case 2: //TODO PREVIOUS MONTH
                break;
            case 3: //TODO YTD
                break;
            case 4: //TODO PREVIOUS YEAR
                break;
            case 5: //TODO VENDOR NAME SEARCH
                break;
            case 0: //TODO RETURN TO PREVIOUS SCREEN (LEDGER??? GET CLAIRFACTION WITH INSTRUCTIONS)
                break;
            default:
                System.out.println("Invalid option selected, Please try again\n");
        }

        }

    }


    // CONVIENCE METHODS GO HERE
    //convience method for choosing lettered screen choices todo dont think im acutally using this. check for code redundencany
    private static String scanChar() {
        while (!scanner.hasNext()) {
            scanner.nextLine();
            System.out.println("Please ONLY enter a single Letter");
            System.out.print("Enter Single Letter here: ");
        }
        String choice = scanner.nextLine().trim().toUpperCase();
        scanner.nextLine();
        return choice;
    }
    //convience method for reports choice screen chooses report
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
