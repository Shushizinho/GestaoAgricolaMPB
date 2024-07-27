package org.isep_2dl_g121.domain;

public class FatorProducao {
    private int ID;
    private String NomeComercial;
    private String Formulacao;
    private String Fabricante;
    private String FatorProducaoTipo;
    private String Aplicacao;

    public FatorProducao(int ID,String NomeComercial,String Formulacao,String Fabricante,String FatorProducaoTipo, String Aplicacao){
        this.ID=ID;
        this.NomeComercial=NomeComercial;
        this.Formulacao=Formulacao;
        this.Fabricante=Fabricante;
        this.FatorProducaoTipo=FatorProducaoTipo;
        this.Aplicacao=Aplicacao;
    }
    public int getID() {
        return ID;
    }

    public String getNomeComercial() {
        return NomeComercial;
    }

    public String getFormulacao() {
        return Formulacao;
    }

    public String getFabricante() {
        return Fabricante;
    }

    public String getFatorProducaoTipo() {
        return FatorProducaoTipo;
    }

    public String getAplicacao() {
        return Aplicacao;
    }
}
