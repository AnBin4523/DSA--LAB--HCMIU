public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit: " + amount + ", New balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw: " + amount + ", New balance: " + balance);
        } else {
            System.out.println("Cannot withdraw");
        }
    }

    public void transfer(BankAccount transferAccount, double amount) {
        if (amount <= balance) {
            balance -= amount;
            transferAccount.deposit(amount);
            System.out.println("Transfer: " + amount + ", New balance: " + balance);
        } else {
            System.out.println("Cannot transfer");
        }
    }
}
