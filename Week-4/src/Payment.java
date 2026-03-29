
public class Payment {
    protected double amount;
    
    public Payment (double amount) {
        this.amount = amount;
    }

    public void processPayment() {
        System.out.println("Processing payment...");
    }
}

class CreditCardPayment extends Payment {
    private String cardNumber;
    private String cardHolder;

    public CreditCardPayment(double amount, String cardNumber, String cardHolder) {
        super(amount);
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public void processPayment() {
        System.out.println("Paid $" + amount + " using Credit Card.");
        System.out.println("Card Holder: " + cardHolder);
        System.out.println("Card Number: " + cardNumber);
    }
}

class PayPalPayment extends Payment {
    private String email;

    public PayPalPayment(double amount, String email) {
        super(amount);
        this.email = email;
    }

    @Override
    public void processPayment() {
        System.out.println("Paid $" + amount + " using PayPal.");
        System.out.println("Email: " + email);
    }
}

class CryptoPayment extends Payment {
    private String walletAddress;

    public CryptoPayment(double amount, String walletAddress) {
        super(amount);
        this.walletAddress = walletAddress;
    }

    @Override
    public void processPayment() {
        System.out.println("Paid $" + amount + " using Cryptocurrency.");
        System.out.println("Wallet Address: " + walletAddress);
    }
}
