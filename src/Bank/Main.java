package Bank;

import java.util.Scanner;

public class Main {

    private static Scanner menuOptionscanner = new Scanner(System.in);

    public static void main(String[] args) {

        Bank bank = new Bank("Bank1");
        boolean quit = false;

        printMenuOptions();

        while (!quit) {

            int menuOption = menuOptionscanner.nextInt();
            Scanner textScanner = new Scanner(System.in);
            Scanner doubleScanner = new Scanner(System.in);
            String branchName;
            String customerName;
            double transactionAmount;
            switch (menuOption) {
                case 1:
                    System.out.print("Enter branch name to add: ");
                    branchName = textScanner.nextLine();
                    bank.addBranch(branchName);
                    printMenuOptions();
                    break;
                case 2:
                    System.out.print("Enter branch name to remove: ");
                    branchName = textScanner.nextLine();
                    bank.removeBranch(branchName);
                    printMenuOptions();
                    break;
                case 3:
                    System.out.print("Enter branch name to search: ");
                    branchName = textScanner.nextLine();
                    if (bank.findBranch(branchName, true) != null) {
                        System.out.println(branchName + " exists!");
                    }
                    printMenuOptions();
                    break;
                case 4:
                    bank.printAllBranches();
                    printMenuOptions();
                    break;
                case 5:
                    System.out.print("Enter customer name to add: ");
                    customerName = textScanner.nextLine();
                    System.out.print("Enter initial transaction to customer to add: ");
                    transactionAmount = doubleScanner.nextDouble();
                    System.out.print("Enter branch name to add the customer " + customerName + " ");
                    branchName = textScanner.nextLine();
                    Branch branch = bank.findBranch(branchName, true);
                    if (branch != null) {
                        branch.addCustomer(branch, customerName, transactionAmount);
                    }
                    printMenuOptions();
                    break;
                case 6:
                    System.out.print("Enter customer name to remove: ");
                    customerName = textScanner.nextLine();
                    System.out.print("Enter branch name to remove the customer " + customerName + " ");
                    branchName = textScanner.nextLine();
                    branch = bank.findBranch(branchName, true);
                    if (branch != null) {
                        branch.removeCustomer(branch, customerName);
                    }
                    printMenuOptions();
                    break;
                case 7:
                    System.out.print("Enter customer name to search: ");
                    customerName = textScanner.nextLine();
                    System.out.print("Enter branch name to search the customer " + customerName + " ");
                    branchName = textScanner.nextLine();
                    branch = bank.findBranch(branchName, true);
                    if (branch != null) {
                        branch.findCustomer(customerName, true);
                    }
                    printMenuOptions();
                    break;
                case 8:
                    System.out.print("Enter branch name to print all customers ");
                    branchName = textScanner.nextLine();
                    branch = bank.findBranch(branchName, true);
                    if (branch != null) {
                        branch.printAllCustomersAtBranch(branch);
                    }
                    printMenuOptions();
                    break;
                case 9:
                    System.out.print("Enter customer name to make transaction ");
                    customerName = textScanner.nextLine();
                    System.out.print("Enter transaction amount to add: ");
                    transactionAmount = doubleScanner.nextDouble();
                    System.out.print("Enter branch name of the customer " + customerName + " ");
                    branchName = textScanner.nextLine();
                    branch = bank.findBranch(branchName, true);
                    if (branch != null) {
                        Customer customer = branch.findCustomer(customerName, true);
                        if (customer != null) {
                            customer.makeTransaction(transactionAmount);
                            System.out.println(transactionAmount + "$ transaction was made to custoemr " + customerName);
                        }
                    }
                    printMenuOptions();
                    break;
                case 10:
                    System.out.print("Enter branch name to search the customer ");
                    branchName = textScanner.nextLine();
                    System.out.print("Enter customer name to print all transactions: ");
                    customerName = textScanner.nextLine();
                    branch = bank.findBranch(branchName, true);
                    if (branch != null) {
                        Customer customer = branch.findCustomer(customerName, true);
                        if (customer != null) {
                            customer.printTransactions();
                        }
                    }
                    printMenuOptions();
                    break;
                case 11:
                    printMenuOptions();
                    break;
                default:
                    quit = true;
                    break;
            }

        }
    }

    private static void printMenuOptions() {
        System.out.println("               ");
        System.out.println("1. Add new branch ");
        System.out.println("2. Remove branch ");
        System.out.println("3. Search for a branch ");
        System.out.println("4. Print all branches ");
        System.out.println("5. Add customer to branch ");
        System.out.println("6. Remove customer from branch  ");
        System.out.println("7. Search for a customer at branch ");
        System.out.println("8. Print all customers at branch ");
        System.out.println("9. Make a transaction for a customer ");
        System.out.println("10. Print all transactions for a customer ");
        System.out.println("11. Exit ");
        System.out.println("               ");
    }
}
