package ua.com.javarush.multithreading.marker_interface;

public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker{

    public void firstMethod(){
        System.out.println("First method!");
    }

    public void secondMethod(){
        System.out.println("Second method!");
    }
}
