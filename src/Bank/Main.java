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
                    if (bank.branchExists(branchName)) {
                        System.out.println(branchName + " exists!");
                    }
                    printMenuOptions();
                    break;
                case 4:
                    System.out.print("Branches at " + bank.getBankName() + " are:");
                    bank.printAllBranches(bank);
                    printMenuOptions();
                    break;
                case 5:
                    System.out.print("Enter customer name to add: ");
                    customerName = textScanner.nextLine();
                    System.out.print("Enter initial transaction to customer to add: ");
                    transactionAmount = doubleScanner.nextDouble();
                    System.out.print("Enter branch name to add the customer " + customerName);
                    branchName = textScanner.nextLine();
                    boolean flag = false;
                    for (int i = 0; i < bank.getBranches().size(); i++) {
                        Branch eachBranch = bank.getBranches().get(i);
                        if (eachBranch.getBranchName().equals(branchName)) {
                            flag = true;
                            eachBranch.addCustomer(eachBranch, customerName, transactionAmount);
                        }
                    }
//                    printMenuOptions();
                    break;
                case 6:
                    System.out.print("Enter branch name to remove: ");
                    branchName = textScanner.nextLine();
                    bank.removeBranch(branchName);
                    printMenuOptions();
                    break;
                case 7:
                    System.out.print("Enter branch name to search: ");
                    branchName = textScanner.nextLine();
                    if (bank.branchExists(branchName)) {
                        System.out.println(branchName + " exists!");
                    }
                    printMenuOptions();
                    break;
                case 8:
                    System.out.print("Enter branch name to print all customers ");
                    branchName = textScanner.nextLine();
                    flag = false;
                    for (int i = 0; i < bank.getBranches().size(); i++) {
                        Branch branch = bank.getBranches().get(i);
                        if (branch.getBranchName().equals(branchName)) {
                            flag = true;
                            branch.printAllCustomersAtBranch(branch);
                        }
                    }
                    printMenuOptions();
                    break;
                default:
                    quit = true;
                    break;
            }

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
        System.out.println("8. Print all customers at branch ");
        System.out.println("9. Make a transaction for a customer ");
        System.out.println("10. Print all transactions for a customer ");
        System.out.println("11. Exit ");
    }
}
