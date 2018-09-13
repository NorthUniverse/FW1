package Bank;

import java.util.ArrayList;

public class Branch {
    private String branchName;
    private ArrayList<Customer> customers;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.customers = new ArrayList<Customer>();
    }

    public String getBranchName() {
        return branchName;
    }

    public void addCustomer(Branch branch, String customerName, double initialTransaction) {
        if (!customerExists(customerName, false)) {
            branch.customers.add(new Customer(customerName, initialTransaction));
        } else {
            System.out.println(customerName + " customer already exists at " + branch.getBranchName());
        }
    }

    public void removeCustomer(Branch branch, String name) {
        boolean flag = false;
        for (int i = 0; i < branch.customers.size(); i++) {
            if (branch.customers.get(i).getName().equals(name)) {
                branch.customers.remove(i);
                System.out.println(name + " was removed from " + branch.getBranchName());
                flag = true;
                return;
            }
        }
        if (!flag) {
            System.out.println(name + " was not found at " + branch.getBranchName());
        }
    }

    public void addCustomerTransaction(Customer customer, double amount) {
        customer.makeTransaction(amount);
    }

    public void printAllCustomersAtBranch(Branch branch) {
        if(branch.customers.size() > 0) {
            System.out.println("Customer at " + branch.getBranchName() + " are:");
            for (int i = 0; i < branch.customers.size(); i++) {
                System.out.println((i+1) + ". " + branch.customers.get(i).getName());
            }
        }
        else {
            System.out.println("No customers present at " + branch.getBranchName());
        }
    }

    public void printCustomersTransactions(Customer customer) {
        System.out.println(customer.getName() + ": ");
        customer.printTransactions();
    }

    public boolean customerExists(String name, boolean printMessage) {
        boolean flag = false;
        for (int i = 0; i < this.customers.size(); i++) {
            if (this.customers.get(i).getName().equals(name)) {
                flag = true;
                return true;
            }
        }
        if (!flag) {
            if (printMessage) {
                System.out.println(name + " is not registered at " + this.getBranchName());
            }
        }
        return false;
    }
}
