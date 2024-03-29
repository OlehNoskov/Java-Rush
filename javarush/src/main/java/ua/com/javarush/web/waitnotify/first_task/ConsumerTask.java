package ua.com.javarush.web.waitnotify.first_task;

public class ConsumerTask implements Runnable {
    private TransferObject transferObject;
    protected volatile boolean stopped;

    public ConsumerTask(TransferObject transferObject) {
        this.transferObject = transferObject;
        new Thread(this, "ConsumerTask").start();
    }

    public void run() {
            while (!stopped) {
                transferObject.get();
        }
    }

    public void stop() {
        stopped = true;
    }
}