package ua.com.javarush.other.interface_wont_help;

public class SecuritySystem implements SwitchTable {
    private boolean on = false;

    @Override
    public boolean isOn() {
        return on;
    }
    @Override
    public void turnOff() {
        System.out.println("Turning off the SecuritySystem!");
        on = false;
    }
    @Override
    public void turnOn() {
        System.out.println("Turning on the SecuritySystem!");
        on = true;
    }
}