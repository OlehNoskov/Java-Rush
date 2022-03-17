package ua.com.javarush.wat_notify;

import java.util.concurrent.CountDownLatch;

public class SecondSolution {

    private volatile boolean isWaitingForValue = true;

    CountDownLatch latch = new CountDownLatch(1);

    public void someMethod() throws InterruptedException {
        //ожидание сомоблокировки потока
        latch.await();
        retrieveValue();
        //Извещение о событии и уменьшение отсчета на единицу
        latch.countDown();
    }

    void retrieveValue() {
        System.out.println("Value retrieved.");
    }

    public static void main(String[] args) {

    }
}