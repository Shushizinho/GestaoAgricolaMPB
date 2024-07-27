package org.isep_2dl_g121;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class DistantPathRestricted {

    private final String vOrig;
    private final LinkedList<String> path;
    private final Integer charges;
    private final ArrayList<String> chargingVertices;
    private final ArrayList<Double> distanceBetweenVertices;
    private final Double totalDistance;
    private final String vDest;

    public DistantPathRestricted(String vOrig, LinkedList<String> path, Integer charges, ArrayList<String> chargingVertices, ArrayList<Double> distanceBetweenVertices, Double totalDistance, String vDest) {
        this.vOrig = vOrig;
        this.path = path;
        this.charges = charges;
        this.chargingVertices = chargingVertices;
        this.distanceBetweenVertices = distanceBetweenVertices;
        this.totalDistance = totalDistance;
        this.vDest = vDest;
    }

    @Override
    public String toString() {
        String string = new String();
        System.out.println("Local de Origem: "+ vOrig);
        System.out.println("Locais de Passagem: "+ this.path);
        System.out.println("Carregamentos: "+charges+", "+chargingVertices);
        System.out.println("Distancia entre Locais:" + distanceBetweenVertices);
        System.out.println("Distancia total:"+totalDistance);
        System.out.println("Local de Destino: "+ vDest);
        return string;
//        "Local de Origem: "
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistantPathRestricted that = (DistantPathRestricted) o;
        return Objects.equals(vOrig, that.vOrig) && Objects.equals(path, that.path) && Objects.equals(charges, that.charges) && Objects.equals(chargingVertices, that.chargingVertices) && Objects.equals(distanceBetweenVertices, that.distanceBetweenVertices) && Objects.equals(totalDistance, that.totalDistance) && Objects.equals(vDest, that.vDest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vOrig, path, charges, chargingVertices, distanceBetweenVertices, totalDistance, vDest);
    }
}
