package org.isep_2dl_g121.domain;

public class Monda {
    private int OperacaoAgricolaID;
    private String TipoMonda;

    public Monda(int OperacaoAgricolaID, String TipoMonda){
        this.OperacaoAgricolaID=OperacaoAgricolaID;
        this.TipoMonda=TipoMonda;
    }

    public int getOperacaoAgricolaID() {
        return OperacaoAgricolaID;
    }
    public String getTipoMonda() {
        return TipoMonda;
    }
}
