package org.isep_2dl_g121.dataAccess;

import oracle.jdbc.OracleTypes;
import org.isep_2dl_g121.domain.FatorProducao;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FatorProducaoRepository {
    public List<FatorProducao> getFatoresProducao() throws SQLException {

        CallableStatement callStmt = null;
        ResultSet resultSet = null;
        List<FatorProducao> fatoresProducao = null;

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            callStmt = connection.prepareCall("{ ? = call fncSailors() }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);

            callStmt.execute();
            resultSet = (ResultSet) callStmt.getObject(1);

            fatoresProducao = resultSetToList(resultSet);
        } finally {
            if(!Objects.isNull(callStmt)) {
                callStmt.close();
            }
            if(!Objects.isNull(resultSet)) {
                resultSet.close();
            }
        }

        return fatoresProducao;
    }

    private List<FatorProducao> resultSetToList(ResultSet resultSet) throws SQLException {
        List<FatorProducao> fatoresProducao = new ArrayList<>();
        while (true) {
            if (!resultSet.next()) break;
            FatorProducao fatorProducao = new FatorProducao(
                    resultSet.getInt("ID"),
                    resultSet.getString("Nome Comercial"),
                    resultSet.getString("Formulação"),
                    resultSet.getString("Fabricante"),
                    resultSet.getString("Tipo de Fator Produção"),
                    resultSet.getString("Aplicação")
            );
            fatoresProducao.add(fatorProducao);
        }
        return fatoresProducao;
    }

}
