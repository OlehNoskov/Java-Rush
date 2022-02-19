package ua.com.javarush.multithreading.marker_interface;

public class UnsupportedInterfaceMarkerException extends Exception{

    public UnsupportedInterfaceMarkerException(String message) {
        super(message);
    }
}
