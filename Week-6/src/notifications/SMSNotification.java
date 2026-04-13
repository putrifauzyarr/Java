package notifications;

public class SMSNotification implements Notification {
    private String phoneNumber;

    public SMSNotification(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        if (!isValidReceiver(phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number");
        }
    }   

    public void send(String Message) {
        System.out.println("Sending SMS to " + phoneNumber + " with message: " + Message);
    }

    public String formatMessage(String Message) {
        return "SMS to: " + phoneNumber + "\nMessage: " + Message;
    }

    public boolean isValidReceiver(String Receiver) {
        return Receiver.contains("+62");
    }
}