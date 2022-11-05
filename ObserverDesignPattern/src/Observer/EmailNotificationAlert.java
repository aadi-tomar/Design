package Observer;

public class EmailNotificationAlert implements NotificationAlertObserver{

    public String emailId;
    public EmailNotificationAlert(String emailId){
        this.emailId = emailId;
    }
    @Override
    public void update() {
        sendMail(emailId);

    }
    private void sendMail(String emailId){
        System.out.println("Email has been sent to : " + emailId);
    }
}
