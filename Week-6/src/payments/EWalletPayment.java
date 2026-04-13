package payments;

public class EWalletPayment extends Payment {
    private String provider;
    private String phoneNumber;
    
    public EWalletPayment(String provider, String phoneNumber) {
        this.provider = provider;
        this.phoneNumber = phoneNumber;
    }

    public void pay(Double amount, int transactionID) {
        System.out.println("The amount:" + amount + " already paid for the Transaction ID:" + transactionID);
        System.out.println("The payment from " +this.provider+" and the account: " +this.phoneNumber);
    }  

    public String getProvider() {
        return provider;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
}