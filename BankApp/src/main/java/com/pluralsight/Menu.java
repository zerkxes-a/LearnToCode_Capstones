package com.pluralsight;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
        System.out.print("Please enter the type of Deposit: ");
        String description = scanner.nextLine();
        System.out.print("Please enter the Vendor Name: ");
        String vendor = scanner.nextLine();
        System.out.print("Please enter the Deposit Amount (only positive): ");
        float price = scanner.nextFloat();
        scanner.nextLine(); //CONSUME LINE CLRF
        //research what this is Anna!!!!
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/transactions.csv", true))) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd | HH:mm:ss | ");
            //WRITES DEPOSIT INFO TO TRANSACTIONS.CSV
           bufferedWriter.write(new Transaction(description, vendor, price).toString());//todo hate yourself for this
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
        System.out.print("Please enter the Payment Amount (only negative): ");
        float price = scanner.nextFloat();
        scanner.nextLine();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/transactions.csv", true))) {
            //WRITES PAYMENT INFO TO TRANSACTIONS.CSV FORMATS BY FORMATTER CAT PAYMENT INSTANCE
            bufferedWriter.write(new Transaction(description, vendor, price).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
// todo bright green
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
                displayAllEntries();
                break;
            case "D": //DISPLAY ONLY DEPOSITS
                System.out.println("Continue Deposit Display (Please press Enter):  ");
                scanner.nextLine();
                displayDeposits();
                break;
            case "P": //DISPLAY ONLY PAYMENTS
                System.out.println("Continue to Payment Display (Please press Enter): ");
                scanner.nextLine();
                displayPayments();
                break;
            case "R": //GOES TO DISPLAY REPORTS SELECTOR
                System.out.println("Continue to Reports Screen (Please press Enter): ");
                scanner.nextLine();
                displayReports();
            default: //WHOOPSIE WAS DONE, REDO
                System.out.println("Invalid option selected, please try again \n");
        }
    }

    //ALL LEDGER ENTRIES SCREEN - SORTS BY TIME NEW TO OLD
    public static void displayAllEntries() {
        System.out.println("Newest Entries Shown first");
        System.out.println("date | time | description | vendor | amount");
        //SORTS TRANSACTIONS BY NEWEST TO OLDEST. HOLDS SORT WITHIN TIMESORTTRANSACTION
        ArrayList<Transaction> sorted = ListParse.loadTransactions();
        for (Transaction timeSortTransaction : sorted) {
            System.out.println(timeSortTransaction);
        }
    }
    //DEPOSIT DISPLAY SCREEN checks if price is positive then only prints positive values
    public static void displayDeposits(){
        System.out.println("Newest Entries Shown First");
        System.out.println("date | time | description | vendor | amount");
        ArrayList<Transaction> sorted = ListParse.loadTransactions();
        for (Transaction timeSortTransaction : sorted) {
            //positive check here
            if (timeSortTransaction.getPrice() > 0){
                System.out.println(timeSortTransaction);
            }
        }
    }

    //PAYMENT DISPLAY SCREEN checks if price is negative then only prints negative values
    public static void displayPayments(){
        System.out.println("Newest Entries Shown First");
        System.out.println("date | time | description | vendor | amount");
        ArrayList<Transaction> sorted = ListParse.loadTransactions();
        for (Transaction timeSortTransaction : sorted) {
            //negative check here
            if (timeSortTransaction.getPrice() < 0){
                System.out.println(timeSortTransaction);
            }
        }
    }

    //REPORTS SCREEN
    public static void displayReports(){//todo maybe name better, naming too the same with above which does different thing
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

        switch(scanInt()){//todo we gonna need math for all of this anna.
            case 1: //DISPLAY MTD REPORT: DISPLAY TRANSACTIONS DURING MONTH, MONTH NET, AND TOTAL ACCOUNT BALANCE
                System.out.println("Continue to Month to Date Report (Please press Enter):  ");
                scanner.nextLine();
                mtdReport();
                break;
            case 2: //TODO PREVIOUS MONTH: PREVIOUS MONTH WHAT MTD? BALANCE AT END? PROBABLY
                break;
            case 3: //TODO YTD :math functions for all transactions with same year
                break;
            case 4: //TODO PREVIOUS YEAR SAME AS CASE 2 AAAAAAA
                break;
            case 5: //TODO VENDOR NAME SEARCH  need to compare user input and vendor name and see if the strings match
                break;
            case 0: //TODO RETURN TO PREVIOUS SCREEN (LEDGER??? GET CLAIRFACTION WITH INSTRUCTIONS)
                break;
            default:
                System.out.println("Invalid option selected, Please try again\n");
        }
      }
    }
    //MTDREPORT: do all addition and subtraction for transactions in current month
    public static void mtdReport(){
        float accountTotal = 0;
        float mtdTotal = 0;
        ArrayList<Transaction> sorted = ListParse.loadTransactions();
        for (Transaction timeSortTransaction : sorted) {
            if (timeSortTransaction.getNow().getMonth().equals(LocalDateTime.now().getMonth())){
                System.out.println(timeSortTransaction);
                mtdTotal += timeSortTransaction.getPrice();
            }
            accountTotal += timeSortTransaction.getPrice();

        }
        System.out.printf("Gross Monthly Transactions: $%.2f\n", mtdTotal);
        System.out.printf("Account Total: $%.2f\n", accountTotal);
    }


    // CONVIENCE METHODS GO HERE
    // convience method for reports choice screen chooses report
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
