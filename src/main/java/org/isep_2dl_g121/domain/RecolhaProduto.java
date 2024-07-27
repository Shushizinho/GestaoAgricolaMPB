package org.isep_2dl_g121.domain;

public class RecolhaProduto {
    private int OperacaoAgricolaID;
    private int ProdutoAgricolaID;
    private double QuantidadeProduto;
    private String UnidadeProduto;

    public RecolhaProduto(int OperacaoAgricolaID, int ProdutoAgricolaID,double QuantidadeProduto, String UnidadeProduto ){
        this.OperacaoAgricolaID=OperacaoAgricolaID;
        this.ProdutoAgricolaID=ProdutoAgricolaID;
        this.QuantidadeProduto=QuantidadeProduto;
        this.UnidadeProduto=UnidadeProduto;
    }
    public int getOperacaoAgricolaID() {
        return OperacaoAgricolaID;
    }

    public int getProdutoAgricolaID() {
        return ProdutoAgricolaID;
    }

    public double getQuantidadeProduto() {
        return QuantidadeProduto;
    }

    public String getUnidadeProduto() {
        return UnidadeProduto;
    }
}
