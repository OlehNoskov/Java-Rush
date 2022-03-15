package ua.com.javarush.deadlock;

public class ThirdDeadLock {

    private final String field;

    public ThirdDeadLock(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public synchronized void sout(ThirdDeadLock solution) {
        System.out.format("111:  %s: %s %n", this.field, solution.getField());
        solution.sout2(this);
    }

    public synchronized void sout2(ThirdDeadLock solution) {
        System.out.format("222:  %s: %s %n", this.field, solution.getField());
        solution.sout(this);
    }

    public static void main(String[] args) {
        final ThirdDeadLock solution = new ThirdDeadLock("first");
        final ThirdDeadLock solution2 = new ThirdDeadLock("second");
        new Thread(new Runnable() {
            public void run() {
                solution.sout(solution2);
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                solution2.sout(solution);
            }
        }).start();

    }
}