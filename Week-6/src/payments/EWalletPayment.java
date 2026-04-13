package payments;

public class EWalletPayment extends Payment {
    private String ewalletProvider;
    private String phoneNumber;
    
    public EWalletPayment(String ewalletProvider, String phoneNumber) {
        this.ewalletProvider = ewalletProvider;
        this.phoneNumber = phoneNumber;
    }

    public void pay(Double amount, int transactionID) {
        System.out.println("the amount:" + amount + " already paid for the Transaction ID:" + transactionID);
        System.out.println("The payment from " +this.ewalletProvider+" and the account: " +this.phoneNumber);
    }  

    public String getEwalletProvider() {
        return ewalletProvider;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
}