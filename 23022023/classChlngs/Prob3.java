// Encapsulation Challenge: 
// Create a class called “BankAccount” with properties like “accountNumber”, 
// “balance”, and methods like “deposit”, “withdraw”. Use encapsulation to 
// ensure that the “balance” property can only be accessed and modified using 
// the “deposit” and “withdraw” methods.

package classChlngs;

public class Prob3 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(123456789, 500);
        account.deposit(100);
        account.withdraw(200);

        // account.accountNumber = 987654321; <- Error
        
    }
}

class BankAccount {
    private int accountNumber;
    private int balance;

    public BankAccount(int accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
        System.out.println("deposited: " + amount + "balance: " + this.balance);
    }
    public Boolean withdraw(int amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            System.out.println("withdrawed: " + amount + "balance: " + this.balance);
            return true;
        }
        System.out.println("No enough balance");
        return false;
    }
}