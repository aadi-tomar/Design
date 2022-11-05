import Observable.IphoneObservableImpl;
import Observer.EmailNotificationAlert;
import Observer.NotificationAlertObserver;
import Observer.PhoneNotificationAlert;

public class Store {


    public static void main(String args[]){
        IphoneObservableImpl iphoneObservable = new IphoneObservableImpl();
        NotificationAlertObserver phoneNotificationAlert = new PhoneNotificationAlert(23456);
        NotificationAlertObserver emailNotificationAlert = new EmailNotificationAlert("xyz@gmail.com");

        iphoneObservable.add(phoneNotificationAlert);
        iphoneObservable.add(emailNotificationAlert);

        iphoneObservable.setStockCount(20);
    }
}
