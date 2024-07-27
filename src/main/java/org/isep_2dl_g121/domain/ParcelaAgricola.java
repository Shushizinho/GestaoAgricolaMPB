package org.isep_2dl_g121.domain;

public class ParcelaAgricola {
    private int ID;
    private String Designacao;
    private double Area;
    public ParcelaAgricola(int ID, String Designacao, double Area) {
        this.ID = ID;
        this.Designacao = Designacao;
        this.Area = Area;
    }

    public int getId() {
        return ID;
    }

    public String getDesignacao() {
        return Designacao;
    }

    public double getArea() {
        return Area;
    }
}
