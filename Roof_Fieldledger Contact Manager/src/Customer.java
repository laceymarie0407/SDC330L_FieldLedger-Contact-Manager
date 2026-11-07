/*
 * Name: Lacey Roof
 * Date: October 13, 2026
 * Assignment: SDC330L Week 1 Project
 * Purpose: Represents an customer contact using inheritance.
 */

// Inheritance: Customer extends Contact
public class Customer extends Contact {
    private String customerNumber;

    public Customer(String firstName, String lastName, String phone,
                    String email, Company company, String customerNumber) {
        super(firstName, lastName, phone, email, company);
            this.customerNumber = customerNumber;}

    public String getCustomerNumber() {
        return customerNumber;}
    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;}

    @Override
    public String getContactType() {
    return "Customer";}

    @Override
    public String toString() {
        return super.toString() +
               "\nCustomer #: " + customerNumber;}
}
