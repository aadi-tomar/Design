public abstract class AbstractLogger {

    int level;
    AbstractLogger nextAbstractLogger;

    public void setNextLoggingLevel(AbstractLogger nextAbstractLogger) {
        this.nextAbstractLogger = nextAbstractLogger;
    }

    void logMessage(int level, String msg){
        if( this.level <= level){
            display(msg);
        }
        if(nextAbstractLogger != null){
            nextAbstractLogger.logMessage(level, msg);

        }
    }


    protected abstract void display(String msg);

}
