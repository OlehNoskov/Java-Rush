package ua.com.javarush.other.rmi.service_locator.service.impl;

import ua.com.javarush.other.rmi.service_locator.service.Service;

public class JMSServiceImpl implements Service {
    @Override
    public void execute() {
        System.out.println("Executing the JMSService");
    }

    @Override
    public String getName() {
        return "JMSService";
    }
}