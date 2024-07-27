package org.isep_2dl_g121;

import graph.PairHub;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

public class PathWithNoCharge {
    private final String vOrig;
    private final ArrayList<PairHub<String, Boolean>> path;
    private final ArrayList<Double> distanceBetweenVertices;
    private final Double totalDistance;
    private final Double totalTime;
    private final String vDest;

    public PathWithNoCharge(String vOrig,  ArrayList<PairHub<String, Boolean>> path, ArrayList<Double> distanceBetweenVertices, Double totalDistance, Double totalTime, String vDest) {
        this.vOrig = vOrig;
        this.path = path;
        this.distanceBetweenVertices = distanceBetweenVertices;
        this.totalDistance = totalDistance;
        this.totalTime = totalTime;
        this.vDest = vDest;
    }

    @Override
    public String toString() {
        return "PathWithNoCharge{" +
                "vOrig='" + vOrig + '\'' +
                ", path=" + pathToString() +
                ", distanceBetweenVertices=" + distanceBetweenVertices +
                ", totalDistance=" + totalDistance +
                ", totalTime=" + totalTime +
                ", vDest='" + vDest + '\'' +
                '}';
    }

    public String pathToString(){
        String s = "";
        for(PairHub<String,Boolean> pair : path){
            s += pair.toString();
        }
        return s;
    }

}
