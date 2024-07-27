package org.isep_2dl_g121.ui;

import org.isep_2dl_g121.dataAccess.DatabaseConnection;
import org.isep_2dl_g121.ui.menu.MainMenuUI;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

public class DataBaseLink {

    public static void link() {
        try {
            loadProperties();

            String ipAddress = System.getProperty("database.inet");
            InetAddress inet = InetAddress.getByName(ipAddress);

            MainMenuUI menu = new MainMenuUI();
            menu.run();

        } catch (UnknownHostException e) {
            System.out.println("\nDatabase Server not reachable!");
        } catch (Exception e) {
            System.out.println("App properties not loaded!");
        }
    }

    private static void loadProperties() throws IOException {
        Properties properties = new Properties(System.getProperties());

        InputStream inputStream = new DataBaseLink().getClass().getClassLoader().getResourceAsStream("application.properties");
        properties.load(inputStream);
        inputStream.close();

        System.setProperties(properties);
    }

}
