package ua.com.javarush.multithreading.big_task_refactoring.human;

public class BloodGroup {

    private final int CODE;

    public BloodGroup(int code) {
        this.CODE = code;
    }

    public int getCode() {
        return CODE;
    }

    public static BloodGroup first(){
        return new BloodGroup(1);
    }

    public static BloodGroup second(){
        return new BloodGroup(2);
    }

    public static BloodGroup third(){
        return new BloodGroup(3);
    }

    public static BloodGroup fourth(){
        return new BloodGroup(5);
    }
}