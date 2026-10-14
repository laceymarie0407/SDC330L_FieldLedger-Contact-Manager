/*
 * Name: Lacey Roof
 * Date: October 13, 2026
 * Assignment: SDC330L Week 1 Project
 * Purpose: Main application for the FieldLedger Contact Manager.
 */

public class App {
    public static void main(String[] args) throws Exception {
        //Application header and welcome message
        System.out.println("\nLacey Roof - SDC330L Week 1 Project");
        System.out.println("FIELDLEDGER CONTACT MANAGER");
        System.out.println("----------------------------------------");
        System.out.println("Welcome to FieldLedger!");
        System.out.println("This application manages customer, vendor, and employee contacts.");

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

        //Display contact information using toString()
        System.out.println("\n--- CUSTOMER ---");
        System.out.println(customer);

        System.out.println("\n--- VENDOR ---");
        System.out.println(vendor);

        System.out.println("\n--- EMPLOYEE ---");
        System.out.println(employee);

    }
}
