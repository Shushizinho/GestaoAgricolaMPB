package org.isep_2dl_g121.domain;

public class ProdutosAgricolas {
    private int ID;
    private String Nome;
    private int PlantaID;

    public ProdutosAgricolas(int ID, String Nome,int PlantaID ){
        this.ID=ID;
        this.Nome=Nome;
        this.PlantaID=PlantaID;
    }
    public int getID() {
        return ID;
    }
    public String getNome(){
        return Nome;
    }
    public int getPlantaID() {
        return PlantaID;
    }
}
