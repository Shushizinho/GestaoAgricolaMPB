import graph.Algorithms;
import graph.MyAlgorithms;
import graph.PairHub;
import org.isep_2dl_g121.CoordMap;
import org.isep_2dl_g121.DistMap;
import org.isep_2dl_g121.PathWithNoCharge;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.*;

public class USEI06 {

    @AfterEach
    public void tearDown() {
        DistMap.clear();
        CoordMap.clear();
    }

    @Test
    void testNull() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_Null.csv");
        distMap.loadCSVMap(csvDist);

        List<PathWithNoCharge> result = null;
        
        Assertions.assertNull(result);
    }

    @Test
    void testpathsWithoutChargeOneLine() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_OneLine.csv");
        distMap.loadCSVMap(csvDist);

        ArrayList<String> hubs = new ArrayList<>(List.of("CT10", "CT13"));

        ArrayList<PairHub<String, Boolean>> expectedPath = new ArrayList<>();
        expectedPath.add(new PairHub<>("CT10", hubs.contains("CT10")));
        expectedPath.add(new PairHub<>("CT13", hubs.contains("CT13")));
        ArrayList<Double> expectedDistances = new ArrayList<>();
        expectedDistances.add(63.448);
        Double totalDistance = 63.448;
        Double time = 38.0688;

        PathWithNoCharge path = new PathWithNoCharge("CT10", expectedPath, expectedDistances,totalDistance,time, "CT13");
        List<PathWithNoCharge> expected = new ArrayList<>();
        expected.add(path);

        String vOrig = "CT10";
        String vDest = "CT13";
        Double autonomy = 63.448;
        Integer velocity = 100;
        List<PathWithNoCharge> result = MyAlgorithms.pathsWithoutCharge(distMap,vOrig, vDest, autonomy, velocity, hubs);

        Assertions.assertEquals(expected.toString(), result.toString());
    }

    @Test
    void testpathsWithoutChargeMultipleLinesNull() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_MultipleLines.csv");
        distMap.loadCSVMap(csvDist);

        ArrayList<String> hubs = new ArrayList<>(List.of("CT3"));


         ArrayList<PairHub<String, Boolean>> expectedPath = new ArrayList<>();
        expectedPath.add(new PairHub<>("CT5", hubs.contains("CT5")));
        expectedPath.add(new PairHub<>("CT10", hubs.contains("CT10")));
        expectedPath.add(new PairHub<>("CT1", hubs.contains("CT1")));
        expectedPath.add(new PairHub<>("CT12", hubs.contains("CT12")));
        expectedPath.add(new PairHub<>("CT3", hubs.contains("CT3")));
        ArrayList<Double> expectedDistances = new ArrayList<>();
        expectedDistances.add(125.041);
        expectedDistances.add(110.848);
        expectedDistances.add(62.877);
        expectedDistances.add(50.467);

        Double totalDistance = 349.233;
        Double time = 22.1905;

        PathWithNoCharge path = new PathWithNoCharge("CT5", expectedPath, expectedDistances,totalDistance,time, "CT3");
        List<PathWithNoCharge> expected = new ArrayList<>();
        expected.add(path);


        String vOrig = "CT5";
        String vDest = "CT3";
        Double autonomy = 235.889; //com a autonomia dada não é possível realizar o precurso
        Integer velocity = 70;
        List<PathWithNoCharge> result = MyAlgorithms.pathsWithoutCharge(distMap,vOrig, vDest, autonomy, velocity, hubs);

        Assertions.assertNull(result);
    }

    @Test
    void testpathsWithoutChargeMultipleLines() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_MultipleLines.csv");
        distMap.loadCSVMap(csvDist);

        ArrayList<String> hubs = new ArrayList<>(List.of("CT3"));

        ArrayList<PairHub<String, Boolean>> expectedPath = new ArrayList<>();
        expectedPath.add(new PairHub<>("CT5", hubs.contains("CT5")));
        expectedPath.add(new PairHub<>("CT10", hubs.contains("CT10")));
        expectedPath.add(new PairHub<>("CT1", hubs.contains("CT1")));
        expectedPath.add(new PairHub<>("CT12", hubs.contains("CT12")));
        expectedPath.add(new PairHub<>("CT3", hubs.contains("CT3")));
        ArrayList<Double> expectedDistances = new ArrayList<>();
        expectedDistances.add(125.041);
        expectedDistances.add(110.848);
        expectedDistances.add(62.877);
        expectedDistances.add(50.467);

        Double totalDistance = 349.233;
        Double time = 299.3425714285715;

        PathWithNoCharge path = new PathWithNoCharge("CT5", expectedPath, expectedDistances,totalDistance,time, "CT3");
        List<PathWithNoCharge> expected = new ArrayList<>();
        expected.add(path);

        String vOrig = "CT5";
        String vDest = "CT3";
        Double autonomy = 349.233;
        Integer velocity = 70;
        List<PathWithNoCharge> result = MyAlgorithms.pathsWithoutCharge(distMap,vOrig, vDest, autonomy, velocity, hubs);

        Assertions.assertEquals(expected.toString(), result.toString());
    }

    @Test
    void testpathsWithoutChargeSmall9Paths() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_small.csv");
        distMap.loadCSVMap(csvDist);

        ArrayList<String> hubs = new ArrayList<>(List.of("CT6"));


        ArrayList<PairHub<String, Boolean>> expectedPath = new ArrayList<>();
        expectedPath.add(new PairHub<>("CT10", hubs.contains("CT10")));
        expectedPath.add(new PairHub<>("CT13", hubs.contains("CT13")));
        expectedPath.add(new PairHub<>("CT11", hubs.contains("CT11")));
        expectedPath.add(new PairHub<>("CT5", hubs.contains("CT5")));
        expectedPath.add(new PairHub<>("CT6", hubs.contains("CT6")));
        ArrayList<Double> expectedDistances = new ArrayList<>();
        expectedDistances.add(63.448);
        expectedDistances.add(121.584);
        expectedDistances.add(62.655);
        expectedDistances.add(100.563);

        Double totalDistance = 348.250;
        Double time = 298.5;


        ArrayList<PairHub<String, Boolean>> expectedPath2 = new ArrayList<>();
        expectedPath2.add(new PairHub<>("CT10", hubs.contains("CT10")));
        expectedPath2.add(new PairHub<>("CT6", hubs.contains("CT6")));
        ArrayList<Double> expectedDistances2 = new ArrayList<>();
        expectedDistances2.add(67.584);

        Double totalDistance2 = 67.584;
        Double time2 = 57.92914285714286;


        ArrayList<PairHub<String, Boolean>> expectedPath3 = new ArrayList<>();
        expectedPath3.add(new PairHub<>("CT10", hubs.contains("CT10")));
        expectedPath3.add(new PairHub<>("CT1", hubs.contains("CT1")));
        expectedPath3.add(new PairHub<>("CT17", hubs.contains("CT17")));
        expectedPath3.add(new PairHub<>("CT6", hubs.contains("CT6")));
        ArrayList<Double> expectedDistances3 = new ArrayList<>();
        expectedDistances3.add(110.848);
        expectedDistances3.add(69.282);
        expectedDistances3.add(73.828);

        Double totalDistance3 = 253.958;
        Double time3 = 217.67828571428572;


        ArrayList<PairHub<String, Boolean>> expectedPath4 = new ArrayList<>();
        expectedPath4.add(new PairHub<>("CT10", hubs.contains("CT10")));
        expectedPath4.add(new PairHub<>("CT1", hubs.contains("CT1")));
        expectedPath4.add(new PairHub<>("CT6", hubs.contains("CT6")));
        ArrayList<Double> expectedDistances4 = new ArrayList<>();
        expectedDistances4.add(110.848);
        expectedDistances4.add(56.717);

        Double totalDistance4 = 167.565;
        Double time4 = 143.62714285714287;


        ArrayList<PairHub<String, Boolean>> expectedPath5 = new ArrayList<>();
        expectedPath5.add(new PairHub<>("CT10", hubs.contains("CT10")));
        expectedPath5.add(new PairHub<>("CT5", hubs.contains("CT5")));
        expectedPath5.add(new PairHub<>("CT9", hubs.contains("CT9")));
        expectedPath5.add(new PairHub<>("CT17", hubs.contains("CT17")));
        expectedPath5.add(new PairHub<>("CT6", hubs.contains("CT6")));
        ArrayList<Double> expectedDistances5 = new ArrayList<>();
        expectedDistances5.add(125.041);
        expectedDistances5.add(90.186);
        expectedDistances5.add(62.879);
        expectedDistances5.add(73.828);

        Double totalDistance5 = 351.93399999999997;
        Double time5 = 301.6577142857143;


        ArrayList<PairHub<String, Boolean>> expectedPath6 = new ArrayList<>();
        expectedPath6.add(new PairHub<>("CT10", hubs.contains("CT10")));
        expectedPath6.add(new PairHub<>("CT5", hubs.contains("CT5")));
        expectedPath6.add(new PairHub<>("CT6", hubs.contains("CT6")));
        ArrayList<Double> expectedDistances6 = new ArrayList<>();
        expectedDistances6.add(125.041);
        expectedDistances6.add(100.563);

        Double totalDistance6 = 225.60399999999998;
        Double time6 = 193.37485714285714;


        ArrayList<PairHub<String, Boolean>> expectedPath7 = new ArrayList<>();
        expectedPath7.add(new PairHub<>("CT10", hubs.contains("CT10")));
        expectedPath7.add(new PairHub<>("CT5", hubs.contains("CT5")));
        expectedPath7.add(new PairHub<>("CT17", hubs.contains("CT17")));
        expectedPath7.add(new PairHub<>("CT1", hubs.contains("CT1")));
        expectedPath7.add(new PairHub<>("CT6", hubs.contains("CT6")));
        ArrayList<Double> expectedDistances7 = new ArrayList<>();
        expectedDistances7.add(125.041);
        expectedDistances7.add(111.134);
        expectedDistances7.add(69.282);
        expectedDistances7.add(56.717);

        Double totalDistance7 = 362.174;
        Double time7 = 310.43485714285714;


        ArrayList<PairHub<String, Boolean>> expectedPath8 = new ArrayList<>();
        expectedPath8.add(new PairHub<>("CT10", hubs.contains("CT10")));
        expectedPath8.add(new PairHub<>("CT5", hubs.contains("CT5")));
        expectedPath8.add(new PairHub<>("CT17", hubs.contains("CT17")));
        expectedPath8.add(new PairHub<>("CT6", hubs.contains("CT6")));
        ArrayList<Double> expectedDistances8 = new ArrayList<>();
        expectedDistances8.add(125.041);
        expectedDistances8.add(111.134);
        expectedDistances8.add(73.828);

        Double totalDistance8 = 310.00300000000004;
        Double time8 = 265.7168571428571;


        ArrayList<PairHub<String, Boolean>> expectedPath9 = new ArrayList<>();
        expectedPath9.add(new PairHub<>("CT10", hubs.contains("CT10")));
        expectedPath9.add(new PairHub<>("CT11", hubs.contains("CT11")));
        expectedPath9.add(new PairHub<>("CT5", hubs.contains("CT5")));
        expectedPath9.add(new PairHub<>("CT6", hubs.contains("CT6")));
        ArrayList<Double> expectedDistances9 = new ArrayList<>();
        expectedDistances9.add(142.470);
        expectedDistances9.add(62.655);
        expectedDistances9.add(100.563);

        Double totalDistance9 = 305.688;
        Double time9 = 262.0182857142857;

        String vOrig = "CT10";
        String vDest = "CT6";

        PathWithNoCharge path = new PathWithNoCharge(vOrig, expectedPath, expectedDistances,totalDistance,time, vDest);
        PathWithNoCharge path2 = new PathWithNoCharge(vOrig, expectedPath2, expectedDistances2,totalDistance2,time2, vDest);
        PathWithNoCharge path3 = new PathWithNoCharge(vOrig, expectedPath3, expectedDistances3, totalDistance3, time3, vDest);
        PathWithNoCharge path4 = new PathWithNoCharge(vOrig, expectedPath4, expectedDistances4, totalDistance4, time4, vDest);
        PathWithNoCharge path5 = new PathWithNoCharge(vOrig, expectedPath5, expectedDistances5, totalDistance5, time5, vDest);
        PathWithNoCharge path6 = new PathWithNoCharge(vOrig, expectedPath6, expectedDistances6, totalDistance6, time6, vDest);
        PathWithNoCharge path7 = new PathWithNoCharge(vOrig, expectedPath7, expectedDistances7, totalDistance7, time7, vDest);
        PathWithNoCharge path8 = new PathWithNoCharge(vOrig, expectedPath8, expectedDistances8, totalDistance8, time8, vDest);
        PathWithNoCharge path9 = new PathWithNoCharge(vOrig, expectedPath9, expectedDistances9, totalDistance9, time9, vDest);
        List<PathWithNoCharge> expected = new ArrayList<>();
        expected.add(path);
        expected.add(path2);
        expected.add(path3);
        expected.add(path4);
        expected.add(path5);
        expected.add(path6);
        expected.add(path7);
        expected.add(path8);
        expected.add(path9);
        Double autonomy = 390.000;
        Integer velocity = 70;
        List<PathWithNoCharge> result = MyAlgorithms.pathsWithoutCharge(distMap,vOrig, vDest, autonomy, velocity, hubs);

        Assertions.assertEquals(expected.toString(), result.toString());
      }


    @Test
    void testpathsWithoutChargeBigPaths() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_big.csv");
        distMap.loadCSVMap(csvDist);

        ArrayList<String> hubs = new ArrayList<>(List.of("CT90"));


        ArrayList<PairHub<String, Boolean>> expectedPath = new ArrayList<>();
        expectedPath.add(new PairHub<>("CT32", hubs.contains("CT32")));
        expectedPath.add(new PairHub<>("CT160", hubs.contains("CT160")));
        expectedPath.add(new PairHub<>("CT69", hubs.contains("CT69")));
        expectedPath.add(new PairHub<>("CT288", hubs.contains("CT288")));
        expectedPath.add(new PairHub<>("CT90", hubs.contains("CT90")));
        ArrayList<Double> expectedDistances = new ArrayList<>();
        expectedDistances.add(6.992);
        expectedDistances.add(13.987);
        expectedDistances.add(15.907);
        expectedDistances.add(8.236);

        Double totalDistance = 45.122;
        Double time = 45.122;

        ArrayList<PairHub<String, Boolean>> expectedPath2 = new ArrayList<>();
        expectedPath2.add(new PairHub<>("CT32", hubs.contains("CT32")));
        expectedPath2.add(new PairHub<>("CT160", hubs.contains("CT160")));
        expectedPath2.add(new PairHub<>("CT288", hubs.contains("CT288")));
        expectedPath2.add(new PairHub<>("CT90", hubs.contains("CT90")));
        ArrayList<Double> expectedDistances2 = new ArrayList<>();
        expectedDistances2.add(6.992);
        expectedDistances2.add(12.596);
        expectedDistances2.add(8.236);

        Double totalDistance2 = 27.824;
        Double time2 = 27.824;


        ArrayList<PairHub<String, Boolean>> expectedPath3 = new ArrayList<>();
        expectedPath3.add(new PairHub<>("CT32", hubs.contains("CT32")));
        expectedPath3.add(new PairHub<>("CT160", hubs.contains("CT160")));
        expectedPath3.add(new PairHub<>("CT288", hubs.contains("CT288")));
        expectedPath3.add(new PairHub<>("CT142", hubs.contains("CT142")));
        expectedPath3.add(new PairHub<>("CT90", hubs.contains("CT90")));
        ArrayList<Double> expectedDistances3 = new ArrayList<>();
        expectedDistances3.add(6.992);
        expectedDistances3.add(12.596);
        expectedDistances3.add(12.968);
        expectedDistances3.add(12.134);

        Double totalDistance3 = 44.690;
        Double time3 = 44.69;


        ArrayList<PairHub<String, Boolean>> expectedPath4 = new ArrayList<>();
        expectedPath4.add(new PairHub<>("CT32", hubs.contains("CT32")));
        expectedPath4.add(new PairHub<>("CT160", hubs.contains("CT160")));
        expectedPath4.add(new PairHub<>("CT288", hubs.contains("CT288")));
        expectedPath4.add(new PairHub<>("CT142", hubs.contains("CT142")));
        expectedPath4.add(new PairHub<>("CT218", hubs.contains("CT218")));
        expectedPath4.add(new PairHub<>("CT90", hubs.contains("CT90")));
        ArrayList<Double> expectedDistances4 = new ArrayList<>();
        expectedDistances4.add(6.992);
        expectedDistances4.add(12.596);
        expectedDistances4.add(12.968);
        expectedDistances4.add(8.198);
        expectedDistances4.add(16.901);

        Double totalDistance4 = 57.655;
        Double time4 = 57.655;


        ArrayList<PairHub<String, Boolean>> expectedPath5 = new ArrayList<>();
        expectedPath5.add(new PairHub<>("CT32", hubs.contains("CT32")));
        expectedPath5.add(new PairHub<>("CT160", hubs.contains("CT160")));
        expectedPath5.add(new PairHub<>("CT181", hubs.contains("CT181")));
        expectedPath5.add(new PairHub<>("CT142", hubs.contains("CT142")));
        expectedPath5.add(new PairHub<>("CT90", hubs.contains("CT90")));
        ArrayList<Double> expectedDistances5 = new ArrayList<>();
        expectedDistances5.add(6.992);
        expectedDistances5.add(20.660);
        expectedDistances5.add(18.407);
        expectedDistances5.add(12.134);

        Double totalDistance5 = 58.193;
        Double time5 = 58.193;


        ArrayList<PairHub<String, Boolean>> expectedPath6 = new ArrayList<>();
        expectedPath6.add(new PairHub<>("CT32", hubs.contains("CT32")));
        expectedPath6.add(new PairHub<>("CT198", hubs.contains("CT198")));
        expectedPath6.add(new PairHub<>("CT160", hubs.contains("CT160")));
        expectedPath6.add(new PairHub<>("CT288", hubs.contains("CT288")));
        expectedPath6.add(new PairHub<>("CT90", hubs.contains("CT90")));
        ArrayList<Double> expectedDistances6 = new ArrayList<>();
        expectedDistances6.add(12.014);
        expectedDistances6.add(17.635);
        expectedDistances6.add(12.596);
        expectedDistances6.add(8.236);

        Double totalDistance6 = 50.48100000000001;
        Double time6 = 50.48100000000001;


        ArrayList<PairHub<String, Boolean>> expectedPath7 = new ArrayList<>();
        expectedPath7.add(new PairHub<>("CT32", hubs.contains("CT32")));
        expectedPath7.add(new PairHub<>("CT181", hubs.contains("CT181")));
        expectedPath7.add(new PairHub<>("CT209", hubs.contains("CT209")));
        expectedPath7.add(new PairHub<>("CT142", hubs.contains("CT142")));
        expectedPath7.add(new PairHub<>("CT90", hubs.contains("CT90")));
        ArrayList<Double> expectedDistances7 = new ArrayList<>();
        expectedDistances7.add(19.440);
        expectedDistances7.add(16.048);
        expectedDistances7.add(4.803);
        expectedDistances7.add(12.134);

        Double totalDistance7 = 52.425;
        Double time7 = 52.425;


        ArrayList<PairHub<String, Boolean>> expectedPath8 = new ArrayList<>();
        expectedPath8.add(new PairHub<>("CT32", hubs.contains("CT32")));
        expectedPath8.add(new PairHub<>("CT181", hubs.contains("CT181")));
        expectedPath8.add(new PairHub<>("CT209", hubs.contains("CT209")));
        expectedPath8.add(new PairHub<>("CT218", hubs.contains("CT218")));
        expectedPath8.add(new PairHub<>("CT90", hubs.contains("CT90")));
        ArrayList<Double> expectedDistances8 = new ArrayList<>();
        expectedDistances8.add(19.440);
        expectedDistances8.add(16.048);
        expectedDistances8.add(6.343);
        expectedDistances8.add(16.901);

        Double totalDistance8 = 58.732;
        Double time8 = 58.732;


        ArrayList<PairHub<String, Boolean>> expectedPath9 = new ArrayList<>();
        expectedPath9.add(new PairHub<>("CT32", hubs.contains("CT32")));
        expectedPath9.add(new PairHub<>("CT181", hubs.contains("CT181")));
        expectedPath9.add(new PairHub<>("CT142", hubs.contains("CT142")));
        expectedPath9.add(new PairHub<>("CT90", hubs.contains("CT90")));
        ArrayList<Double> expectedDistances9 = new ArrayList<>();
        expectedDistances9.add(19.440);
        expectedDistances9.add(18.407);
        expectedDistances9.add(12.134);

        Double totalDistance9 = 49.981;
        Double time9 = 49.981;


        ArrayList<PairHub<String, Boolean>> expectedPath10 = new ArrayList<>();
        expectedPath10.add(new PairHub<>("CT32", hubs.contains("CT32")));
        expectedPath10.add(new PairHub<>("CT181", hubs.contains("CT181")));
        expectedPath10.add(new PairHub<>("CT142", hubs.contains("CT142")));
        expectedPath10.add(new PairHub<>("CT288", hubs.contains("CT288")));
        expectedPath10.add(new PairHub<>("CT90", hubs.contains("CT90")));
        ArrayList<Double> expectedDistances10 = new ArrayList<>();
        expectedDistances10.add(19.440);
        expectedDistances10.add(18.407);
        expectedDistances10.add(12.968);
        expectedDistances10.add(8.236);

        Double totalDistance10 = 59.051;
        Double time10 = 59.051;

        String vOrig = "CT32";
        String vDest = "CT90";

        PathWithNoCharge path = new PathWithNoCharge(vOrig, expectedPath, expectedDistances, totalDistance, time, vDest);
        PathWithNoCharge path2 = new PathWithNoCharge(vOrig, expectedPath2, expectedDistances2, totalDistance2, time2, vDest);
        PathWithNoCharge path3 = new PathWithNoCharge(vOrig, expectedPath3, expectedDistances3, totalDistance3, time3, vDest);
        PathWithNoCharge path4 = new PathWithNoCharge(vOrig, expectedPath4, expectedDistances4, totalDistance4, time4, vDest);
        PathWithNoCharge path5 = new PathWithNoCharge(vOrig, expectedPath5, expectedDistances5, totalDistance5, time5, vDest);
        PathWithNoCharge path6 = new PathWithNoCharge(vOrig, expectedPath6, expectedDistances6, totalDistance6, time6, vDest);
        PathWithNoCharge path7 = new PathWithNoCharge(vOrig, expectedPath7, expectedDistances7, totalDistance7, time7, vDest);
        PathWithNoCharge path8 = new PathWithNoCharge(vOrig, expectedPath8, expectedDistances8, totalDistance8, time8, vDest);
        PathWithNoCharge path9 = new PathWithNoCharge(vOrig, expectedPath9, expectedDistances9, totalDistance9, time9, vDest);
        PathWithNoCharge path10 = new PathWithNoCharge(vOrig, expectedPath10, expectedDistances10, totalDistance10, time10, vDest);
        List<PathWithNoCharge> expected = new ArrayList<>();
        expected.add(path);
        expected.add(path2);
        expected.add(path3);
        expected.add(path4);
        expected.add(path5);
        expected.add(path6);
        expected.add(path7);
        expected.add(path8);
        expected.add(path9);
        expected.add(path10);

        Double autonomy = 60.000;
        Integer velocity = 60;
        List<PathWithNoCharge> result = MyAlgorithms.pathsWithoutCharge(distMap,vOrig, vDest, autonomy, velocity, hubs);

        Assertions.assertEquals(expected.toString(), result.toString());
       }
}
