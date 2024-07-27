package org.isep_2dl_g121.domain;

import java.sql.Date;

public class Rega {
    private int OperacaoAgricolaID;
    private int horainicio;
    private int horafim;

    public Rega(int OperacaoAgricolaID, int horainicio, int horafim){
        this.OperacaoAgricolaID=OperacaoAgricolaID;
        this.horainicio=horainicio;
        this.horafim=horafim;
    }

    public int getOperacaoAgricolaID() {
        return OperacaoAgricolaID;
    }
    public int getHorainicio() {
        return horainicio;
    }
    public int getHorafim() {
        return horafim;
    }
}
