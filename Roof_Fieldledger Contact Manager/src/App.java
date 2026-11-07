
/*
 * Name: Lacey Roof
 * Date: November 6, 2026
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
        System.out.println("Manage customer, vendor, and employee contacts using the menu below.");

        //Initialize SQLite database and create contacts table
        DatabaseManager.createTable();

        //Create ContactManager, which implements ContactOperations
        ContactManager manager = new ContactManager();

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

            //Read menu selection and handle invalid input
            try {choice = Integer.parseInt(scanner.nextLine());}
            catch (NumberFormatException e) {
                System.out.println("Please enter a number from 1 to 6.");
                continue;
            }

            //Perform selected contact operation
            switch (choice) {
                case 1:
                    //Create: Collect information for a new contact
                    System.out.println("\n--- ADD CONTACT ---");
                    System.out.println("1. Customer");
                    System.out.println("2. Vendor");
                    System.out.println("3. Employee");
                    System.out.print("Select contact type: ");

                    int contactType;
                    try {contactType = Integer.parseInt(scanner.nextLine());}
                    catch (NumberFormatException e) {
                        System.out.println("Invalid contact type.");
                        break;
                    }

                    if (contactType < 1 || contactType > 3) {
                        System.out.println("Please select 1, 2, or 3.");
                        break;
                    }

                    System.out.print("First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Phone: ");
                    String contactPhone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Company: ");
                    String companyName = scanner.nextLine();

                    //Composition: Each contact contains a Company object
                    Company company = new Company(companyName);

                    //Inheritance: Create the appropriate Contact subclass
                    //Polymorphism: Contact reference holds different contact types
                    Contact contact;

                    if (contactType == 1) {
                        System.out.print("Customer Number: ");
                        String customerNumber = scanner.nextLine();
                        contact = new Customer(firstName, lastName, contactPhone,
                            email, company, customerNumber);
                    } else if (contactType == 2) {
                        System.out.print("Service Type: ");
                        String serviceType = scanner.nextLine();
                        contact = new Vendor(firstName, lastName, contactPhone,
                            email, company, serviceType);
                    } else {
                        System.out.print("Job Title: ");
                        String jobTitle = scanner.nextLine();
                        contact = new Employee(firstName, lastName, contactPhone,
                            email, company, jobTitle);
                    }

                    //Save new contact to SQLite using ContactManager
                    manager.addContact(contact);
                    break;

                case 2:
                    //Read: Display all contacts stored in SQLite
                    System.out.println("\n--- ALL CONTACTS ---");
                    manager.viewContacts();
                    break;

                case 3:
                    //Read: Search SQLite by last name initial
                    System.out.print("Enter first letter of last name: ");
                    String letter = scanner.nextLine();
                    manager.searchContacts(letter);
                    break;

                case 4:
                    //Update: Modify contact phone number using database ID
                    System.out.print("Enter Contact ID: ");
                    try {
                        int updateId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter new phone number: ");
                        String phone = scanner.nextLine();
                        manager.updateContact(updateId, phone);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Contact ID.");
                    }
                    break;

                case 5:
                    //Delete: Remove contact from SQLite using database ID
                    System.out.print("Enter Contact ID to remove: ");
                    try {
                        int removeId = Integer.parseInt(scanner.nextLine());
                        manager.removeContact(removeId);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Contact ID.");
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using FieldLedger!");
                    break;

                default:
                    System.out.println("Please select an option from 1 to 6.");
            }
        }
        //Close Scanner when application exits
        scanner.close();
    }
}