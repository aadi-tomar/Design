package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class UserBucketCreator {

    Map<Integer, SlidingWindow> bucket;

    public UserBucketCreator(int id) {
        bucket = new HashMap<>();
        bucket.put(id, new SlidingWindow(1, 10));
    }

    public void accessApplication(int id){
        if( bucket.get(id).grantAccess()){
            System.out.println(Thread.currentThread().getName() + " - access successful " + System.currentTimeMillis());
        }
        else{
            System.out.println(Thread.currentThread().getName() + " - Too many requests!! Please try after sometime " + System.currentTimeMillis());
        }
    }
}
