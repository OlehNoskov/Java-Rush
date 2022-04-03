package ua.com.javarush.autoboxing.chainofresponsibility;

public class AbstractLogger implements Logger {
    int level;
    Logger next;

    public AbstractLogger(int level) {
        this.level = level;
    }

    @Override
    public void inform(String message, int level) {
        if (this.level <= level) {
            info(message);
        }
        if (next != null) {
            next.inform(message, level);
        }
    }

    @Override
    public void setNext(Logger next) {
        this.next = next;
    }

    @Override
    public void info(String message) {
        switch (level) {
            case Level.INFO -> System.out.println("Logging to console: " + message);
            case Level.WARN -> System.out.println("Send SMS to CEO: " + message);
            case Level.ERROR -> System.out.println("Logging to file: " + message);
            case Level.FATAL -> System.out.println("Call to director: " + message);
        }
    }
}