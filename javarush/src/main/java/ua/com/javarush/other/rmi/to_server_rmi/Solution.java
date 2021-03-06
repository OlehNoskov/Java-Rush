package ua.com.javarush.other.rmi.to_server_rmi;

import javax.imageio.spi.ServiceRegistry;
import javax.mail.Service;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

//К серверу по RMI
public class Solution {
    public static final String UNIC_BINDING_NAME = "double.string";
    public static Registry registry;

    // Pretend we're starting an RMI client as the CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                DoubleString doubleString = (DoubleString) registry.lookup(UNIC_BINDING_NAME);
                String result = doubleString.doubleString("Oleg is cool!");
                System.out.println(result);

            } catch (RemoteException | NotBoundException e) {
                e.printStackTrace();
            }
        }
    });

    public static void main(String[] args) {
        // Pretend we're starting an RMI server as the main thread
        Remote stub = null;
        try {
            //создание реестра для расшаренных обьектов
            registry = LocateRegistry.createRegistry(2099);

            //создание обьекта для удаленного доступа
            final DoubleStringImpl service = new DoubleStringImpl();

            //создание заглушки - приемника удаленных вызовов
            stub = UnicastRemoteObject.exportObject(service, 0);

            //регистрация заглушки в реестре
            registry.bind(UNIC_BINDING_NAME, stub);
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }

        // Start the client
        CLIENT_THREAD.start();
    }
}