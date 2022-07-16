package ua.com.javarush.collections.security_proxy.connectors;

import ua.com.javarush.collections.security_proxy.security.SecurityChecker;
import ua.com.javarush.collections.security_proxy.security.SecurityCheckerImpl;

public class SecurityProxyConnector implements Connector {
    private SecurityChecker securityChecker = new SecurityCheckerImpl();
    private SimpleConnector connector;

    public SecurityProxyConnector(String resourceString) {
        this.connector = new SimpleConnector(resourceString);
    }

    @Override
    public void connect() {
        if (securityChecker.performSecurityCheck()) {
            connector.connect();
        } else {
            System.out.println("FAILED SECURITY CHECK, WON'T CONNECT!");
        }
    }
}