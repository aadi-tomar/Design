package Observer;

public class PhoneNotificationAlert implements NotificationAlertObserver{

    int phoneNo;

    public PhoneNotificationAlert(int phoneNo){
        this.phoneNo = phoneNo;
    }

    @Override
    public void update() {

        sendMessage(phoneNo);

    }
    private  void sendMessage(int phoneNo){
        System.out.println(  "Message has been sent to " + phoneNo);
    }
}
