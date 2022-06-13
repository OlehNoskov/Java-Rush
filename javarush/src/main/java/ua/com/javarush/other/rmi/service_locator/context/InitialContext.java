package ua.com.javarush.other.rmi.service_locator.context;

import ua.com.javarush.other.rmi.service_locator.service.impl.EJBServiceImpl;
import ua.com.javarush.other.rmi.service_locator.service.impl.JMSServiceImpl;

public class InitialContext {
    public Object lookup(String jndiName) {

        if (jndiName.equalsIgnoreCase("EJBService")) {
            System.out.println("Looking up and creating a new EJBService object");
            return new EJBServiceImpl();
        } else if (jndiName.equalsIgnoreCase("JMSService")) {
            System.out.println("Looking up and creating a new JMSService object");
            return new JMSServiceImpl();
        }
        return null;
    }
}