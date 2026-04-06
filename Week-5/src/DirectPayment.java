public class DirectPayment extends Payment {
    public void pay(double amount, int trancactionID) {
        System.out.println("the amount:" + amount + " already paid for the Transaction ID:" + trancactionID);
        //saving data into database
        System.out.println("Data stored into database");
    }
    
}
