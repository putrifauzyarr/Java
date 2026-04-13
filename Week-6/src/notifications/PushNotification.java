package notifications;

public class PushNotification implements Notification {
    private String username;

    public PushNotification(String username) {
        this.username = username;
    }

    public void send(String Message) {
        System.out.println(formatMessage(Message));
    }

    public String formatMessage(String Message) {
        return "[PUSH] User: " + username + " | Message: " + Message;
    }

    public boolean isValidReceiver(String Receiver) {
        return Receiver != null && !Receiver.isEmpty();
    }
}