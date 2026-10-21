/*
 * Name: Lacey Roof
 * Date: October 19, 2026
 * Assignment: SDC330L Week 2 Project
 * Purpose: Manages the contact list using the ContactOperations interface.
 */
import java.util.ArrayList;

// implementing an interface
public class ContactManager implements ContactOperations {
    private ArrayList<Contact> contacts = new ArrayList<>();
@Override
    public void addContact(Contact contact) {contacts.add(contact);}
@Override
    public void viewContacts() {
        //Polymorphism: calls the correct toString() for each contact type
        for (Contact contact : contacts) {System.out.println("\n" + contact);}
    }
@Override
    public void searchContacts(String letter) {
        for (Contact contact : contacts) {
            if (contact.getLastName().toLowerCase().startsWith(letter.toLowerCase())) {
                System.out.println(contact);}
        }
    }
@Override
    public void updateContact(int index, String phone) {
        if (index >= 0 && index < contacts.size()) {contacts.get(index).setPhone(phone);}
    }
@Override
    public void removeContact(int index) {
        if (index >= 0 && index < contacts.size()) {contacts.remove(index);}
    }
}
