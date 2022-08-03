package ua.com.javarush.other.interface_wont_help;

public class LightBulb implements SwitchTable {

    private boolean on = false;

    @Override
    public boolean isOn() {
        return on;
    }

    @Override
    public void turnOff() {
        System.out.println("The light is off!");
        on = false;
    }

    @Override
    public void turnOn() {
        System.out.println("The light is on!");
        on = true;
    }
}