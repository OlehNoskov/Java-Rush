package ua.com.javarush.other.rmi.server_rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Solution {
    public static Registry registry;

    // Pretend we're starting an RMI client as the CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                for (String bindingName : registry.list()) {
                    Animal service = (Animal) registry.lookup(bindingName);
                    service.printName();
                    service.speak();
                }
            } catch (RemoteException | NotBoundException e) {
                e.printStackTrace();
            }
        }
    });

    // Pretend we're starting an RMI server as the SERVER_THREAD thread
    public static Thread SERVER_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                //создание реестра расшаренных обьектов
                registry = LocateRegistry.createRegistry(2099);

                //создание обьетов для удаленного доступа
                final Animal dog = new Dog("Lora");
                final Animal cat = new Cat("Belia");

                //создание заглушки приемника удаленных вызовов
                Remote stubDog = UnicastRemoteObject.exportObject(dog,0);
                //регистрация заглушки в реестре
                registry.bind("dog",dog);

                Remote stubCat = UnicastRemoteObject.exportObject(cat,0);
                //регистрация заглушки в реестре
                registry.bind("cat",cat);

            } catch (RemoteException | AlreadyBoundException e) {
                e.printStackTrace();
            }
        }
    });

    public static void main(String[] args) throws InterruptedException {
        // Starting an RMI server thread
        SERVER_THREAD.start();
        Thread.sleep(1000);
        // Start the client
        CLIENT_THREAD.start();
    }
}