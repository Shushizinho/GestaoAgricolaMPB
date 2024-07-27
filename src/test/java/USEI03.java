import graph.MyAlgorithms;
import org.isep_2dl_g121.CoordMap;
import org.isep_2dl_g121.DistMap;
import org.isep_2dl_g121.DistantPathRestricted;
import org.isep_2dl_g121.PairCoord;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class USEI03 {

    private MyAlgorithms e = new MyAlgorithms();

    @AfterEach
    public void tearDown() {
        DistMap.clear();
        CoordMap.clear();
    }

    @Test
    void emptyMap() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_Null.csv");
        distMap.loadCSVMap(csvDist);

        DistantPathRestricted actual = e.shortestPathRestrictedByAutonomy(distMap, 0d);

        Assertions.assertNull(actual);
    }
    @Test
    void smallMap_largeAutonomy() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_MultipleLines.csv");
        distMap.loadCSVMap(csvDist);


        DistantPathRestricted actual = e.shortestPathRestrictedByAutonomy(distMap, 1000.000);
        LinkedList<String> expectedPath = new LinkedList<>();
        expectedPath.add("CT5");
        expectedPath.add( "CT10");
        expectedPath.add( "CT1");
        expectedPath.add( "CT12");
        expectedPath.add( "CT3");
        ArrayList<Double> expectedDistances = new ArrayList<>();
        expectedDistances.add(125.041);
        expectedDistances.add(110.848);
        expectedDistances.add(62.877);
        expectedDistances.add(50.467);
        ArrayList<String> expectedCharges = new ArrayList<>();
        Double totalDistance = 0d;
        for (Double d:expectedDistances) {
            totalDistance+=d;
        }
        DistantPathRestricted expected = new DistantPathRestricted("CT5",expectedPath,0,expectedCharges,expectedDistances,totalDistance,"CT3");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void smallMap_mediumAutonomy() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_MultipleLines.csv");
        distMap.loadCSVMap(csvDist);


        DistantPathRestricted actual = e.shortestPathRestrictedByAutonomy(distMap, 240.000);
        LinkedList<String> expectedPath = new LinkedList<>();
        expectedPath.add("CT5");
        expectedPath.add( "CT10");
        expectedPath.add( "CT1");
        expectedPath.add( "CT12");
        expectedPath.add( "CT3");
        ArrayList<Double> expectedDistances = new ArrayList<>();
        expectedDistances.add(125.041);
        expectedDistances.add(110.848);
        expectedDistances.add(62.877);
        expectedDistances.add(50.467);
        ArrayList<String> expectedCharges = new ArrayList<>();
        expectedCharges.add("CT1");
        Double totalDistance = 0d;
        for (Double d:expectedDistances) {
            totalDistance+=d;
        }
        DistantPathRestricted expected = new DistantPathRestricted("CT5",expectedPath,1,expectedCharges,expectedDistances,totalDistance,"CT3");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void smallMap_smallAutonomy() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_MultipleLines.csv");
        distMap.loadCSVMap(csvDist);


        DistantPathRestricted actual = e.shortestPathRestrictedByAutonomy(distMap, 130.000);
        LinkedList<String> expectedPath = new LinkedList<>();
        expectedPath.add("CT5");
        expectedPath.add( "CT10");
        expectedPath.add( "CT1");
        expectedPath.add( "CT12");
        expectedPath.add( "CT3");
        ArrayList<Double> expectedDistances = new ArrayList<>();
        expectedDistances.add(125.041);
        expectedDistances.add(110.848);
        expectedDistances.add(62.877);
        expectedDistances.add(50.467);
        ArrayList<String> expectedCharges = new ArrayList<>();
        expectedCharges.add("CT10");
        expectedCharges.add("CT1");
        Double totalDistance = 0d;
        for (Double d:expectedDistances) {
            totalDistance+=d;
        }
        DistantPathRestricted expected = new DistantPathRestricted("CT5",expectedPath,2,expectedCharges,expectedDistances,totalDistance,"CT3");
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void smallMap_noAutonomy() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_MultipleLines.csv");
        distMap.loadCSVMap(csvDist);


        DistantPathRestricted actual = e.shortestPathRestrictedByAutonomy(distMap, 0d);
        LinkedList<String> expectedPath = new LinkedList<>();
        ArrayList<Double> expectedDistances = new ArrayList<>();
        ArrayList<String> expectedCharges = new ArrayList<>();
        Double totalDistance = 0d;
        for (Double d:expectedDistances) {
            totalDistance+=d;
        }
        DistantPathRestricted expected = new DistantPathRestricted("CT5",expectedPath,0,expectedCharges,expectedDistances,totalDistance,"CT3");
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void mediumMap_largeAutonomy() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_small.csv");
        distMap.loadCSVMap(csvDist);


        DistantPathRestricted actual = e.shortestPathRestrictedByAutonomy(distMap, 1000.000);
        LinkedList<String> expectedPath = new LinkedList<>();
        expectedPath.add("CT15");
        expectedPath.add( "CT12");
        expectedPath.add( "CT1");
        expectedPath.add( "CT10");
        expectedPath.add( "CT13");
        expectedPath.add( "CT14");
        expectedPath.add( "CT8");
        ArrayList<Double> expectedDistances = new ArrayList<>();
        expectedDistances.add(70.717);
        expectedDistances.add(62.877);
        expectedDistances.add(110.848);
        expectedDistances.add(63.448);
        expectedDistances.add(89.813);
        expectedDistances.add(207.558);
        ArrayList<String> expectedCharges = new ArrayList<>();
        Double totalDistance = 0d;
        for (Double d:expectedDistances) {
            totalDistance+=d;
        }
        DistantPathRestricted expected = new DistantPathRestricted("CT15",expectedPath,0,expectedCharges,expectedDistances,totalDistance,"CT8");
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void mediumMap_mediumAutonomy() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_small.csv");
        distMap.loadCSVMap(csvDist);


        DistantPathRestricted actual = e.shortestPathRestrictedByAutonomy(distMap, 210.000);
        LinkedList<String> expectedPath = new LinkedList<>();
        expectedPath.add("CT15");
        expectedPath.add( "CT12");
        expectedPath.add( "CT1");
        expectedPath.add( "CT10");
        expectedPath.add( "CT13");
        expectedPath.add( "CT14");
        expectedPath.add( "CT8");
        ArrayList<Double> expectedDistances = new ArrayList<>();
        expectedDistances.add(70.717);
        expectedDistances.add(62.877);
        expectedDistances.add(110.848);
        expectedDistances.add(63.448);
        expectedDistances.add(89.813);
        expectedDistances.add(207.558);
        ArrayList<String> expectedCharges = new ArrayList<>();
        expectedCharges.add("CT1");
        expectedCharges.add("CT13");
        expectedCharges.add("CT14");
        Double totalDistance = 0d;
        for (Double d:expectedDistances) {
            totalDistance+=d;
        }
        DistantPathRestricted expected = new DistantPathRestricted("CT15",expectedPath,3,expectedCharges,expectedDistances,totalDistance,"CT8");
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void mediumMap_smallAutonomy() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_small.csv");
        distMap.loadCSVMap(csvDist);


        DistantPathRestricted actual = e.shortestPathRestrictedByAutonomy(distMap, 175.000);
        LinkedList<String> expectedPath = new LinkedList<>();
        expectedPath.add("CT15");
        expectedPath.add( "CT12");
        expectedPath.add( "CT1");
        expectedPath.add( "CT10");
        expectedPath.add( "CT13");
        expectedPath.add( "CT7");
        expectedPath.add( "CT2");
        expectedPath.add( "CT8");
        ArrayList<Double> expectedDistances = new ArrayList<>();
        expectedDistances.add(70.717);
        expectedDistances.add(62.877);
        expectedDistances.add(110.848);
        expectedDistances.add(63.448);
        expectedDistances.add(111.686);
        expectedDistances.add(65.574);
        expectedDistances.add(125.105);
        ArrayList<String> expectedCharges = new ArrayList<>();
        expectedCharges.add("CT1");
        expectedCharges.add("CT13");
        expectedCharges.add("CT7");
        expectedCharges.add("CT2");
        Double totalDistance = 0d;
        for (Double d:expectedDistances) {
            totalDistance+=d;
        }
        DistantPathRestricted expected = new DistantPathRestricted("CT15",expectedPath,4,expectedCharges,expectedDistances,totalDistance,"CT8");
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void mediumMap_noAutonomy() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_small.csv");
        distMap.loadCSVMap(csvDist);


        DistantPathRestricted actual = e.shortestPathRestrictedByAutonomy(distMap, 0d);
        LinkedList<String> expectedPath = new LinkedList<>();
        ArrayList<Double> expectedDistances = new ArrayList<>();
        ArrayList<String> expectedCharges = new ArrayList<>();
        Double totalDistance = 0d;
        for (Double d:expectedDistances) {
            totalDistance+=d;
        }
        DistantPathRestricted expected = new DistantPathRestricted("CT15",expectedPath,0,expectedCharges,expectedDistances,totalDistance,"CT8");
        Assertions.assertEquals(expected,actual);
    }
    //mega
    //large
    //medium
    //small
    //micro
    @Test
    void bigMap_megaAutonomy() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_big.csv");
        distMap.loadCSVMap(csvDist);


        DistantPathRestricted actual = e.shortestPathRestrictedByAutonomy(distMap, 1000.000);
        LinkedList<String> expectedPath = new LinkedList<>();
        {
            expectedPath.add("CT194");
            expectedPath.add("CT143");
            expectedPath.add("CT23");
            expectedPath.add("CT83");
            expectedPath.add("CT115");
            expectedPath.add("CT297");
            expectedPath.add("CT107");
            expectedPath.add("CT42");
            expectedPath.add("CT180");
            expectedPath.add("CT222");
            expectedPath.add("CT126");
            expectedPath.add("CT148");
            expectedPath.add("CT230");
            expectedPath.add("CT193");
            expectedPath.add("CT205");
            expectedPath.add("CT37");
            expectedPath.add("CT272");
            expectedPath.add("CT72");
            expectedPath.add("CT68");
            expectedPath.add("CT320");
            expectedPath.add("CT255");
            expectedPath.add("CT41");
            expectedPath.add("CT78");
            expectedPath.add("CT210");
            expectedPath.add("CT147");
            expectedPath.add("CT113");
            expectedPath.add("CT133");
            expectedPath.add("CT228");
            expectedPath.add("CT30");
            expectedPath.add("CT276");
            expectedPath.add("CT34");
            expectedPath.add("CT162");
        }
        ArrayList<Double> expectedDistances = new ArrayList<>();
        {
            expectedDistances.add(23.111);
            expectedDistances.add(45.292);
            expectedDistances.add(22.979);
            expectedDistances.add(43.344);
            expectedDistances.add(36.210);
            expectedDistances.add(30.205);
            expectedDistances.add(20.849);
            expectedDistances.add(30.377);
            expectedDistances.add(40.958);
            expectedDistances.add(27.495);
            expectedDistances.add(12.343);
            expectedDistances.add(25.392);
            expectedDistances.add(20.487);
            expectedDistances.add(16.684);
            expectedDistances.add(22.908);
            expectedDistances.add(18.341);
            expectedDistances.add(8.761);
            expectedDistances.add(13.897);
            expectedDistances.add(18.500);
            expectedDistances.add(17.382);
            expectedDistances.add(27.513);
            expectedDistances.add(16.596);
            expectedDistances.add(16.923);
            expectedDistances.add(10.235);
            expectedDistances.add(12.830);
            expectedDistances.add(12.785);
            expectedDistances.add(15.117);
            expectedDistances.add(11.236);
            expectedDistances.add(11.235);
            expectedDistances.add(19.597);
            expectedDistances.add(35.534);
        }
        ArrayList<String> expectedCharges = new ArrayList<>();
        Double totalDistance = 0d;
        for (Double d:expectedDistances) {
            totalDistance+=d;
        }
        DistantPathRestricted expected = new DistantPathRestricted("CT194",expectedPath,0,expectedCharges,expectedDistances,totalDistance,"CT162");
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void bigMap_largeAutonomy() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_big.csv");
        distMap.loadCSVMap(csvDist);


        DistantPathRestricted actual = e.shortestPathRestrictedByAutonomy(distMap, 255.000);
        LinkedList<String> expectedPath = new LinkedList<>();
        {
            expectedPath.add("CT194");
            expectedPath.add("CT143");
            expectedPath.add("CT23");
            expectedPath.add("CT83");
            expectedPath.add("CT115");
            expectedPath.add("CT297");
            expectedPath.add("CT107");
            expectedPath.add("CT42");
            expectedPath.add("CT180");
            expectedPath.add("CT222");
            expectedPath.add("CT126");
            expectedPath.add("CT148");
            expectedPath.add("CT230");
            expectedPath.add("CT193");
            expectedPath.add("CT205");
            expectedPath.add("CT37");
            expectedPath.add("CT272");
            expectedPath.add("CT72");
            expectedPath.add("CT68");
            expectedPath.add("CT320");
            expectedPath.add("CT255");
            expectedPath.add("CT41");
            expectedPath.add("CT78");
            expectedPath.add("CT210");
            expectedPath.add("CT147");
            expectedPath.add("CT113");
            expectedPath.add("CT133");
            expectedPath.add("CT228");
            expectedPath.add("CT30");
            expectedPath.add("CT276");
            expectedPath.add("CT34");
            expectedPath.add("CT162");
        }
        ArrayList<Double> expectedDistances = new ArrayList<>();
        {
            expectedDistances.add(23.111);
            expectedDistances.add(45.292);
            expectedDistances.add(22.979);
            expectedDistances.add(43.344);
            expectedDistances.add(36.210);
            expectedDistances.add(30.205);
            expectedDistances.add(20.849);
            expectedDistances.add(30.377);
            expectedDistances.add(40.958);
            expectedDistances.add(27.495);
            expectedDistances.add(12.343);
            expectedDistances.add(25.392);
            expectedDistances.add(20.487);
            expectedDistances.add(16.684);
            expectedDistances.add(22.908);
            expectedDistances.add(18.341);
            expectedDistances.add(8.761);
            expectedDistances.add(13.897);
            expectedDistances.add(18.500);
            expectedDistances.add(17.382);
            expectedDistances.add(27.513);
            expectedDistances.add(16.596);
            expectedDistances.add(16.923);
            expectedDistances.add(10.235);
            expectedDistances.add(12.830);
            expectedDistances.add(12.785);
            expectedDistances.add(15.117);
            expectedDistances.add(11.236);
            expectedDistances.add(11.235);
            expectedDistances.add(19.597);
            expectedDistances.add(35.534);
        }
        ArrayList<String> expectedCharges = new ArrayList<>();
        expectedCharges.add("CT180");
        expectedCharges.add("CT255");
        Double totalDistance = 0d;
        for (Double d:expectedDistances) {
            totalDistance+=d;
        }
        DistantPathRestricted expected = new DistantPathRestricted("CT194",expectedPath,2,expectedCharges,expectedDistances,totalDistance,"CT162");
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void bigMap_mediumAutonomy() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_big.csv");
        distMap.loadCSVMap(csvDist);


        DistantPathRestricted actual = e.shortestPathRestrictedByAutonomy(distMap, 175.000);
        LinkedList<String> expectedPath = new LinkedList<>();
        {
            expectedPath.add("CT194");
            expectedPath.add("CT143");
            expectedPath.add("CT23");
            expectedPath.add("CT83");
            expectedPath.add("CT115");
            expectedPath.add("CT297");
            expectedPath.add("CT107");
            expectedPath.add("CT42");
            expectedPath.add("CT180");
            expectedPath.add("CT222");
            expectedPath.add("CT126");
            expectedPath.add("CT148");
            expectedPath.add("CT230");
            expectedPath.add("CT193");
            expectedPath.add("CT205");
            expectedPath.add("CT37");
            expectedPath.add("CT272");
            expectedPath.add("CT72");
            expectedPath.add("CT68");
            expectedPath.add("CT320");
            expectedPath.add("CT255");
            expectedPath.add("CT41");
            expectedPath.add("CT78");
            expectedPath.add("CT210");
            expectedPath.add("CT147");
            expectedPath.add("CT113");
            expectedPath.add("CT133");
            expectedPath.add("CT228");
            expectedPath.add("CT30");
            expectedPath.add("CT276");
            expectedPath.add("CT34");
            expectedPath.add("CT162");
        }
        ArrayList<Double> expectedDistances = new ArrayList<>();
        {
            expectedDistances.add(23.111);
            expectedDistances.add(45.292);
            expectedDistances.add(22.979);
            expectedDistances.add(43.344);
            expectedDistances.add(36.210);
            expectedDistances.add(30.205);
            expectedDistances.add(20.849);
            expectedDistances.add(30.377);
            expectedDistances.add(40.958);
            expectedDistances.add(27.495);
            expectedDistances.add(12.343);
            expectedDistances.add(25.392);
            expectedDistances.add(20.487);
            expectedDistances.add(16.684);
            expectedDistances.add(22.908);
            expectedDistances.add(18.341);
            expectedDistances.add(8.761);
            expectedDistances.add(13.897);
            expectedDistances.add(18.500);
            expectedDistances.add(17.382);
            expectedDistances.add(27.513);
            expectedDistances.add(16.596);
            expectedDistances.add(16.923);
            expectedDistances.add(10.235);
            expectedDistances.add(12.830);
            expectedDistances.add(12.785);
            expectedDistances.add(15.117);
            expectedDistances.add(11.236);
            expectedDistances.add(11.235);
            expectedDistances.add(19.597);
            expectedDistances.add(35.534);
        }
        ArrayList<String> expectedCharges = new ArrayList<>();
        expectedCharges.add("CT297");
        expectedCharges.add("CT148");
        expectedCharges.add("CT255");
        expectedCharges.add("CT34");
        Double totalDistance = 0d;
        for (Double d:expectedDistances) {
            totalDistance+=d;
        }
        DistantPathRestricted expected = new DistantPathRestricted("CT194",expectedPath,4,expectedCharges,expectedDistances,totalDistance,"CT162");
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void bigMap_smallAutonomy() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_big.csv");
        distMap.loadCSVMap(csvDist);


        DistantPathRestricted actual = e.shortestPathRestrictedByAutonomy(distMap, 120.000);
        LinkedList<String> expectedPath = new LinkedList<>();
        {
            expectedPath.add("CT194");
            expectedPath.add("CT143");
            expectedPath.add("CT23");
            expectedPath.add("CT83");
            expectedPath.add("CT115");
            expectedPath.add("CT297");
            expectedPath.add("CT107");
            expectedPath.add("CT42");
            expectedPath.add("CT180");
            expectedPath.add("CT222");
            expectedPath.add("CT126");
            expectedPath.add("CT148");
            expectedPath.add("CT230");
            expectedPath.add("CT193");
            expectedPath.add("CT205");
            expectedPath.add("CT37");
            expectedPath.add("CT272");
            expectedPath.add("CT72");
            expectedPath.add("CT68");
            expectedPath.add("CT320");
            expectedPath.add("CT255");
            expectedPath.add("CT41");
            expectedPath.add("CT78");
            expectedPath.add("CT210");
            expectedPath.add("CT147");
            expectedPath.add("CT113");
            expectedPath.add("CT133");
            expectedPath.add("CT228");
            expectedPath.add("CT30");
            expectedPath.add("CT276");
            expectedPath.add("CT34");
            expectedPath.add("CT162");
        }
        ArrayList<Double> expectedDistances = new ArrayList<>();
        {
            expectedDistances.add(23.111);
            expectedDistances.add(45.292);
            expectedDistances.add(22.979);
            expectedDistances.add(43.344);
            expectedDistances.add(36.210);
            expectedDistances.add(30.205);
            expectedDistances.add(20.849);
            expectedDistances.add(30.377);
            expectedDistances.add(40.958);
            expectedDistances.add(27.495);
            expectedDistances.add(12.343);
            expectedDistances.add(25.392);
            expectedDistances.add(20.487);
            expectedDistances.add(16.684);
            expectedDistances.add(22.908);
            expectedDistances.add(18.341);
            expectedDistances.add(8.761);
            expectedDistances.add(13.897);
            expectedDistances.add(18.500);
            expectedDistances.add(17.382);
            expectedDistances.add(27.513);
            expectedDistances.add(16.596);
            expectedDistances.add(16.923);
            expectedDistances.add(10.235);
            expectedDistances.add(12.830);
            expectedDistances.add(12.785);
            expectedDistances.add(15.117);
            expectedDistances.add(11.236);
            expectedDistances.add(11.235);
            expectedDistances.add(19.597);
            expectedDistances.add(35.534);
        }
        ArrayList<String> expectedCharges = new ArrayList<>();
        expectedCharges.add("CT83");
        expectedCharges.add("CT107");
        expectedCharges.add("CT126");
        expectedCharges.add("CT272");
        expectedCharges.add("CT210");
        expectedCharges.add("CT34");
        Double totalDistance = 0d;
        for (Double d:expectedDistances) {
            totalDistance+=d;
        }
        DistantPathRestricted expected = new DistantPathRestricted("CT194",expectedPath,6,expectedCharges,expectedDistances,totalDistance,"CT162");
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void bigMap_microAutonomy() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_big.csv");
        distMap.loadCSVMap(csvDist);


        DistantPathRestricted actual = e.shortestPathRestrictedByAutonomy(distMap, 40.000);
        LinkedList<String> expectedPath = new LinkedList<>();
        {
            expectedPath.add("CT194");
            expectedPath.add("CT275");
            expectedPath.add("CT82");
            expectedPath.add("CT12");
            expectedPath.add("CT163");
            expectedPath.add("CT261");
            expectedPath.add("CT182");
            expectedPath.add("CT235");
            expectedPath.add("CT234");
            expectedPath.add("CT106");
            expectedPath.add("CT271");
            expectedPath.add("CT123");
            expectedPath.add("CT25");
            expectedPath.add("CT97");
            expectedPath.add("CT188");
            expectedPath.add("CT315");
            expectedPath.add("CT77");
            expectedPath.add("CT124");
            expectedPath.add("CT96");
            expectedPath.add("CT154");
            expectedPath.add("CT130");
            expectedPath.add("CT211");
            expectedPath.add("CT257");
            expectedPath.add("CT311");
            expectedPath.add("CT81");
            expectedPath.add("CT236");
            expectedPath.add("CT49");
            expectedPath.add("CT29");
            expectedPath.add("CT113");
            expectedPath.add("CT133");
            expectedPath.add("CT228");
            expectedPath.add("CT30");
            expectedPath.add("CT276");
            expectedPath.add("CT34");
            expectedPath.add("CT162");
        }
        ArrayList<Double> expectedDistances = new ArrayList<>();
        {
            expectedDistances.add(22.452);
            expectedDistances.add(22.363);
            expectedDistances.add(31.413);
            expectedDistances.add(26.402);
            expectedDistances.add(37.436);
            expectedDistances.add(28.458);
            expectedDistances.add(34.978);
            expectedDistances.add(28.260);
            expectedDistances.add(24.399);
            expectedDistances.add(16.032);
            expectedDistances.add(12.148);
            expectedDistances.add(18.136);
            expectedDistances.add(10.781);
            expectedDistances.add(28.555);
            expectedDistances.add(16.461);
            expectedDistances.add(26.892);
            expectedDistances.add(38.870);
            expectedDistances.add(17.710);
            expectedDistances.add(14.683);
            expectedDistances.add(13.799);
            expectedDistances.add(21.931);
            expectedDistances.add(8.764);
            expectedDistances.add(14.425);
            expectedDistances.add(19.666);
            expectedDistances.add(24.626);
            expectedDistances.add(11.284);
            expectedDistances.add(13.818);
            expectedDistances.add(15.878);
            expectedDistances.add(12.785);
            expectedDistances.add(15.117);
            expectedDistances.add(11.236);
            expectedDistances.add(11.235);
            expectedDistances.add(19.597);
            expectedDistances.add(35.534);
        }
        ArrayList<String> expectedCharges = new ArrayList<>();
        {
            expectedCharges.add("CT275");
            expectedCharges.add("CT82");
            expectedCharges.add("CT12");
            expectedCharges.add("CT163");
            expectedCharges.add("CT261");
            expectedCharges.add("CT182");
            expectedCharges.add("CT235");
            expectedCharges.add("CT234");
            expectedCharges.add("CT106");
            expectedCharges.add("CT123");
            expectedCharges.add("CT97");
            expectedCharges.add("CT188");
            expectedCharges.add("CT315");
            expectedCharges.add("CT77");
            expectedCharges.add("CT124");
            expectedCharges.add("CT154");
            expectedCharges.add("CT211");
            expectedCharges.add("CT311");
            expectedCharges.add("CT81");
            expectedCharges.add("CT49");
            expectedCharges.add("CT113");
            expectedCharges.add("CT30");
            expectedCharges.add("CT34");
        }
        Double totalDistance = 0d;
        for (Double d:expectedDistances) {
            totalDistance+=d;
        }
        DistantPathRestricted expected = new DistantPathRestricted("CT194",expectedPath,23,expectedCharges,expectedDistances,totalDistance,"CT162");
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void bigMap_noAutonomy() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_big.csv");
        distMap.loadCSVMap(csvDist);


        DistantPathRestricted actual = e.shortestPathRestrictedByAutonomy(distMap, 0d);
        LinkedList<String> expectedPath = new LinkedList<>();
        ArrayList<Double> expectedDistances = new ArrayList<>();
        ArrayList<String> expectedCharges = new ArrayList<>();
        Double totalDistance = 0d;
        for (Double d:expectedDistances) {
            totalDistance+=d;
        }
        DistantPathRestricted expected = new DistantPathRestricted("CT194",expectedPath,0,expectedCharges,expectedDistances,totalDistance,"CT162");
        Assertions.assertEquals(expected,actual);
    }

}
