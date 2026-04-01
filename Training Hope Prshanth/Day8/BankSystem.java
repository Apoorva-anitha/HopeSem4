package Day8;

class BankAccount {
    
    private String accountHolderName;
    private int accountNumber;
    private double balance;

    
    BankAccount(String accountHolderName, int accountNumber, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
            System.out.println("New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("Remaining Balance: " + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    
    public void display() {
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Balance        : " + balance);
        System.out.println();
    }
}

public class BankSystem {
    public static void main(String[] args) {

        
        BankAccount acc1 = new BankAccount("ABU", 1001, 5000000.0);
        BankAccount acc2 = new BankAccount("Ani", 1002, 20000000.0);

        
        System.out.println("Account Details");
        acc1.display();
        acc2.display();

        
        System.out.println("Deposit");
        acc1.deposit(15000.0);
        System.out.println();

        
        System.out.println("Withdraw");
        acc1.withdraw(20000.0);
        System.out.println();

    
        System.out.println("Getter / Setter Demo");
        System.out.println("Name before update: " + acc2.getAccountHolderName());
        acc2.setAccountHolderName("Asi");
        System.out.println("Name after update : " + acc2.getAccountHolderName());
        System.out.println();

        System.out.println("Final Account Details");
        acc1.display();
        acc2.display();
    }
}
