package org.isep_2dl_g121.dataAccess;

import oracle.jdbc.OracleTypes;
import org.isep_2dl_g121.domain.OperacaoAgricola;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class OperacaoAgricolaRepository {

    public OperacaoAgricolaRepository() {
    }

    public List<OperacaoAgricola> getOperacoesAgricolas() throws SQLException {

        //NOT READY TO USE YET

        CallableStatement callStmt = null;
        ResultSet resultSet = null;
        List<OperacaoAgricola> sailors = null;

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            callStmt = connection.prepareCall("{ ? = call fncSailors() }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);

            callStmt.execute();
            resultSet = (ResultSet) callStmt.getObject(1);

            sailors = resultSetToList(resultSet);
        } finally {
            if(!Objects.isNull(callStmt)) {
                callStmt.close();
            }
            if(!Objects.isNull(resultSet)) {
                resultSet.close();
            }
        }

        return sailors;
    }


    private List<OperacaoAgricola> resultSetToList(ResultSet resultSet) throws SQLException {
        List<OperacaoAgricola> operacoesAgricolas = new ArrayList<>();
        while (true) {
            if (!resultSet.next()) break;
            OperacaoAgricola operacaoAgricola = new OperacaoAgricola(
                    resultSet.getInt("ID"),
                    resultSet.getString("Tipo de Operação"),
                    resultSet.getInt("Caderno de Campo ID"),
                    resultSet.getDate("Data de Realização"),
                    resultSet.getDouble("Quantidade"),
                    resultSet.getString("Unidade designação"),
                    resultSet.getInt("Cultura ID"),
                    resultSet.getInt("Parcela Agricola ID")

            );
            operacoesAgricolas.add(operacaoAgricola);
        }
        return operacoesAgricolas;
    }

    public void OperacaoAgricolaRegisterSemeadura(String tipo_operacao, int id_caderno_campo, Date
            data_operacao, double quantidade_operacao, String unidade_operacao, double quantidade_cultura,  String unidade_cultura, String planta_nome, String parcela_nome) throws SQLException {

        CallableStatement callStmt = null;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            callStmt = connection.prepareCall("{ call prc_create_operacao_agricola_semeadura(?,?,?,?,?,?,?,?,?) }");


            callStmt.setString(1, tipo_operacao);
            callStmt.setInt(2, id_caderno_campo);
            java.sql.Date sqlDate = new java.sql.Date(data_operacao.getTime());
            callStmt.setDate(3, sqlDate);
            callStmt.setDouble(4, quantidade_operacao);
            callStmt.setString(5, unidade_operacao);
            callStmt.setDouble(6, quantidade_cultura);
            callStmt.setString(7, unidade_cultura);
            callStmt.setString(8, planta_nome);
            callStmt.setString(9, parcela_nome);

            callStmt.execute();
            connection.commit();
        } finally {
            if(!Objects.isNull(callStmt)) {
                callStmt.close();
            }
        }
    }




    public void OperacaoAgricolaRegisterMonda(String tipo_operacao, int id_caderno_campo, Date
            data_operacao, double quantidade_operacao, String unidade_operacao, String parcela, String produto_agricola_nome, String tipo) throws SQLException {

        CallableStatement callStmt = null;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();

            callStmt = connection.prepareCall("{ call pro_create_operacao_agricola_monda(?,?,?,?,?,?,?,?) }");

            callStmt.setString(1, tipo_operacao);
            callStmt.setInt(2, id_caderno_campo);
            java.sql.Date sqlDate = new java.sql.Date(data_operacao.getTime());
            callStmt.setDate(3, sqlDate);
            callStmt.setDouble(4, quantidade_operacao);
            callStmt.setString(5, unidade_operacao);
            callStmt.setString(6, parcela);
            callStmt.setString(7, produto_agricola_nome);
            callStmt.setString(8, tipo);


            callStmt.execute();
            connection.commit();
        } finally {
            try {
                if(!Objects.isNull(callStmt) && !callStmt.isClosed()) {
                    callStmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void OperacaoAgricolaRegisterColheita(String tipo_operacao, int id_caderno_campo, Date
            data_operacao, String parcela_nome, String produto_agricola_nome,int cultura_id, int quantidade_produto, String unidade_produto ) throws SQLException {

        CallableStatement callStmt = null;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            callStmt = connection.prepareCall("{ call pro_create_operacao_agricola_colheita(?,?,?,?,?,?,?,?) }");


            callStmt.setString(1, tipo_operacao);
            callStmt.setInt(2, id_caderno_campo);
            java.sql.Date sqlDate = new java.sql.Date(data_operacao.getTime());
            callStmt.setDate(3, sqlDate);
            callStmt.setString(4, parcela_nome);
            callStmt.setString(5, produto_agricola_nome);
            callStmt.setInt(6, cultura_id);
            callStmt.setInt(7, quantidade_produto);
            callStmt.setString(8, unidade_produto);

            callStmt.execute();
            connection.commit();

        } finally {
            try {
                if(!Objects.isNull(callStmt) && !callStmt.isClosed()) {
                    callStmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }



    public void OperacaoRegisterRega(String DesignacaoSetor , int id_caderno_campo, Date
            data_operacao, String hora_inicio,int duracao, int mistura) throws SQLException {

        CallableStatement callStmt = null;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();


            if(mistura != -1) {
                callStmt = connection.prepareCall("{ call pro_create_operacao_rega(?,?,?,?,?,?) }");
                callStmt.setInt(6, mistura);
            }
            else callStmt = connection.prepareCall("{ call pro_create_operacao_rega(?,?,?,?,?) }");


            callStmt.setString(1, DesignacaoSetor);
            callStmt.setInt(2, id_caderno_campo);
            java.sql.Date sqlDate = new java.sql.Date(data_operacao.getTime());
            callStmt.setDate(3, sqlDate);
            callStmt.setString(4, hora_inicio);
            callStmt.setInt(5, duracao);

            callStmt.execute();
            connection.commit();

        } finally {
            try {
                if(!Objects.isNull(callStmt) && !callStmt.isClosed()) {
                    callStmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }


    public void OperacaoAgricolaRegisterFatorProducao(int idCadernoCampo, Date dataOperacao, double quantidadeOperacao, String unidadeOperacao, double quantidadeFator,
                                                      String unidadeFator, int culturaId, String fatorNome, String parcelaNome) throws SQLException {

        CallableStatement callStmt = null;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            callStmt = connection.prepareCall("{ call prc_create_operacao_fator_producao(?,?,?,?,?,?,?,?,?) }");


            callStmt.setInt(1, idCadernoCampo);
            java.sql.Date sqlDate = new java.sql.Date(dataOperacao.getTime());
            callStmt.setDate(2, sqlDate);
            callStmt.setDouble(3, quantidadeOperacao);
            callStmt.setString(4, unidadeOperacao);
            callStmt.setDouble(5, quantidadeFator);
            callStmt.setString(6, unidadeFator);
            callStmt.setInt(7, culturaId);
            callStmt.setString(8, fatorNome);
            callStmt.setString(9, parcelaNome);

            callStmt.execute();
            connection.commit();
        } finally {
            if(!Objects.isNull(callStmt)) {
                callStmt.close();
            }
        }
    }

}
