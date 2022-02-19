package ua.com.javarush.multithreading.inner_classes.black_box;

public abstract class FirstClass implements Action {

    protected  FirstClass() {
        Solution.countActionObjects++;
    }

    public void someAction() {
        System.out.println("class FirstClass, method someAction");
    }

    public abstract Action getDependantAction();
}