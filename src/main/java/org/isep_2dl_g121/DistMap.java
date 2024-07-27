package org.isep_2dl_g121;


import graph.Edge;
import graph.Graph;
import graph.map.MapGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static graph.MyAlgorithms.orderCentralityInfluence;

public class DistMap extends MapGraph<String, Double> {

    public static Map<String, PairHorario> mapHorarios = new HashMap<>();

    private static final PairTime LOCALIDADE1_HORARIO_INICIO = new PairTime(9, 0);
    private static final PairTime LOCALIDADE1_HORARIO_FIM = new PairTime(14, 0);

    private static final PairTime LOCALIDADE2_HORARIO_INICIO = new PairTime(11, 0);
    private static final PairTime LOCALIDADE2_HORARIO_FIM = new PairTime(16, 0);

    private static final PairTime LOCALIDADE3_HORARIO_INICIO = new PairTime(12, 0);
    private static final PairTime LOCALIDADE3_HORARIO_FIM = new PairTime(17, 0);

    private static final Integer LOCALIDADE1_INICIO = 1;
    private static final Integer LOCALIDADE2_INICIO = 106;
    private static final Integer LOCALIDADE3_INICIO = 216;
    private static final Integer LOCALIDADE3_FIM = 323;



    public DistMap(boolean directed) {
        super(directed);
    }

    public DistMap(Graph<String, Double> g) {
        super(g);
    }

    public static void clear() {
        MapGraph g = new MapGraph(false);
    }

    public void loadCSVMap(File csv) throws Exception {
        Scanner sc = new Scanner(csv);

        if (sc.hasNextLine()) {
            sc.nextLine();
        }
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            line = line.replace('"', ' ');

            String[] strings = line.split(",");
            String vOrig = strings[0];
            String vDest = strings[1];
            Double weight = Double.parseDouble(strings[2])/1000;

            addVertex(vOrig);
            addVertex(vDest);

            addEdge(vOrig, vDest, weight);
        }
    }

//    public static void loadHubs(DistMap g){
//        List<Map.Entry<String, Double>> list = orderCentralityInfluence(g);
//        int i = 0;
//        while (i < 6 && i < list.size()){
//            loadHubsHorarios(list.get(i).getKey());
//            i++;
//        }
//    }


    public static void loadHubsHorarios(String hub){
        if (!mapHorarios.containsKey(hub)){
            String numero = hub.replaceAll("[^0-9]", "");

            if (Integer.parseInt(numero) >= LOCALIDADE3_INICIO && Integer.parseInt(numero) <= LOCALIDADE3_FIM){
                mapHorarios.put(hub, new PairHorario(LOCALIDADE3_HORARIO_INICIO, LOCALIDADE3_HORARIO_FIM));
            }else if (Integer.parseInt(numero) >= LOCALIDADE2_INICIO) {
                mapHorarios.put(hub, new PairHorario(LOCALIDADE2_HORARIO_INICIO, LOCALIDADE2_HORARIO_FIM));
            } else if (Integer.parseInt(numero) >= LOCALIDADE1_INICIO){
                mapHorarios.put(hub, new PairHorario(LOCALIDADE1_HORARIO_INICIO, LOCALIDADE1_HORARIO_FIM));
            }
        }
    }

    public static String mapHorariosToString(){
        String result = "";
        for(String hub : mapHorarios.keySet()){
            result += "\n " + hub + ": " + mapHorarios.get(hub).toString();
        }
        return result;
    }



    public static String generateChecksum(DistMap graph) {
        if (graph == null || graph.numVerts == 0) {
            return "0"; // Return a default checksum for an empty graph.
        }

        long checksum = 0;

        // Traverse vertices and edges to MapGraph checksum
        for (String vertex : graph.vertices) {
            checksum += MapGraphVertexChecksum(graph, vertex);
        }

        return Long.toString(checksum);
    }

    private static long MapGraphVertexChecksum(DistMap graph, String vertex) {
        long vertexChecksum = vertex.hashCode();

        for (Edge<String, Double> edge : graph.outgoingEdges(vertex)) {
            vertexChecksum += edge.hashCode();
        }

        return vertexChecksum;
    }
    public static Map<String, PairHorario> getMapHorarios(){
        return mapHorarios;
    }


}
