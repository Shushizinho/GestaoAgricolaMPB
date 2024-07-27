package org.isep_2dl_g121.domain;

public class SetorDeRega {
    private int ID;
    private double debito;
    private double area;
    private String desigacao;

    public SetorDeRega(int ID,double debito,double area,String desigacao){
        this.ID=ID;
        this.debito=debito;
        this.area=area;
        this.desigacao=desigacao;
    }
    public int getID() {
        return ID;
    }
    public double getDebito() {
        return debito;
    }
    public double getArea() {
        return area;
    }
    public String getDesigacao() {
        return desigacao;
    }
}
