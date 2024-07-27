package org.isep_2dl_g121.domain;

public class AplicacaoFator {

    private int OperacaoAgricolaID;
    private int FatorProducaoID;
    private String Modo;
    private double QuantidadeFator;
    private String UnidadeFator;

    public AplicacaoFator(int OperacaoAgricolaID, int FatorProducaoID, String Modo, double QuantidadeFator, String UnidadeFator){
        this.OperacaoAgricolaID=OperacaoAgricolaID;
        this.FatorProducaoID=FatorProducaoID;
        this.Modo=Modo;
        this.QuantidadeFator=QuantidadeFator;
        this.UnidadeFator=UnidadeFator;
    }
    public int getOperacaoAgricolaID() {
        return OperacaoAgricolaID;
    }
    public int getFatorProducaoID() {
        return FatorProducaoID;
    }
    public String getModo() {
        return Modo;
    }
    public double getQuantidadeFator() {
        return QuantidadeFator;
    }
    public String getUnidadeFator() {
        return UnidadeFator;
    }
}
