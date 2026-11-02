/*
 * Name: Lacey Roof
 * Date: Nov 1, 2026
 * Assignment: SDC330L 
 * Week 1: Demonstrate inheritance & composition using multiple contact types.
 * Week 2: Implement interfaces & polymorphism to manage multiple contact types.
 * Week 3: Demonstrate abstraction, constructors & access specifiers.
 * Week 4: Implement SQLite database interactions and CRUD operations.
 * Purpose: Main application for the FieldLedger Contact Manager.
 */

import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        //Application header and welcome message
        System.out.println("\nLacey Roof - SDC330L Week 4 Project");
        System.out.println("FIELDLEDGER CONTACT MANAGER");
        System.out.println("----------------------------------------");
        System.out.println("Welcome to FieldLedger!");
        System.out.println("This application manages customer, vendor, and employee contacts.");
        System.out.println("Below are the contacts currently stored in the application.");

        //Create ContactManager, which implements ContactOperations
        ContactManager manager = new ContactManager();

        //Week 4: Initialize SQLite database and create contacts table
        DatabaseManager.createTable();

        
        //Create Scanner to accept user input
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        //Display menu until user chooses to exit
        while (choice != 6) {
            System.out.println("\n--- CONTACT MANAGER MENU ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Search Contacts");
            System.out.println("4. Update Contact");
            System.out.println("5. Remove Contact");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            //Read menu selection
            try {choice = Integer.parseInt(scanner.nextLine());} 
            catch (NumberFormatException e) {System.out.println("Please enter a number from 1 to 6.");
                continue;}

            //Perform selected contact operation
            switch (choice) {
                case 1: System.out.println("Add Contact - Coming next");
                    break;
                case 2: manager.viewContacts();
                    break;
                case 3: System.out.print("Enter first letter of last name: ");
                    String letter = scanner.nextLine();
                    manager.searchContacts(letter);
                    break;
                case 4:
                    System.out.print("Enter Contact ID: ");
                    try {
                        int updateId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter new phone number: ");
                        String phone = scanner.nextLine();
                        manager.updateContact(updateId, phone);} 
                        catch (NumberFormatException e) {
                        System.out.println("Invalid Contact ID.");}
                    break;
                case 5:
                    System.out.print("Enter Contact ID to remove: ");
                    try {int removeId = Integer.parseInt(scanner.nextLine());
                        manager.removeContact(removeId);} 
                        catch (NumberFormatException e) {System.out.println("Invalid Contact ID.");}
                    break;
                case 6:
                    System.out.println("Thank you for using FieldLedger!");
                    break;
                default:
                    System.out.println("Please select an option from 1 to 6.");}
        }
        scanner.close();
    }
}
