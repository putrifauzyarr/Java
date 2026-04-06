public class BankAccount {
    private double balance;
    protected String account_no;
    protected String account_name;

    public BankAccount(double amount, String acc_no, String acc_name) {
        this.balance = amount;
        this.account_no = acc_no;
        this.account_name = acc_name;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getAccountNumber() {
        return this.account_no;
    }

    public String getAccountName() {
        return this.account_name;
    }

    public String toString() {
        return "Account Name: " + this.account_name + 
               "\nAccount Number: " + this.account_no + 
               "\nYour Balance: $" + this.balance;
    }
}