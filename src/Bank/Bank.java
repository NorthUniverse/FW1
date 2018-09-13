package Bank;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public String getBankName() {
        return this.name;
    }

    public void addBranch(String branchName) {
        if (!branchExists(branchName)) {
            Branch branch = new Branch(branchName);
            branches.add(branch);
        }
        else {
            System.out.println(branchName + " already exists!");
        }
    }

    public void removeBranch(String branchName) {
        boolean flag = false;
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getBranchName().equals(branchName)) {
                branches.remove(i);
                System.out.println("Branch " + branchName + " was removed!");
                flag = true;
                return;
            }
        }
        if(!flag) {
            System.out.println("Branch not found!");
        }
    }

    public void printAllBranches(Bank bank) {
        if(bank.branches.size() > 0) {
            System.out.println("Branches at " + bank.getBankName() + " are:");
            for (int i = 0; i < bank.branches.size(); i++) {
                System.out.println((i+1) + ". " + bank.branches.get(i).getBranchName());
            }
        }
        else {
            System.out.println("No customers present at " + bank.getBankName());
        }
    }

    public boolean branchExists(String branchName) {
        boolean flag = false;
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getBranchName().equals(branchName)) {
                flag = true;
                return true;
            }
        }
        if (!flag) {
            System.out.println(branchName + " was not found!");
            return false;
        }
        return false;
    }
}
