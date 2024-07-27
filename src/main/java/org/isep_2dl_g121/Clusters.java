package org.isep_2dl_g121;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Clusters {

    private String hub;
    private Set<String> localidades;

    public Clusters(String hub, Set<String> localidades) {
        this.hub = hub;
        this.localidades = localidades;
    }

    public Set<String> getLocalidades() {
        return localidades;
    }

    public String getHub() {
        return hub;
    }

    @Override
    public String toString() {
        return "Hub e respetivo Cluster= {" +
                "hub=" + hub +
                "localidades=" + localidades +
                '}';
    }

}
