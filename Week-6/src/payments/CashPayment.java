package payments;

public class CashPayment extends Payment {
    public void pay(Double amount, int transactionID) {
        System.out.println("The amount: " + amount + " already paid for the Transaction ID: " + transactionID);
        //saving data into database
        System.out.println("Data stored into databases");
    }
}
