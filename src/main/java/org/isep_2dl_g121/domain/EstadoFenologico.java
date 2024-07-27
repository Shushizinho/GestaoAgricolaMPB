package org.isep_2dl_g121.domain;

public class EstadoFenologico {
    private String Estado;
    private int CulturaID;
    public EstadoFenologico(String Estado,int CulturaID){
        this.Estado=Estado;
        this.CulturaID=CulturaID;
    }

    public String getEstado() {
        return Estado;
    }
    public int getCulturaID() {
        return CulturaID;
    }
}
