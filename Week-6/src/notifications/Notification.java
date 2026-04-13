package notifications;

public interface Notification {
    void send(String message);
    String formatMessage(String Message);
    boolean isValidReceiver(String Receiver);
}
