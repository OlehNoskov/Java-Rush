package ua.com.javarush.multithreading.synchonizedes;

public class ThreadSafe {

    public static void main(String[] args) {

    }

    public static class IntegerHolder{
        private int value;

        public synchronized void setValue(int value) {
            this.value = value;
        }

        public synchronized int getValue() {
            return value;
        }
    }
}