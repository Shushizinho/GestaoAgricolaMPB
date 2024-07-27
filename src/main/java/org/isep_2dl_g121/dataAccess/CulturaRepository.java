package org.isep_2dl_g121.dataAccess;

import oracle.jdbc.OracleTypes;
import org.isep_2dl_g121.domain.Cultura;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class CulturaRepository {
    public CulturaRepository() {
    }

    public List<Cultura> getCulturasByParcela(String parcela_nome,String produto_nome, Date data_operacao) throws SQLException {
        CallableStatement callStmt = null;
        ResultSet resultSet = null;
        List<Cultura> culturas = null;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            callStmt = connection.prepareCall("{ ? = call fnc_culturas_por_parcela(?,?,?) }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setString(2, parcela_nome);
            callStmt.setString(3, produto_nome);
            java.sql.Date sqlDate = new java.sql.Date(data_operacao.getTime());
            callStmt.setDate(4, sqlDate);


            callStmt.execute();
            resultSet = (ResultSet) callStmt.getObject(1);

            culturas = resultSetToList(resultSet);
        } finally {
            if(!Objects.isNull(callStmt)) {
                callStmt.close();
            }
            if(!Objects.isNull(resultSet)) {
                resultSet.close();
            }
        }

        return culturas;
    }

    public void culturaRegister(int sailorId, String name, int rating, Date birthday) throws SQLException {

        CallableStatement callStmt = null;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            callStmt = connection.prepareCall("{ call prcSailorRegister(?,?,?,?) }");

            callStmt.setInt(1, sailorId);
            callStmt.setString(2, name);
            callStmt.setInt(3, rating);
            java.sql.Date sqlDate = new java.sql.Date(birthday.getTime());
            callStmt.setDate(4, sqlDate);

            callStmt.execute();
            connection.commit();
        } finally {
            if(!Objects.isNull(callStmt)) {
                callStmt.close();
            }
        }
    }

    public int culturaDelete(int sailorId) throws SQLException {

        CallableStatement callStmt = null;
        int deletedRows = 0;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            callStmt = connection.prepareCall("{ ? = call fncSailorDelete(?) }");

            callStmt.registerOutParameter(1, OracleTypes.INTEGER);
            callStmt.setInt(2, sailorId);

            callStmt.execute();
            deletedRows = callStmt.getInt(1);

            connection.commit();

        } finally {
            if(!Objects.isNull(callStmt)) {
                callStmt.close();
            }
        }
        return deletedRows;
    }

    private List<Cultura> resultSetToList(ResultSet resultSet) throws SQLException {
        List<Cultura> culturas = new ArrayList<>();
        while (true) {
            if (!resultSet.next()) break;
            Cultura cultura = new Cultura(
                    resultSet.getInt("ID"),
                    resultSet.getInt("PARCELAAGRICOLAID"),
                    resultSet.getInt("PLANTAID"),
                    resultSet.getString("UNIDADE"),
                    resultSet.getDouble("QUANTIDADE"),
                    resultSet.getDate("DATA_INICIO"),
                    resultSet.getDate("DATA_FIM")
            );
            culturas.add(cultura);
        }
        return culturas;
    }

    public List<Cultura> getCulturasByParcelaOnly(String parcelaNome, Date dataOperacao) throws SQLException {
        CallableStatement callStmt = null;
        ResultSet resultSet = null;
        List<Cultura> culturas = null;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            callStmt = connection.prepareCall("{ ? = call fnc_culturas_por_parcela_sem_parcela(?,?) }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setString(2, parcelaNome);
            java.sql.Date sqlDate = new java.sql.Date(dataOperacao.getTime());
            callStmt.setDate(3, sqlDate);


            callStmt.execute();
            resultSet = (ResultSet) callStmt.getObject(1);

            culturas = resultSetToList(resultSet);

        } finally {
            if(!Objects.isNull(callStmt)) {
                callStmt.close();
            }
            if(!Objects.isNull(resultSet)) {
                resultSet.close();
            }
        }

        return culturas;

    }
}
