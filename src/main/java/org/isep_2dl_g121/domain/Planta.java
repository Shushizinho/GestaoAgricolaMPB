package org.isep_2dl_g121.domain;

public class Planta {
    private int ID;
    private String Especie;
    private String Nome;
    private String Tipo;

    public Planta(int ID,String Especie,String Nome,String Tipo){
        this.ID=ID;
        this.Especie=Especie;
        this.Nome=Nome;
        this.Tipo=Tipo;
    }
    public int getID() {
        return ID;
    }
    public String getEspecie() {
        return Especie;
    }
    public String getNome() {
        return Nome;
    }
    public String getTipo() {
        return Tipo;
    }
}
