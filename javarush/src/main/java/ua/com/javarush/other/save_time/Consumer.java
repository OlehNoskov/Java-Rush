package ua.com.javarush.other.save_time;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(450);
            while (true) {
                ShareItem item = queue.take();
                System.out.format("Processing " + item.toString() + "\n");
            }
        } catch (InterruptedException e) {
        }
    }
}