package Observable;

import Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable{

    List< NotificationAlertObserver > notificationAlertObserverList = new ArrayList<>();
    int currStockCount =0;

    @Override
    public void add(NotificationAlertObserver notificationAlertObserver) {
        notificationAlertObserverList.add(notificationAlertObserver);
    }

    @Override
    public void remove(NotificationAlertObserver notificationAlertObserver) {
        notificationAlertObserverList.remove(notificationAlertObserver);
    }

    @Override
    public void notifySubscribers() {
        for(NotificationAlertObserver notificationAlertObserver : notificationAlertObserverList){
            notificationAlertObserver.update();
        }
    }

    @Override
    public void setStockCount(int stockCount) {
        if(currStockCount == 0){
            notifySubscribers();
        }
        currStockCount += stockCount;
    }
}
