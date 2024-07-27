import graph.MyAlgorithms;
import org.isep_2dl_g121.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class USEI07 {

    private MyAlgorithms e = new MyAlgorithms();

    @AfterEach
    public void tearDown() {
        DistMap.clear();
        CoordMap.clear();
    }

    @Test
    void test1() throws Exception {
        DistMap distMap = new DistMap(false);
        distMap.loadCSVMap(new File("Data/distancias_small.csv"));
        String b = distMap.vertices().get(0);
        List<String> lo = Arrays.asList("CT6", "CT17", "CT1", "CT12");
        for (String hub: lo) {
            distMap.loadHubsHorarios(hub);
        }
        LinkedList<String> p = new LinkedList<>();
        p.addAll(Arrays.asList("CT10", "CT11", "CT5", "CT9", "CT16", "CT4", "CT3", "CT12", "CT1", "CT17", "CT6"));
        ArrayList<PairTime> p2 = new ArrayList<>();
        ArrayList<String> p3 = new ArrayList<>();
        ArrayList<PairTime> p4 = new ArrayList<>();
        ArrayList<String> p5 = new ArrayList<>();
        p5.addAll(Arrays.asList("CT11", "CT9", "CT16", "CT4", "CT3", "CT17"));
        p2.addAll(Arrays.asList(new PairTime(9,13),new PairTime(9,19),new PairTime(9,36)));
        p3.addAll(Arrays.asList("CT6", "CT17", "CT1", "CT12"));
        p4.addAll(Arrays.asList(new PairTime(8,0),new PairTime(8,4),new PairTime(8,15),new PairTime(8,17),new PairTime(8,30),new PairTime(8,43),new PairTime(8,57),new PairTime(9,8),new PairTime(9,14),new PairTime(9,21),new PairTime(9,38)));
        PathMaximumHubs expected = new PathMaximumHubs("CT10", p,
                6, p5 ,922.825, p3, p4 ,
                p2 , 28.0, 60, 20,108.0);
        PathMaximumHubs actual = MyAlgorithms.getPathToMaximizeHubs(distMap,b,new PairTime(8,0),lo,10,200.000,2000.000,5);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void test2() throws Exception {
        DistMap distMap = new DistMap(false);
        distMap.loadCSVMap(new File("Data/distancias_small.csv"));
        List<String> lo = Arrays.asList("CT6", "CT17", "CT10", "CT12", "CT1", "CT3");
        for (String hub : lo) {
            distMap.loadHubsHorarios(hub);
        }
        LinkedList<String> p = new LinkedList<>();
        p.addAll(Arrays.asList("CT1", "CT17", "CT6", "CT10")); //path
        ArrayList<PairTime> p2 = new ArrayList<>();
        ArrayList<String> p3 = new ArrayList<>();
        ArrayList<PairTime> p4 = new ArrayList<>();
        ArrayList<String> p5 = new ArrayList<>();
        p5.addAll(Arrays.asList("CT17", "CT6")); //charges
        p2.addAll(Arrays.asList(new PairTime(10, 40), new PairTime(11, 50), new PairTime(13, 04)));
        p3.addAll(Arrays.asList("CT6", "CT17", "CT10", "CT1")); //hubs
        p4.addAll(Arrays.asList(new PairTime(10, 35), new PairTime(11, 35), new PairTime(12, 49), new PairTime(13, 58)));
        PathMaximumHubs expected = new PathMaximumHubs("CT1", p,
                2, p5, 210.69400000000002, p3, p4,
                p2, 169.0, 20, 20, 209.0);
        PathMaximumHubs actual = MyAlgorithms.getPathToMaximizeHubs(distMap, "CT1", new PairTime(10, 35), lo, 10, 100.000, 75.000, 5);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void test3() throws Exception {
        DistMap distMap = new DistMap(false);
        distMap.loadCSVMap(new File("Data/distancias_small.csv"));
        List<String> lo = Arrays.asList("CT6", "CT17", "CT10", "CT12");
        for (String hub: lo) {
            distMap.loadHubsHorarios(hub);
        }
        LinkedList<String> p = new LinkedList<>();
        p.addAll(Arrays.asList("CT1", "CT10", "CT6", "CT17")); //path
        ArrayList<PairTime> p2 = new ArrayList<>();
        ArrayList<String> p3 = new ArrayList<>();
        ArrayList<PairTime> p4 = new ArrayList<>();
        ArrayList<String> p5 = new ArrayList<>();
        p5.addAll(Arrays.asList()); //charges
        p2.addAll(Arrays.asList(new PairTime(13,46),new PairTime(13,55))); //departures
        p3.addAll(Arrays.asList("CT6", "CT17", "CT10")); //hubs
        p4.addAll(Arrays.asList(new PairTime(13,35),new PairTime(13,41),new PairTime(13,50),new PairTime(13,59))); //arrivals
        PathMaximumHubs expected = new PathMaximumHubs("CT1", p,
                0, p5 ,252.26000000000002, p3, p4 ,
                p2 , 16.0, 0, 15,31.0);
        PathMaximumHubs actual = MyAlgorithms.getPathToMaximizeHubs(distMap, "CT1", new PairTime(13, 35), lo, 10, 500.000, 1000.000, 5);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void test4() throws Exception {
        DistMap distMap = new DistMap(false);
        distMap.loadCSVMap(new File("Data/distancias_mid.csv"));
        List<String> lo = Arrays.asList("CT50", "CT58", "CT61");
        for (String hub: lo) {
            distMap.loadHubsHorarios(hub);
        }
        LinkedList<String> p = new LinkedList<>();
        p.addAll(Arrays.asList("CT51", "CT198", "CT61", "CT193", "CT197", "CT37", "CT58", "CT35", "CT31", "CT50")); //path
        ArrayList<PairTime> p2 = new ArrayList<>();
        ArrayList<String> p3 = new ArrayList<>();
        ArrayList<PairTime> p4 = new ArrayList<>();
        ArrayList<String> p5 = new ArrayList<>();
        p5.addAll(Arrays.asList("CT31")); //charges
        p2.addAll(Arrays.asList(new PairTime(10,51),new PairTime(11,51))); //departures
        p3.addAll(Arrays.asList("CT50", "CT58", "CT61")); //hubs
        p4.addAll(Arrays.asList(new PairTime(10,35),new PairTime(10,41),new PairTime(10,46),new PairTime(11,4),new PairTime(11,18),new PairTime(11,38),new PairTime(11,46),new PairTime(11,57),new PairTime(12,1),new PairTime(12,12))); //arrivals
        PathMaximumHubs expected = new PathMaximumHubs("CT51", p,
                1, p5 ,101.078, p3, p4 ,
                p2 , 81.0, 10, 15,106.0);
        PathMaximumHubs actual = MyAlgorithms.getPathToMaximizeHubs(distMap, "CT51", new PairTime(10, 35), lo, 10, 100.000, 75.000, 5);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void test5() throws Exception {
        DistMap distMap = new DistMap(false);
        distMap.loadCSVMap(new File("Data/distancias_mid.csv"));
        List<String> lo = Arrays.asList("CT32", "CT198", "CT196", "CT39", "CT191");
        for (String hub: lo) {
            distMap.loadHubsHorarios(hub);
        }
        LinkedList<String> p = new LinkedList<>();
        p.addAll(Arrays.asList("CT45", "CT34", "CT35", "CT31", "CT51", "CT198", "CT61", "CT39", "CT49", "CT191")); //path
        ArrayList<PairTime> p2 = new ArrayList<>();
        ArrayList<String> p3 = new ArrayList<>();
        ArrayList<PairTime> p4 = new ArrayList<>();
        ArrayList<String> p5 = new ArrayList<>();
        p5.addAll(Arrays.asList("CT34", "CT35", "CT51", "CT198", "CT61", "CT39", "CT49")); //charges
        p2.addAll(Arrays.asList(new PairTime(14,41))); //departures
        p3.addAll(Arrays.asList("CT198", "CT191")); //hubs
        p4.addAll(Arrays.asList(new PairTime(13,35),new PairTime(13,39),new PairTime(13,53),new PairTime(14,7),new PairTime(14,10),new PairTime(14,26),new PairTime(14,46),new PairTime(15,03),new PairTime(15,20),new PairTime(15,34))); //arrivals
        PathMaximumHubs expected = new PathMaximumHubs("CT45", p,
                7, p5 ,60.805, p3, p4 ,
                p2 , 49.0, 70, 10,129.0);
        PathMaximumHubs actual = MyAlgorithms.getPathToMaximizeHubs(distMap, "CT45", new PairTime(13, 35), lo, 10, 10.000, 75.000, 5);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void test6() throws Exception {
        DistMap distMap = new DistMap(false);
        distMap.loadCSVMap(new File("Data/distancias_mid.csv"));
        List<String> lo = Arrays.asList("CT49", "CT41", "CT60", "CT48", "CT37", "CT195", "CT190");
        for (String hub: lo) {
            distMap.loadHubsHorarios(hub);
        }
        LinkedList<String> p = new LinkedList<>();
        p.addAll(Arrays.asList("CT34", "CT35", "CT60")); //path
        ArrayList<PairTime> p2 = new ArrayList<>();
        ArrayList<String> p3 = new ArrayList<>();
        ArrayList<PairTime> p4 = new ArrayList<>();
        ArrayList<String> p5 = new ArrayList<>();
        p5.addAll(Arrays.asList("CT35")); //charges
        p2.addAll(Arrays.asList()); //departures
        p3.addAll(Arrays.asList("CT60")); //hubs
        p4.addAll(Arrays.asList(new PairTime(8,35),new PairTime(8,41),new PairTime(9,2))); //arrivals
        PathMaximumHubs expected = new PathMaximumHubs("CT34", p,
                1, p5 ,15.197, p3, p4 ,
                p2 , 19.0, 10, 5,34.0);
        PathMaximumHubs actual = MyAlgorithms.getPathToMaximizeHubs(distMap, "CT34", new PairTime(8, 35), lo, 10, 10.000, 50.000, 5);
        Assertions.assertEquals(expected,actual);
    }

}
