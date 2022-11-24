package LeakyBucket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Applicationj {

    public static void main(String[] args) {

         UserBucketCreator userBucketCreator = new UserBucketCreator(1);
        /*
         for(int i=0; i< 15; i++){
             userBucketCreator.accessApplication(1);
         }*/

        ExecutorService executorService = Executors.newFixedThreadPool(12);
        for(int i=0; i< 12; i++) {
            executorService.execute(() -> userBucketCreator.accessApplication(1));
        }
        executorService.shutdown();

    }

}
