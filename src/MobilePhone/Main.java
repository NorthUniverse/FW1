package MobilePhone;

import java.util.Scanner;

public class Main {

    public static Scanner menuOptionScanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Starting mobile phone: ");
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
                    mobilePhone.addContact(contactName, contactPhoneNumber);
                    printPhoneMenu();
                    break;
                case 2:
                    System.out.print("Enter contact name to remove: ");
                    contactName = contactScanner.nextLine();
                    if (mobilePhone.searchContact(contactName)) {
                        mobilePhone.removeContact(contactName);
                    }
                    printPhoneMenu();
                    break;
                case 3:
                    System.out.print("Enter contact name to edit: ");
                    String oldName = contactScanner.nextLine();
                    if (mobilePhone.searchContact(oldName)) {
                        System.out.print("Enter new contact name: ");
                        contactName = contactScanner.nextLine();
                        System.out.print("Enter new contact phone number: ");
                        contactPhoneNumber = contactScanner.nextLine();
                        mobilePhone.editContact(oldName, contactName, contactPhoneNumber);
                        printPhoneMenu();
                    }
                    break;
                case 4:
                    System.out.print("Enter contact name to search: ");
                    contactName = contactScanner.nextLine();
                    mobilePhone.searchContact(contactName);
                    printPhoneMenu();
                    break;
                case 5:
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
        System.out.print("Enter Option: ");
    }
}
