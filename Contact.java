/*
 * Name: Lacey Roof
 * Date: October 13, 2026
 * Assignment: SDC330L Week 1 Project
 * Purpose: Stores basic information for a contact.
 */

public abstract class Contact {
        //Class Properties
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Company company;

    //Constructor to set class properties
    public Contact(String firstName, String lastName, String phone, String email, Company company){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.company = company;
}

    //Functions to get and set properties
    public String getFirstName() { 
        return firstName;} 
    public void setFirstName(String firstName) { 
       this.firstName = firstName;} 

    public String getLastName() { 
        return lastName;} 
    public void setLastName(String lastName) { 
       this.lastName = lastName;} 

    public String getPhone() { 
        return phone;} 
    public void setPhone(String phone) { 
       this.phone = phone;} 

    public String getEmail() { 
        return email;} 
    public void setEmail(String email) { 
       this.email = email;} 

    public Company getCompany() {
        return company;}
    public void setCompany(Company company) {
        this.company = company;}

//Abstraction: each contact type must identify itself
    public abstract String getContactType();

    //Return contact information as: 
    //First Name: FirstName
    //Last Name: LastName
    //Phone: Phone
    //Email: Email
    public String getContactInformation() {
        return String.format("%s%s%n%s%s%n%s%s%n%s%s%n%s%s",
            "First Name: ", firstName,
            "Last Name: ", lastName,
            "Phone: ", phone,
            "Email: ", email,
            "Company: ", company.getCompanyName());
    }

    @Override 
    public String toString() {
        return getContactInformation();
    }
}