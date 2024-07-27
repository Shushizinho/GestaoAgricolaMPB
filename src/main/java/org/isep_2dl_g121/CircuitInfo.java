package org.isep_2dl_g121;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class CircuitInfo {

    private final String vOrig;
    private final ArrayList<Pair<String,Integer>> locPassagem;
    private final ArrayList<Double> distancias;
    private final double distanciaTotal;
    private final ArrayList<String> carregamentos;
    private final Integer numCarregamentos;
    private final double tempPercurso;
    private final double tempCarregamento;
    private final double tempDescarga;
    private final double tempTotal;

    public CircuitInfo(String vOrig, ArrayList<Pair<String, Integer>> locPassagem,ArrayList<Double> distancias, double distanciaTotal,
                       ArrayList<String> carregamentos, Integer numCarregamentos,double tempPercurso, double tempCarregamento, double tempDescarga, double tempTotal) {

        this.vOrig = vOrig;
        this.locPassagem = locPassagem;
        this.distancias = distancias;
        this.distanciaTotal = distanciaTotal;
        this.carregamentos = carregamentos;
        this.numCarregamentos = numCarregamentos;
        this.tempPercurso = tempPercurso;
        this.tempCarregamento = tempCarregamento;
        this.tempDescarga = tempDescarga;
        this.tempTotal = tempTotal;

    }

    @Override
    public String toString() {
        return "CircuitInfo{" +
                "vOrig='" + vOrig + '\'' +
                ", locPassagem=" + locPassagem +
                ", distancias=" + distancias +
                ", distanciaTotal=" + distanciaTotal +
                ", carregamentos=" + carregamentos +
                ", numCarregamentos=" + numCarregamentos +
                ", tempPercurso=" + tempPercurso +
                ", tempCarregamento=" + tempCarregamento +
                ", tempDescarga=" + tempDescarga +
                ", tempTotal=" + tempTotal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CircuitInfo that = (CircuitInfo) o;
        return Double.compare(that.distanciaTotal, distanciaTotal) == 0 && Double.compare(that.tempPercurso, tempPercurso) == 0 &&
                Double.compare(that.tempCarregamento, tempCarregamento) == 0 && Double.compare(that.tempDescarga, tempDescarga) == 0 &&
                Double.compare(that.tempTotal, tempTotal) == 0 && Objects.equals(vOrig, that.vOrig) && Objects.equals(locPassagem, that.locPassagem) &&
                Objects.equals(distancias, that.distancias) && Objects.equals(carregamentos, that.carregamentos) && Objects.equals(numCarregamentos, that.numCarregamentos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vOrig, locPassagem, distancias, distanciaTotal, carregamentos, numCarregamentos, tempPercurso, tempCarregamento, tempDescarga, tempTotal);
    }
}
