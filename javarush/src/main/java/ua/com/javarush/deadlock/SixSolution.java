package ua.com.javarush.deadlock;

public class SixSolution {

    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    private static volatile boolean flag = false;
    private static volatile boolean isInnerThreadBlocked = false;

    public static boolean isLockOrderNormal(final SixSolution solution, final Object o1, final Object o2) throws Exception {
        //do something here
        synchronized (o1) {
            Thread outerThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Thread innerThread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            solution.someMethodWithSynchronizedBlocks(o1, o2);
                        }
                    });
                    innerThread.start();

                    while (innerThread.getState() != Thread.State.BLOCKED) ;
                    isInnerThreadBlocked = true;
                    synchronized (o2) {
                        flag = true;
                    }
                }
            });
            outerThread.setDaemon(true);
            outerThread.start();

            while (!isInnerThreadBlocked) {
                Thread.sleep(1);
            }
            while (outerThread.getState() != Thread.State.BLOCKED && outerThread.isAlive()) {
                Thread.sleep(1);
            }
        }
        return flag;
    }

    public static void main(String[] args) throws Exception {
        final SixSolution solution = new SixSolution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}