import payments.*;
import notifications.*;

public class App {
    public static void main(String[] args) {
        Payment adam = new CashPayment();
        adam.pay(1000000.00, 1001);
        Notification email = new EmailNotification("adam@gmail.com");
        email.send(email.formatMessage("Payment successful!"));

        Payment willi = new EWalletPayment("Gopay", "+628123456789");
        willi.pay(1000000.00, 1002);
        Notification whatsapp = new WhatsAppNotification("+628123456789");
        whatsapp.send(whatsapp.formatMessage("Payment successful!"));

        Payment zya = new BankPayment("BNI", "20202020");
        zya.pay(1000000.00, 1003);
        Notification sms = new SMSNotification("+628987654321");
        sms.send(sms.formatMessage("Payment successful!"));
    }
}