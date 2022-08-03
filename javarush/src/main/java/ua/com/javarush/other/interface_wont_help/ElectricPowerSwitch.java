package ua.com.javarush.other.interface_wont_help;

public class ElectricPowerSwitch {
    private SwitchTable switchTable;

    public ElectricPowerSwitch(SwitchTable switchTable) {
        this.switchTable = switchTable;
    }

    public void press() {
        System.out.println("Power switch flipped.");
        if (switchTable.isOn()) {
            switchTable.turnOff();
        } else {
            switchTable.turnOn();
        }
    }
}