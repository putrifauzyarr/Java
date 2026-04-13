package notifications;

public interface Notification {
    void send(String Message);
    String formatMessage(String Message);
    boolean isValidReceiver(String Receiver);
}
