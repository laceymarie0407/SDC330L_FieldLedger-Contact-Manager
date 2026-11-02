/*
 * Name: Lacey Roof
 * Date: October 19, 2026
 * Assignment: SDC330L Week 2 Project
 * Purpose: Manages the contact list using the ContactOperations interface.
 */
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

// implementing an interface
public class ContactManager implements ContactOperations {
    private ArrayList<Contact> contacts = new ArrayList<>();

    //Create: Add contact to SQLite database
    @Override
    public void addContact(Contact contact) {
        String sql = "INSERT INTO contacts (contact_type, first_name, last_name, " +
            "phone, email, company_name, additional_info) VALUES (?, ?, ?, ?, ?, ?, ?)";

        //Identify the additional information based on contact type
        String additionalInfo = "";
        if (contact instanceof Customer) {additionalInfo = ((Customer) contact).getCustomerNumber();} 
        else if (contact instanceof Vendor) {additionalInfo = ((Vendor) contact).getServiceType();} 
        else if (contact instanceof Employee) {additionalInfo = ((Employee) contact).getJobTitle();}

        //Connect to database and insert contact information
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, contact.getContactType());
            stmt.setString(2, contact.getFirstName());
            stmt.setString(3, contact.getLastName());
            stmt.setString(4, contact.getPhone());
            stmt.setString(5, contact.getEmail());
            stmt.setString(6, contact.getCompany().getCompanyName());
            stmt.setString(7, additionalInfo);
            stmt.executeUpdate();
            contacts.add(contact);
            System.out.println("Contact saved to database.");} 
            catch (SQLException e) {System.out.println("Error saving contact: " + e.getMessage());}
    }


    //Read: Retrieve and display all contacts from SQLite
    @Override
    public void viewContacts() {String sql = "SELECT * FROM contacts ORDER BY last_name";

        //Connect to database and retrieve stored records
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            //Loop through each record returned from database
            while (rs.next()) {
                System.out.println("\nContact ID: " + rs.getInt("contact_id"));
                System.out.println("Type: " + rs.getString("contact_type"));
                System.out.println("First Name: " + rs.getString("first_name"));
                System.out.println("Last Name: " + rs.getString("last_name"));
                System.out.println("Phone: " + rs.getString("phone"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Company: " + rs.getString("company_name"));
                System.out.println("Additional Info: " + rs.getString("additional_info"));}
        } catch (SQLException e) {System.out.println("Error retrieving contacts: " + e.getMessage());}
    }


    //Read: Search SQLite contacts by first letter of last name
    @Override
    public void searchContacts(String letter) {
        String sql = "SELECT * FROM contacts WHERE LOWER(last_name) LIKE ? ORDER BY last_name";

        //Use PreparedStatement to safely search the database
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, letter.toLowerCase() + "%");

            //Retrieve and display matching contacts
            try (ResultSet rs = stmt.executeQuery()) {
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    System.out.println("\nContact ID: " + rs.getInt("contact_id"));
                    System.out.println("Type: " + rs.getString("contact_type"));
                    System.out.println("First Name: " + rs.getString("first_name"));
                    System.out.println("Last Name: " + rs.getString("last_name"));
                    System.out.println("Phone: " + rs.getString("phone"));
                    System.out.println("Email: " + rs.getString("email"));
                    System.out.println("Company: " + rs.getString("company_name"));
                    System.out.println("Additional Info: " + rs.getString("additional_info"));
                }
                if (!found) {System.out.println("No matching contacts found.");}
            }
        } catch (SQLException e) {System.out.println("Error searching contacts: " + e.getMessage());}
    }



    //Update: Modify a contact's phone number in SQLite using contact ID
    @Override
    public void updateContact(int contactId, String phone) {
        String sql = "UPDATE contacts SET phone = ? WHERE contact_id = ?";

        //Use PreparedStatement to update the selected database record
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, phone);
            stmt.setInt(2, contactId);

            //Execute update and confirm whether a record was changed
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {System.out.println("Contact updated successfully.");} 
            else {System.out.println("Contact ID not found.");}
        } 
            catch (SQLException e) {System.out.println("Error updating contact: " + e.getMessage());}
    }


    //Delete: Remove a contact from SQLite using contact ID
    @Override
    public void removeContact(int contactId) {String sql = "DELETE FROM contacts WHERE contact_id = ?";

        //Use PreparedStatement to delete the selected database record
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, contactId);

            //Execute delete and confirm whether a record was removed
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {System.out.println("Contact deleted successfully.");} 
            else {System.out.println("Contact ID not found.");}
        } 
            catch (SQLException e) {System.out.println("Error deleting contact: " + e.getMessage());}
    }
}
