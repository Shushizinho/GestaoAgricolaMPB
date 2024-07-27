package org.isep_2dl_g121;

import graph.Algorithms;
import graph.MyAlgorithms;

import java.io.File;
import java.util.*;

public class Debug {
    private static File[] displayFiles(File[] files,int total) {
        // Get an array of File objects representing the files in the folder
        int i=1,answer=0;
        if (files != null) {
            File[] filexlsx = filexlsx = new File[total];
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().startsWith("distancias_")  && file.getName().toLowerCase().endsWith(".csv")) {
                    System.out.println("\u001B[0m" + i +". " + file.getName() + "\u001B[0m" );
                    filexlsx[i-1] = file;
                    i++;
                }
            }
            return filexlsx;

        }

        if(files == null || i==1) {
            System.out.println("\u001B[31mDoes not existe any CSV file or is not in the directory 'resources'.\u001B[0m");

        }
        return null;
    }
    public static void Tests() throws Exception {
        DistMap distMap = new DistMap(false);
        distMap.loadCSVMap(new File("Data/distancias_small.csv"));
        String b = distMap.vertices().get(0);
        //velocidadeMedia - m/h
        //tmpcarregamento & tmpdescarga - min
        System.out.println(MyAlgorithms.getCircuit(distMap,b,Arrays.asList("CT17", "CT12", "CT16", "CT3", "CT4", "CT9",  "CT2", "CT8", "CT14"),
                450,80,10,10));

//        ArrayList<LinkedList<String>> paths = new ArrayList<>();
//        LinkedList<String> clean = new LinkedList<>();
//        for (String v : distMap.adjVertices(b)) {
//            for (LinkedList<String> p:Algorithms.allPaths(distMap,v,b)) {
//                clean = new LinkedList<>();
//                clean.add(b);
//                if (p.containsAll(Arrays.asList("CT6", "CT17", "CT1", "CT12", "CT16", "CT3", "CT4", "CT9", "CT5", "CT11", "CT2", "CT8", "CT14", "CT13"))){
//                    clean.addAll(p);
//                    paths.add(clean);
//                }
//            }
//
//        }
//        Map<LinkedList<String>, Integer> m = new HashMap<>();
//        for (LinkedList<String> s :paths) {
//            m.put(s,MyAlgorithms.getPathLength(distMap, s));
//        }
//        List<Map.Entry<LinkedList<String>, Integer>> list = new LinkedList<>(m.entrySet());
//
////        for (Map.Entry<LinkedList<String>, Integer> s :list) {
////            System.out.println(s);
////        }
//        System.out.println();
//        Collections.sort(list, new Comparator<Map.Entry<LinkedList<String>, Integer>>() {
//            @Override
//            public int compare(Map.Entry<LinkedList<String>, Integer> o1, Map.Entry<LinkedList<String>, Integer> o2) {
//                return o1.getValue()-o2.getValue();
//            }
//        });
////        for (Map.Entry<LinkedList<String>, Integer> s :list) {
////            System.out.println(s);
////        }
//        System.out.println(list.get(0));
////        for (String sa:list.get(0).getKey()) {
////            System.out.println(sa);
////        }

    }
    public static void TestsB() throws Exception {
        DistMap distMap = new DistMap(false);
        distMap.loadCSVMap(new File("Data/distancias_mid.csv"));
        String b = distMap.vertices().get(0);
        List<String> lo = Arrays.asList("CT49", "CT41", "CT60", "CT48", "CT37", "CT195", "CT190");
        for (String hub : lo) {
            distMap.loadHubsHorarios(hub);
        }
        System.out.println(MyAlgorithms.getPathToMaximizeHubs(distMap, "CT36", new PairTime(11, 35), lo, 10, 50.000, 50.000, 5));
    }
//
//        ArrayList<LinkedList<String>> paths = new ArrayList<>();
//        LinkedList<String> clean;
//        for (String v : distMap.adjVertices(b)) {
//            for (LinkedList<String> p : Algorithms.allPaths(distMap, b, v)) {
//                clean = new LinkedList<>();
//                clean.add(b);
//                if (p.containsAll(Arrays.asList("CT6", "CT17", "CT1", "CT12", "CT16", "CT3", "CT14"))) {
//                    clean.addAll(p);
//                    paths.add(clean);
//                }
//            }
//        }
////        System.out.println(paths);
//        List<String> lo = Arrays.asList("CT6", "CT17", "CT1", "CT12", "CT16", "CT3", "CT14");
//            for (String hub: lo) {
//                DistMap.loadHubsHorarios(hub);
//
//            }
//            System.out.println(DistMap.getMapHorarios());
//
//            List<List<String>> lp = new ArrayList<>();
//        for (int i = lo.size(); i > 0; i--) {
//            lp.addAll(getCombinations(lo, i));
//        }
//        HashMap<List<String>, ArrayList<List<String>>> pathMap = new HashMap<>();
//        for (List<String> l:lp) {
//            pathMap.put(l, new ArrayList<>());
//        }
////        System.out.println(pathMap);
//        System.out.println(lp.size()+" Combinations of "+lo);
//        ArrayList<LinkedList<String>> allPaths = new ArrayList<>();
//        for (String s:lo) {
//            allPaths.addAll(Algorithms.allPaths(distMap, distMap.vertex(0),s));
//        }
//        for (List<String> p:allPaths) {
//            for (List<String>s:lp) {
//                if (new HashSet<>(p).containsAll(s)) pathMap.get(s).add(p);
//            }
//        }
//        boolean found = false;
//        boolean notLast = true;
//        List<String> finalPath = new ArrayList<>();
//        List<Map.Entry<List<String>, ArrayList<List<String>>>> orderedPaths = new ArrayList<>(pathMap.entrySet());
//        orderedPaths.sort((o1, o2) -> o2.getKey().size()-o1.getKey().size());
//        int keyIndex = 0;
//        int valueIndex = 0;
//        while (!found && notLast){
//            List<String> la = orderedPaths.get(keyIndex).getValue().get(valueIndex);
////            System.out.println(la);
//            PairTime currtime = new PairTime(9,50);
//            List<String> h = MyAlgorithms.getOpenHubs(distMap, lo, currtime);
//            String currentV = la.get(0);
//            int index = 0;
//            boolean l = true;
//            while (!currentV.equals(la.get(la.size()-1))&&l){
//                String nextV = la.get(index+1);
////                StringBuilder str = new StringBuilder();
////                StringBuilder str2 = new StringBuilder();
////                str.append("Hora de Chegada: ").append(currtime).append(" - Hora de Saida:");
//                if (lo.contains(currentV)){
//                    l = h.contains(currentV);
////                    str2.append(l);
//                    if (l) currtime.incrementar(35);
//                }
////                else {
////                    str2.append("not hub");
////                }
////                System.out.println("Vertex: " + currentV + " - " + str + " - " + currtime + " - "+ str2);
//                index++;
//                currtime.incrementar(distMap.edge(currentV,nextV).getWeight()/7000);
//                currentV = nextV;
//                h = MyAlgorithms.getOpenHubs(distMap, lo, currtime);
//            }
//            if (l) {
////                StringBuilder str = new StringBuilder();
////                StringBuilder str2 = new StringBuilder();
////                str.append("Hora de Chegada: ").append(currtime).append(" - Hora de Saida:");
//                if (lo.contains(currentV)) {
//                    l = h.contains(currentV);
////                    str2.append(l);
//                    if (l) currtime.incrementar(35);
//                }
////                else {
////                    str2.append("not hub");
////                }
////                System.out.println("Vertex: " + currentV + " - " + str + " - " + currtime + " - "+ str2);
//            }
//            if (l){
//                finalPath=la;
//            }
//            found = l;
//            valueIndex++;
//            if (valueIndex==orderedPaths.get(keyIndex).getValue().size()){
//                valueIndex = 0;
//                keyIndex++;
//                if (keyIndex==orderedPaths.size()) {
//                    notLast = false;
//                }
//            }
//
//        }
//        System.out.println(finalPath);

//        }
//    }


    public static void USEI02() throws Exception {
        DistMap distMap = new DistMap(false);
        distMap.loadCSVMap(new File("Data/distancias_big.csv"));
        Integer autonomy = -1;
        System.out.println(MyAlgorithms.influenceList(distMap));
        System.out.println(MyAlgorithms.centralityList(distMap));
        System.out.println(MyAlgorithms.proximityList(distMap));
//        System.out.println(path);
    }
    public static void USEI03() throws Exception {
        //display the task categories as a menu with number options to select
        //String folderPath = "src\\main\\resources\\";; // The folder path
        String folderPath = System.getProperty("user.dir");
        File folder = new File("Data"); // Create a new File object with the folder path
        File[] files = folder.listFiles();
        int answer=0;
        File[] filexlsx = displayFiles(files,countCSVFiles(files));

        System.out.println("\n\u001B[0m0. Cancel\u001B[0m");

        if (filexlsx != null){
            if (filexlsx.length>0){
                while(answer < 1 || answer > filexlsx.length){
                    Scanner input = new Scanner(System.in);
                    System.out.print("\u001B[35m\nSelect a file: \u001B[0m");

                    try{
                        answer = input.nextInt();

                        if (answer == 0) break;

                    }
                    catch (Exception e){
                        System.out.println("\u001B[31mMust be an Integer cannot be a String\u001B[0m");
                    }
                }

                if(answer!=0){

                    File file = filexlsx[answer-1];
                    System.out.println("\u001B[34m... \u001B[0m");
                    DistMap distMap = new DistMap(false);
                    distMap.loadCSVMap(file);
                    Double autonomy = -1d;
                    while(autonomy < 0){
                        Scanner input = new Scanner(System.in);
                        System.out.print("\u001B[35m\nSelect an Autonomy: \u001B[0m");

                        try{
                            autonomy = input.nextDouble();

                        }
                        catch (Exception e){
                            System.out.println("\u001B[31mMust be an Integer cannot be a String\u001B[0m");
                        }
                    }
                    DistantPathRestricted path = MyAlgorithms.shortestPathRestrictedByAutonomy(distMap, autonomy);
                    System.out.println(path);

                }

            }
        }
    }
    private static int countCSVFiles(File[] files) {
        int count = 0;

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().startsWith("distancias_") && file.getName().toLowerCase().endsWith(".csv")) {
                    count++;
                }
            }
        }

        return count;
    }
}
