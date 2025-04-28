package com.pluralsight;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        run();
    }

    //MAIN MENU START
    public static void run() {
        System.out.println("Welcome to your Personal Banking App! \n");

        //CREATE WHILE LOOP FOR HOMESCREEN MENU SELECTION
        while (true) {

            System.out.println("Please choose from the following options \n");

            System.out.println("What would you like to do?");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make a Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println(("X) Exit \n"));

            System.out.print("Please enter your letter selection here:  ");

            switch (scanChar()) {
                case 1: //GO TO FISRT PAGE (ADD DEPOSIT)
                    System.out.println("Continue to Deposit info (Please press Enter):  ");
                    scanner.nextLine();
                    //todo prompt user for deposit info to go to csv file
                    break;
                case 2: //GO TO THE SECOND PAGE (MAKE A PAYMENT)
                    System.out.println("Continue to Payment (Please press Enter):  ");
                    scanner.nextLine();
                    //todo prompt user for debit info and save to csv file
                    break;
                case 3: //CREATE LEDGER MENU TO CALL TO
                    System.out.println("Continue to Ledger Menu (Please press Enter):  ");
                    scanner.nextLine();
                    // TODO displayLedger();  CREATE LEDGER MENU BELOW
                case 4: //EXIT OUT OF APP
                    System.exit(0);
                default: //WHOOPSIE WAS DONE, REDO
                    System.out.println("Invalid option selected, please try again \n");
            }


        }
    }


    // CONVIENCE METHODS GO HERE
    private static char scanChar() {
        while (!scanner.hasNextChar()) {
            scanner.nextLine();
            System.out.println("Please ONLY enter a single Letter");
            System.out.print("Enter Letter here: ");
        }
        char choice = scanner.nextChar();
        scanner.nextLine();
        return choice;
    }
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
