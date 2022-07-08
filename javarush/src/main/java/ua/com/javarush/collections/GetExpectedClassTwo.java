package ua.com.javarush.collections;

/* Найти класс - пакет - java.util.concurrent
   Реализует интерфейс BlockingQueue
   Используется при работе с тредами
   Является блокирующей очередью
   Не имеет внутренней емкости
*/

import java.util.concurrent.SynchronousQueue;

public class GetExpectedClassTwo {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        return SynchronousQueue.class;
    }
}