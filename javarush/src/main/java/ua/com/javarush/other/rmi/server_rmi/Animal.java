package ua.com.javarush.other.rmi.server_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Animal extends Remote {
    void speak() throws RemoteException;
    void printName() throws RemoteException;
}
