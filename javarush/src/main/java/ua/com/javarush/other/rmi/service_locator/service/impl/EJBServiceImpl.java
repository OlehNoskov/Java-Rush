package ua.com.javarush.other.rmi.service_locator.service.impl;

import ua.com.javarush.other.rmi.service_locator.service.Service;

public class EJBServiceImpl implements Service {
    @Override
    public void execute() {
        System.out.println("Executing the EJBService");
    }

    @Override
    public String getName() {
        return "EJBService";
    }
}