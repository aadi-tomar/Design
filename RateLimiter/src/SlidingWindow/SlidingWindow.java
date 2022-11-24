package SlidingWindow;

import LeakyBucket.RateLimiter;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SlidingWindow implements RateLimiter {

    Queue<Long> slidingWindow;
    int timeWindowInSeconds;
    int bucketCapacity;

    public SlidingWindow(int timeWindowInSeconds, int bucketCapacity) {
        this.timeWindowInSeconds = timeWindowInSeconds;
        this.bucketCapacity = bucketCapacity;
        slidingWindow = new ConcurrentLinkedQueue<>();
    }

    @Override
    public boolean grantAccess() {
        long currTime = System.currentTimeMillis();
        checkAndUpdateQueue(currTime);
        if( slidingWindow.size() < bucketCapacity ){
            slidingWindow.add(currTime);
            return true;
        }
        return false;
    }

    private void checkAndUpdateQueue(long currTime) {
        if(slidingWindow.isEmpty())
            return;
        long calTime = (currTime - slidingWindow.peek())/1000;
        System.out.println(calTime);
        while( calTime > timeWindowInSeconds){
            slidingWindow.remove();
            if(slidingWindow.isEmpty())
                break;
            calTime = (currTime - slidingWindow.peek())/1000;
        }

    }
}
