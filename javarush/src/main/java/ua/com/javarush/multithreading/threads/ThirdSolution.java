package ua.com.javarush.multithreading.threads;

public class ThirdSolution {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new ThirdSolution().new MyThread("super secret key");
        myThread.start();
    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
//            setDaemon(true);
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }

        private class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {

            public MyUncaughtExceptionHandler() {
            }

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    String exception = String.format("%s, %s, %s",
                            MyThread.this.secretKey, t.getName(), e.getMessage());
                    System.out.println(exception);
                }
            }
        }
    }
}