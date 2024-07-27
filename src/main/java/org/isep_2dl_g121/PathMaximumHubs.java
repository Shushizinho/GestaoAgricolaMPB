package org.isep_2dl_g121;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class PathMaximumHubs {

    private final String vOrig;
    private final LinkedList<String> path;
    private final Integer charges;
    private final ArrayList<String> chargingVertices;
    private final ArrayList<String> hubs;
    private final ArrayList<PairTime> arrivals;
    private final ArrayList<PairTime> departures;
    private final Double totalDistance;
    private final Double movingTime;
    private final Integer chargingTime;
    private final Integer unloadTime;
    private final Double totalTime;

    public PathMaximumHubs(String vOrig, LinkedList<String> path, Integer charges, ArrayList<String> chargingVertices, Double totalDistance, ArrayList<String> hubs, ArrayList<PairTime> arrivals, ArrayList<PairTime> departures, Double movingTime, Integer chargingTime, Integer unloadTime, Double totalTime) {
        this.vOrig = vOrig;
        this.path = path;
        this.charges = charges;
        this.chargingVertices = chargingVertices;
        this.hubs = hubs;
        this.arrivals = arrivals;
        this.departures = departures;
        this.movingTime = movingTime;
        this.chargingTime = chargingTime;
        this.unloadTime = unloadTime;
        this.totalTime = totalTime;
        this.totalDistance = totalDistance;
    }

    @Override
    public String toString() {
        return "PathMaximumHubs{" +
                "vOrig='" + vOrig + '\'' +
                ", path=" + path +
                ", charges=" + charges +
                ", chargingVertices=" + chargingVertices +
                ", hubs=" + hubs +
                ", arrivalTimes=" + arrivals +
                ", departureTimesFromHubs=" + departures +
                ", totalDistance=" + totalDistance +
                ", movingTime=" + movingTime +
                ", chargingTime=" + chargingTime +
                ", unloadTime=" + unloadTime +
                ", totalTime=" + totalTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PathMaximumHubs that = (PathMaximumHubs) o;
        return Objects.equals(vOrig, that.vOrig) && Objects.equals(path, that.path) && Objects.equals(charges, that.charges) && Objects.equals(chargingVertices, that.chargingVertices) && Objects.equals(hubs, that.hubs) && Objects.equals(arrivals, that.arrivals) && Objects.equals(departures, that.departures) && Objects.equals(totalDistance, that.totalDistance) && Objects.equals(movingTime, that.movingTime) && Objects.equals(chargingTime, that.chargingTime) && Objects.equals(unloadTime, that.unloadTime) && Objects.equals(totalTime, that.totalTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vOrig, path, charges, chargingVertices, hubs, arrivals, departures, totalDistance, movingTime, chargingTime, unloadTime, totalTime);
    }
}
