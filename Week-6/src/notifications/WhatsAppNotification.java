package notifications;

public class WhatsAppNotification implements Notification {
    private String phoneNumber;

    public WhatsAppNotification(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        if (!isValidReceiver(phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number");
        }
    }   

    public void send(String Message) {
        System.out.println("Sending WhatsApp message to " + phoneNumber + " with message " + Message);
    }

    public String formatMessage(String Message) {
        return "WhatsApp: " + phoneNumber + "\nMessage: " + Message;
    }

    public boolean isValidReceiver(String Receiver) {
        return Receiver.contains("+62");
    }
}
