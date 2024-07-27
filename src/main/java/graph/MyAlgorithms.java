package graph;

import graph.map.MapGraph;
import org.isep_2dl_g121.*;

import java.util.*;
import java.util.function.BinaryOperator;


public class MyAlgorithms<V, E> {


    public static <V, E> double getPathLength(Graph<V, E> graph, LinkedList<V> s) {
        int l = s.size();
        int length = 0;
        for (int i = 0; i < l - 1; i++) {
            length += (double) graph.edge(s.get(i), s.get(i + 1)).getWeight();
        }
        return length;
    }

    public Double getVelocityKMHForTimeForAdjVert(Graph<V, E> graph, V vOrig, V vDest, Integer time) {
        Double meters = (Double) graph.edge(vOrig, vDest).getWeight();
        double segundos = time * 60;
        double velocidadeMS = meters / segundos;
        return velocidadeMS * 3.6;
    }

    //usei08
    public static <V, E> CircuitInfo getCircuit(Graph<V, E> graph, V vOrig, List<V> hubs, double autonomiaCarro, double velocidadeMedia, int tmpCarregamento, int tmpDescarga) {


        ArrayList<LinkedList<V>> paths = new ArrayList<>();
        LinkedList<V> clean;

        for (V v : graph.adjVertices(vOrig)) {
            for (LinkedList<V> p : Algorithms.allPaths(graph, v, vOrig)) {
                clean = new LinkedList<>();
                clean.add(vOrig);
                if (p.containsAll(hubs)) {
                    clean.addAll(p);
                    paths.add(clean);
                }
            }

        }

        Map<LinkedList<V>, Double> m = new HashMap<>();
        for (LinkedList<V> s : paths) {
            m.put(s, MyAlgorithms.getPathLength(graph, s));
        }
        List<Map.Entry<LinkedList<V>, Double>> list = new LinkedList<>(m.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<LinkedList<V>, Double>>() {
            @Override
            public int compare(Map.Entry<LinkedList<V>, Double> o1, Map.Entry<LinkedList<V>, Double> o2) {
                return (int) (o1.getValue() - o2.getValue());
            }
        });

        int index = 0;
        V currentV = list.get(0).getKey().get(0);
        ArrayList<Double> dist = new ArrayList<>();
        ArrayList<String> carregamentos = new ArrayList<>();
        double autonomiaRest = autonomiaCarro;

        while (index != list.get(0).getKey().size() - 1) {

            V nextV = list.get(0).getKey().get(index + 1);
            double x = (Double) graph.edge(currentV, nextV).getWeight();
            dist.add(x);

            if (autonomiaRest - x <= 0) {
                autonomiaRest = autonomiaCarro;
                carregamentos.add((String) currentV);
            }
            autonomiaRest -= x;

            currentV = nextV;

            index++;
        }

        double disttot = dist.stream().mapToDouble(Double::doubleValue).sum();

        ArrayList<Pair<String, Integer>> locPassagem = new ArrayList<>();

        for (V v : list.get(0).getKey()) {

            int n = 0;
            if (hubs.contains(v)) n = getColaboraters((String) v);

            Pair<String, Integer> pair = new Pair<>((String) v, n);
            locPassagem.add(pair);
        }

        double percurso = (list.get(0).getValue() / velocidadeMedia) * 60; //minutos
        double carga = carregamentos.size() * tmpCarregamento; // minutos
        double descarga = hubs.size() * tmpDescarga; //minutos
        double tempTotal = percurso + carga + descarga;

        return new CircuitInfo((String) vOrig, locPassagem, dist, disttot, carregamentos, carregamentos.size(), percurso, carga, descarga, tempTotal);

    }


    private static int getColaboraters(String hub) {
        String[] colab = hub.split("CT");
        return Integer.parseInt(colab[1]);

    }


    //usei04

    public MinimumDistanceNetwork kruskallAlgorithm(Graph<V, E> graph, Comparator<E> ce) {

        MapGraph<V, E> minimumSpanningTree = new MapGraph<>(false);

        List<Edge<V, E>> edgesList = new ArrayList<>();


        for (V vertex : graph.vertices()) {
            minimumSpanningTree.addVertex(vertex);
        }

        for (Edge<V, E> edge : graph.edges()) {
            edgesList.add(edge);
        }

        edgesList.sort(new Comparator<Edge<V, E>>() {
            @Override
            public int compare(Edge<V, E> edge1, Edge<V, E> edge2) {
                return ce.compare(edge1.getWeight(), edge2.getWeight());
            }
        });

        for (Edge<V, E> edge : edgesList) {
            V vOrig = edge.getVOrig();
            V vDest = edge.getVDest();

            LinkedList<V> connectedVertsOrig = Algorithms.DepthFirstSearch(minimumSpanningTree, vOrig);

            if (!connectedVertsOrig.contains(vDest)) {
                minimumSpanningTree.addEdge(vOrig, vDest, edge.getWeight());

            }
        }
        double totalDistance = 0;
        for (Edge<V, E> edge : minimumSpanningTree.edges()) {
            totalDistance = totalDistance + (double) edge.getWeight();
        }

        totalDistance = totalDistance / 2;

        MinimumDistanceNetwork result = new MinimumDistanceNetwork(minimumSpanningTree, totalDistance, true);

        return result;
    }


    //usei03
    public static DistantPathRestricted shortestPathRestrictedByAutonomy(Graph<String, Double> g, Double autonomy) {
        Comparator<Double> c = new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return (int) (o1 - o2);
            }
        };
        BinaryOperator<Double> sum = new BinaryOperator<Double>() {
            @Override
            public Double apply(Double integer, Double integer2) {
                return integer + integer2;
            }
        };
        if (!g.vertices().isEmpty()) {
            Edge<String, Double> mostDistantShortestPath = new Edge<>("α_vOrig", "Ω_vDest", Double.MIN_VALUE);
            for (Edge<String, Double> edge : Algorithms.minDistGraph(g, c, sum).edges()) {
                if (edge.getWeight() > mostDistantShortestPath.getWeight()) mostDistantShortestPath = edge;
            }
            Double remainingAutonomy = autonomy;
            String currentVertex = mostDistantShortestPath.getVOrig();
            LinkedList<String> shortPath = new LinkedList<>();
            Algorithms.shortestPath(g, mostDistantShortestPath.getVOrig(), mostDistantShortestPath.getVDest(), c, sum, 0d, shortPath);
            ArrayList<String> chargingVertices = new ArrayList<>();
            ArrayList<Double> distanceBetweenVertices = new ArrayList<>();
            List<Edge<String, Double>> avoidEdges = new ArrayList<>();
            for (Edge<String, Double> e : g.edges()) {
                if (e.getWeight() > autonomy) avoidEdges.add(e);
            }
            shortPath = new LinkedList<>();
            shortestPathAvoidEdges(g, mostDistantShortestPath.getVOrig(), mostDistantShortestPath.getVDest(), c, sum, 0d, shortPath, avoidEdges);
            if (!shortPath.isEmpty()) {
                while (!Objects.equals(currentVertex, mostDistantShortestPath.getVDest())) {
                    String nextVertex = shortPath.get(shortPath.indexOf(currentVertex) + 1);
                    distanceBetweenVertices.add(g.edge(currentVertex, nextVertex).getWeight());
                    if (remainingAutonomy - g.edge(currentVertex, nextVertex).getWeight() <= 0) {
                        remainingAutonomy = autonomy;
                        chargingVertices.add(currentVertex);
                    }
                    remainingAutonomy = remainingAutonomy - g.edge(currentVertex, nextVertex).getWeight();
                    currentVertex = nextVertex;
                }
            }
            Double totalDistance = 0d;
            for (Double d : distanceBetweenVertices) {
                totalDistance += d;
            }
            return new DistantPathRestricted(mostDistantShortestPath.getVOrig(), shortPath, chargingVertices.size(), chargingVertices, distanceBetweenVertices, totalDistance, mostDistantShortestPath.getVDest());
        }
        return null;
    }

    public static <V, E> void shortestPathAvoidEdges(Graph<V, E> g, V vOrig, V vDest,
                                                     Comparator<E> ce, BinaryOperator<E> sum, E zero,
                                                     LinkedList<V> shortPath, List<Edge<V, E>> avoidEdges) {

        if (!g.validVertex(vOrig) || !g.validVertex(vDest))
            return;

        shortPath.clear();
        int numVerts = g.numVertices();
        boolean[] visited = new boolean[numVerts]; //default value: false
        @SuppressWarnings("unchecked")
        V[] pathKeys = (V[]) new Object[numVerts];
        @SuppressWarnings("unchecked")
        E[] dist = (E[]) new Object[numVerts];
        for (int i = 0; i < numVerts; i++) {
            dist[i] = null;
            pathKeys[i] = null;
        }

        shortestPathDijkstraAvoidEdges(g, vOrig, ce, sum, zero, visited, pathKeys, dist, avoidEdges);

        E lengthPath = dist[g.key(vDest)];

        if (lengthPath != null) {
            getPath(g, vOrig, vDest, pathKeys, shortPath);
        }
    }

    private static <V, E> void getPath(Graph<V, E> g, V vOrig, V vDest,
                                       V[] pathKeys, LinkedList<V> path) {

        if (vOrig.equals(vDest))
            path.push(vOrig);
        else {
            path.push(vDest);
            int vKey = g.key(vDest);
            vDest = pathKeys[vKey];
            getPath(g, vOrig, vDest, pathKeys, path);
        }
    }

    protected static <V, E> void shortestPathDijkstraAvoidEdges(Graph<V, E> g, V vOrig,
                                                                Comparator<E> ce, BinaryOperator<E> sum, E zero,
                                                                boolean[] visited, V[] pathKeys, E[] dist, List<Edge<V, E>> avoidEdges) {

        int vkey = g.key(vOrig);
        dist[vkey] = zero;
        pathKeys[vkey] = vOrig;
        while (vOrig != null) {
            vkey = g.key(vOrig);
            visited[vkey] = true;
            for (Edge<V, E> edge : g.outgoingEdges(vOrig)) {
                if (avoidEdges.contains(edge)) {
                    // Skip the edge to be avoided
                    continue;
                }

                int vkeyAdj = g.key(edge.getVDest());
                if (!visited[vkeyAdj]) {
                    E s = sum.apply(dist[vkey], edge.getWeight());
                    if (dist[vkeyAdj] == null || ce.compare(dist[vkeyAdj], s) > 0) {
                        dist[vkeyAdj] = s;
                        pathKeys[vkeyAdj] = vOrig;
                    }
                }
            }
            E minDist = null;
            vOrig = null;
            for (V vert : g.vertices()) {
                int i = g.key(vert);
                if (!visited[i] && (dist[i] != null) && ((minDist == null) || ce.compare(dist[i], minDist) < 0)) {
                    minDist = dist[i];
                    vOrig = vert;
                }
            }
        }
    }

    public static List<Map.Entry<String, Integer>> influenceList(DistMap g) {
        Map<String, Integer> influenceMap = new HashMap<>();
        for (String v : g.vertices()) {
            influenceMap.put(v, g.incomingEdges(v).size());
        }
        List<Map.Entry<String, Integer>> influenceList = new ArrayList<>(influenceMap.entrySet());
        influenceList.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        return influenceList;
    }


    public static List<Map.Entry<String, Integer>> centralityList(DistMap g) {
        Comparator<Double> c = Comparator.comparingDouble(o -> o);
        BinaryOperator<Double> sum = new BinaryOperator<Double>() {
            @Override
            public Double apply(Double integer, Double integer2) {
                return integer + integer2;
            }
        };
        List<String> influence = new ArrayList<>();
        ArrayList<LinkedList<String>> fullPaths = new ArrayList<>();
        ArrayList<LinkedList<String>> path = new ArrayList<>();
        ArrayList<Double> dists = new ArrayList<>();
        Map<String, Integer> centralityMap = new HashMap<>();
        for (String v : g.vertices()) {
            centralityMap.put(v, 0);
            influence.add(v);
            Algorithms.shortestPaths(g, v, c, sum, 0d, path, dists);
            fullPaths.addAll(path);
        }
        for (LinkedList<String> list : fullPaths) {
            for (String s : list) {
                centralityMap.put(s, centralityMap.get(s) + 1);
            }
        }
        List<Map.Entry<String, Integer>> centralityList = new ArrayList<>(centralityMap.entrySet());
        Collections.sort(centralityList, Collections.reverseOrder(Map.Entry.comparingByValue()));
        return centralityList;
    }


    public static List<Map.Entry<String, Double>> proximityList(DistMap g) {

        Map<String, Double> proximityMap = new HashMap<>();
        for (String vertice : g.vertices()) {
            int distancia = 0;
            int contador = 0;

            for (String vAdj : g.adjVertices(vertice)) {
                for (Edge edge : g.incomingEdges(vAdj)) {
                    distancia += (Integer) edge.getWeight();
                    contador++;
                }
            }

            Double average;
            if (contador == 0) {
                average = (double) 0;
                proximityMap.put(vertice, average);
            } else {
                average = (double) (distancia / contador);
                proximityMap.put(vertice, average);
            }
        }
        List<Map.Entry<String, Double>> proximityList = new ArrayList<>(proximityMap.entrySet());

        proximityList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        return proximityList;

    }

    public static List<Map.Entry<String, Double>> orderCentralityInfluence(DistMap g) {

        List<Map.Entry<String, Integer>> centrality = centralityList(g);
        List<Map.Entry<String, Integer>> influence = influenceList(g);

        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Integer> entry : centrality) {
            String key = entry.getKey();

            if (containsKey(influence, key)) {

                Integer influenceValue = getValueByKey(influence, key);

                double average = (entry.getValue() + influenceValue) / 2;
                resultMap.put(key, average);
            }
        }

        List<Map.Entry<String, Double>> sortedResult = new ArrayList<>(resultMap.entrySet());
        Collections.sort(sortedResult, Map.Entry.<String, Double>comparingByValue().reversed());


        // Exibir os resultados
        for (Map.Entry<String, Double> entry : sortedResult) {
            // System.out.println("Chave: " + entry.getKey() + ", Ocorrências: " + entry.getValue());

        }


        return sortedResult;
    }

    // Método auxiliar para verificar se uma chave está presente em uma lista de Map.Entry
    private static boolean containsKey(List<Map.Entry<String, Integer>> list, String key) {
        for (Map.Entry<String, Integer> entry : list) {
            if (entry.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    private static Integer getValueByKey(List<Map.Entry<String, Integer>> list, String key) {
        for (Map.Entry<String, Integer> entry : list) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null; // Pode ser necessário lidar com o caso em que a chave não é encontrada
    }

    //usei06
    public static List<PathWithNoCharge> pathsWithoutCharge(Graph<String, Double> g, String vOrig, String vDest, Double autonomy, Integer velocity, ArrayList<String> hubs) {
        if (vOrig == null || vDest == null || !hubs.contains(vDest)) return null;

        ArrayList<LinkedList<String>> p = allPathsByAutonomy(g, vOrig, vDest, autonomy);
        List<PathWithNoCharge> listPaths = new ArrayList<>();

        for (LinkedList<String> e : p) {
            double totalDistance = 0;
            String currentVertex = e.get(0);
            Double time = 0.0;
            ArrayList<PairHub<String, Boolean>> pathHub = new ArrayList<>();
            ArrayList<Double> distanceBetweenVertices = new ArrayList<>();
            while (!Objects.equals(currentVertex, vDest)) {
                String nextVertex = e.get(e.indexOf(currentVertex) + 1);
                totalDistance += g.edge(currentVertex, nextVertex).getWeight();
                time += getTimeMinForVelocityForAdjVert(g, currentVertex,nextVertex, velocity);
                PairHub<String, Boolean> pairCurrentVertex = new PairHub<>(currentVertex, hubs.contains(currentVertex));
                if (!pathHub.contains(pairCurrentVertex)) {
                    pathHub.add(pairCurrentVertex);
                }
                PairHub<String, Boolean> pairNextVertex = new PairHub<>(nextVertex, hubs.contains(nextVertex));
                if (!pathHub.contains(pairNextVertex)) {
                    pathHub.add(pairNextVertex);
                }
                distanceBetweenVertices.add(g.edge(currentVertex, nextVertex).getWeight());
                currentVertex = nextVertex;
            }
            listPaths.add(new PathWithNoCharge( vOrig, pathHub, distanceBetweenVertices, totalDistance, time, (String) vDest));
        }
        if (!listPaths.isEmpty()) return listPaths;
        else return null;

    }

    private static <E, V> ArrayList<LinkedList<V>> allPathsByAutonomy(Graph<V, E> g, V vOrig, V vDest, Double autonomy) {
        ArrayList<LinkedList<V>> paths = new ArrayList<>();
        boolean[] visited = new boolean[g.numVertices()];
        LinkedList<V> currentPath = new LinkedList<>();

        allPathsByAutonomyRecursive(g, vOrig, vDest, visited, currentPath, paths, autonomy);

        return paths;

    }

    private static <V, E> void allPathsByAutonomyRecursive(Graph<V, E> g, V vOrig, V vDest, boolean[] visited, LinkedList<V> currentPath, ArrayList<LinkedList<V>> paths, double autonomy) {
        int key_vOrig = g.key(vOrig);

        visited[key_vOrig] = true;

        currentPath.addLast(vOrig);
        double remainingAutonomy = 0;

        if (vOrig.equals(vDest)) {
            paths.add(new LinkedList<>(currentPath));
        } else {
            Iterable<V> adjVertices = g.adjVertices(vOrig);
            for (V vAdj : adjVertices) {
                int key_vAdj = g.key(vAdj);
                remainingAutonomy = autonomy - (double) g.edge(vOrig, vAdj).getWeight();
                if (!visited[key_vAdj] && remainingAutonomy >= 0) {

                    allPathsByAutonomyRecursive(g, vAdj, vDest, visited, currentPath, paths, remainingAutonomy);
                }
            }
        }

        visited[key_vOrig] = false;
        currentPath.removeLast();

    }


    private static <V, E> Double getTimeMinForVelocityForAdjVert(Graph<String, Double> g, String currentVertex, String nextVertex, Integer velocity) {
        return (g.edge(currentVertex, nextVertex).getWeight() / velocity) * 60;
    }

    //usei07
    public static PathMaximumHubs getPathToMaximizeHubs(Graph<String, Double> g, String vOrig, PairTime tOrig, List<String> hubs, Integer chargeTime, Double autonomy, Double meanSpeed, Integer unloadTime) throws Exception {


        List<Map.Entry<List<String>, ArrayList<List<String>>>> orderedPaths = getPathsToProcess(g, vOrig, hubs, autonomy);
        Pair<List<String>, List<String>> finalPath = processPathsForMaximumHubs(g, vOrig, tOrig.clone(), hubs, chargeTime, autonomy, meanSpeed, unloadTime, orderedPaths);
        Double currCharge = autonomy;
        List<String> charges = new ArrayList<>();
        List<PairTime> arrivalTimes = new ArrayList<>();
        List<PairTime> departureTimes = new ArrayList<>();
        PairTime currtime = tOrig.clone();
        String currentV = vOrig;
        Double pathLength = 0d;
        List<String> maxHubs = finalPath.getRight();
        int index = 0;
        if (finalPath.getLeft().size() > 0) {
            while (!currentV.equals(finalPath.getLeft().get(finalPath.getLeft().size() - 1))) {
                arrivalTimes.add(currtime.clone());
                String nextV = finalPath.getLeft().get(index + 1);
                if (finalPath.getRight().contains(currentV)) {
                    currtime.incrementar(unloadTime);
                }
                index++;
                Double dist = g.edge(currentV, nextV).getWeight();
                if (currCharge - dist <= 0) {
                    currCharge = autonomy;
                    currtime.incrementar(chargeTime);
                    charges.add(currentV);
                }
                if (finalPath.getRight().contains(currentV)) departureTimes.add(currtime.clone());
                currCharge -= dist;
                pathLength += dist;
                currtime.incrementar((int) ((dist / meanSpeed) * 60));
                currentV = nextV;
            }
            arrivalTimes.add(currtime.clone());
            currtime.incrementar(unloadTime);
//        Double i = (double) (currtime.getInMinutes() - tOrig.getInMinutes());
            Double i = Math.ceil((pathLength / meanSpeed) * 60) + charges.size() * chargeTime + maxHubs.size() * unloadTime;
            return new PathMaximumHubs(vOrig, (LinkedList<String>) finalPath.getLeft(), charges.size(), (ArrayList<String>) charges, pathLength, (ArrayList<String>) maxHubs, (ArrayList<PairTime>) arrivalTimes, (ArrayList<PairTime>) departureTimes, Math.ceil((pathLength / meanSpeed) * 60), charges.size() * chargeTime, maxHubs.size() * unloadTime, i);
        } else {
            return new PathMaximumHubs(vOrig, new LinkedList<>(), 0, new ArrayList<>(), 0d, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 0d, 0, 0, 0d);
        }
    }

    private static List<Map.Entry<List<String>, ArrayList<List<String>>>> getPathsToProcess(Graph<String, Double> g, String vOrig, List<String> hubs, Double autonomy) {
        List<List<String>> lp = new ArrayList<>();
        for (int i = hubs.size(); i > 0; i--) {
            lp.addAll(getCombinations(hubs, i));
        }
        HashMap<List<String>, ArrayList<List<String>>> pathMap = new HashMap<>();
        for (List<String> l : lp) {
            pathMap.put(l, new ArrayList<>());
        }
        ArrayList<LinkedList<String>> allPaths = new ArrayList<>();
        for (String s : hubs) {
            allPaths.addAll(MyAlgorithms.allPathsRestrictedByAutonomy(g, vOrig, s, autonomy));
        }
        for (List<String> p : allPaths) {
            for (List<String> s : lp) {
                if (new HashSet<>(p).containsAll(s)) pathMap.get(s).add(p);
            }
        }
        for (List<String> s : pathMap.keySet()) {
            pathMap.get(s).sort(new Comparator<List<String>>() {
                @Override
                public int compare(List<String> o1, List<String> o2) {
                    return o1.size() - o2.size();
                }
            });
        }
        List<Map.Entry<List<String>, ArrayList<List<String>>>> orderedPaths = new ArrayList<>(pathMap.entrySet());
        orderedPaths.sort((o1, o2) -> o2.getKey().size() - o1.getKey().size());
        return orderedPaths;
    }

    private static Pair<List<String>, List<String>> processPathsForMaximumHubs(Graph<String, Double> g, String vOrig, PairTime tOrig, List<String> hubs, Integer chargeTime, Double autonomy, Double meanSpeed, Integer unloadTime, List<Map.Entry<List<String>, ArrayList<List<String>>>> orderedPaths) {
        boolean found = false;
        boolean notLast = true;
        List<String> finalPath = new ArrayList<>();
        int keyIndex = 0;
        int valueIndex = 0;
//        for (Map.Entry<List<String>, ArrayList<List<String>>> s:orderedPaths) {
//            System.out.println(s.getKey() + " - " + s.getValue());
//        }
        boolean l;
        while (!found && notLast) {
//            System.out.println(keyIndex + " - " + valueIndex);
            if (!orderedPaths.get(keyIndex).getValue().isEmpty()) {
                List<String> la = orderedPaths.get(keyIndex).getValue().get(valueIndex);
                double currCharge = autonomy;
                PairTime currtime = tOrig.clone();
                List<String> h = MyAlgorithms.getOpenHubs(g, orderedPaths.get(keyIndex).getKey(), currtime);
                String currentV = vOrig;
                int index = 0;
                l = true;
                while (!currentV.equals(la.get(la.size() - 1)) && l) {
                    String nextV = la.get(index + 1);
                    if (orderedPaths.get(keyIndex).getKey().contains(currentV)) {
                        l = h.contains(currentV);
                        if (l) currtime.incrementar(unloadTime);
                    }
                    index++;
                    Double dist = g.edge(currentV, nextV).getWeight();
                    if (currCharge - dist <= 0) {
                        currCharge = autonomy;
                        currtime.incrementar(chargeTime);
                    }
                    currCharge -= dist;
                    currtime.incrementar((int) ((dist / meanSpeed) * 60));
                    currentV = nextV;
                    h = MyAlgorithms.getOpenHubs(g, orderedPaths.get(keyIndex).getKey(), currtime);

                }

                if (l) {
                    if (orderedPaths.get(keyIndex).getKey().contains(currentV)) {
                        l = h.contains(currentV);
                        if (l) currtime.incrementar(unloadTime);
                    }
                }
                if (l) {
                    finalPath = la;
                }
                found = l;
            }
            if (!found) {
                valueIndex++;
                if (valueIndex >= orderedPaths.get(keyIndex).getValue().size()) {
                    valueIndex = 0;
                    keyIndex++;
                    if (keyIndex >= orderedPaths.size()) {
                        notLast = false;
                    }
                }
            }

        }
        if (!found) return new Pair<>(new ArrayList<>(), new ArrayList<>());
        return new Pair<>(finalPath, orderedPaths.get(keyIndex).getKey());
    }

    public static <T> List<List<T>> getCombinations(List<T> elements, int n) {
        List<List<T>> combinations = new ArrayList<>();
        generateCombinations(elements, n, new ArrayList<>(), combinations, 0);
        return combinations;
    }

    private static <T> void generateCombinations(List<T> elements, int n, List<T> currentCombination,
                                                 List<List<T>> allCombinations, int start) {
        if (n == 0) {
            allCombinations.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = start; i < elements.size(); i++) {
            currentCombination.add(elements.get(i));
            generateCombinations(elements, n - 1, currentCombination, allCombinations, i + 1);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    public static <V, E> List<V> getOpenHubs(Graph<V, E> g, List<V> hubs, PairTime currentTime) {
        Map<String, PairHorario> horarios = DistMap.getMapHorarios();
        List<V> openHubs = new ArrayList<>();
        for (V hub : hubs) {
            if (horarios.get((String) hub).periodContains(currentTime)) {
                openHubs.add(hub);
            }
        }
        return openHubs;
    }

    private static <E, V> ArrayList<LinkedList<V>> allPathsRestrictedByAutonomy(Graph<V, E> g, V vOrig, V vDest, Double autonomy) {
        ArrayList<LinkedList<V>> paths = new ArrayList<>();
        boolean[] visited = new boolean[g.numVertices()];
        LinkedList<V> currentPath = new LinkedList<>();

        allPathsRestrictedByAutonomy(g, vOrig, vDest, visited, currentPath, paths, autonomy);

        return paths;

    }

    private static <V, E> void allPathsRestrictedByAutonomy(Graph<V, E> G, V vOrig, V vDest, boolean[] visited, LinkedList<V> path, ArrayList<LinkedList<V>> paths, Double autonomy) {
        int key_vOrig = G.key(vOrig);

        visited[key_vOrig] = true;

        path.addLast(vOrig);

        if (vOrig.equals(vDest)) {
            paths.add(new LinkedList<>(path));
        } else {
            Iterable<V> adjVertices = G.adjVertices(vOrig);
            for (V vAdj : adjVertices) {
                int key_vAdj = G.key(vAdj);
                if (!visited[key_vAdj] && (double) G.edge(vOrig, vAdj).getWeight() < autonomy) {
                    allPathsRestrictedByAutonomy(G, vAdj, vDest, visited, path, paths, autonomy);
                }
            }
        }

        visited[key_vOrig] = false;
        path.removeLast();
    }
    //


    //usei09

    public static <V, E> List<Clusters> organizeLocationsInClusters(Graph<String, Double> graph, List<Set<String>> hubs, int numClusters) {
        List<Clusters> resultClusters = new ArrayList<>();

        HashMap<Edge<String, Double>, Double> edgesBetweenness = calculateBetweenness(graph);

// Iterate until the desired number of clusters is achieved
        while (resultClusters.size() < numClusters) {

            // Remove the branch with the highest betweenness
            Edge<String, Double> branchToRemove = findBranchWithHighestBetweenness(edgesBetweenness);

            graph.removeEdge(branchToRemove.getVOrig(), branchToRemove.getVDest());
            edgesBetweenness.remove(branchToRemove);

            // Update the clusters
            List<Set<String>> clusterList = new ArrayList<>();
            updateClusterList(hubs, branchToRemove, clusterList);

            // Create a new cluster
            for (Set<String> localitySet : clusterList) {

                String hub = getCentralHub(localitySet);

                Clusters newCluster = new Clusters(hub, new HashSet<>(localitySet));

                resultClusters.add(newCluster);
            }
        }

        return resultClusters;
    }

    private static String getCentralHub(Set<String> localitySet) {

        if (localitySet.isEmpty()) {
            // Handle the case where the set is empty (no central hub)
            return null; // Or throw an exception, return a default hub, etc.
        }

        // Find the element with the minimum lexicographical order
        String centralHub = localitySet.stream()
                .min(String::compareTo)
                .orElse(null);

        return centralHub;

    }

//    private static <V, E> void removeBranch(Graph<V, E> graph, E branchToRemove) {
//        // Get the vertices associated with the edge
//        Edge<V, E> edgeToRemove = null;
//        Collection<Edge<V, E>> edges = graph.edges();
//
//        // Find the edge to remove
//        for (Edge<V, E> edge : edges) {
//            if (edge.equals(branchToRemove)) {
//                edgeToRemove = edge;
//                break;
//            }
//        }
//
//        // Remove the edge if found
//        if (edgeToRemove != null) {
//            V vOrig = edgeToRemove.getVOrig();
//            V vDest = edgeToRemove.getVDest();
//            graph.removeEdge(vOrig, vDest);
//        }
//    }


    private static <V, E> Edge<String, Double> findBranchWithHighestBetweenness(HashMap<Edge<String, Double>, Double> branchBetweenness) {
        Edge<String, Double> maxEdge = null;
        double maxBetweenness = 0d;

        for (Map.Entry<Edge<String, Double>, Double> entry : branchBetweenness.entrySet()) {
            Edge<String, Double> edge = entry.getKey();
            double betweenness = entry.getValue();

            if (betweenness > maxBetweenness) {
                maxEdge = edge;
                maxBetweenness = betweenness;
            }
        }
        return maxEdge;

//        Pair<E, Integer> branchWithHighestBetweenness = null;
//        int highestBetweenness = 0;
//
//        for (Pair<E, Integer> entry : branchBetweenness) {
//            E branch = entry.getLeft(); // Assuming Pair has a getLeft method for the first element
//            int betweenness = entry.getRight(); // Assuming Pair has a getRight method for the second element
//
//            if (betweenness > highestBetweenness) {
//                branchWithHighestBetweenness = entry;
//                highestBetweenness = betweenness;
//            }
//        }
//
//        branchBetweenness.remove(branchWithHighestBetweenness);
//        return branchWithHighestBetweenness;
    }


//    private static <V, E> void updateClusters(Graph<V, E> graph, List<Clusters> clusters, HashMap<Edge<String,Double>,Double> edgesBetweenness) {
//        Map<String, Clusters> clusterMap = new HashMap<>();
//
//        for (Clusters cluster : clusters) {
//            cluster.getLocalidades().clear();
//            clusterMap.put(cluster.getHub(), cluster);
//        }
//
//        for (V vertex : graph.vertices()) {
//            String location = vertex.toString();
//            for (Clusters cluster : clusters) {
//                if (cluster.getHub().equals(location) || graph.adjVertices(vertex).contains(cluster.getHub())) {
//                    clusterMap.get(cluster.getHub()).getLocalidades().add(location);
//                    break;
//                }
//            }
//        }
//}

    public static List<Set<String>> updateClusterList(List<Set<String>> clusters, Edge<String,Double> removedEdge, List<Set<String>> newClusters){
        String origin = removedEdge.getVOrig();
        List<Set<String>> updatedClusters;
        updatedClusters = removeCluster(clusters, origin);
        return updatedClusters;
    }


    public static List<Set<String>> removeCluster(List<Set<String>> clusters, String origin) {
        Iterator<Set<String>> iterator = clusters.iterator();
        while (iterator.hasNext()) {
            Set<String> cluster = iterator.next();
            if (cluster.contains(origin)) {
                iterator.remove();
                break;
            }
        }
        return clusters;
    }



//    private static <V, E> boolean pathContainsBranch(LinkedList<V> path, E branch, Graph<V, E> graph) {
//        // Check if the given path contains the specified branch (edge)
//        for (int i = 0; i < path.size() - 1; i++) {
//            V currentVertex = path.get(i);
//            V nextVertex = path.get(i + 1);
//            E currentEdge = graph.edge(currentVertex, nextVertex).getWeight();
//
//            if (currentEdge != null && currentEdge.equals(branch)) {
//                return true;
//            }
//        }
//        return false;
//    }
    private static <V, E> HashMap<Edge<String,Double>,Double>  calculateBetweenness(Graph<String, Double> g) {

        HashMap<Edge<String,Double>,Double> edgesBetweenness = new HashMap<>();
        for(Edge<String,Double> edge : g.edges()) {
            edgesBetweenness.put(edge, 0d);
        }

        Collection<Caminho<String, Double>> shortestPaths = new ArrayList<>();
        for(String String : g.vertices()){
            Collection<Caminho<String, Double>> collection = allShortestPaths(String,g);
            shortestPaths.addAll(collection);
        }

        for( Caminho<String, Double> path:  shortestPaths){
            for(Edge<String,Double> edge : path.getEdges()){
                edgesBetweenness.putIfAbsent(edge, 0d);
                Double increment = edgesBetweenness.get(edge) + 1;
                edgesBetweenness.put(edge,increment);
            }
        }
        return edgesBetweenness;

    }


    public static <V,E extends Number> Collection<Caminho<V,E>> allShortestPaths(V origin, Graph<V,E> graph){

        ArrayList<V> unvisited = new ArrayList<>(graph.vertices());
        ArrayList<V> visited = new ArrayList<>();
        HashMap<V, Pair<Double,V>> auxiliaryTable = new HashMap<>();

        for (V vertex : unvisited){
            auxiliaryTable.put(vertex,new Pair<>(Double.MAX_VALUE,null));
        }

        V usedVertex = origin;
        auxiliaryTable.replace(origin, new Pair<>(0.0, null));
        while (!unvisited.isEmpty()) {
            for (V vertex : graph.adjVertices(usedVertex)) {
                double totalWeight = graph.edge(usedVertex, vertex).getWeight().doubleValue() + auxiliaryTable.get(usedVertex).getLeft();
                if (unvisited.contains(vertex) && totalWeight < auxiliaryTable.get(vertex).getLeft()) {
                    auxiliaryTable.replace(vertex, new Pair<>(totalWeight, usedVertex));
                }
            }
            unvisited.remove(usedVertex);
            visited.add(usedVertex);
            usedVertex = lowestValueVertex(auxiliaryTable, unvisited);
        }

        Collection<Caminho<V,E>> collection = new HashSet<>();
        for (V vertex : graph.vertices()){

            if(vertex.equals(origin)) continue;

            Caminho<V, E> path = new Caminho<>();
            path.addEdge(graph.edge(auxiliaryTable.get(vertex).getRight(), vertex));
            while (!path.getOrigin().equals(origin)) {
                path.addEdge(graph.edge(auxiliaryTable.get(path.getOrigin()).getRight(), path.getOrigin()));
            }
            collection.add(path);
        }

        return collection;

    }

    private static <V> V lowestValueVertex(HashMap<V, Pair<Double,V>> auxiliaryTable, ArrayList<V> unvisited) {
        V lowestVertex = null;
        double lowestValue = Double.POSITIVE_INFINITY;

        for (V vertex : unvisited) {
            if (auxiliaryTable.containsKey(vertex)) {
                double value = auxiliaryTable.get(vertex).getLeft();
                if (value < lowestValue) {
                    lowestValue = value;
                    lowestVertex = vertex;
                }
            }
        }

        return lowestVertex;
    }

}