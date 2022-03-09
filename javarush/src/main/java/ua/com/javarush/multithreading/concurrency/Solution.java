package ua.com.javarush.multithreading.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Solution {

    protected Lock lock = new ReentrantLock();

    public void someMethod() {
        if (lock.tryLock()) { //Пытаемся захватить lock
            try { //Если lock свободен
                actionIfLockIsFree();
            } finally {
                lock.unlock(); //Отпустить lock в любом случае
            }
        } else { //Если lock занят
            actionIfLockIsBusy();
        }
    }

    public void actionIfLockIsFree() {
    }

    public void actionIfLockIsBusy() {
    }
}