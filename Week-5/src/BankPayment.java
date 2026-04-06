public class BankPayment extends Payment {
    private String AccountNumber;
    private String BankName;
    private String AccountReceipt;
    private String BankReceipt; 

    public BankPayment(String BankName, String AccountNumber) {
        this.AccountNumber = AccountNumber;
        this.BankName = BankName;
        this.AccountReceipt = "87900094922";
        this.BankReceipt = "BCA";
    }

    public void pay(double amount, int transactionID) {
        System.out.println("the amount:" + amount + " already paid for the Transaction ID:" + transactionID);
        System.out.println("The payment from"+this.BankName+" and the account:" +this.AccountNumber);
    }      
}
