package org.isep_2dl_g121.controller;
import org.isep_2dl_g121.dataAccess.DatabaseConnection;

import java.sql.SQLException;

public class DatabaseConnectionTestController {

    public DatabaseConnectionTestController() {
    }

    public int DatabaseConnectionTest() throws SQLException {
        int testResult = DatabaseConnection.getInstance().testConnection();
        return testResult;
    }
}
