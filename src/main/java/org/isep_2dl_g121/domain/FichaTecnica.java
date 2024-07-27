package org.isep_2dl_g121.domain;

public class FichaTecnica {
    private String Nome;
    private int FatorProducaoID;
    private double quantidade;

    public FichaTecnica(String Nome, int FatorProducaoID,double quantidade){
        this.Nome=Nome;
        this.FatorProducaoID=FatorProducaoID;
        this.quantidade=quantidade;
    }
    public String getNome() {
        return Nome;
    }

    public int getFatorProducaoID() {
        return FatorProducaoID;
    }

    public double getQuantidade() {
        return quantidade;
    }
}
