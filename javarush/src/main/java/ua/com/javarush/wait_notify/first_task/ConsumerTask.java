package ua.com.javarush.wait_notify.first_task;

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