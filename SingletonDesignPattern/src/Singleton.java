import java.io.Serial;
import java.io.Serializable;

public class Singleton implements Cloneable, Serializable {

    private static volatile Singleton singletonObject;

    private Singleton() throws IllegalAccessException {

        //It prevents new object creation through Reflection.
        if(singletonObject !=null)
            throw new IllegalAccessException(" Object already created");
    }

    public static Singleton getInstance() throws IllegalAccessException {

        if(singletonObject == null){
            synchronized (Singleton.class){
                if(singletonObject == null){
                    singletonObject = new Singleton();
                }
            }
        }

        return singletonObject;
    }


    //It prevents new object Creation through Cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    // it prevents new object creation through serialization/deserialization.
    @Serial
    protected Object readResolve(){
        return singletonObject;
    }

    /*
    public static Singleton getInstance(){
        if( singletonObject == null){
            singletonObject = new Singleton();
        }
        return singletonObject;
    }*/
}
