package Chapter_02_Advanced_OOP;
public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
 
    public BankAccount(String accNumber, String holderName) {
        this.accountNumber = accNumber;
        this.accountHolderName = holderName;
        this.balance = 0.0;
    }
 
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }
 
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else if (amount > balance) {
            System.out.println("Withdrawal failed. Insufficient balance.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }
 
    public void displayBalance() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }
 
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount("123456789", "Alice");
        
        myAccount.displayBalance();
        System.out.println("---");
        
        myAccount.deposit(500.00);
        myAccount.withdraw(200.00);
        System.out.println("---");
        
        myAccount.displayBalance();
        System.out.println("---");
        
        myAccount.withdraw(400.00);
    }
}