package Bank_Constructors;

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
        if (findBranch(branchName, false) == null) {
            Branch branch = new Branch(branchName);
            branches.add(branch);
            System.out.println(branchName + " was successfully added!");
        } else {
            System.out.println(branchName + " already exists!");
        }
    }

    public void removeBranch(String branchName) {
        Branch branch = findBranch(branchName, false);
        if (branch != null) {
            int branchIndex = this.branches.indexOf(branch);
            this.branches.remove(branchIndex);
            System.out.println(branchName + " was removed!");
        } else {
            System.out.println(branch.getBranchName() + " does not exists! ");
        }
    }

    public void printAllBranches() {
        if (this.branches.size() > 0) {
            System.out.println("Branches at " + this.getBankName() + " are:");
            for (int i = 0; i < this.branches.size(); i++) {
                System.out.println((i + 1) + ". " + this.branches.get(i).getBranchName());
            }
        } else {
            System.out.println("No customers present at " + this.getBankName());
        }
    }

    public Branch findBranch(String branchName, boolean printMessage) {
        boolean flag = false;
        for (int i = 0; i < this.branches.size(); i++) {
            if (this.branches.get(i).getBranchName().equals(branchName)) {
                flag = true;
                return this.branches.get(i);
            }
        }
        if (!flag) {
            if (printMessage) {
                System.out.println(branchName + " was not found!");
            }
            return null;
        }
        return null;
    }
}
