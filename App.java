/*
 * Name: Lacey Roof
 * Date: October 19, 2026
 * Assignment: SDC330L 
 * Week 1: Demonstrate inheritance & composition using multiple contact types.
 * Week 2: Implement interfaces & polymorphism to manage multiple contact types.
 * Purpose: Main application for the FieldLedger Contact Manager.
 */

import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        //Application header and welcome message
        System.out.println("\nLacey Roof - SDC330L Week 2 Project");
        System.out.println("FIELDLEDGER CONTACT MANAGER");
        System.out.println("----------------------------------------");
        System.out.println("Welcome to FieldLedger!");
        System.out.println("This application manages customer, vendor, and employee contacts.");
        System.out.println("Below are the contacts currently stored in the application.");

        //Create company objects to demonstrate composition
        Company customerCompany = new Company("Costco");
        Company vendorCompany = new Company("United Rentals");
        Company employeeCompany = new Company("Sier Site Grading");

        //Create customer, vendor, and employee objects to demonstrate inheritance
        Customer customer = new Customer("Michael", "Reynolds",
            "555-0102", "michael@costco.example", customerCompany, "CUST-001");

        Vendor vendor = new Vendor("David", "Thompson",
            "555-0104", "david@unitedrentals.example", vendorCompany, "Equipment Rental");

        Employee employee = new Employee("Justin", "Carter",
            "555-0101", "justin@siergrading.example", employeeCompany, "Foreman");

        //Create ContactManager, which implements ContactOperations
        ContactManager manager = new ContactManager();

        //Add different contact types to the same collection
        manager.addContact(customer);
        manager.addContact(vendor);
        manager.addContact(employee);

        //Display contact information using toString()
        System.out.println("\n--- CUSTOMER ---");
        System.out.println(customer);

        System.out.println("\n--- VENDOR ---");
        System.out.println(vendor);

        System.out.println("\n--- EMPLOYEE ---");
        System.out.println(employee);

        //Demonstrates polymorphism through overridden toString() methods
        System.out.println("\n--- ALL CONTACTS ---");
        manager.viewContacts();

        Scanner scanner = new Scanner(System.in);
        //Search contacts by last name initial
        System.out.print("\nEnter the first letter of a last name: ");
        String letter = scanner.nextLine();
        manager.searchContacts(letter);
        scanner.close();
    }
}
