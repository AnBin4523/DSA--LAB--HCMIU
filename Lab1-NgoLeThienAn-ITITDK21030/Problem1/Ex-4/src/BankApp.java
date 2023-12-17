import java.util.*;

public class BankApp {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the initial balance for the first account: ");
        double initialBalance_1 = sc.nextDouble();
        BankAccount account_1 = new BankAccount(initialBalance_1);

        System.out.print("Enter the initial balance for the second account: ");
        double initialBalance_2 = sc.nextDouble();
        BankAccount account_2 = new BankAccount(initialBalance_2);

        System.out.print("Enter the deposit amount for the first account: ");
        double depositAmount_1 = sc.nextDouble();
        account_1.deposit(depositAmount_1);

        System.out.print("Enter the deposit amount for the second account: ");
        double depositAmount_2 = sc.nextDouble();
        account_2.deposit(depositAmount_2);

        System.out.print("Enter the withdrawal amount for the first account: ");
        double withdrawalAmount_1 = sc.nextDouble();
        account_1.withdraw(withdrawalAmount_1);

        System.out.print("Enter the withdrawal amount for the second account: ");
        double withdrawalAmount_2 = sc.nextDouble();
        account_2.withdraw(withdrawalAmount_2);

        account_1.transfer(account_2, account_1.getBalance());

        System.out.println("Balance of account 1: " + account_1.getBalance() + "$");
        System.out.println("Balance of account 2: " + account_2.getBalance() + "$");
        sc.close();
    }
}
