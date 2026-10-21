/*
 * Name: Lacey Roof
 * Date: October 19, 2026
 * Assignment: SDC330L Week 2 Project
 * Purpose: Defines the contact management operations.
 */
//Interface = contact management methods
public interface ContactOperations {
    void addContact(Contact contact);
    void viewContacts();
    void searchContacts(String letter);
    void updateContact(int index, String phone);
    void removeContact(int index);}