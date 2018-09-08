package MobilePhone;

import java.util.Scanner;

public class Main {

    public static Scanner menuOptionScanner = new Scanner(System.in);

    public static void main(String[] args) {

        MobilePhone mobilePhone = new MobilePhone("2000");

        boolean quit = false;

        printPhoneMenu();

        while(!quit) {

            int menuOption = menuOptionScanner.nextInt();
            Scanner contactScanner = new Scanner(System.in);
            String contactName;
            String contactPhoneNumber;
            switch (menuOption) {
                case 1:
                    System.out.print("Enter contact name to add: ");
                    contactName = contactScanner.nextLine();
                    System.out.print("Enter contact phone number to add: ");
                    contactPhoneNumber = contactScanner.nextLine();
//                    Contact newContact = Contact.createContact(contactName, contactPhoneNumber);
                    mobilePhone.addContact(contactName, contactPhoneNumber);
                    printPhoneMenu();
                    break;
                case 2:
                    System.out.print("Enter contact name to remove: ");
                    contactName = contactScanner.nextLine();
                    mobilePhone.removeContact(contactName);
                    printPhoneMenu();
                    break;
                case 3:
                    System.out.print("Enter contact name to edit: ");
                    String oldName = contactScanner.nextLine();
                    System.out.print("Enter new contact name: ");
                    contactName = contactScanner.nextLine();
                    System.out.print("Enter new contact phone number: ");
                    contactPhoneNumber = contactScanner.nextLine();
                    mobilePhone.editContact(oldName, contactName, contactPhoneNumber);
                    printPhoneMenu();
                    break;
                case 4:
                    System.out.print("Enter contact name to search: ");
                    contactName = contactScanner.nextLine();
                    mobilePhone.searchContact(contactName);
                    printPhoneMenu();
                    break;
                case 5:
                    System.out.println("Here are you list of contacts: ");
                    mobilePhone.printContacts();
                    printPhoneMenu();
                    break;
                case 7:
                    quit = true;
                    break;
                default:
                    quit = true;
                    break;
            }

        }

    }

    private static void printPhoneMenu() {
        System.out.println("1. Add Contact ");
        System.out.println("2. Remove Contact ");
        System.out.println("3. Edit Contact ");
        System.out.println("4. Find Contact  ");
        System.out.println("5. Print Contact list ");
        System.out.println("6. Print Menu Options ");
        System.out.println("7. Exit ");
    }
}
