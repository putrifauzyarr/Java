package notifications;

public class EmailNotification implements Notification {
    private String email;
    
    public EmailNotification(String email) {
        this.email = email;
        if (!isValidReceiver(email)) {
            throw new IllegalArgumentException("Invalid email address");
        }
    }

    public void send(String Message) {
        System.out.println("Sending email to " + email + " with message " + Message);
    }

    public String formatMessage(String Message) {
        return "Email: " + email + "\nMessage: " + Message;
    }

    public boolean isValidReceiver(String Receiver) {
        return Receiver.contains("@");
    }
}
