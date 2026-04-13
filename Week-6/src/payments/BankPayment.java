package payments;

public class BankPayment extends Payment {
    private String AccountNumber;
    private String BankName;

    public BankPayment(String BankName, String AccountNumber) {
        this.AccountNumber = AccountNumber;
        this.BankName = BankName;
    }

    public void pay(Double amount, int transactionID) {
        System.out.println("the amount: " + amount + " already paid for the Transaction ID: " + transactionID);
        System.out.println("The payment from " +this.BankName+" and the account: " +this.AccountNumber);
    }  
    
    public String getBankName() {
        return this.BankName;
    }
    public String getAccount() {
        return this.AccountNumber;
    }
}
