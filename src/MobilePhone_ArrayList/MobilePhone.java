package MobilePhone_ArrayList;

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
                System.out.println(newPhoneNumber + " phone number already exists! Cannot add phone number" + newPhoneNumber);
                return;
            }
        }

        contactList.add(new Contact(newName, newPhoneNumber));
        System.out.println(newName + " was added");
    }


    public void removeContact(String enteredName) {

        boolean flag = false;
        for(int i=0; i<contactList.size(); i++) {
            if(contactList.get(i).getName().equals(enteredName)) {
                contactList.remove(i);
                flag = true;
                System.out.println(enteredName + " was removed from the contact list");
                return;
            }
        }
        if (!flag) {
            System.out.println(enteredName + " is not in contact list! Cannot remove " + enteredName);
        }
    }
    public void editContact(String oldName, String newName, String newPhoneNumber) {

        boolean flag = false;

        for(int i=0; i<contactList.size(); i++) {
            if(contactList.get(i).getName().equals(newName)) {
                System.out.println(newName + " contact already exists, cannot add " + newName);
                flag = true;
                return;
            }
        }

        for(int i=0; i<contactList.size(); i++) {
            if(contactList.get(i).getName().equals(oldName)) {
                contactList.set(i, new Contact(newName, newPhoneNumber));
                System.out.println(oldName + " was changed to " + newName + " with phone number " + newPhoneNumber);
                flag = true;
                return;
            }
        }
        if (!flag) {
            System.out.println(oldName + " is not in contact list! Cannot remove " + oldName);
        }
    }

    public boolean searchContact(String contactName, boolean print) {

        boolean flag = false;
        for(int i=0; i<contactList.size(); i++) {
            if(contactList.get(i).getName().equals(contactName)) {
                if(print) {
                    System.out.println("Name: " + contactList.get(i).getName() + " -> Phone Number: " + contactList.get(i).getPhoneNumber());
                }
                flag = true;
                return true;
            }
        }
        if (!flag) {
            System.out.println(contactName + " is not in contact list!");
            return false;
        }
        return false;
    }

    public void printContacts() {

        if (contactList.size() < 1) {
            System.out.println("There are no contacts in your list");
            return;
        }
        System.out.println("Here are you list of contacts: ");
        for(int i=0; i<contactList.size(); i++) {
            System.out.println((i + 1) + ". " + contactList.get(i).getName() + ": " + contactList.get(i).getPhoneNumber());
        }
        System.out.println(" ");
    }


}
