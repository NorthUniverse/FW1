package Bank;

import java.util.Scanner;

public class Main {

    private static Scanner menuOptionscanner = new Scanner(System.in);

    public static void main(String[] args) {

        Bank bank = new Bank("Bank1");
        boolean quit = false;

        printMenuOptions();

        while(!quit) {

        }

    }

    private static void printMenuOptions() {
        System.out.println("1. Add new branch ");
        System.out.println("2. Remove branch ");
        System.out.println("3. Search for a branch ");
        System.out.println("4. Print all branches ");
        System.out.println("5. Add customer to branch ");
        System.out.println("6. Remove customer from branch  ");
        System.out.println("7. Search for a customer at branch ");
        System.out.println("7. Print all customers at branch ");
        System.out.println("8. Make a transaction for a customer ");
        System.out.println("9. Print all transactions for a customer ");
        System.out.println("10. Exit ");
    }
}
