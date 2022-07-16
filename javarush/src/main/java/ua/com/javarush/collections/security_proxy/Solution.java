package ua.com.javarush.collections.security_proxy;

import ua.com.javarush.collections.security_proxy.connectors.Connector;
import ua.com.javarush.collections.security_proxy.connectors.SecurityProxyConnector;
import ua.com.javarush.collections.security_proxy.connectors.SimpleConnector;

public class Solution {
    public static void main(String[] args) {
        Connector securityProxyConnector = new SecurityProxyConnector("google.com");
        Connector simpleConnector = new SimpleConnector("javarush.ru");

        System.out.println("Connecting with SimpleConnector...");
        simpleConnector.connect();

        System.out.println("----------------------------------------------------");

        System.out.println("Connecting with SecurityProxyConnector...");
        securityProxyConnector.connect();
    }
}