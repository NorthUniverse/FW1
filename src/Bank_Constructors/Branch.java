package Bank_Constructors;

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
        if (findCustomer(customerName, false) == null) {
            branch.customers.add(new Customer(customerName, initialTransaction));
            System.out.println(customerName + " was added to " + branch.getBranchName());
        } else {
            System.out.println(customerName + " customer already exists at " + branch.getBranchName());
        }
    }

    public void removeCustomer(Branch branch, String name) {
        Customer customer = branch.findCustomer(name, false);
        if (customer != null) {
            int customerIndex = branch.customers.indexOf(customer);
            branch.customers.remove(customerIndex);
            System.out.println(name + " was removed from " + branch.getBranchName());
        } else {
            System.out.println(name + " is not registered at " + branch.getBranchName());
        }
    }

    public void addCustomerTransaction(Customer customer, double amount) {
        customer.makeTransaction(amount);
    }

    public void printAllCustomersAtBranch(Branch branch) {
        if (branch.customers.size() > 0) {
            System.out.println("Customer at " + branch.getBranchName() + " are:");
            for (int i = 0; i < branch.customers.size(); i++) {
                System.out.println((i + 1) + ". " + branch.customers.get(i).getName());
            }
        } else {
            System.out.println("No customers present at " + branch.getBranchName());
        }
    }

    public void printCustomersTransactions(Customer customer) {
        System.out.println(customer.getName() + ": ");
        customer.printTransactions();
    }

    public Customer findCustomer(String name, boolean printMessage) {
        boolean flag = false;
        for (int i = 0; i < this.customers.size(); i++) {
            if (this.customers.get(i).getName().equals(name)) {
                flag = true;
                return this.customers.get(i);
            }
        }
        if (!flag) {
            if (printMessage) {
                System.out.println(name + " is not registered at " + this.getBranchName());
            }
        }
        return null;
    }
}
