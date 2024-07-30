import java.util.*;
class Logger {

    private static Logger instance;

   // private Logger() {
    //}

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }


    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

public class Main {
    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();


        logger1.log("The first log message");
        logger2.log("The second log message");


        if (logger1 == logger2) {
            System.out.println("Logger is a singleton: Both references point to the same instance");
        } else {
            System.out.println("Logger is not a singleton: Both references point to the different instances");
        }
    }
}
