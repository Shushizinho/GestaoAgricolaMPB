package org.isep_2dl_g121;

import graph.Edge;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class Caminho<V, E> implements Cloneable{

    LinkedList<Edge<V, E>> edges;

    public Caminho(LinkedList<Edge<V, E>> edges) {
        this.edges = edges;
    }

    public Caminho() {
        this.edges = new LinkedList<>();
    }

    public Edge<V, E> getEdge(int index) {
        return edges.get(index);
    }

    public LinkedList<Edge<V, E>> getEdges() {
        return edges;
    }

    public  V getOrigin() {
       return edges.getFirst().getVOrig();
    }

    public void addEdge(Edge<V, E> edge) {
        edges.add(edge);
    }
}
