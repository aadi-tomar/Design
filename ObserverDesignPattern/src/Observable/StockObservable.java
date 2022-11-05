package Observable;

import Observer.NotificationAlertObserver;

public interface StockObservable {
    public void add(NotificationAlertObserver notificationAlertObserver);

    public  void remove(NotificationAlertObserver notificationAlertObserver);

    public  void notifySubscribers();

    public void setStockCount(int stockCount);
}
