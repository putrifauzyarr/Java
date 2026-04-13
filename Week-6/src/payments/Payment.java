package payments;

public abstract class Payment {
    protected Double amount;
    protected int transactionID;

    public abstract void pay(Double amount, int transactionID);

    public String toString() {
        return "Payment{" +
                "amount=" + amount +
                ", transactionID=" + transactionID +
                '}';
    }

    public Double getAmount() {
        return amount;
    }

    public int getTransactionID() {
        return transactionID;
    }           
}