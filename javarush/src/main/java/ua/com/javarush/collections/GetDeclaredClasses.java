package ua.com.javarush.collections;

import java.util.concurrent.DelayQueue;

/* DelayQueue - Реализует Queue, используется при работе с тредами!
   У него есть очень полезная характеристика —
   когда потребитель хочет взять элемент из очереди,
   он может взять его только тогда, когда истечет
   задержка для этого конкретного элемента.
 */

public class GetDeclaredClasses {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
       return DelayQueue.class;
    }
}