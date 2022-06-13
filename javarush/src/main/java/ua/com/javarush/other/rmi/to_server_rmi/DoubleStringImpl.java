package ua.com.javarush.other.rmi.to_server_rmi;

import java.rmi.RemoteException;

public class DoubleStringImpl implements DoubleString{
    @Override
    public String doubleString(String str) throws RemoteException {
        return str + " " + str;
    }
}