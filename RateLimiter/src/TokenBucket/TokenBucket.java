package TokenBucket;

import LeakyBucket.RateLimiter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TokenBucket implements RateLimiter {
    private int bucketCapacity;
    private int refreshRate;
    private AtomicInteger currentCapacity;
    private AtomicLong lastUpdatedTime;

    public TokenBucket(int bucketCapacity, int refreshRate){
        this.bucketCapacity = bucketCapacity;
        this.refreshRate = refreshRate;
        currentCapacity = new AtomicInteger(bucketCapacity);
        lastUpdatedTime = new AtomicLong(System.currentTimeMillis());
    }

    @Override
    public boolean grantAccess() {

        refreshBucket();
        if(currentCapacity.get() > 0){
            currentCapacity.decrementAndGet();
            return true;
        }

        return false;
    }

    private void refreshBucket(){

        long currTime = System.currentTimeMillis();
        int additionalToken = (int)((currTime - lastUpdatedTime.get())/1000)*refreshRate ;
        int currCapacity = Math.min(additionalToken + currentCapacity.get() , bucketCapacity);
        currentCapacity.getAndSet(currCapacity);
        lastUpdatedTime.getAndSet(currTime);

    }
}
