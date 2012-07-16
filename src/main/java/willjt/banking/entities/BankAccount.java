package willjt.banking.entities;

public class BankAccount {

    private int balance;

    public void addToBalance(int amount) {
        balance += amount;
    }

    public void deductFromBalance(int amount) {
        balance -= amount;
    }

    public int currentBalance() {
        return balance;
    }

    public void resetBalanceTo(int balance) {
        this.balance = balance;
    }
}
