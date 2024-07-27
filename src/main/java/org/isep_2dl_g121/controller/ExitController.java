package org.isep_2dl_g121.controller;

import org.isep_2dl_g121.dataAccess.DatabaseConnection;

import java.sql.SQLException;

public class ExitController {

    public ExitController(){
    }

    public void exit() throws SQLException {
        DatabaseConnection.getInstance().closeConnection();
    }
}
