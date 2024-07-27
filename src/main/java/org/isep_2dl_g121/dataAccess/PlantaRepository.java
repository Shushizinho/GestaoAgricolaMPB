package org.isep_2dl_g121.dataAccess;

import oracle.jdbc.OracleTypes;
import org.isep_2dl_g121.domain.Planta;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlantaRepository {
    public List<Planta> getPlantas() throws SQLException {

        CallableStatement callStmt = null;
        ResultSet resultSet = null;
        List<Planta> plantas = null;

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            callStmt = connection.prepareCall("{ ? = call fncSailors() }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);

            callStmt.execute();
            resultSet = (ResultSet) callStmt.getObject(1);

            plantas = resultSetToList(resultSet);
        } finally {
            if(!Objects.isNull(callStmt)) {
                callStmt.close();
            }
            if(!Objects.isNull(resultSet)) {
                resultSet.close();
            }
        }

        return plantas;
    }

    private List<Planta> resultSetToList(ResultSet resultSet) throws SQLException {
        List<Planta> plantas = new ArrayList<>();
        while (true) {
            if (!resultSet.next()) break;
            Planta planta = new Planta(
                    resultSet.getInt("ID"),
                    resultSet.getString("Espécie"),
                    resultSet.getString("Nome"),
                    resultSet.getString("Tipo")

            );
            plantas.add(planta);
        }
        return plantas;
    }
}
