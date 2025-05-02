# LearnToCode_Capstones
In this app I created a Financial Tracking Application that is capable of the following tasks:

1. Adding deposits, tracking debit payments, go to Ledger menu, and exit app
 
![Screenshot 2025-05-01 213025](https://github.com/user-attachments/assets/97e1998a-e452-45f9-8757-3e6ccd0f4d02)


2. Display all Transactions, Display only deposits, display only payments, go to reports menu, or go home

![Screenshot 2025-05-01 213201](https://github.com/user-attachments/assets/15116112-4fd5-4ec0-9442-44e2f596a604)

3. Pull MTD report, previous MTD report, YTD report, prev YTD report, search by Vendor, or go back to the Ledger Menu
 
 ![Screenshot 2025-05-01 213238](https://github.com/user-attachments/assets/36b743f2-0357-45e9-8808-f7a432c9648c)


 A piece of code that I am proud of is how I handled taking the user input for both Deposits and Payments and subsequently wrote it to the transactions.csv file :

  ![Screenshot 2025-05-01 230948](https://github.com/user-attachments/assets/4b5c4605-562f-4612-b73e-abfb4df41ae5)

  ![Screenshot 2025-05-01 231014](https://github.com/user-attachments/assets/e5b2fe67-dd15-42cb-a941-f835cc1b30ef)

Using what is shown above I was able to append(add on to the end of) to transactions.csv with the new user input.

By calling to the toString method I am able to take the user input that is reveiced and get it into the format seen in transactions.csv.

By doing it this way, when the input is done being entered the bufferedWriter closes automatically. even if an exception happens.

From there you are free to follow any other path available.



   
