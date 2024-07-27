package org.isep_2dl_g121.domain;

import java.sql.Date;
public class Cultura {
    private int ID;
    private int ParecelaAgricolaID;
    private int PlantaID;

    private String PlantaNome;
    private String unidade;
    private double quantidade;
    private Date Data_Inicio;
    private Date Data_Fim;
    public Cultura(int ID, int ParecelaAgricolaID, int PlantaID, String unidade, double quantidade,
                   Date Data_Inicio, Date Data_Fim){
        this.ID=ID;
        this.ParecelaAgricolaID=ParecelaAgricolaID;
        this.PlantaID=PlantaID;
        this.unidade=unidade;
        this.quantidade=quantidade;
        this.Data_Inicio=Data_Inicio;
        this.Data_Fim=Data_Fim;
    }

    public Cultura(int ID, int ParecelaAgricolaID,int PlantaID ,String PlantaNome, String unidade, double quantidade,
                   Date Data_Inicio, Date Data_Fim){
        this.ID=ID;
        this.ParecelaAgricolaID=ParecelaAgricolaID;
        this.PlantaID=PlantaID;
        this.PlantaNome=PlantaNome;
        this.unidade=unidade;
        this.quantidade=quantidade;
        this.Data_Inicio=Data_Inicio;
        this.Data_Fim=Data_Fim;
    }

    public int getID(){
        return ID;
    }
    public int getParecelaAgricolaID() {
        return ParecelaAgricolaID;
    }
    public int getPlantaID() {
        return PlantaID;
    }
    public String getUnidade() {
        return unidade;
    }
    public double getQuantidade() {
        return quantidade;
    }
    public Date getData_Inicio() {
        return Data_Inicio;
    }
    public Date getData_Fim() {
        return Data_Fim;
    }
}
