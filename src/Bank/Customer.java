package Bank;

import java.util.ArrayList;

public class Customer {
    private String name;
    ArrayList<Double> transactions;

    public Customer(String name, double transaction) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        transactions.add(transaction);
    }

    public String getName() {
        return name;
    }

    public void printTransactions() {
        for(int i=0; i<transactions.size(); i++) {
            System.out.println(transactions.get(i));
        }
    }

    public void makeTransaction(double amount) {
        transactions.add(amount);
    }
}
