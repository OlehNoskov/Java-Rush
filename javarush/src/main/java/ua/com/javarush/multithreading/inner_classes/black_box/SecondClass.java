package ua.com.javarush.multithreading.inner_classes.black_box;

public abstract class SecondClass implements Action {

    public static String SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM = "\nSpecific action for anonymous SecondClass, param = ";

    private static String SECOND_CLASS_METHOD_STRING = "class SecondClass, method someAction";

    public SecondClass() {
        Solution.countActionObjects++;
    }

    protected StringBuilder sb = new StringBuilder(SECOND_CLASS_METHOD_STRING);

    public void someAction() {
        System.out.println(sb.toString());
    }
}