package org.isep_2dl_g121.domain;

public class PlanoDeRega {
    private long ID;
    private int HorasRega;
    private int Duração;
    private String Regularidade;
    private int ParcelaAgricolaID;

    public PlanoDeRega(long ID, int HorasRega,int Duração,String Regularidade,int ParcelaAgricolaID){
        this.ID=ID;
        this.HorasRega=HorasRega;
        this.Duração=Duração;
        this.Regularidade=Regularidade;
        this.ParcelaAgricolaID=ParcelaAgricolaID;
    }

    public long getID() {
        return ID;
    }

    public int getHorasRega() {
        return HorasRega;
    }

    public int getDuração() {
        return Duração;
    }

    public String getRegularidade() {
        return Regularidade;
    }

    public int getParcelaAgricolaID() {
        return ParcelaAgricolaID;
    }
}
