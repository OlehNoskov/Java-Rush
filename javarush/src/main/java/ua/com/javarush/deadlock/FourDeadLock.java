package ua.com.javarush.deadlock;

public class FourDeadLock {

    public void safeMethod(Object obj1, Object obj2) {
        int lock1 = obj1.hashCode();
        int lock2 = obj2.hashCode();
        Object max = lock1 > lock2 ? obj1:obj2;
        Object min = lock1 < lock2 ? obj2:obj1;
        synchronized (max) {
            longTimeMethod();
            synchronized (min) {
                unsafeMethod(obj1, obj2);
            }
        }
    }

    public void longTimeMethod() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
    }

    protected void unsafeMethod(Object obj1, Object obj2) {
        System.out.println(obj1 + " " + obj2);
    }

    public static void main(String[] args) {
        final Object o1 = new Object();
        final Object o2 = new Object();
        final FourDeadLock solution = new FourDeadLock();

        new Thread() {
            @Override
            public void run() {
                solution.safeMethod(o1, o2);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                solution.safeMethod(o2, o1);
            }
        }.start();
    }
}
