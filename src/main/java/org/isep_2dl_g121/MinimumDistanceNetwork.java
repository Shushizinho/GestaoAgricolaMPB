package org.isep_2dl_g121;

import graph.map.MapGraph;
import graph.map.MapVertex;

import java.util.Map;

public class MinimumDistanceNetwork {

    private MapGraph<String, Double> mapVertices;
    private Double totalDist;

    public MinimumDistanceNetwork(MapGraph<String, Double> mapVertices, Double totalDist) {
        this.mapVertices = mapVertices;
        this.totalDist = totalDist;
    }

    public <V, E> MinimumDistanceNetwork(MapGraph<V,E> mapVertices, Double totalDist, boolean b) {
        this.mapVertices = (MapGraph<String, Double> ) mapVertices;
        this.totalDist = totalDist;
    }

    public Double getTotalDist() {
        return totalDist;
    }

    public void setTotalDist(Double totalDist) {
        this.totalDist = totalDist;
    }

    @Override
    public String toString() {
        return "MinimumDistanceNetwork{" +
                "mapVertices=" + mapVertices.toString() +
                "TotalDist=" + totalDist +
                '}';
    }

}
