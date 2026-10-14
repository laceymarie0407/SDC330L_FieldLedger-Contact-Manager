/*
 * Name: Lacey Roof
 * Date: October 13, 2026
 * Assignment: SDC330L Week 1 Project
 * Purpose: Represents an employee contact using inheritance.
 */

// Inheritance: Employee extends Contact
public class Employee extends Contact {
    private String jobTitle;

    public Employee(String firstName, String lastName, String phone,
                    String email, Company company, String jobTitle) {
        super(firstName, lastName, phone, email, company);
            this.jobTitle = jobTitle;}

    public String getJobTitle() {
        return jobTitle;}
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;}

    @Override
    public String toString() {
        return super.toString() +
               "\nJob Title: " + jobTitle;}
}
