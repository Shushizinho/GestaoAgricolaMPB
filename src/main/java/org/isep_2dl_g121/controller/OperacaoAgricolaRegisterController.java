package org.isep_2dl_g121.controller;

import org.isep_2dl_g121.dataAccess.OperacaoAgricolaRepository;
import org.isep_2dl_g121.dataAccess.Repositories;

import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;

public class OperacaoAgricolaRegisterController {

    private OperacaoAgricolaRepository operacaoAgricolaRepository;

    public OperacaoAgricolaRegisterController (){
        getOperacaoAgricolaRepository();
    }

    private OperacaoAgricolaRepository getOperacaoAgricolaRepository() {
        if (Objects.isNull(operacaoAgricolaRepository)) {
            Repositories repositories = Repositories.getInstance();
            operacaoAgricolaRepository = repositories.getOperacaoAgricolaRepository();
        }
        return operacaoAgricolaRepository;
    }

    public void operacaoAgricolaRegisterSemeadura(String tipo_operacao, int id_caderno_campo, Date
            data_operacao, double quantidade_operacao, String unidade_operacao, double quantidade_cultura,  String unidade_cultura, String planta_nome, String parcela_nome) throws SQLException {
        operacaoAgricolaRepository.OperacaoAgricolaRegisterSemeadura(tipo_operacao, id_caderno_campo, data_operacao, quantidade_operacao, unidade_operacao,quantidade_cultura, unidade_cultura,planta_nome,parcela_nome);
    }

    public void operacaoAgricolaRegisterMonda(String tipo_operacao, int id_caderno_campo, Date
                                              data_operacao, double quantidade_operacao, String unidade_operacao, String parcela, String produto_agricola_nome, String tipo) throws SQLException {
        operacaoAgricolaRepository.OperacaoAgricolaRegisterMonda(tipo_operacao, id_caderno_campo, data_operacao, quantidade_operacao, unidade_operacao,parcela,produto_agricola_nome,tipo);
    }

    public void operacaoAgricolaRegisterColheita(String tipo_operacao, int id_caderno_campo, Date
            data_operacao, String parcela_nome, String produto_agricola_nome, int cultura_id, int quantidade_produto, String unidade_produto) throws SQLException {
        operacaoAgricolaRepository.OperacaoAgricolaRegisterColheita(tipo_operacao, id_caderno_campo, data_operacao, parcela_nome,produto_agricola_nome,cultura_id,quantidade_produto,unidade_produto);
    }

    public void operacaoAgricolaRegisterFatorProdução(int idCadernoCampo, Date dataOperacao, double quantidadeOperacao, String unidadeOperacao, double quantidadeFator,
                                                      String unidadeFator, int culturaId, String fatorNome, String parcelaNome) throws SQLException {

        operacaoAgricolaRepository.OperacaoAgricolaRegisterFatorProducao(idCadernoCampo, dataOperacao, quantidadeOperacao, unidadeOperacao, quantidadeFator,
                unidadeFator,  culturaId,  fatorNome,  parcelaNome);

    }


    public void operacaoRegisterRega(String DesignacaoSetor , int id_caderno_campo, Date
            data_operacao, String hora_inicio, int duracao, int mistura) throws SQLException {
            operacaoAgricolaRepository.OperacaoRegisterRega(DesignacaoSetor , id_caderno_campo,data_operacao, hora_inicio, duracao, mistura);
    }



}
