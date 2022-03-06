package ua.com.javarush.multithreading.threads.second_task;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

public interface CancellableTask <T> extends Callable<T> {

    void cancel();

    RunnableFuture<T> newTask();
}