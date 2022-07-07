package ua.com.javarush.mvc.first_example;

public class View {
    private Controller controller = new Controller();

    public void fireShowDataEvent() {
        System.out.println(controller.onShowDataList());
    }
}