/*
 * Name: Lacey Roof
 * Date: October 13, 2026
 * Assignment: SDC330L Week 1 Project
 * Purpose: Stores company information for a contact.
 */
public class Company {
    private String companyName;

    public Company(String companyName) {
        this.companyName = companyName;}

//Overloaded constructor
    public Company() {
        this.companyName = "Not Assigned";}

    public String getCompanyName() {
        return companyName;}
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
