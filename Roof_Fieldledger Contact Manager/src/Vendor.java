/*
 * Name: Lacey Roof
 * Date: October 13, 2026
 * Assignment: SDC330L Week 1 Project
 * Purpose: Represents a vendor contact using inheritance.
 */

// Inheritance: Vendor extends Contact
public class Vendor extends Contact {
    private String serviceType;

    public Vendor (String firstName, String lastName, String phone,
                    String email, Company company, String serviceType) {
        super(firstName, lastName, phone, email, company);
            this.serviceType = serviceType;}

    public String getServiceType() {
        return serviceType;}
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;}

    @Override
    public String getContactType() {
    return "Vendor";}

    @Override
    public String toString() {
        return super.toString() +
               "\nService Type: " + serviceType;}
}
