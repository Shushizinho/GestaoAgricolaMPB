package org.isep_2dl_g121.domain;

public class SetorDeRegaParcela {
    private int ParcelaAgricolaID;
    private int SetorDeRegaID;

    public SetorDeRegaParcela(int ParcelaAgricolaID,int SetorDeRegaID){
        this.ParcelaAgricolaID=ParcelaAgricolaID;
        this.SetorDeRegaID=SetorDeRegaID;

    }
    public int getParcelaAgricolaID() {
        return ParcelaAgricolaID;
    }
    public int getSetorDeRegaID() {
        return SetorDeRegaID;
    }
}
