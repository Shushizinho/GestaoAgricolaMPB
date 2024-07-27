package org.isep_2dl_g121.domain;

public class LeituraSensor {
    private int ID;
    private int SensorID;
    private int Valor;
    private int Hora;
    private int PlanoDeRegaOperacaoAgricolaID;
    private int CadernoCampoID;

    public LeituraSensor(int ID, int SensorID, int Valor, int Hora, int PlanoDeRegaOperacaoAgricolaID, int CadernoCampoID){
        this.ID=ID;
        this.SensorID=SensorID;
        this.Valor=Valor;
        this.Hora=Hora;
        this.PlanoDeRegaOperacaoAgricolaID=PlanoDeRegaOperacaoAgricolaID;
        this.CadernoCampoID=CadernoCampoID;
    }
    public int getID() {
        return ID;
    }
    public int getSensorID() {
        return SensorID;
    }
    public int getValor() {
        return Valor;
    }
    public int getHora() {
        return Hora;
    }
    public int getPlanoDeRegaOperacaoAgricolaID() {
        return PlanoDeRegaOperacaoAgricolaID;
    }
    public int getCadernoCampoID() {
        return CadernoCampoID;
    }
}
