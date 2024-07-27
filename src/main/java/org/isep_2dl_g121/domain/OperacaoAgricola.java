package org.isep_2dl_g121.domain;

import java.sql.Date;

public class OperacaoAgricola {
    private int ID;
    private String TipoOperacao;
    private int CadernoCampoID;
    private Date DataRealizacao;
    private double Quantidade;
    private String Unidadedesignacao;
    private int CulturaID;
    private int ParcelaAgricolaID;

    public OperacaoAgricola(int ID,String TipoOperacao, int CadernoCampoID,Date DataRealizacao, double Quantidade, String Unidadedesignacao, int CulturaID, int ParcelaAgricolaID){

        this.ID=ID;
        this.TipoOperacao=TipoOperacao;
        this.CadernoCampoID=CadernoCampoID;
        this.DataRealizacao=DataRealizacao;
        this.Quantidade=Quantidade;
        this.Unidadedesignacao=Unidadedesignacao;
        this.CulturaID=CulturaID;
        this.ParcelaAgricolaID=ParcelaAgricolaID;

    }
    public int getId() {
        return ID;
    }
    public String getTipoOperacao() {
        return TipoOperacao;
    }
    public int getCadernoCampoID() {
        return CadernoCampoID;
    }
    public Date getDataRealizacao() {
        return DataRealizacao;
    }
    public double getQuantidade() {
        return Quantidade;
    }
    public String getUnidadedesignacao() {
        return Unidadedesignacao;
    }

    public int getCulturaID() {
        return CulturaID;
    }
    public int getParcelaAgricolaID() {
        return ParcelaAgricolaID;
    }
}
