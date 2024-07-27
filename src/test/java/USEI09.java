import graph.Graph;
import graph.MyAlgorithms;
import org.isep_2dl_g121.Clusters;
import org.isep_2dl_g121.CoordMap;
import org.isep_2dl_g121.DistMap;
import org.isep_2dl_g121.Pair;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class USEI09 {
    public static MyAlgorithms e = new MyAlgorithms();

    @AfterEach
    public void tearDown() {
        DistMap.clear();
        CoordMap.clear();
    }


    @Test
    void testA() throws Exception {
        DistMap distMap = new DistMap(false);
        distMap.loadCSVMap(new File("Data/distancias_5.csv"));

        List<Set<String>> clusters = new ArrayList<>();
        Set<String> initialCluster = new HashSet<>();
        initialCluster.add("CT1");
        initialCluster.add("CT2");
        initialCluster.add("CT3");
        clusters.add(initialCluster);

        int nClusters = 3;

        List<Clusters>  resultClusters = MyAlgorithms.organizeLocationsInClusters(distMap,clusters,nClusters);
        System.out.println(resultClusters);

        assertEquals(nClusters,resultClusters.size());

    }

    @Test
    void testB() throws Exception {
        DistMap distMap = new DistMap(false);
        distMap.loadCSVMap(new File("Data/distancias_small.csv"));

        List<Set<String>> clusters = new ArrayList<>();
        Set<String> initialCluster = new HashSet<>();
        initialCluster.add("CT1");
        initialCluster.add("CT2");
        initialCluster.add("CT3");
        clusters.add(initialCluster);

        int nClusters = 3;

        List<Clusters>  resultClusters = MyAlgorithms.organizeLocationsInClusters(distMap,clusters,nClusters);
        System.out.println(resultClusters);

        assertEquals(nClusters,resultClusters.size());

    }


}
