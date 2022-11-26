import java.io.Serial;
import java.io.Serializable;

public class Logger implements Cloneable, Serializable {

    private volatile static Logger logger;
    private volatile static AbstractLogger chainOfLogger;

    private Logger () {
        if( logger != null) {
            throw new IllegalStateException();
        }
    }

    public static  Logger getInstance (){
        if( logger == null){
            synchronized (Logger.class){
                if( logger == null){
                    logger = new Logger();
                    chainOfLogger = LogManager.buildChainOfLogger();
                }
            }
        }
        return  logger;

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @Serial
    protected Object readResolve(){
        return logger;
    }

    public void info(String msg){
        createLog(1, msg);
    }

    public void debug(String msg){
        createLog(3, msg);
    }
    public void error(String msg){
        createLog(2, msg);
    }

    private void createLog(int level, String msg) {
        chainOfLogger.logMessage(level, msg);
    }
}
