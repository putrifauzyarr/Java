import payments.*;

public class App {
    public static void main(String[] args) {
        Payment adam = new CashPayment();
        adam.pay(1000000.00, 1001);

        Payment willi = new EWalletPayment("Gopay", "08123456789");
        willi.pay(1000000.00, 1002);
        
        Payment zya = new BankPayment("BNI", "20202020");
        zya.pay(1000000.00, 1003);
    }
}