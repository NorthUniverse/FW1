package MobilePhone;

import java.util.ArrayList;

public class MobilePhone {

    private String  myPhoneNumber;
    private ArrayList<Contact> contactList;

    public MobilePhone(String myPhoneNumber) {
        this.myPhoneNumber = myPhoneNumber;
        this.contactList = new ArrayList<Contact>();
    }

    public void addContact(String newName, String newPhoneNumber) {

        for(int i=0; i<contactList.size(); i++) {

            if(contactList.get(i).getName().equals(newName)) {
                System.out.println(newName + " already exists! Cannot add " + newName);
                return;
            }
            else if(contactList.get(i).getPhoneNumber().equals(newPhoneNumber)) {
                System.out.println(newPhoneNumber + " already exists! Cannot add " + newPhoneNumber);
                return;
            }
        }
        Contact addContact = Contact.createContact(newName, newPhoneNumber);
        contactList.add(addContact);
        System.out.println(newName + " was added");
    }

    public void addContact(Contact contact) {

        for(int i=0; i<contactList.size(); i++) {
            if(contactList.get(i).getName().equals(contact.getName())) {
                System.out.println(contact.getName() + " already exists! Cannot add " + contact.getName());
                return;
            }
            else if(contactList.get(i).getPhoneNumber().equals(contact.getPhoneNumber())) {
                System.out.println(contact.getPhoneNumber() + " already exists! Cannot add " + contact.getPhoneNumber());
                return;
            }
        }
        Contact addContact = Contact.createContact("A", "C");
        contactList.add(contact);
        System.out.println(contact.getName() + " was added");
    }

    public void removeContact(String enteredName) {

        for(int i=0; i<contactList.size(); i++) {
            if(contactList.get(i).getName().equals(enteredName)) {
                contactList.remove(i);
                System.out.println(enteredName + " was removed from the contact list");
                return;
            }
            else {
                System.out.println(enteredName + " is not in contact list! Cannot remove " + enteredName);
                return;
            }
        }
    }
    public void editContact(String oldName, String newName, String newPhoneNumber) {

        for(int i=0; i<contactList.size(); i++) {
            if(contactList.get(i).getName().equals(oldName)) {
                contactList.set(i, new Contact(newName, newPhoneNumber));
                System.out.println(oldName + " was changed to " + newName + " with phone number " + newPhoneNumber);
                return;
            }
            else {
                System.out.println(oldName + " is not in contact list! Cannot edit " + oldName);
                return;
            }
        }
    }

    public void searchContact(String contactName) {

        for(int i=0; i<contactList.size(); i++) {
            if(contactList.get(i).getName().equals(contactName)) {
                System.out.println(contactName + " exists in the contact lists!");
                return;
            }
            else {
                System.out.println(contactName + " does not exists in the contact lists!");
                return;
            }
        }
    }

    public void printContacts() {

        for(int i=0; i<contactList.size(); i++) {
            if(contactList.size() < 1) {
                System.out.println("There are no contacts!");
                return;
            }
            else {
                System.out.println((i+1) + ". " + contactList.get(i).getName() + ": " + contactList.get(i).getPhoneNumber());
                System.out.println(" ");
                return;
            }
        }
    }


}
