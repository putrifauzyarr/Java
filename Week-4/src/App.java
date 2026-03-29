import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Payment> payments = new ArrayList<>();
        Payment p1 = new CreditCardPayment(100.0, "1234-5678-9999", "Putri");
        Payment p2 = new PayPalPayment(50.0, "Putri123@gmail.com");
        Payment p3 = new CryptoPayment(200.0, "123Abcd");
        Payment p4 = new PayPalPayment(50.0, "Zya123@gmail.com");

        payments.add(p1);
        payments.add(p2);
        payments.add(p3);
        payments.add(p4);

        for (Payment p : payments) {
            p.processPayment();

System.out.println("----------------------");
        }
    }
}