package org.isep_2dl_g121.domain;

public class SistemaDeRega {
    private int ID;
    private String nome;
    public SistemaDeRega(int ID, String nome){
        this.ID=ID;
        this.nome=nome;
    }
    public int getID() {
        return ID;
    }
    public String getNome() {
        return nome;
    }
}
