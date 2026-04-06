public class App {
    public static void main(String[] args) throws Exception {
        BankAccount xw = new BankAccount(100000, "123456789", "BCA");
        xw.deposit(500000);
        xw.withdraw(120000);
        System.out.println(xw);

        Payment ronaldo = new DirectPayment();
        ronaldo.pay(1000000.00,11);

        Payment kudak = new BankPayment(" BNI", "20202020");
        kudak.pay(1000000.00,12);
    }
}