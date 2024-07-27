import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.isep_2dl_g121.CoordMap;
import org.isep_2dl_g121.DistMap;
import org.isep_2dl_g121.PairCoord;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class USEI01 {

    @AfterEach
    public void tearDown() {
        DistMap.clear();
        CoordMap.clear();
    }

    @Test
    void NullEdgeToDistMap() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_Null.csv");
        distMap.loadCSVMap(csvDist);

        DistMap expected = new DistMap(false);

        Assertions.assertEquals(expected.toString(), distMap.toString());
    }

    @Test
    void NullCoordMap() throws Exception {
        CoordMap coordMap = new CoordMap();
        File csvCoord = new File("Data/locais_Null.csv");
        coordMap.loadCSVMap(csvCoord);

        CoordMap expected = new CoordMap();
        String localidade = "CT10";
        PairCoord pairCoord = new PairCoord(40.6389, -8.6553);
        Map<String, PairCoord> c = new HashMap<>();
        c.put(localidade, pairCoord);
        CoordMap.setCoordenadas(c);

        Assertions.assertEquals(expected.toString(), coordMap.toString());
    }


    @Test
    void addOneEdgeToDistMap() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_OneLine.csv");
        distMap.loadCSVMap(csvDist);

        DistMap expected = new DistMap(false);
        String vOrig = "CT10";
        String vDest = "CT13";
        Double dist = 63448.0;
        expected.addEdge(vOrig, vDest, dist);

        Assertions.assertEquals(expected.toString(), distMap.toString());
    }

    @Test
    void addOneCoordToCoordMap() throws Exception {
        CoordMap coordMap = new CoordMap();
        File csvCoord = new File("Data/locais_OneLine.csv");
        coordMap.loadCSVMap(csvCoord);

        CoordMap expected = new CoordMap();
        String localidade = "CT1";
        PairCoord pairCoord = new PairCoord(40.6389, -8.6553);
        Map<String, PairCoord> c = new HashMap<>();
        c.put(localidade, pairCoord);
        CoordMap.setCoordenadas(c);

        Assertions.assertEquals(expected.toString(), coordMap.toString());

    }

    @Test
    void addMultipleEdgesToDistMap() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_MultipleLines.csv");
        distMap.loadCSVMap(csvDist);

        DistMap expected = new DistMap(false);
        String vOrig = "CT10";
        String vDest = "CT13";
        Double dist = 63448.0;
        expected.addEdge(vOrig, vDest, dist);

        String vOrig2 = "CT10";
        String vDest2 = "CT6";
        Double dist2 = 67584.0;
        expected.addEdge(vOrig2, vDest2, dist2);

        String vOrig3 = "CT10";
        String vDest3 = "CT1";
        Double dist3 = 110848.0;
        expected.addEdge(vOrig3, vDest3, dist3);

        String vOrig4 = "CT10";
        String vDest4 = "CT5";
        Double dist4 = 125041.0;
        expected.addEdge(vOrig4, vDest4, dist4);

        String vOrig5 = "CT12";
        String vDest5 = "CT3";
        Double dist5 = 50467.0;
        expected.addEdge(vOrig5, vDest5, dist5);

        String vOrig6 = "CT12";
        String vDest6 = "CT1";
        Double dist6 = 62877.0;
        expected.addEdge(vOrig6, vDest6, dist6);

        Assertions.assertEquals(expected.toString(), distMap.toString());

    }

    @Test
    void addMultipleCoordToCoordMap() throws Exception {
        CoordMap coordMap = new CoordMap();
        File csvCoord = new File("Data/locais_OneLine.csv");
        coordMap.loadCSVMap(csvCoord);

        CoordMap expected = new CoordMap();
        Map<String, PairCoord> c = new HashMap<>();
        String localidade = "CT1";
        PairCoord pairCoord = new PairCoord(40.6389, -8.6553);
        c.put(localidade, pairCoord);

        String localidade1 = "CT2";
        PairCoord pairCoord1 = new PairCoord(38.0333,-7.8833);
        c.put(localidade1, pairCoord1);

        String localidade3 = "CT3";
        PairCoord pairCoord3 = new PairCoord(41.5333,-8.4167);
        c.put(localidade3, pairCoord3);

        String localidade4 = "CT15";
        PairCoord pairCoord4 = new PairCoord(41.7,-8.8333);
        c.put(localidade4, pairCoord4);

        String localidade5 = "CT16";
        PairCoord pairCoord5 = new PairCoord(41.3002,-7.7398);
        c.put(localidade5, pairCoord5);

        String localidade6 = "CT12";
        PairCoord pairCoord6 = new PairCoord(41.1495,-8.6108);
        c.put(localidade6, pairCoord6);
        CoordMap.setCoordenadas(c);

        Assertions.assertEquals(expected.toString(), coordMap.toString());
    }

    @Test
    void SmallFileToDistMap() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_small.csv");
        distMap.loadCSVMap(csvDist);

        String expected = "2282767202";
        String result = DistMap.generateChecksum(distMap);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void SmallFileStringToDistMap() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_small.csv");
        distMap.loadCSVMap(csvDist);
        String expected;

        {
            expected = "Graph: 17 vertices, 66 edges\n" +
                    "CT10: \n" +
                    "CT10 -> CT13\n" +
                    "Weight: 63448CT10 -> CT6\n" +
                    "Weight: 67584CT10 -> CT1\n" +
                    "Weight: 110848CT10 -> CT5\n" +
                    "Weight: 125041CT10 -> CT11\n" +
                    "Weight: 142470\n" +
                    "CT13: \n" +
                    "CT13 -> CT10\n" +
                    "Weight: 63448CT13 -> CT11\n" +
                    "Weight: 121584CT13 -> CT14\n" +
                    "Weight: 89813CT13 -> CT7\n" +
                    "Weight: 111686\n" +
                    "CT6: \n" +
                    "CT6 -> CT10\n" +
                    "Weight: 67584CT6 -> CT17\n" +
                    "Weight: 73828CT6 -> CT1\n" +
                    "Weight: 56717CT6 -> CT5\n" +
                    "Weight: 100563\n" +
                    "CT1: \n" +
                    "CT1 -> CT10\n" +
                    "Weight: 110848CT1 -> CT12\n" +
                    "Weight: 62877CT1 -> CT17\n" +
                    "Weight: 69282CT1 -> CT6\n" +
                    "Weight: 56717\n" +
                    "CT5: \n" +
                    "CT5 -> CT10\n" +
                    "Weight: 125041CT5 -> CT11\n" +
                    "Weight: 62655CT5 -> CT9\n" +
                    "Weight: 90186CT5 -> CT6\n" +
                    "Weight: 100563CT5 -> CT17\n" +
                    "Weight: 111134\n" +
                    "CT12: \n" +
                    "CT12 -> CT3\n" +
                    "Weight: 50467CT12 -> CT1\n" +
                    "Weight: 62877CT12 -> CT15\n" +
                    "Weight: 70717CT12 -> CT16\n" +
                    "Weight: 82996\n" +
                    "CT3: \n" +
                    "CT3 -> CT12\n" +
                    "Weight: 50467CT3 -> CT16\n" +
                    "Weight: 68957CT3 -> CT15\n" +
                    "Weight: 43598CT3 -> CT4\n" +
                    "Weight: 157223\n" +
                    "CT15: \n" +
                    "CT15 -> CT12\n" +
                    "Weight: 70717CT15 -> CT3\n" +
                    "Weight: 43598\n" +
                    "CT11: \n" +
                    "CT11 -> CT5\n" +
                    "Weight: 62655CT11 -> CT13\n" +
                    "Weight: 121584CT11 -> CT10\n" +
                    "Weight: 142470CT11 -> CT2\n" +
                    "Weight: 163996\n" +
                    "CT14: \n" +
                    "CT14 -> CT13\n" +
                    "Weight: 89813CT14 -> CT7\n" +
                    "Weight: 95957CT14 -> CT2\n" +
                    "Weight: 114913CT14 -> CT8\n" +
                    "Weight: 207558\n" +
                    "CT7: \n" +
                    "CT7 -> CT14\n" +
                    "Weight: 95957CT7 -> CT13\n" +
                    "Weight: 111686CT7 -> CT2\n" +
                    "Weight: 65574\n" +
                    "CT2: \n" +
                    "CT2 -> CT14\n" +
                    "Weight: 114913CT2 -> CT7\n" +
                    "Weight: 65574CT2 -> CT8\n" +
                    "Weight: 125105CT2 -> CT11\n" +
                    "Weight: 163996\n" +
                    "CT8: \n" +
                    "CT8 -> CT14\n" +
                    "Weight: 207558CT8 -> CT2\n" +
                    "Weight: 125105\n" +
                    "CT16: \n" +
                    "CT16 -> CT3\n" +
                    "Weight: 68957CT16 -> CT17\n" +
                    "Weight: 79560CT16 -> CT12\n" +
                    "Weight: 82996CT16 -> CT9\n" +
                    "Weight: 103704CT16 -> CT4\n" +
                    "Weight: 110133\n" +
                    "CT17: \n" +
                    "CT17 -> CT16\n" +
                    "Weight: 79560CT17 -> CT9\n" +
                    "Weight: 62879CT17 -> CT1\n" +
                    "Weight: 69282CT17 -> CT6\n" +
                    "Weight: 73828CT17 -> CT5\n" +
                    "Weight: 111134\n" +
                    "CT9: \n" +
                    "CT9 -> CT16\n" +
                    "Weight: 103704CT9 -> CT17\n" +
                    "Weight: 62879CT9 -> CT4\n" +
                    "Weight: 162527CT9 -> CT5\n" +
                    "Weight: 90186\n" +
                    "CT4: \n" +
                    "CT4 -> CT16\n" +
                    "Weight: 110133CT4 -> CT3\n" +
                    "Weight: 157223CT4 -> CT9\n" +
                    "Weight: 162527\n";
        }

        Assertions.assertEquals(expected, distMap.toString());
    }

    @Test
    void SmallFileCoordMap() throws Exception {
        CoordMap coordMap = new CoordMap();
        File csvCoord = new File("Data/locais_small.csv");
        coordMap.loadCSVMap(csvCoord);

       String result = CoordMap.generateChecksum(coordMap);
       String expected = "-12024329803";

        Assertions.assertEquals(expected, result);
    }

    @Test
    void SmallFileStringCoordMap() throws Exception {
        CoordMap coordMap = new CoordMap();
        File csvCoord = new File("Data/locais_small.csv");
        coordMap.loadCSVMap(csvCoord);

        String expected;

        {
            expected = "Map: 17 localidades\n" +
                    "Localidade: CT2\n" +
                    "Coordenadas: 38.0333, -7.8833\n" +
                    "Localidade: CT1\n" +
                    "Coordenadas: 40.6389, -8.6553\n" +
                    "Localidade: CT4\n" +
                    "Coordenadas: 41.8, -6.75\n" +
                    "Localidade: CT3\n" +
                    "Coordenadas: 41.5333, -8.4167\n" +
                    "Localidade: CT6\n" +
                    "Coordenadas: 40.2111, -8.4291\n" +
                    "Localidade: CT5\n" +
                    "Coordenadas: 39.823, -7.4931\n" +
                    "Localidade: CT8\n" +
                    "Coordenadas: 37.0161, -7.935\n" +
                    "Localidade: CT7\n" +
                    "Coordenadas: 38.5667, -7.9\n" +
                    "Localidade: CT17\n" +
                    "Coordenadas: 40.6667, -7.9167\n" +
                    "Localidade: CT16\n" +
                    "Coordenadas: 41.3002, -7.7398\n" +
                    "Localidade: CT9\n" +
                    "Coordenadas: 40.5364, -7.2683\n" +
                    "Localidade: CT15\n" +
                    "Coordenadas: 41.7, -8.8333\n" +
                    "Localidade: CT14\n" +
                    "Coordenadas: 38.5243, -8.8926\n" +
                    "Localidade: CT13\n" +
                    "Coordenadas: 39.2369, -8.685\n" +
                    "Localidade: CT12\n" +
                    "Coordenadas: 41.1495, -8.6108\n" +
                    "Localidade: CT11\n" +
                    "Coordenadas: 39.3167, -7.4167\n" +
                    "Localidade: CT10\n" +
                    "Coordenadas: 39.7444, -8.8072\n";
        }

        Assertions.assertEquals(expected, coordMap.toString());
    }

    @Test
    void BigFileStringToDistMap() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_Big.csv");
        distMap.loadCSVMap(csvDist);
        String expected;

        {
            expected = "Graph: 323 vertices, 1566 edges\n" +
                    "CT32: \n" +
                    "CT32 -> CT160\n" +
                    "Weight: 6992CT32 -> CT198\n" +
                    "Weight: 12014CT32 -> CT3\n" +
                    "Weight: 17407CT32 -> CT181\n" +
                    "Weight: 19440\n" +
                    "CT160: \n" +
                    "CT160 -> CT32\n" +
                    "Weight: 6992CT160 -> CT198\n" +
                    "Weight: 17635CT160 -> CT69\n" +
                    "Weight: 13987CT160 -> CT288\n" +
                    "Weight: 12596CT160 -> CT181\n" +
                    "Weight: 20660\n" +
                    "CT198: \n" +
                    "CT198 -> CT32\n" +
                    "Weight: 12014CT198 -> CT114\n" +
                    "Weight: 6341CT198 -> CT3\n" +
                    "Weight: 8615CT198 -> CT286\n" +
                    "Weight: 12034CT198 -> CT160\n" +
                    "Weight: 17635CT198 -> CT165\n" +
                    "Weight: 24698\n" +
                    "CT3: \n" +
                    "CT3 -> CT32\n" +
                    "Weight: 17407CT3 -> CT198\n" +
                    "Weight: 8615CT3 -> CT286\n" +
                    "Weight: 4882CT3 -> CT114\n" +
                    "Weight: 6514\n" +
                    "CT31: \n" +
                    "CT31 -> CT259\n" +
                    "Weight: 2352CT31 -> CT93\n" +
                    "Weight: 4163CT31 -> CT264\n" +
                    "Weight: 25192CT31 -> CT263\n" +
                    "Weight: 22541\n" +
                    "CT259: \n" +
                    "CT259 -> CT31\n" +
                    "Weight: 2352CT259 -> CT52\n" +
                    "Weight: 4087CT259 -> CT93\n" +
                    "Weight: 4324CT259 -> CT19\n" +
                    "Weight: 6823\n" +
                    "CT93: \n" +
                    "CT93 -> CT31\n" +
                    "Weight: 4163CT93 -> CT19\n" +
                    "Weight: 3808CT93 -> CT259\n" +
                    "Weight: 4324CT93 -> CT95\n" +
                    "Weight: 8278\n" +
                    "CT34: \n" +
                    "CT34 -> CT220\n" +
                    "Weight: 5190CT34 -> CT207\n" +
                    "Weight: 15150CT34 -> CT36\n" +
                    "Weight: 17857CT34 -> CT221\n" +
                    "Weight: 18438CT34 -> CT276\n" +
                    "Weight: 19597CT34 -> CT162\n" +
                    "Weight: 35534CT34 -> CT293\n" +
                    "Weight: 29637\n" +
                    "CT220: \n" +
                    "CT220 -> CT34\n" +
                    "Weight: 5190CT220 -> CT36\n" +
                    "Weight: 16237CT220 -> CT221\n" +
                    "Weight: 15918CT220 -> CT276\n" +
                    "Weight: 15701CT220 -> CT207\n" +
                    "Weight: 18109\n" +
                    "CT207: \n" +
                    "CT207 -> CT34\n" +
                    "Weight: 15150CT207 -> CT36\n" +
                    "Weight: 15011CT207 -> CT307\n" +
                    "Weight: 17348CT207 -> CT293\n" +
                    "Weight: 15923CT207 -> CT220\n" +
                    "Weight: 18109CT207 -> CT162\n" +
                    "Weight: 36886CT207 -> CT172\n" +
                    "Weight: 21223\n" +
                    "CT36: \n" +
                    "CT36 -> CT34\n" +
                    "Weight: 17857CT36 -> CT221\n" +
                    "Weight: 3237CT36 -> CT207\n" +
                    "Weight: 15011CT36 -> CT220\n" +
                    "Weight: 16237CT36 -> CT66\n" +
                    "Weight: 24822CT36 -> CT307\n" +
                    "Weight: 22863CT36 -> CT298\n" +
                    "Weight: 24732CT36 -> CT293\n" +
                    "Weight: 29284\n" +
                    "CT221: \n" +
                    "CT221 -> CT34\n" +
                    "Weight: 18438CT221 -> CT36\n" +
                    "Weight: 3237CT221 -> CT220\n" +
                    "Weight: 15918CT221 -> CT298\n" +
                    "Weight: 24459\n" +
                    "CT276: \n" +
                    "CT276 -> CT34\n" +
                    "Weight: 19597CT276 -> CT300\n" +
                    "Weight: 18489CT276 -> CT316\n" +
                    "Weight: 14774CT276 -> CT220\n" +
                    "Weight: 15701CT276 -> CT30\n" +
                    "Weight: 11235\n" +
                    "CT33: \n" +
                    "CT33 -> CT26\n" +
                    "Weight: 11293CT33 -> CT214\n" +
                    "Weight: 15087CT33 -> CT120\n" +
                    "Weight: 15102CT33 -> CT219\n" +
                    "Weight: 18428CT33 -> CT76\n" +
                    "Weight: 22907\n" +
                    "CT26: \n" +
                    "CT26 -> CT33\n" +
                    "Weight: 11293CT26 -> CT219\n" +
                    "Weight: 25320CT26 -> CT116\n" +
                    "Weight: 18935CT26 -> CT120\n" +
                    "Weight: 13278CT26 -> CT214\n" +
                    "Weight: 24578\n" +
                    "CT214: \n" +
                    "CT214 -> CT33\n" +
                    "Weight: 15087CT214 -> CT76\n" +
                    "Weight: 16278CT214 -> CT91\n" +
                    "Weight: 15056CT214 -> CT166\n" +
                    "Weight: 9459CT214 -> CT120\n" +
                    "Weight: 19129CT214 -> CT146\n" +
                    "Weight: 16146CT214 -> CT270\n" +
                    "Weight: 23720CT214 -> CT26\n" +
                    "Weight: 24578\n" +
                    "CT120: \n" +
                    "CT120 -> CT33\n" +
                    "Weight: 15102CT120 -> CT76\n" +
                    "Weight: 13256CT120 -> CT208\n" +
                    "Weight: 11975CT120 -> CT26\n" +
                    "Weight: 13278CT120 -> CT214\n" +
                    "Weight: 19129CT120 -> CT262\n" +
                    "Weight: 20705\n" +
                    "CT219: \n" +
                    "CT219 -> CT33\n" +
                    "Weight: 18428CT219 -> CT270\n" +
                    "Weight: 16450CT219 -> CT70\n" +
                    "Weight: 21536CT219 -> CT26\n" +
                    "Weight: 25320CT219 -> CT140\n" +
                    "Weight: 27102\n" +
                    "CT76: \n" +
                    "CT76 -> CT33\n" +
                    "Weight: 22907CT76 -> CT193\n" +
                    "Weight: 30186CT76 -> CT208\n" +
                    "Weight: 12029CT76 -> CT120\n" +
                    "Weight: 13256CT76 -> CT146\n" +
                    "Weight: 14118CT76 -> CT214\n" +
                    "Weight: 16278CT76 -> CT166\n" +
                    "Weight: 16510CT76 -> CT205\n" +
                    "Weight: 25950\n" +
                    "CT35: \n" +
                    "CT35 -> CT290\n" +
                    "Weight: 5431CT35 -> CT102\n" +
                    "Weight: 5591CT35 -> CT150\n" +
                    "Weight: 8059CT35 -> CT38\n" +
                    "Weight: 9606CT35 -> CT195\n" +
                    "Weight: 10631\n" +
                    "CT290: \n" +
                    "CT290 -> CT35\n" +
                    "Weight: 5431CT290 -> CT195\n" +
                    "Weight: 11102CT290 -> CT309\n" +
                    "Weight: 4675CT290 -> CT150\n" +
                    "Weight: 3909\n" +
                    "CT102: \n" +
                    "CT102 -> CT35\n" +
                    "Weight: 5591CT102 -> CT38\n" +
                    "Weight: 8427CT102 -> CT195\n" +
                    "Weight: 12911CT102 -> CT112\n" +
                    "Weight: 13795\n" +
                    "CT150: \n" +
                    "CT150 -> CT35\n" +
                    "Weight: 8059CT150 -> CT195\n" +
                    "Weight: 8943CT150 -> CT309\n" +
                    "Weight: 2536CT150 -> CT129\n" +
                    "Weight: 7812CT150 -> CT290\n" +
                    "Weight: 3909\n" +
                    "CT38: \n" +
                    "CT38 -> CT35\n" +
                    "Weight: 9606CT38 -> CT195\n" +
                    "Weight: 7012CT38 -> CT102\n" +
                    "Weight: 8427CT38 -> CT112\n" +
                    "Weight: 11239CT38 -> CT252\n" +
                    "Weight: 15081\n" +
                    "CT195: \n" +
                    "CT195 -> CT38\n" +
                    "Weight: 7012CT195 -> CT150\n" +
                    "Weight: 8943CT195 -> CT129\n" +
                    "Weight: 9712CT195 -> CT35\n" +
                    "Weight: 10631CT195 -> CT290\n" +
                    "Weight: 11102CT195 -> CT102\n" +
                    "Weight: 12911\n" +
                    "CT37: \n" +
                    "CT37 -> CT127\n" +
                    "Weight: 10254CT37 -> CT272\n" +
                    "Weight: 18341CT37 -> CT218\n" +
                    "Weight: 18461CT37 -> CT205\n" +
                    "Weight: 22908\n" +
                    "CT127: \n" +
                    "CT127 -> CT37\n" +
                    "Weight: 10254CT127 -> CT205\n" +
                    "Weight: 19978CT127 -> CT146\n" +
                    "Weight: 13125CT127 -> CT218\n" +
                    "Weight: 15014\n" +
                    "CT272: \n" +
                    "CT272 -> CT37\n" +
                    "Weight: 18341CT272 -> CT199\n" +
                    "Weight: 16168CT272 -> CT72\n" +
                    "Weight: 8761CT272 -> CT246\n" +
                    "Weight: 9908CT272 -> CT279\n" +
                    "Weight: 18933\n" +
                    "CT218: \n" +
                    "CT218 -> CT37\n" +
                    "Weight: 18461CT218 -> CT209\n" +
                    "Weight: 6343CT218 -> CT90\n" +
                    "Weight: 16901CT218 -> CT142\n" +
                    "Weight: 8198CT218 -> CT146\n" +
                    "Weight: 12809CT218 -> CT127\n" +
                    "Weight: 15014CT218 -> CT166\n" +
                    "Weight: 16351\n" +
                    "CT39: \n" +
                    "CT39 -> CT137\n" +
                    "Weight: 9485CT39 -> CT74\n" +
                    "Weight: 9842CT39 -> CT7\n" +
                    "Weight: 11460CT39 -> CT266\n" +
                    "Weight: 12153\n" +
                    "CT137: \n" +
                    "CT137 -> CT39\n" +
                    "Weight: 9485CT137 -> CT74\n" +
                    "Weight: 4478CT137 -> CT225\n" +
                    "Weight: 7921CT137 -> CT266\n" +
                    "Weight: 6272\n" +
                    "CT74: \n" +
                    "CT74 -> CT39\n" +
                    "Weight: 9842CT74 -> CT137\n" +
                    "Weight: 4478CT74 -> CT225\n" +
                    "Weight: 7726CT74 -> CT138\n" +
                    "Weight: 19683\n" +
                    "CT7: \n" +
                    "CT7 -> CT39\n" +
                    "Weight: 11460CT7 -> CT231\n" +
                    "Weight: 15006CT7 -> CT266\n" +
                    "Weight: 21350\n" +
                    "CT266: \n" +
                    "CT266 -> CT39\n" +
                    "Weight: 12153CT266 -> CT225\n" +
                    "Weight: 11596CT266 -> CT137\n" +
                    "Weight: 6272CT266 -> CT7\n" +
                    "Weight: 21350CT266 -> CT173\n" +
                    "Weight: 23170\n" +
                    "CT199: \n" +
                    "CT199 -> CT72\n" +
                    "Weight: 15846CT199 -> CT272\n" +
                    "Weight: 16168CT199 -> CT258\n" +
                    "Weight: 16649CT199 -> CT187\n" +
                    "Weight: 19324CT199 -> CT68\n" +
                    "Weight: 19629\n" +
                    "CT72: \n" +
                    "CT72 -> CT199\n" +
                    "Weight: 15846CT72 -> CT68\n" +
                    "Weight: 13897CT72 -> CT272\n" +
                    "Weight: 8761CT72 -> CT279\n" +
                    "Weight: 12728CT72 -> CT246\n" +
                    "Weight: 12988CT72 -> CT187\n" +
                    "Weight: 17417\n" +
                    "CT258: \n" +
                    "CT258 -> CT199\n" +
                    "Weight: 16649CT258 -> CT96\n" +
                    "Weight: 25494CT258 -> CT130\n" +
                    "Weight: 13783CT258 -> CT154\n" +
                    "Weight: 16179CT258 -> CT187\n" +
                    "Weight: 18180\n" +
                    "CT187: \n" +
                    "CT187 -> CT199\n" +
                    "Weight: 19324CT187 -> CT68\n" +
                    "Weight: 4694CT187 -> CT72\n" +
                    "Weight: 17417CT187 -> CT320\n" +
                    "Weight: 19469CT187 -> CT258\n" +
                    "Weight: 18180CT187 -> CT153\n" +
                    "Weight: 13495\n" +
                    "CT68: \n" +
                    "CT68 -> CT199\n" +
                    "Weight: 19629CT68 -> CT187\n" +
                    "Weight: 4694CT68 -> CT72\n" +
                    "Weight: 13897CT68 -> CT153\n" +
                    "Weight: 16678CT68 -> CT279\n" +
                    "Weight: 16972CT68 -> CT320\n" +
                    "Weight: 18500\n" +
                    "CT114: \n" +
                    "CT114 -> CT198\n" +
                    "Weight: 6341CT114 -> CT3\n" +
                    "Weight: 6514CT114 -> CT286\n" +
                    "Weight: 7184CT114 -> CT135\n" +
                    "Weight: 14652CT114 -> CT289\n" +
                    "Weight: 15514\n" +
                    "CT286: \n" +
                    "CT286 -> CT198\n" +
                    "Weight: 12034CT286 -> CT3\n" +
                    "Weight: 4882CT286 -> CT6\n" +
                    "Weight: 10177CT286 -> CT114\n" +
                    "Weight: 7184CT286 -> CT265\n" +
                    "Weight: 16003\n" +
                    "CT197: \n" +
                    "CT197 -> CT323\n" +
                    "Weight: 6123CT197 -> CT265\n" +
                    "Weight: 17873CT197 -> CT41\n" +
                    "Weight: 25065CT197 -> CT292\n" +
                    "Weight: 25469\n" +
                    "CT323: \n" +
                    "CT323 -> CT197\n" +
                    "Weight: 6123CT323 -> CT255\n" +
                    "Weight: 5388CT323 -> CT320\n" +
                    "Weight: 19577\n" +
                    "CT265: \n" +
                    "CT265 -> CT197\n" +
                    "Weight: 17873CT265 -> CT6\n" +
                    "Weight: 11033CT265 -> CT286\n" +
                    "Weight: 16003CT265 -> CT292\n" +
                    "Weight: 16675\n" +
                    "CT41: \n" +
                    "CT41 -> CT197\n" +
                    "Weight: 25065CT41 -> CT78\n" +
                    "Weight: 16596CT41 -> CT292\n" +
                    "Weight: 17523CT41 -> CT89\n" +
                    "Weight: 22575CT41 -> CT255\n" +
                    "Weight: 27513\n" +
                    "CT292: \n" +
                    "CT292 -> CT197\n" +
                    "Weight: 25469CT292 -> CT196\n" +
                    "Weight: 7241CT292 -> CT41\n" +
                    "Weight: 17523CT292 -> CT252\n" +
                    "Weight: 11181CT292 -> CT265\n" +
                    "Weight: 16675\n" +
                    "CT196: \n" +
                    "CT196 -> CT292\n" +
                    "Weight: 7241CT196 -> CT252\n" +
                    "Weight: 7696CT196 -> CT104\n" +
                    "Weight: 13910CT196 -> CT202\n" +
                    "Weight: 14120\n" +
                    "CT252: \n" +
                    "CT252 -> CT196\n" +
                    "Weight: 7696CT252 -> CT202\n" +
                    "Weight: 12703CT252 -> CT112\n" +
                    "Weight: 5070CT252 -> CT292\n" +
                    "Weight: 11181CT252 -> CT38\n" +
                    "Weight: 15081\n" +
                    "CT104: \n" +
                    "CT104 -> CT196\n" +
                    "Weight: 13910CT104 -> CT6\n" +
                    "Weight: 10631CT104 -> CT202\n" +
                    "Weight: 14552CT104 -> CT185\n" +
                    "Weight: 6916CT104 -> CT45\n" +
                    "Weight: 15972CT104 -> CT125\n" +
                    "Weight: 20069\n" +
                    "CT129: \n" +
                    "CT129 -> CT195\n" +
                    "Weight: 9712CT129 -> CT294\n" +
                    "Weight: 5129CT129 -> CT241\n" +
                    "Weight: 5137CT129 -> CT226\n" +
                    "Weight: 7208CT129 -> CT150\n" +
                    "Weight: 7812CT129 -> CT101\n" +
                    "Weight: 7884\n" +
                    "CT194: \n" +
                    "CT194 -> CT111\n" +
                    "Weight: 9575CT194 -> CT251\n" +
                    "Weight: 15639CT194 -> CT275\n" +
                    "Weight: 22452CT194 -> CT143\n" +
                    "Weight: 23111\n" +
                    "CT111: \n" +
                    "CT111 -> CT194\n" +
                    "Weight: 9575CT111 -> CT251\n" +
                    "Weight: 17222CT111 -> CT231\n" +
                    "Weight: 17581CT111 -> CT143\n" +
                    "Weight: 17971\n" +
                    "CT251: \n" +
                    "CT251 -> CT194\n" +
                    "Weight: 15639CT251 -> CT82\n" +
                    "Weight: 43378CT251 -> CT111\n" +
                    "Weight: 17222CT251 -> CT143\n" +
                    "Weight: 13808CT251 -> CT275\n" +
                    "Weight: 23010\n" +
                    "CT275: \n" +
                    "CT275 -> CT194\n" +
                    "Weight: 22452CT275 -> CT314\n" +
                    "Weight: 24516CT275 -> CT82\n" +
                    "Weight: 22363CT275 -> CT251\n" +
                    "Weight: 23010CT275 -> CT12\n" +
                    "Weight: 45392\n" +
                    "CT143: \n" +
                    "CT143 -> CT194\n" +
                    "Weight: 23111CT143 -> CT111\n" +
                    "Weight: 17971CT143 -> CT231\n" +
                    "Weight: 11890CT143 -> CT251\n" +
                    "Weight: 13808CT143 -> CT23\n" +
                    "Weight: 45292\n" +
                    "CT193: \n" +
                    "CT193 -> CT205\n" +
                    "Weight: 16684CT193 -> CT230\n" +
                    "Weight: 20487CT193 -> CT208\n" +
                    "Weight: 22092CT193 -> CT262\n" +
                    "Weight: 22480CT193 -> CT76\n" +
                    "Weight: 30186\n" +
                    "CT205: \n" +
                    "CT205 -> CT193\n" +
                    "Weight: 16684CT205 -> CT127\n" +
                    "Weight: 19978CT205 -> CT37\n" +
                    "Weight: 22908CT205 -> CT208\n" +
                    "Weight: 25020CT205 -> CT76\n" +
                    "Weight: 25950\n" +
                    "CT230: \n" +
                    "CT230 -> CT193\n" +
                    "Weight: 20487CT230 -> CT301\n" +
                    "Weight: 23619CT230 -> CT315\n" +
                    "Weight: 26744CT230 -> CT262\n" +
                    "Weight: 18509CT230 -> CT148\n" +
                    "Weight: 25392\n" +
                    "CT208: \n" +
                    "CT208 -> CT193\n" +
                    "Weight: 22092CT208 -> CT76\n" +
                    "Weight: 12029CT208 -> CT120\n" +
                    "Weight: 11975CT208 -> CT262\n" +
                    "Weight: 15004CT208 -> CT205\n" +
                    "Weight: 25020\n" +
                    "CT262: \n" +
                    "CT262 -> CT193\n" +
                    "Weight: 22480CT262 -> CT301\n" +
                    "Weight: 15189CT262 -> CT208\n" +
                    "Weight: 15004CT262 -> CT230\n" +
                    "Weight: 18509CT262 -> CT120\n" +
                    "Weight: 20705CT262 -> CT116\n" +
                    "Weight: 21329\n" +
                    "CT192: \n" +
                    "CT192 -> CT158\n" +
                    "Weight: 7791CT192 -> CT95\n" +
                    "Weight: 9058CT192 -> CT105\n" +
                    "Weight: 9309\n" +
                    "CT158: \n" +
                    "CT158 -> CT192\n" +
                    "Weight: 7791CT158 -> CT2\n" +
                    "Weight: 2822CT158 -> CT232\n" +
                    "Weight: 1954\n" +
                    "CT95: \n" +
                    "CT95 -> CT192\n" +
                    "Weight: 9058CT95 -> CT93\n" +
                    "Weight: 8278CT95 -> CT19\n" +
                    "Weight: 8645\n" +
                    "CT191: \n" +
                    "CT191 -> CT144\n" +
                    "Weight: 4058CT191 -> CT109\n" +
                    "Weight: 6147CT191 -> CT141\n" +
                    "Weight: 7086CT191 -> CT244\n" +
                    "Weight: 7534\n" +
                    "CT144: \n" +
                    "CT144 -> CT191\n" +
                    "Weight: 4058CT144 -> CT44\n" +
                    "Weight: 21122CT144 -> CT244\n" +
                    "Weight: 7546CT144 -> CT20\n" +
                    "Weight: 10111\n" +
                    "CT109: \n" +
                    "CT109 -> CT191\n" +
                    "Weight: 6147CT109 -> CT28\n" +
                    "Weight: 1698CT109 -> CT141\n" +
                    "Weight: 5973\n" +
                    "CT141: \n" +
                    "CT141 -> CT191\n" +
                    "Weight: 7086CT141 -> CT244\n" +
                    "Weight: 8041CT141 -> CT109\n" +
                    "Weight: 5973CT141 -> CT19\n" +
                    "Weight: 7978CT141 -> CT11\n" +
                    "Weight: 19253\n" +
                    "CT190: \n" +
                    "CT190 -> CT310\n" +
                    "Weight: 21990CT190 -> CT173\n" +
                    "Weight: 32923CT190 -> CT17\n" +
                    "Weight: 36484CT190 -> CT201\n" +
                    "Weight: 40744CT190 -> CT267\n" +
                    "Weight: 51083CT190 -> CT249\n" +
                    "Weight: 53655\n" +
                    "CT310: \n" +
                    "CT310 -> CT190\n" +
                    "Weight: 21990CT310 -> CT267\n" +
                    "Weight: 30348CT310 -> CT249\n" +
                    "Weight: 37748CT310 -> CT17\n" +
                    "Weight: 49045CT310 -> CT173\n" +
                    "Weight: 52326CT310 -> CT201\n" +
                    "Weight: 55140\n" +
                    "CT173: \n" +
                    "CT173 -> CT190\n" +
                    "Weight: 32923CT173 -> CT310\n" +
                    "Weight: 52326CT173 -> CT138\n" +
                    "Weight: 27422CT173 -> CT17\n" +
                    "Weight: 19629CT173 -> CT266\n" +
                    "Weight: 23170CT173 -> CT225\n" +
                    "Weight: 23470\n" +
                    "CT17: \n" +
                    "CT17 -> CT190\n" +
                    "Weight: 36484CT17 -> CT302\n" +
                    "Weight: 30934CT17 -> CT310\n" +
                    "Weight: 49045CT17 -> CT173\n" +
                    "Weight: 19629CT17 -> CT138\n" +
                    "Weight: 29798CT17 -> CT225\n" +
                    "Weight: 34652\n" +
                    "CT201: \n" +
                    "CT201 -> CT190\n" +
                    "Weight: 40744CT201 -> CT310\n" +
                    "Weight: 55140CT201 -> CT83\n" +
                    "Weight: 15151CT201 -> CT23\n" +
                    "Weight: 23444CT201 -> CT18\n" +
                    "Weight: 28557\n" +
                    "CT267: \n" +
                    "CT267 -> CT190\n" +
                    "Weight: 51083CT267 -> CT310\n" +
                    "Weight: 30348CT267 -> CT249\n" +
                    "Weight: 18369CT267 -> CT131\n" +
                    "Weight: 40889\n" +
                    "CT78: \n" +
                    "CT78 -> CT41\n" +
                    "Weight: 16596CT78 -> CT89\n" +
                    "Weight: 16898CT78 -> CT210\n" +
                    "Weight: 16923CT78 -> CT155\n" +
                    "Weight: 18225\n" +
                    "CT89: \n" +
                    "CT89 -> CT41\n" +
                    "Weight: 22575CT89 -> CT49\n" +
                    "Weight: 13135CT89 -> CT78\n" +
                    "Weight: 16898CT89 -> CT236\n" +
                    "Weight: 13063CT89 -> CT155\n" +
                    "Weight: 15618\n" +
                    "CT40: \n" +
                    "CT40 -> CT273\n" +
                    "Weight: 10849CT40 -> CT216\n" +
                    "Weight: 11376CT40 -> CT247\n" +
                    "Weight: 13835CT40 -> CT242\n" +
                    "Weight: 20816CT40 -> CT274\n" +
                    "Weight: 15410CT40 -> CT170\n" +
                    "Weight: 17723\n" +
                    "CT273: \n" +
                    "CT273 -> CT40\n" +
                    "Weight: 10849CT273 -> CT213\n" +
                    "Weight: 23298CT273 -> CT242\n" +
                    "Weight: 18253CT273 -> CT253\n" +
                    "Weight: 15640CT273 -> CT170\n" +
                    "Weight: 17180CT273 -> CT16\n" +
                    "Weight: 21390\n" +
                    "CT216: \n" +
                    "CT216 -> CT40\n" +
                    "Weight: 11376CT216 -> CT247\n" +
                    "Weight: 4552CT216 -> CT164\n" +
                    "Weight: 8779CT216 -> CT139\n" +
                    "Weight: 12187CT216 -> CT236\n" +
                    "Weight: 16865\n" +
                    "CT247: \n" +
                    "CT247 -> CT40\n" +
                    "Weight: 13835CT247 -> CT313\n" +
                    "Weight: 12954CT247 -> CT216\n" +
                    "Weight: 4552CT247 -> CT164\n" +
                    "Weight: 10152\n" +
                    "CT43: \n" +
                    "CT43 -> CT175\n" +
                    "Weight: 16541CT43 -> CT67\n" +
                    "Weight: 24129CT43 -> CT223\n" +
                    "Weight: 27702CT43 -> CT99\n" +
                    "Weight: 31310CT43 -> CT157\n" +
                    "Weight: 35273CT43 -> CT123\n" +
                    "Weight: 36072\n" +
                    "CT175: \n" +
                    "CT175 -> CT43\n" +
                    "Weight: 16541CT175 -> CT67\n" +
                    "Weight: 35387CT175 -> CT123\n" +
                    "Weight: 20771CT175 -> CT271\n" +
                    "Weight: 26112CT175 -> CT25\n" +
                    "Weight: 28200\n" +
                    "CT67: \n" +
                    "CT67 -> CT43\n" +
                    "Weight: 24129CT67 -> CT99\n" +
                    "Weight: 19162CT67 -> CT175\n" +
                    "Weight: 35387CT67 -> CT58\n" +
                    "Weight: 45393CT67 -> CT317\n" +
                    "Weight: 48100\n" +
                    "CT223: \n" +
                    "CT223 -> CT43\n" +
                    "Weight: 27702CT223 -> CT79\n" +
                    "Weight: 12696CT223 -> CT97\n" +
                    "Weight: 22107CT223 -> CT157\n" +
                    "Weight: 10241CT223 -> CT25\n" +
                    "Weight: 27394\n" +
                    "CT99: \n" +
                    "CT99 -> CT43\n" +
                    "Weight: 31310CT99 -> CT67\n" +
                    "Weight: 19162CT99 -> CT317\n" +
                    "Weight: 30520CT99 -> CT58\n" +
                    "Weight: 29507CT99 -> CT5\n" +
                    "Weight: 31774\n" +
                    "CT157: \n" +
                    "CT157 -> CT43\n" +
                    "Weight: 35273CT157 -> CT79\n" +
                    "Weight: 7475CT157 -> CT97\n" +
                    "Weight: 28850CT157 -> CT223\n" +
                    "Weight: 10241\n" +
                    "CT123: \n" +
                    "CT123 -> CT43\n" +
                    "Weight: 36072CT123 -> CT47\n" +
                    "Weight: 22363CT123 -> CT271\n" +
                    "Weight: 12148CT123 -> CT25\n" +
                    "Weight: 18136CT123 -> CT175\n" +
                    "Weight: 20771\n" +
                    "CT42: \n" +
                    "CT42 -> CT107\n" +
                    "Weight: 20849CT42 -> CT177\n" +
                    "Weight: 24114CT42 -> CT180\n" +
                    "Weight: 30377CT42 -> CT106\n" +
                    "Weight: 40836CT42 -> CT271\n" +
                    "Weight: 40995CT42 -> CT296\n" +
                    "Weight: 45119\n" +
                    "CT107: \n" +
                    "CT107 -> CT42\n" +
                    "Weight: 20849CT107 -> CT297\n" +
                    "Weight: 30205CT107 -> CT177\n" +
                    "Weight: 32218\n" +
                    "CT177: \n" +
                    "CT177 -> CT42\n" +
                    "Weight: 24114CT177 -> CT107\n" +
                    "Weight: 32218CT177 -> CT296\n" +
                    "Weight: 22853CT177 -> CT180\n" +
                    "Weight: 35401\n" +
                    "CT180: \n" +
                    "CT180 -> CT42\n" +
                    "Weight: 30377CT180 -> CT47\n" +
                    "Weight: 29326CT180 -> CT177\n" +
                    "Weight: 35401CT180 -> CT296\n" +
                    "Weight: 42143CT180 -> CT94\n" +
                    "Weight: 36445CT180 -> CT222\n" +
                    "Weight: 40958\n" +
                    "CT106: \n" +
                    "CT106 -> CT42\n" +
                    "Weight: 40836CT106 -> CT58\n" +
                    "Weight: 13595CT106 -> CT317\n" +
                    "Weight: 18716CT106 -> CT271\n" +
                    "Weight: 16032CT106 -> CT234\n" +
                    "Weight: 24399\n" +
                    "CT271: \n" +
                    "CT271 -> CT42\n" +
                    "Weight: 40995CT271 -> CT47\n" +
                    "Weight: 23201CT271 -> CT106\n" +
                    "Weight: 16032CT271 -> CT123\n" +
                    "Weight: 12148CT271 -> CT175\n" +
                    "Weight: 26112CT271 -> CT58\n" +
                    "Weight: 27935\n" +
                    "CT45: \n" +
                    "CT45 -> CT135\n" +
                    "Weight: 4897CT45 -> CT125\n" +
                    "Weight: 5795CT45 -> CT185\n" +
                    "Weight: 12143CT45 -> CT104\n" +
                    "Weight: 15972\n" +
                    "CT135: \n" +
                    "CT135 -> CT45\n" +
                    "Weight: 4897CT135 -> CT125\n" +
                    "Weight: 6223CT135 -> CT289\n" +
                    "Weight: 5662CT135 -> CT114\n" +
                    "Weight: 14652\n" +
                    "CT125: \n" +
                    "CT125 -> CT45\n" +
                    "Weight: 5795CT125 -> CT135\n" +
                    "Weight: 6223CT125 -> CT289\n" +
                    "Weight: 10141CT125 -> CT185\n" +
                    "Weight: 14680CT125 -> CT104\n" +
                    "Weight: 20069\n" +
                    "CT185: \n" +
                    "CT185 -> CT45\n" +
                    "Weight: 12143CT185 -> CT202\n" +
                    "Weight: 15139CT185 -> CT104\n" +
                    "Weight: 6916CT185 -> CT125\n" +
                    "Weight: 14680CT185 -> CT6\n" +
                    "Weight: 15720\n" +
                    "CT44: \n" +
                    "CT44 -> CT269\n" +
                    "Weight: 8983CT44 -> CT305\n" +
                    "Weight: 8989CT44 -> CT13\n" +
                    "Weight: 10197CT44 -> CT144\n" +
                    "Weight: 21122\n" +
                    "CT269: \n" +
                    "CT269 -> CT44\n" +
                    "Weight: 8983CT269 -> CT282\n" +
                    "Weight: 13862CT269 -> CT13\n" +
                    "Weight: 14221CT269 -> CT151\n" +
                    "Weight: 20357\n" +
                    "CT305: \n" +
                    "CT305 -> CT44\n" +
                    "Weight: 8989CT305 -> CT48\n" +
                    "Weight: 18185CT305 -> CT56\n" +
                    "Weight: 16504CT305 -> CT13\n" +
                    "Weight: 12911CT305 -> CT245\n" +
                    "Weight: 20442\n" +
                    "CT13: \n" +
                    "CT13 -> CT44\n" +
                    "Weight: 10197CT13 -> CT48\n" +
                    "Weight: 13760CT13 -> CT56\n" +
                    "Weight: 20358CT13 -> CT305\n" +
                    "Weight: 12911CT13 -> CT245\n" +
                    "Weight: 20980CT13 -> CT269\n" +
                    "Weight: 14221CT13 -> CT282\n" +
                    "Weight: 24957\n" +
                    "CT47: \n" +
                    "CT47 -> CT123\n" +
                    "Weight: 22363CT47 -> CT271\n" +
                    "Weight: 23201CT47 -> CT222\n" +
                    "Weight: 27704CT47 -> CT25\n" +
                    "Weight: 28099CT47 -> CT180\n" +
                    "Weight: 29326\n" +
                    "CT222: \n" +
                    "CT222 -> CT47\n" +
                    "Weight: 27704CT222 -> CT126\n" +
                    "Weight: 27495CT222 -> CT1\n" +
                    "Weight: 31870CT222 -> CT283\n" +
                    "Weight: 33694CT222 -> CT25\n" +
                    "Weight: 34823CT222 -> CT97\n" +
                    "Weight: 35827CT222 -> CT180\n" +
                    "Weight: 40958\n" +
                    "CT25: \n" +
                    "CT25 -> CT47\n" +
                    "Weight: 28099CT25 -> CT97\n" +
                    "Weight: 10781CT25 -> CT223\n" +
                    "Weight: 27394CT25 -> CT222\n" +
                    "Weight: 34823CT25 -> CT123\n" +
                    "Weight: 18136CT25 -> CT175\n" +
                    "Weight: 28200\n" +
                    "CT46: \n" +
                    "CT46 -> CT229\n" +
                    "Weight: 1871CT46 -> CT103\n" +
                    "Weight: 15954CT46 -> CT50\n" +
                    "Weight: 21476\n" +
                    "CT229: \n" +
                    "CT229 -> CT46\n" +
                    "Weight: 1871CT229 -> CT303\n" +
                    "Weight: 5153CT229 -> CT285\n" +
                    "Weight: 19487CT229 -> CT110\n" +
                    "Weight: 21943\n" +
                    "CT103: \n" +
                    "CT103 -> CT46\n" +
                    "Weight: 15954CT103 -> CT50\n" +
                    "Weight: 15564CT103 -> CT298\n" +
                    "Weight: 20996\n" +
                    "CT49: \n" +
                    "CT49 -> CT155\n" +
                    "Weight: 11041CT49 -> CT236\n" +
                    "Weight: 11284CT49 -> CT89\n" +
                    "Weight: 13135CT49 -> CT29\n" +
                    "Weight: 13818\n" +
                    "CT155: \n" +
                    "CT155 -> CT49\n" +
                    "Weight: 11041CT155 -> CT78\n" +
                    "Weight: 18225CT155 -> CT89\n" +
                    "Weight: 15618CT155 -> CT210\n" +
                    "Weight: 12560CT155 -> CT29\n" +
                    "Weight: 12655\n" +
                    "CT236: \n" +
                    "CT236 -> CT49\n" +
                    "Weight: 11284CT236 -> CT81\n" +
                    "Weight: 24626CT236 -> CT89\n" +
                    "Weight: 13063CT236 -> CT216\n" +
                    "Weight: 16865CT236 -> CT139\n" +
                    "Weight: 8022CT236 -> CT164\n" +
                    "Weight: 10276\n" +
                    "CT48: \n" +
                    "CT48 -> CT245\n" +
                    "Weight: 8684CT48 -> CT56\n" +
                    "Weight: 11316CT48 -> CT13\n" +
                    "Weight: 13760CT48 -> CT73\n" +
                    "Weight: 13999CT48 -> CT305\n" +
                    "Weight: 18185\n" +
                    "CT245: \n" +
                    "CT245 -> CT48\n" +
                    "Weight: 8684CT245 -> CT56\n" +
                    "Weight: 5627CT245 -> CT73\n" +
                    "Weight: 16800CT245 -> CT94\n" +
                    "Weight: 26733CT245 -> CT305\n" +
                    "Weight: 20442CT245 -> CT13\n" +
                    "Weight: 20980\n" +
                    "CT56: \n" +
                    "CT56 -> CT48\n" +
                    "Weight: 11316CT56 -> CT245\n" +
                    "Weight: 5627CT56 -> CT305\n" +
                    "Weight: 16504CT56 -> CT13\n" +
                    "Weight: 20358CT56 -> CT94\n" +
                    "Weight: 27850\n" +
                    "CT73: \n" +
                    "CT73 -> CT48\n" +
                    "Weight: 13999CT73 -> CT248\n" +
                    "Weight: 13379CT73 -> CT245\n" +
                    "Weight: 16800CT73 -> CT94\n" +
                    "Weight: 35208CT73 -> CT22\n" +
                    "Weight: 17263\n" +
                    "CT50: \n" +
                    "CT50 -> CT84\n" +
                    "Weight: 15280CT50 -> CT103\n" +
                    "Weight: 15564CT50 -> CT233\n" +
                    "Weight: 16308CT50 -> CT110\n" +
                    "Weight: 17099CT50 -> CT60\n" +
                    "Weight: 18339CT50 -> CT46\n" +
                    "Weight: 21476CT50 -> CT298\n" +
                    "Weight: 28624\n" +
                    "CT84: \n" +
                    "CT84 -> CT50\n" +
                    "Weight: 15280CT84 -> CT60\n" +
                    "Weight: 4077CT84 -> CT233\n" +
                    "Weight: 5371CT84 -> CT136\n" +
                    "Weight: 10401\n" +
                    "CT233: \n" +
                    "CT233 -> CT50\n" +
                    "Weight: 16308CT233 -> CT60\n" +
                    "Weight: 3631CT233 -> CT316\n" +
                    "Weight: 11509CT233 -> CT84\n" +
                    "Weight: 5371CT233 -> CT228\n" +
                    "Weight: 16159CT233 -> CT117\n" +
                    "Weight: 11313\n" +
                    "CT110: \n" +
                    "CT110 -> CT50\n" +
                    "Weight: 17099CT110 -> CT303\n" +
                    "Weight: 22544CT110 -> CT229\n" +
                    "Weight: 21943CT110 -> CT250\n" +
                    "Weight: 9726CT110 -> CT136\n" +
                    "Weight: 10043CT110 -> CT285\n" +
                    "Weight: 10074CT110 -> CT238\n" +
                    "Weight: 12676\n" +
                    "CT60: \n" +
                    "CT60 -> CT50\n" +
                    "Weight: 18339CT60 -> CT233\n" +
                    "Weight: 3631CT60 -> CT84\n" +
                    "Weight: 4077CT60 -> CT136\n" +
                    "Weight: 12286CT60 -> CT117\n" +
                    "Weight: 12774CT60 -> CT228\n" +
                    "Weight: 14459\n" +
                    "CT52: \n" +
                    "CT52 -> CT259\n" +
                    "Weight: 4087CT52 -> CT204\n" +
                    "Weight: 20424CT52 -> CT11\n" +
                    "Weight: 15623CT52 -> CT179\n" +
                    "Weight: 10647CT52 -> CT171\n" +
                    "Weight: 8746\n" +
                    "CT51: \n" +
                    "CT51 -> CT183\n" +
                    "Weight: 45326CT51 -> CT182\n" +
                    "Weight: 46060CT51 -> CT261\n" +
                    "Weight: 63803\n" +
                    "CT183: \n" +
                    "CT183 -> CT51\n" +
                    "Weight: 45326CT183 -> CT235\n" +
                    "Weight: 19104CT183 -> CT182\n" +
                    "Weight: 25139CT183 -> CT224\n" +
                    "Weight: 32529CT183 -> CT234\n" +
                    "Weight: 42222CT183 -> CT299\n" +
                    "Weight: 45061\n" +
                    "CT182: \n" +
                    "CT182 -> CT51\n" +
                    "Weight: 46060CT182 -> CT224\n" +
                    "Weight: 31202CT182 -> CT261\n" +
                    "Weight: 28458CT182 -> CT183\n" +
                    "Weight: 25139CT182 -> CT299\n" +
                    "Weight: 34712CT182 -> CT235\n" +
                    "Weight: 34978CT182 -> CT98\n" +
                    "Weight: 42024\n" +
                    "CT261: \n" +
                    "CT261 -> CT51\n" +
                    "Weight: 63803CT261 -> CT182\n" +
                    "Weight: 28458CT261 -> CT54\n" +
                    "Weight: 31665CT261 -> CT163\n" +
                    "Weight: 37436\n" +
                    "CT54: \n" +
                    "CT54 -> CT98\n" +
                    "Weight: 14342CT54 -> CT115\n" +
                    "Weight: 21162CT54 -> CT299\n" +
                    "Weight: 22024CT54 -> CT27\n" +
                    "Weight: 28347CT54 -> CT261\n" +
                    "Weight: 31665CT54 -> CT163\n" +
                    "Weight: 54166CT54 -> CT18\n" +
                    "Weight: 33456\n" +
                    "CT98: \n" +
                    "CT98 -> CT54\n" +
                    "Weight: 14342CT98 -> CT299\n" +
                    "Weight: 10150CT98 -> CT27\n" +
                    "Weight: 15657CT98 -> CT115\n" +
                    "Weight: 24368CT98 -> CT18\n" +
                    "Weight: 43276CT98 -> CT182\n" +
                    "Weight: 42024\n" +
                    "CT115: \n" +
                    "CT115 -> CT54\n" +
                    "Weight: 21162CT115 -> CT83\n" +
                    "Weight: 43344CT115 -> CT98\n" +
                    "Weight: 24368CT115 -> CT18\n" +
                    "Weight: 22129CT115 -> CT27\n" +
                    "Weight: 27060CT115 -> CT131\n" +
                    "Weight: 48187CT115 -> CT297\n" +
                    "Weight: 36210\n" +
                    "CT299: \n" +
                    "CT299 -> CT54\n" +
                    "Weight: 22024CT299 -> CT98\n" +
                    "Weight: 10150CT299 -> CT224\n" +
                    "Weight: 15648CT299 -> CT27\n" +
                    "Weight: 18805CT299 -> CT297\n" +
                    "Weight: 25554CT299 -> CT183\n" +
                    "Weight: 45061CT299 -> CT182\n" +
                    "Weight: 34712\n" +
                    "CT27: \n" +
                    "CT27 -> CT54\n" +
                    "Weight: 28347CT27 -> CT98\n" +
                    "Weight: 15657CT27 -> CT224\n" +
                    "Weight: 28125CT27 -> CT115\n" +
                    "Weight: 27060CT27 -> CT299\n" +
                    "Weight: 18805CT27 -> CT297\n" +
                    "Weight: 10495\n" +
                    "CT53: \n" +
                    "CT53 -> CT227\n" +
                    "Weight: 7449CT53 -> CT140\n" +
                    "Weight: 10468CT53 -> CT156\n" +
                    "Weight: 14830CT53 -> CT70\n" +
                    "Weight: 16178CT53 -> CT10\n" +
                    "Weight: 19688CT53 -> CT200\n" +
                    "Weight: 22980CT53 -> CT291\n" +
                    "Weight: 20471\n" +
                    "CT227: \n" +
                    "CT227 -> CT53\n" +
                    "Weight: 7449CT227 -> CT70\n" +
                    "Weight: 21509CT227 -> CT10\n" +
                    "Weight: 16389CT227 -> CT291\n" +
                    "Weight: 19329\n" +
                    "CT140: \n" +
                    "CT140 -> CT53\n" +
                    "Weight: 10468CT140 -> CT70\n" +
                    "Weight: 10199CT140 -> CT219\n" +
                    "Weight: 27102CT140 -> CT156\n" +
                    "Weight: 11873CT140 -> CT200\n" +
                    "Weight: 24230\n" +
                    "CT156: \n" +
                    "CT156 -> CT53\n" +
                    "Weight: 14830CT156 -> CT140\n" +
                    "Weight: 11873CT156 -> CT291\n" +
                    "Weight: 21178CT156 -> CT186\n" +
                    "Weight: 22207\n" +
                    "CT70: \n" +
                    "CT70 -> CT53\n" +
                    "Weight: 16178CT70 -> CT140\n" +
                    "Weight: 10199CT70 -> CT200\n" +
                    "Weight: 16552CT70 -> CT227\n" +
                    "Weight: 21509CT70 -> CT219\n" +
                    "Weight: 21536\n" +
                    "CT10: \n" +
                    "CT10 -> CT53\n" +
                    "Weight: 19688CT10 -> CT227\n" +
                    "Weight: 16389CT10 -> CT291\n" +
                    "Weight: 6048CT10 -> CT65\n" +
                    "Weight: 23403\n" +
                    "CT55: \n" +
                    "CT55 -> CT96\n" +
                    "Weight: 16746CT55 -> CT154\n" +
                    "Weight: 17865CT55 -> CT132\n" +
                    "Weight: 23231CT55 -> CT243\n" +
                    "Weight: 24665CT55 -> CT130\n" +
                    "Weight: 29154CT55 -> CT212\n" +
                    "Weight: 29293CT55 -> CT124\n" +
                    "Weight: 30423\n" +
                    "CT96: \n" +
                    "CT96 -> CT55\n" +
                    "Weight: 16746CT96 -> CT154\n" +
                    "Weight: 14683CT96 -> CT124\n" +
                    "Weight: 17710CT96 -> CT258\n" +
                    "Weight: 25494CT96 -> CT212\n" +
                    "Weight: 34545CT96 -> CT243\n" +
                    "Weight: 39556CT96 -> CT134\n" +
                    "Weight: 51637\n" +
                    "CT154: \n" +
                    "CT154 -> CT55\n" +
                    "Weight: 17865CT154 -> CT96\n" +
                    "Weight: 14683CT154 -> CT212\n" +
                    "Weight: 44902CT154 -> CT258\n" +
                    "Weight: 16179CT154 -> CT132\n" +
                    "Weight: 29997CT154 -> CT130\n" +
                    "Weight: 13799CT154 -> CT121\n" +
                    "Weight: 26630\n" +
                    "CT132: \n" +
                    "CT132 -> CT55\n" +
                    "Weight: 23231CT132 -> CT85\n" +
                    "Weight: 17165CT132 -> CT243\n" +
                    "Weight: 28240CT132 -> CT121\n" +
                    "Weight: 26750CT132 -> CT154\n" +
                    "Weight: 29997CT132 -> CT21\n" +
                    "Weight: 41180\n" +
                    "CT243: \n" +
                    "CT243 -> CT55\n" +
                    "Weight: 24665CT243 -> CT212\n" +
                    "Weight: 23891CT243 -> CT132\n" +
                    "Weight: 28240CT243 -> CT96\n" +
                    "Weight: 39556\n" +
                    "CT130: \n" +
                    "CT130 -> CT55\n" +
                    "Weight: 29154CT130 -> CT85\n" +
                    "Weight: 24895CT130 -> CT211\n" +
                    "Weight: 21931CT130 -> CT121\n" +
                    "Weight: 15641CT130 -> CT258\n" +
                    "Weight: 13783CT130 -> CT154\n" +
                    "Weight: 13799CT130 -> CT153\n" +
                    "Weight: 20282\n" +
                    "CT212: \n" +
                    "CT212 -> CT55\n" +
                    "Weight: 29293CT212 -> CT243\n" +
                    "Weight: 23891CT212 -> CT134\n" +
                    "Weight: 31359CT212 -> CT124\n" +
                    "Weight: 31808CT212 -> CT96\n" +
                    "Weight: 34545CT212 -> CT154\n" +
                    "Weight: 44902\n" +
                    "CT58: \n" +
                    "CT58 -> CT317\n" +
                    "Weight: 7137CT58 -> CT106\n" +
                    "Weight: 13595CT58 -> CT234\n" +
                    "Weight: 21462CT58 -> CT67\n" +
                    "Weight: 45393CT58 -> CT99\n" +
                    "Weight: 29507CT58 -> CT271\n" +
                    "Weight: 27935\n" +
                    "CT317: \n" +
                    "CT317 -> CT58\n" +
                    "Weight: 7137CT317 -> CT67\n" +
                    "Weight: 48100CT317 -> CT5\n" +
                    "Weight: 6932CT317 -> CT234\n" +
                    "Weight: 16754CT317 -> CT106\n" +
                    "Weight: 18716CT317 -> CT99\n" +
                    "Weight: 30520\n" +
                    "CT234: \n" +
                    "CT234 -> CT58\n" +
                    "Weight: 21462CT234 -> CT5\n" +
                    "Weight: 15566CT234 -> CT317\n" +
                    "Weight: 16754CT234 -> CT106\n" +
                    "Weight: 24399CT234 -> CT235\n" +
                    "Weight: 28260CT234 -> CT183\n" +
                    "Weight: 42222\n" +
                    "CT57: \n" +
                    "CT57 -> CT64\n" +
                    "Weight: 5942CT57 -> CT189\n" +
                    "Weight: 11349CT57 -> CT145\n" +
                    "Weight: 15039CT57 -> CT65\n" +
                    "Weight: 17293CT57 -> CT215\n" +
                    "Weight: 24195CT57 -> CT240\n" +
                    "Weight: 22959CT57 -> CT282\n" +
                    "Weight: 24874\n" +
                    "CT64: \n" +
                    "CT64 -> CT57\n" +
                    "Weight: 5942CT64 -> CT65\n" +
                    "Weight: 19591CT64 -> CT189\n" +
                    "Weight: 15182CT64 -> CT240\n" +
                    "Weight: 18932\n" +
                    "CT189: \n" +
                    "CT189 -> CT57\n" +
                    "Weight: 11349CT189 -> CT65\n" +
                    "Weight: 7051CT189 -> CT64\n" +
                    "Weight: 15182CT189 -> CT215\n" +
                    "Weight: 19403CT189 -> CT145\n" +
                    "Weight: 19299\n" +
                    "CT145: \n" +
                    "CT145 -> CT57\n" +
                    "Weight: 15039CT145 -> CT215\n" +
                    "Weight: 16166CT145 -> CT189\n" +
                    "Weight: 19299CT145 -> CT282\n" +
                    "Weight: 20043\n" +
                    "CT59: \n" +
                    "CT59 -> CT88\n" +
                    "Weight: 18975CT59 -> CT176\n" +
                    "Weight: 20205CT59 -> CT239\n" +
                    "Weight: 24548CT59 -> CT312\n" +
                    "Weight: 25434CT59 -> CT295\n" +
                    "Weight: 34274\n" +
                    "CT88: \n" +
                    "CT88 -> CT59\n" +
                    "Weight: 18975CT88 -> CT295\n" +
                    "Weight: 22026CT88 -> CT176\n" +
                    "Weight: 31184\n" +
                    "CT176: \n" +
                    "CT176 -> CT59\n" +
                    "Weight: 20205CT176 -> CT88\n" +
                    "Weight: 31184CT176 -> CT239\n" +
                    "Weight: 37755CT176 -> CT300\n" +
                    "Weight: 39356\n" +
                    "CT239: \n" +
                    "CT239 -> CT59\n" +
                    "Weight: 24548CT239 -> CT62\n" +
                    "Weight: 18499CT239 -> CT312\n" +
                    "Weight: 15963CT239 -> CT287\n" +
                    "Weight: 15336CT239 -> CT174\n" +
                    "Weight: 19952CT239 -> CT176\n" +
                    "Weight: 37755\n" +
                    "CT312: \n" +
                    "CT312 -> CT59\n" +
                    "Weight: 25434CT312 -> CT239\n" +
                    "Weight: 15963CT312 -> CT184\n" +
                    "Weight: 19830CT312 -> CT313\n" +
                    "Weight: 24559CT312 -> CT242\n" +
                    "Weight: 27355\n" +
                    "CT295: \n" +
                    "CT295 -> CT59\n" +
                    "Weight: 34274CT295 -> CT319\n" +
                    "Weight: 38418CT295 -> CT88\n" +
                    "Weight: 22026CT295 -> CT149\n" +
                    "Weight: 34507CT295 -> CT168\n" +
                    "Weight: 19250CT295 -> CT184\n" +
                    "Weight: 28584\n" +
                    "CT61: \n" +
                    "CT61 -> CT319\n" +
                    "Weight: 23114CT61 -> CT318\n" +
                    "Weight: 35878CT61 -> CT149\n" +
                    "Weight: 37586CT61 -> CT167\n" +
                    "Weight: 57920\n" +
                    "CT319: \n" +
                    "CT319 -> CT61\n" +
                    "Weight: 23114CT319 -> CT149\n" +
                    "Weight: 35135CT319 -> CT295\n" +
                    "Weight: 38418CT319 -> CT168\n" +
                    "Weight: 44301CT319 -> CT318\n" +
                    "Weight: 54181\n" +
                    "CT318: \n" +
                    "CT318 -> CT61\n" +
                    "Weight: 35878CT318 -> CT167\n" +
                    "Weight: 24538CT318 -> CT169\n" +
                    "Weight: 33676CT318 -> CT149\n" +
                    "Weight: 40256CT318 -> CT14\n" +
                    "Weight: 49404CT318 -> CT319\n" +
                    "Weight: 54181\n" +
                    "CT149: \n" +
                    "CT149 -> CT61\n" +
                    "Weight: 37586CT149 -> CT319\n" +
                    "Weight: 35135CT149 -> CT318\n" +
                    "Weight: 40256CT149 -> CT168\n" +
                    "Weight: 22429CT149 -> CT14\n" +
                    "Weight: 22576CT149 -> CT169\n" +
                    "Weight: 32001CT149 -> CT304\n" +
                    "Weight: 33536CT149 -> CT295\n" +
                    "Weight: 34507\n" +
                    "CT136: \n" +
                    "CT136 -> CT60\n" +
                    "Weight: 12286CT136 -> CT84\n" +
                    "Weight: 10401CT136 -> CT238\n" +
                    "Weight: 5576CT136 -> CT110\n" +
                    "Weight: 10043CT136 -> CT133\n" +
                    "Weight: 11746\n" +
                    "CT117: \n" +
                    "CT117 -> CT60\n" +
                    "Weight: 12774CT117 -> CT316\n" +
                    "Weight: 6423CT117 -> CT30\n" +
                    "Weight: 1744CT117 -> CT233\n" +
                    "Weight: 11313\n" +
                    "CT63: \n" +
                    "CT63 -> CT2\n" +
                    "Weight: 896CT63 -> CT105\n" +
                    "Weight: 11732CT63 -> CT268\n" +
                    "Weight: 8586CT63 -> CT277\n" +
                    "Weight: 11806\n" +
                    "CT2: \n" +
                    "CT2 -> CT63\n" +
                    "Weight: 896CT2 -> CT158\n" +
                    "Weight: 2822CT2 -> CT20\n" +
                    "Weight: 9881\n" +
                    "CT62: \n" +
                    "CT62 -> CT287\n" +
                    "Weight: 5044CT62 -> CT86\n" +
                    "Weight: 15950CT62 -> CT108\n" +
                    "Weight: 17463CT62 -> CT239\n" +
                    "Weight: 18499CT62 -> CT300\n" +
                    "Weight: 18902\n" +
                    "CT287: \n" +
                    "CT287 -> CT62\n" +
                    "Weight: 5044CT287 -> CT86\n" +
                    "Weight: 12961CT287 -> CT239\n" +
                    "Weight: 15336CT287 -> CT174\n" +
                    "Weight: 10840CT287 -> CT108\n" +
                    "Weight: 19567\n" +
                    "CT86: \n" +
                    "CT86 -> CT62\n" +
                    "Weight: 15950CT86 -> CT174\n" +
                    "Weight: 5096CT86 -> CT287\n" +
                    "Weight: 12961CT86 -> CT29\n" +
                    "Weight: 15870CT86 -> CT108\n" +
                    "Weight: 17103CT86 -> CT113\n" +
                    "Weight: 18499\n" +
                    "CT108: \n" +
                    "CT108 -> CT62\n" +
                    "Weight: 17463CT108 -> CT86\n" +
                    "Weight: 17103CT108 -> CT322\n" +
                    "Weight: 12267CT108 -> CT113\n" +
                    "Weight: 10687CT108 -> CT133\n" +
                    "Weight: 11506CT108 -> CT287\n" +
                    "Weight: 19567CT108 -> CT174\n" +
                    "Weight: 20995\n" +
                    "CT300: \n" +
                    "CT300 -> CT62\n" +
                    "Weight: 18902CT300 -> CT228\n" +
                    "Weight: 14787CT300 -> CT276\n" +
                    "Weight: 18489CT300 -> CT176\n" +
                    "Weight: 39356\n" +
                    "CT65: \n" +
                    "CT65 -> CT189\n" +
                    "Weight: 7051CT65 -> CT57\n" +
                    "Weight: 17293CT65 -> CT64\n" +
                    "Weight: 19591CT65 -> CT215\n" +
                    "Weight: 23786CT65 -> CT240\n" +
                    "Weight: 21382CT65 -> CT10\n" +
                    "Weight: 23403\n" +
                    "CT240: \n" +
                    "CT240 -> CT64\n" +
                    "Weight: 18932CT240 -> CT65\n" +
                    "Weight: 21382CT240 -> CT57\n" +
                    "Weight: 22959\n" +
                    "CT66: \n" +
                    "CT66 -> CT307\n" +
                    "Weight: 11513CT66 -> CT298\n" +
                    "Weight: 21861CT66 -> CT36\n" +
                    "Weight: 24822\n" +
                    "CT307: \n" +
                    "CT307 -> CT66\n" +
                    "Weight: 11513CT307 -> CT293\n" +
                    "Weight: 14842CT307 -> CT207\n" +
                    "Weight: 17348CT307 -> CT36\n" +
                    "Weight: 22863\n" +
                    "CT298: \n" +
                    "CT298 -> CT66\n" +
                    "Weight: 21861CT298 -> CT103\n" +
                    "Weight: 20996CT298 -> CT221\n" +
                    "Weight: 24459CT298 -> CT36\n" +
                    "Weight: 24732CT298 -> CT50\n" +
                    "Weight: 28624\n" +
                    "CT69: \n" +
                    "CT69 -> CT160\n" +
                    "Weight: 13987CT69 -> CT288\n" +
                    "Weight: 15907CT69 -> CT165\n" +
                    "Weight: 16748CT69 -> CT118\n" +
                    "Weight: 34834CT69 -> CT178\n" +
                    "Weight: 23622\n" +
                    "CT288: \n" +
                    "CT288 -> CT69\n" +
                    "Weight: 15907CT288 -> CT90\n" +
                    "Weight: 8236CT288 -> CT160\n" +
                    "Weight: 12596CT288 -> CT142\n" +
                    "Weight: 12968\n" +
                    "CT165: \n" +
                    "CT165 -> CT69\n" +
                    "Weight: 16748CT165 -> CT289\n" +
                    "Weight: 16410CT165 -> CT198\n" +
                    "Weight: 24698\n" +
                    "CT153: \n" +
                    "CT153 -> CT68\n" +
                    "Weight: 16678CT153 -> CT320\n" +
                    "Weight: 16004CT153 -> CT211\n" +
                    "Weight: 10755CT153 -> CT257\n" +
                    "Weight: 16325CT153 -> CT130\n" +
                    "Weight: 20282CT153 -> CT187\n" +
                    "Weight: 13495\n" +
                    "CT279: \n" +
                    "CT279 -> CT68\n" +
                    "Weight: 16972CT279 -> CT72\n" +
                    "Weight: 12728CT279 -> CT246\n" +
                    "Weight: 15260CT279 -> CT272\n" +
                    "Weight: 18933CT279 -> CT181\n" +
                    "Weight: 20673\n" +
                    "CT309: \n" +
                    "CT309 -> CT226\n" +
                    "Weight: 2064CT309 -> CT150\n" +
                    "Weight: 2536CT309 -> CT290\n" +
                    "Weight: 4675\n" +
                    "CT226: \n" +
                    "CT226 -> CT309\n" +
                    "Weight: 2064CT226 -> CT241\n" +
                    "Weight: 5835CT226 -> CT129\n" +
                    "Weight: 7208CT226 -> CT159\n" +
                    "Weight: 8880\n" +
                    "CT308: \n" +
                    "CT308 -> CT280\n" +
                    "Weight: 14341CT308 -> CT161\n" +
                    "Weight: 19079CT308 -> CT253\n" +
                    "Weight: 25574CT308 -> CT71\n" +
                    "Weight: 25703CT308 -> CT213\n" +
                    "Weight: 26835CT308 -> CT119\n" +
                    "Weight: 27376CT308 -> CT122\n" +
                    "Weight: 31026\n" +
                    "CT280: \n" +
                    "CT280 -> CT308\n" +
                    "Weight: 14341CT280 -> CT304\n" +
                    "Weight: 13231CT280 -> CT71\n" +
                    "Weight: 16666CT280 -> CT122\n" +
                    "Weight: 34173CT280 -> CT14\n" +
                    "Weight: 24044CT280 -> CT253\n" +
                    "Weight: 26106\n" +
                    "CT161: \n" +
                    "CT161 -> CT308\n" +
                    "Weight: 19079CT161 -> CT217\n" +
                    "Weight: 28732CT161 -> CT213\n" +
                    "Weight: 12032CT161 -> CT284\n" +
                    "Weight: 23530CT161 -> CT260\n" +
                    "Weight: 22893CT161 -> CT253\n" +
                    "Weight: 24508CT161 -> CT119\n" +
                    "Weight: 28729CT161 -> CT21\n" +
                    "Weight: 44355\n" +
                    "CT253: \n" +
                    "CT253 -> CT308\n" +
                    "Weight: 25574CT253 -> CT213\n" +
                    "Weight: 18485CT253 -> CT273\n" +
                    "Weight: 15640CT253 -> CT71\n" +
                    "Weight: 17079CT253 -> CT161\n" +
                    "Weight: 24508CT253 -> CT280\n" +
                    "Weight: 26106CT253 -> CT16\n" +
                    "Weight: 18918\n" +
                    "CT71: \n" +
                    "CT71 -> CT308\n" +
                    "Weight: 25703CT71 -> CT304\n" +
                    "Weight: 15379CT71 -> CT16\n" +
                    "Weight: 16562CT71 -> CT280\n" +
                    "Weight: 16666CT71 -> CT253\n" +
                    "Weight: 17079CT71 -> CT184\n" +
                    "Weight: 23107\n" +
                    "CT213: \n" +
                    "CT213 -> CT308\n" +
                    "Weight: 26835CT213 -> CT161\n" +
                    "Weight: 12032CT213 -> CT260\n" +
                    "Weight: 14103CT213 -> CT253\n" +
                    "Weight: 18485CT213 -> CT170\n" +
                    "Weight: 21108CT213 -> CT273\n" +
                    "Weight: 23298CT213 -> CT284\n" +
                    "Weight: 24831\n" +
                    "CT119: \n" +
                    "CT119 -> CT308\n" +
                    "Weight: 27376CT119 -> CT217\n" +
                    "Weight: 17107CT119 -> CT21\n" +
                    "Weight: 22152CT119 -> CT122\n" +
                    "Weight: 27349CT119 -> CT161\n" +
                    "Weight: 28729\n" +
                    "CT293: \n" +
                    "CT293 -> CT307\n" +
                    "Weight: 14842CT293 -> CT207\n" +
                    "Weight: 15923CT293 -> CT172\n" +
                    "Weight: 15165CT293 -> CT36\n" +
                    "Weight: 29284CT293 -> CT34\n" +
                    "Weight: 29637\n" +
                    "CT306: \n" +
                    "CT306 -> CT100\n" +
                    "Weight: 3787CT306 -> CT237\n" +
                    "Weight: 7732CT306 -> CT128\n" +
                    "Weight: 7775CT306 -> CT92\n" +
                    "Weight: 10370CT306 -> CT283\n" +
                    "Weight: 17872\n" +
                    "CT100: \n" +
                    "CT100 -> CT306\n" +
                    "Weight: 3787CT100 -> CT92\n" +
                    "Weight: 12873CT100 -> CT237\n" +
                    "Weight: 5235CT100 -> CT281\n" +
                    "Weight: 6667CT100 -> CT128\n" +
                    "Weight: 8347CT100 -> CT278\n" +
                    "Weight: 17058\n" +
                    "CT237: \n" +
                    "CT237 -> CT306\n" +
                    "Weight: 7732CT237 -> CT9\n" +
                    "Weight: 14841CT237 -> CT100\n" +
                    "Weight: 5235CT237 -> CT281\n" +
                    "Weight: 5013CT237 -> CT128\n" +
                    "Weight: 6299\n" +
                    "CT128: \n" +
                    "CT128 -> CT306\n" +
                    "Weight: 7775CT128 -> CT9\n" +
                    "Weight: 19122CT128 -> CT87\n" +
                    "Weight: 4996CT128 -> CT237\n" +
                    "Weight: 6299CT128 -> CT100\n" +
                    "Weight: 8347CT128 -> CT24\n" +
                    "Weight: 19829\n" +
                    "CT92: \n" +
                    "CT92 -> CT306\n" +
                    "Weight: 10370CT92 -> CT283\n" +
                    "Weight: 8860CT92 -> CT100\n" +
                    "Weight: 12873CT92 -> CT278\n" +
                    "Weight: 16395CT92 -> CT256\n" +
                    "Weight: 17014\n" +
                    "CT304: \n" +
                    "CT304 -> CT280\n" +
                    "Weight: 13231CT304 -> CT71\n" +
                    "Weight: 15379CT304 -> CT14\n" +
                    "Weight: 18002CT304 -> CT168\n" +
                    "Weight: 21895CT304 -> CT184\n" +
                    "Weight: 29910CT304 -> CT149\n" +
                    "Weight: 33536\n" +
                    "CT14: \n" +
                    "CT14 -> CT304\n" +
                    "Weight: 18002CT14 -> CT318\n" +
                    "Weight: 49404CT14 -> CT149\n" +
                    "Weight: 22576CT14 -> CT169\n" +
                    "Weight: 22915CT14 -> CT168\n" +
                    "Weight: 25918CT14 -> CT280\n" +
                    "Weight: 24044\n" +
                    "CT168: \n" +
                    "CT168 -> CT304\n" +
                    "Weight: 21895CT168 -> CT319\n" +
                    "Weight: 44301CT168 -> CT149\n" +
                    "Weight: 22429CT168 -> CT295\n" +
                    "Weight: 19250CT168 -> CT14\n" +
                    "Weight: 25918CT168 -> CT184\n" +
                    "Weight: 26721\n" +
                    "CT184: \n" +
                    "CT184 -> CT304\n" +
                    "Weight: 29910CT184 -> CT312\n" +
                    "Weight: 19830CT184 -> CT242\n" +
                    "Weight: 20223CT184 -> CT168\n" +
                    "Weight: 26721CT184 -> CT16\n" +
                    "Weight: 15359CT184 -> CT295\n" +
                    "Weight: 28584CT184 -> CT71\n" +
                    "Weight: 23107\n" +
                    "CT1: \n" +
                    "CT1 -> CT283\n" +
                    "Weight: 4513CT1 -> CT256\n" +
                    "Weight: 8776CT1 -> CT148\n" +
                    "Weight: 21931CT1 -> CT222\n" +
                    "Weight: 31870CT1 -> CT126\n" +
                    "Weight: 25074\n" +
                    "CT283: \n" +
                    "CT283 -> CT1\n" +
                    "Weight: 4513CT283 -> CT92\n" +
                    "Weight: 8860CT283 -> CT222\n" +
                    "Weight: 33694CT283 -> CT256\n" +
                    "Weight: 11921CT283 -> CT306\n" +
                    "Weight: 17872\n" +
                    "CT256: \n" +
                    "CT256 -> CT1\n" +
                    "Weight: 8776CT256 -> CT301\n" +
                    "Weight: 18501CT256 -> CT126\n" +
                    "Weight: 23448CT256 -> CT283\n" +
                    "Weight: 11921CT256 -> CT148\n" +
                    "Weight: 16189CT256 -> CT92\n" +
                    "Weight: 17014\n" +
                    "CT148: \n" +
                    "CT148 -> CT1\n" +
                    "Weight: 21931CT148 -> CT301\n" +
                    "Weight: 21512CT148 -> CT315\n" +
                    "Weight: 33726CT148 -> CT230\n" +
                    "Weight: 25392CT148 -> CT126\n" +
                    "Weight: 12343CT148 -> CT256\n" +
                    "Weight: 16189\n" +
                    "CT303: \n" +
                    "CT303 -> CT229\n" +
                    "Weight: 5153CT303 -> CT285\n" +
                    "Weight: 17727CT303 -> CT152\n" +
                    "Weight: 18943CT303 -> CT159\n" +
                    "Weight: 19095CT303 -> CT110\n" +
                    "Weight: 22544\n" +
                    "CT285: \n" +
                    "CT285 -> CT303\n" +
                    "Weight: 17727CT285 -> CT229\n" +
                    "Weight: 19487CT285 -> CT110\n" +
                    "Weight: 10074CT285 -> CT250\n" +
                    "Weight: 7642CT285 -> CT15\n" +
                    "Weight: 12466CT285 -> CT152\n" +
                    "Weight: 13843CT285 -> CT101\n" +
                    "Weight: 15292\n" +
                    "CT152: \n" +
                    "CT152 -> CT303\n" +
                    "Weight: 18943CT152 -> CT159\n" +
                    "Weight: 5663CT152 -> CT101\n" +
                    "Weight: 6910CT152 -> CT241\n" +
                    "Weight: 7704CT152 -> CT285\n" +
                    "Weight: 13843\n" +
                    "CT159: \n" +
                    "CT159 -> CT303\n" +
                    "Weight: 19095CT159 -> CT152\n" +
                    "Weight: 5663CT159 -> CT226\n" +
                    "Weight: 8880CT159 -> CT241\n" +
                    "Weight: 9829\n" +
                    "CT302: \n" +
                    "CT302 -> CT138\n" +
                    "Weight: 24232CT302 -> CT17\n" +
                    "Weight: 30934\n" +
                    "CT138: \n" +
                    "CT138 -> CT302\n" +
                    "Weight: 24232CT138 -> CT74\n" +
                    "Weight: 19683CT138 -> CT225\n" +
                    "Weight: 13749CT138 -> CT173\n" +
                    "Weight: 27422CT138 -> CT17\n" +
                    "Weight: 29798\n" +
                    "CT301: \n" +
                    "CT301 -> CT116\n" +
                    "Weight: 12829CT301 -> CT262\n" +
                    "Weight: 15189CT301 -> CT256\n" +
                    "Weight: 18501CT301 -> CT148\n" +
                    "Weight: 21512CT301 -> CT230\n" +
                    "Weight: 23619\n" +
                    "CT116: \n" +
                    "CT116 -> CT301\n" +
                    "Weight: 12829CT116 -> CT278\n" +
                    "Weight: 17654CT116 -> CT26\n" +
                    "Weight: 18935CT116 -> CT262\n" +
                    "Weight: 21329\n" +
                    "CT4: \n" +
                    "CT4 -> CT260\n" +
                    "Weight: 11029CT4 -> CT311\n" +
                    "Weight: 18360CT4 -> CT284\n" +
                    "Weight: 18398CT4 -> CT257\n" +
                    "Weight: 19411CT4 -> CT170\n" +
                    "Weight: 21310CT4 -> CT211\n" +
                    "Weight: 22837CT4 -> CT85\n" +
                    "Weight: 26285\n" +
                    "CT260: \n" +
                    "CT260 -> CT4\n" +
                    "Weight: 11029CT260 -> CT213\n" +
                    "Weight: 14103CT260 -> CT170\n" +
                    "Weight: 15147CT260 -> CT284\n" +
                    "Weight: 19713CT260 -> CT161\n" +
                    "Weight: 22893\n" +
                    "CT311: \n" +
                    "CT311 -> CT4\n" +
                    "Weight: 18360CT311 -> CT257\n" +
                    "Weight: 14425CT311 -> CT170\n" +
                    "Weight: 19561CT311 -> CT81\n" +
                    "Weight: 19666\n" +
                    "CT284: \n" +
                    "CT284 -> CT4\n" +
                    "Weight: 18398CT284 -> CT85\n" +
                    "Weight: 19014CT284 -> CT217\n" +
                    "Weight: 26489CT284 -> CT260\n" +
                    "Weight: 19713CT284 -> CT161\n" +
                    "Weight: 23530CT284 -> CT213\n" +
                    "Weight: 24831\n" +
                    "CT257: \n" +
                    "CT257 -> CT4\n" +
                    "Weight: 19411CT257 -> CT311\n" +
                    "Weight: 14425CT257 -> CT211\n" +
                    "Weight: 8764CT257 -> CT153\n" +
                    "Weight: 16325\n" +
                    "CT170: \n" +
                    "CT170 -> CT4\n" +
                    "Weight: 21310CT170 -> CT311\n" +
                    "Weight: 19561CT170 -> CT213\n" +
                    "Weight: 21108CT170 -> CT260\n" +
                    "Weight: 15147CT170 -> CT274\n" +
                    "Weight: 16192CT170 -> CT273\n" +
                    "Weight: 17180CT170 -> CT40\n" +
                    "Weight: 17723\n" +
                    "CT211: \n" +
                    "CT211 -> CT4\n" +
                    "Weight: 22837CT211 -> CT257\n" +
                    "Weight: 8764CT211 -> CT153\n" +
                    "Weight: 10755CT211 -> CT121\n" +
                    "Weight: 15345CT211 -> CT320\n" +
                    "Weight: 21862CT211 -> CT130\n" +
                    "Weight: 21931\n" +
                    "CT228: \n" +
                    "CT228 -> CT300\n" +
                    "Weight: 14787CT228 -> CT30\n" +
                    "Weight: 11236CT228 -> CT60\n" +
                    "Weight: 14459CT228 -> CT133\n" +
                    "Weight: 15117CT228 -> CT233\n" +
                    "Weight: 16159\n" +
                    "CT5: \n" +
                    "CT5 -> CT317\n" +
                    "Weight: 6932CT5 -> CT234\n" +
                    "Weight: 15566CT5 -> CT99\n" +
                    "Weight: 31774\n" +
                    "CT6: \n" +
                    "CT6 -> CT286\n" +
                    "Weight: 10177CT6 -> CT104\n" +
                    "Weight: 10631CT6 -> CT265\n" +
                    "Weight: 11033CT6 -> CT185\n" +
                    "Weight: 15720\n" +
                    "CT231: \n" +
                    "CT231 -> CT7\n" +
                    "Weight: 15006CT231 -> CT111\n" +
                    "Weight: 17581CT231 -> CT143\n" +
                    "Weight: 11890\n" +
                    "CT8: \n" +
                    "CT8 -> CT131\n" +
                    "Weight: 23819CT8 -> CT296\n" +
                    "Weight: 38680CT8 -> CT264\n" +
                    "Weight: 41139CT8 -> CT204\n" +
                    "Weight: 44342\n" +
                    "CT131: \n" +
                    "CT131 -> CT8\n" +
                    "Weight: 23819CT131 -> CT249\n" +
                    "Weight: 24221CT131 -> CT267\n" +
                    "Weight: 40889CT131 -> CT115\n" +
                    "Weight: 48187CT131 -> CT264\n" +
                    "Weight: 52455\n" +
                    "CT296: \n" +
                    "CT296 -> CT8\n" +
                    "Weight: 38680CT296 -> CT94\n" +
                    "Weight: 34602CT296 -> CT177\n" +
                    "Weight: 22853CT296 -> CT180\n" +
                    "Weight: 42143CT296 -> CT42\n" +
                    "Weight: 45119CT296 -> CT204\n" +
                    "Weight: 45694\n" +
                    "CT264: \n" +
                    "CT264 -> CT8\n" +
                    "Weight: 41139CT264 -> CT204\n" +
                    "Weight: 5259CT264 -> CT131\n" +
                    "Weight: 52455CT264 -> CT263\n" +
                    "Weight: 22316CT264 -> CT31\n" +
                    "Weight: 25192\n" +
                    "CT204: \n" +
                    "CT204 -> CT8\n" +
                    "Weight: 44342CT204 -> CT264\n" +
                    "Weight: 5259CT204 -> CT179\n" +
                    "Weight: 18486CT204 -> CT52\n" +
                    "Weight: 20424CT204 -> CT296\n" +
                    "Weight: 45694\n" +
                    "CT9: \n" +
                    "CT9 -> CT281\n" +
                    "Weight: 13264CT9 -> CT237\n" +
                    "Weight: 14841CT9 -> CT128\n" +
                    "Weight: 19122\n" +
                    "CT281: \n" +
                    "CT281 -> CT9\n" +
                    "Weight: 13264CT281 -> CT200\n" +
                    "Weight: 21033CT281 -> CT100\n" +
                    "Weight: 6667CT281 -> CT237\n" +
                    "Weight: 5013CT281 -> CT278\n" +
                    "Weight: 18133\n" +
                    "CT200: \n" +
                    "CT200 -> CT70\n" +
                    "Weight: 16552CT200 -> CT278\n" +
                    "Weight: 16994CT200 -> CT281\n" +
                    "Weight: 21033CT200 -> CT53\n" +
                    "Weight: 22980CT200 -> CT140\n" +
                    "Weight: 24230\n" +
                    "CT246: \n" +
                    "CT246 -> CT72\n" +
                    "Weight: 12988CT246 -> CT181\n" +
                    "Weight: 9648CT246 -> CT272\n" +
                    "Weight: 9908CT246 -> CT279\n" +
                    "Weight: 15260\n" +
                    "CT16: \n" +
                    "CT16 -> CT71\n" +
                    "Weight: 16562CT16 -> CT242\n" +
                    "Weight: 9404CT16 -> CT273\n" +
                    "Weight: 21390CT16 -> CT184\n" +
                    "Weight: 15359CT16 -> CT253\n" +
                    "Weight: 18918\n" +
                    "CT225: \n" +
                    "CT225 -> CT74\n" +
                    "Weight: 7726CT225 -> CT137\n" +
                    "Weight: 7921CT225 -> CT266\n" +
                    "Weight: 11596CT225 -> CT138\n" +
                    "Weight: 13749CT225 -> CT17\n" +
                    "Weight: 34652CT225 -> CT173\n" +
                    "Weight: 23470\n" +
                    "CT248: \n" +
                    "CT248 -> CT73\n" +
                    "Weight: 13379CT248 -> CT22\n" +
                    "Weight: 7403CT248 -> CT24\n" +
                    "Weight: 9947\n" +
                    "CT146: \n" +
                    "CT146 -> CT76\n" +
                    "Weight: 14118CT146 -> CT218\n" +
                    "Weight: 12809CT146 -> CT127\n" +
                    "Weight: 13125CT146 -> CT166\n" +
                    "Weight: 8301CT146 -> CT214\n" +
                    "Weight: 16146\n" +
                    "CT166: \n" +
                    "CT166 -> CT76\n" +
                    "Weight: 16510CT166 -> CT90\n" +
                    "Weight: 16378CT166 -> CT214\n" +
                    "Weight: 9459CT166 -> CT146\n" +
                    "Weight: 8301CT166 -> CT91\n" +
                    "Weight: 15876CT166 -> CT218\n" +
                    "Weight: 16351\n" +
                    "CT75: \n" +
                    "CT75 -> CT105\n" +
                    "Weight: 2536CT75 -> CT268\n" +
                    "Weight: 12676\n" +
                    "CT105: \n" +
                    "CT105 -> CT75\n" +
                    "Weight: 2536CT105 -> CT192\n" +
                    "Weight: 9309CT105 -> CT63\n" +
                    "Weight: 11732\n" +
                    "CT268: \n" +
                    "CT268 -> CT75\n" +
                    "Weight: 12676CT268 -> CT254\n" +
                    "Weight: 3463CT268 -> CT277\n" +
                    "Weight: 6770CT268 -> CT63\n" +
                    "Weight: 8586\n" +
                    "CT210: \n" +
                    "CT210 -> CT78\n" +
                    "Weight: 16923CT210 -> CT80\n" +
                    "Weight: 4647CT210 -> CT147\n" +
                    "Weight: 10235CT210 -> CT155\n" +
                    "Weight: 12560\n" +
                    "CT77: \n" +
                    "CT77 -> CT315\n" +
                    "Weight: 26892CT77 -> CT134\n" +
                    "Weight: 27168CT77 -> CT124\n" +
                    "Weight: 38870CT77 -> CT188\n" +
                    "Weight: 40481\n" +
                    "CT315: \n" +
                    "CT315 -> CT77\n" +
                    "Weight: 26892CT315 -> CT188\n" +
                    "Weight: 16461CT315 -> CT230\n" +
                    "Weight: 26744CT315 -> CT148\n" +
                    "Weight: 33726CT315 -> CT126\n" +
                    "Weight: 34316CT315 -> CT134\n" +
                    "Weight: 52563\n" +
                    "CT134: \n" +
                    "CT134 -> CT77\n" +
                    "Weight: 27168CT134 -> CT212\n" +
                    "Weight: 31359CT134 -> CT124\n" +
                    "Weight: 37333CT134 -> CT96\n" +
                    "Weight: 51637CT134 -> CT315\n" +
                    "Weight: 52563\n" +
                    "CT124: \n" +
                    "CT124 -> CT77\n" +
                    "Weight: 38870CT124 -> CT96\n" +
                    "Weight: 17710CT124 -> CT212\n" +
                    "Weight: 31808CT124 -> CT55\n" +
                    "Weight: 30423CT124 -> CT134\n" +
                    "Weight: 37333\n" +
                    "CT188: \n" +
                    "CT188 -> CT77\n" +
                    "Weight: 40481CT188 -> CT79\n" +
                    "Weight: 22685CT188 -> CT315\n" +
                    "Weight: 16461CT188 -> CT97\n" +
                    "Weight: 28555CT188 -> CT126\n" +
                    "Weight: 28057\n" +
                    "CT79: \n" +
                    "CT79 -> CT157\n" +
                    "Weight: 7475CT79 -> CT223\n" +
                    "Weight: 12696CT79 -> CT188\n" +
                    "Weight: 22685CT79 -> CT97\n" +
                    "Weight: 24664\n" +
                    "CT97: \n" +
                    "CT97 -> CT79\n" +
                    "Weight: 24664CT97 -> CT25\n" +
                    "Weight: 10781CT97 -> CT223\n" +
                    "Weight: 22107CT97 -> CT188\n" +
                    "Weight: 28555CT97 -> CT157\n" +
                    "Weight: 28850CT97 -> CT222\n" +
                    "Weight: 35827\n" +
                    "CT167: \n" +
                    "CT167 -> CT318\n" +
                    "Weight: 24538CT167 -> CT169\n" +
                    "Weight: 46370CT167 -> CT61\n" +
                    "Weight: 57920\n" +
                    "CT169: \n" +
                    "CT169 -> CT318\n" +
                    "Weight: 33676CT169 -> CT122\n" +
                    "Weight: 32304CT169 -> CT149\n" +
                    "Weight: 32001CT169 -> CT14\n" +
                    "Weight: 22915CT169 -> CT167\n" +
                    "Weight: 46370\n" +
                    "CT316: \n" +
                    "CT316 -> CT117\n" +
                    "Weight: 6423CT316 -> CT233\n" +
                    "Weight: 11509CT316 -> CT276\n" +
                    "Weight: 14774\n" +
                    "CT126: \n" +
                    "CT126 -> CT315\n" +
                    "Weight: 34316CT126 -> CT222\n" +
                    "Weight: 27495CT126 -> CT148\n" +
                    "Weight: 12343CT126 -> CT256\n" +
                    "Weight: 23448CT126 -> CT1\n" +
                    "Weight: 25074CT126 -> CT188\n" +
                    "Weight: 28057\n" +
                    "CT314: \n" +
                    "CT314 -> CT82\n" +
                    "Weight: 3863CT314 -> CT275\n" +
                    "Weight: 24516CT314 -> CT12\n" +
                    "Weight: 33832\n" +
                    "CT82: \n" +
                    "CT82 -> CT314\n" +
                    "Weight: 3863CT82 -> CT275\n" +
                    "Weight: 22363CT82 -> CT12\n" +
                    "Weight: 31413CT82 -> CT251\n" +
                    "Weight: 43378\n" +
                    "CT12: \n" +
                    "CT12 -> CT314\n" +
                    "Weight: 33832CT12 -> CT82\n" +
                    "Weight: 31413CT12 -> CT163\n" +
                    "Weight: 26402CT12 -> CT275\n" +
                    "Weight: 45392\n" +
                    "CT313: \n" +
                    "CT313 -> CT247\n" +
                    "Weight: 12954CT313 -> CT242\n" +
                    "Weight: 15888CT313 -> CT164\n" +
                    "Weight: 21126CT313 -> CT312\n" +
                    "Weight: 24559\n" +
                    "CT242: \n" +
                    "CT242 -> CT313\n" +
                    "Weight: 15888CT242 -> CT312\n" +
                    "Weight: 27355CT242 -> CT16\n" +
                    "Weight: 9404CT242 -> CT273\n" +
                    "Weight: 18253CT242 -> CT184\n" +
                    "Weight: 20223CT242 -> CT40\n" +
                    "Weight: 20816\n" +
                    "CT164: \n" +
                    "CT164 -> CT313\n" +
                    "Weight: 21126CT164 -> CT216\n" +
                    "Weight: 8779CT164 -> CT236\n" +
                    "Weight: 10276CT164 -> CT247\n" +
                    "Weight: 10152CT164 -> CT139\n" +
                    "Weight: 10365\n" +
                    "CT249: \n" +
                    "CT249 -> CT310\n" +
                    "Weight: 37748CT249 -> CT267\n" +
                    "Weight: 18369CT249 -> CT131\n" +
                    "Weight: 24221CT249 -> CT190\n" +
                    "Weight: 53655\n" +
                    "CT81: \n" +
                    "CT81 -> CT311\n" +
                    "Weight: 19666CT81 -> CT274\n" +
                    "Weight: 20026CT81 -> CT255\n" +
                    "Weight: 22244CT81 -> CT139\n" +
                    "Weight: 23359CT81 -> CT236\n" +
                    "Weight: 24626\n" +
                    "CT274: \n" +
                    "CT274 -> CT81\n" +
                    "Weight: 20026CT274 -> CT139\n" +
                    "Weight: 11288CT274 -> CT40\n" +
                    "Weight: 15410CT274 -> CT170\n" +
                    "Weight: 16192\n" +
                    "CT255: \n" +
                    "CT255 -> CT81\n" +
                    "Weight: 22244CT255 -> CT323\n" +
                    "Weight: 5388CT255 -> CT320\n" +
                    "Weight: 17382CT255 -> CT41\n" +
                    "Weight: 27513\n" +
                    "CT139: \n" +
                    "CT139 -> CT81\n" +
                    "Weight: 23359CT139 -> CT216\n" +
                    "Weight: 12187CT139 -> CT236\n" +
                    "Weight: 8022CT139 -> CT164\n" +
                    "Weight: 10365CT139 -> CT274\n" +
                    "Weight: 11288\n" +
                    "CT80: \n" +
                    "CT80 -> CT206\n" +
                    "Weight: 270CT80 -> CT210\n" +
                    "Weight: 4647\n" +
                    "CT206: \n" +
                    "CT206 -> CT80\n" +
                    "Weight: 270CT206 -> CT294\n" +
                    "Weight: 15628\n" +
                    "CT83: \n" +
                    "CT83 -> CT201\n" +
                    "Weight: 15151CT83 -> CT23\n" +
                    "Weight: 22979CT83 -> CT18\n" +
                    "Weight: 23559CT83 -> CT163\n" +
                    "Weight: 42924CT83 -> CT115\n" +
                    "Weight: 43344\n" +
                    "CT23: \n" +
                    "CT23 -> CT83\n" +
                    "Weight: 22979CT23 -> CT201\n" +
                    "Weight: 23444CT23 -> CT163\n" +
                    "Weight: 42832CT23 -> CT143\n" +
                    "Weight: 45292\n" +
                    "CT18: \n" +
                    "CT18 -> CT83\n" +
                    "Weight: 23559CT18 -> CT201\n" +
                    "Weight: 28557CT18 -> CT115\n" +
                    "Weight: 22129CT18 -> CT54\n" +
                    "Weight: 33456CT18 -> CT98\n" +
                    "Weight: 43276\n" +
                    "CT163: \n" +
                    "CT163 -> CT83\n" +
                    "Weight: 42924CT163 -> CT261\n" +
                    "Weight: 37436CT163 -> CT12\n" +
                    "Weight: 26402CT163 -> CT23\n" +
                    "Weight: 42832CT163 -> CT54\n" +
                    "Weight: 54166\n" +
                    "CT85: \n" +
                    "CT85 -> CT121\n" +
                    "Weight: 12657CT85 -> CT132\n" +
                    "Weight: 17165CT85 -> CT284\n" +
                    "Weight: 19014CT85 -> CT130\n" +
                    "Weight: 24895CT85 -> CT4\n" +
                    "Weight: 26285\n" +
                    "CT121: \n" +
                    "CT121 -> CT85\n" +
                    "Weight: 12657CT121 -> CT211\n" +
                    "Weight: 15345CT121 -> CT130\n" +
                    "Weight: 15641CT121 -> CT132\n" +
                    "Weight: 26750CT121 -> CT154\n" +
                    "Weight: 26630\n" +
                    "CT87: \n" +
                    "CT87 -> CT128\n" +
                    "Weight: 4996CT87 -> CT24\n" +
                    "Weight: 15820\n" +
                    "CT24: \n" +
                    "CT24 -> CT87\n" +
                    "Weight: 15820CT24 -> CT248\n" +
                    "Weight: 9947CT24 -> CT22\n" +
                    "Weight: 6871CT24 -> CT128\n" +
                    "Weight: 19829\n" +
                    "CT174: \n" +
                    "CT174 -> CT86\n" +
                    "Weight: 5096CT174 -> CT239\n" +
                    "Weight: 19952CT174 -> CT287\n" +
                    "Weight: 10840CT174 -> CT29\n" +
                    "Weight: 19874CT174 -> CT108\n" +
                    "Weight: 20995\n" +
                    "CT29: \n" +
                    "CT29 -> CT86\n" +
                    "Weight: 15870CT29 -> CT155\n" +
                    "Weight: 12655CT29 -> CT174\n" +
                    "Weight: 19874CT29 -> CT49\n" +
                    "Weight: 13818CT29 -> CT113\n" +
                    "Weight: 15878\n" +
                    "CT113: \n" +
                    "CT113 -> CT86\n" +
                    "Weight: 18499CT113 -> CT322\n" +
                    "Weight: 6316CT113 -> CT108\n" +
                    "Weight: 10687CT113 -> CT133\n" +
                    "Weight: 12785CT113 -> CT147\n" +
                    "Weight: 12830CT113 -> CT29\n" +
                    "Weight: 15878\n" +
                    "CT209: \n" +
                    "CT209 -> CT142\n" +
                    "Weight: 4803CT209 -> CT218\n" +
                    "Weight: 6343CT209 -> CT181\n" +
                    "Weight: 16048\n" +
                    "CT142: \n" +
                    "CT142 -> CT209\n" +
                    "Weight: 4803CT142 -> CT90\n" +
                    "Weight: 12134CT142 -> CT218\n" +
                    "Weight: 8198CT142 -> CT288\n" +
                    "Weight: 12968CT142 -> CT181\n" +
                    "Weight: 18407\n" +
                    "CT181: \n" +
                    "CT181 -> CT209\n" +
                    "Weight: 16048CT181 -> CT246\n" +
                    "Weight: 9648CT181 -> CT279\n" +
                    "Weight: 20673CT181 -> CT142\n" +
                    "Weight: 18407CT181 -> CT32\n" +
                    "Weight: 19440CT181 -> CT160\n" +
                    "Weight: 20660\n" +
                    "CT179: \n" +
                    "CT179 -> CT204\n" +
                    "Weight: 18486CT179 -> CT11\n" +
                    "Weight: 6357CT179 -> CT171\n" +
                    "Weight: 6786CT179 -> CT52\n" +
                    "Weight: 10647CT179 -> CT244\n" +
                    "Weight: 16633\n" +
                    "CT203: \n" +
                    "CT203 -> CT147\n" +
                    "Weight: 9282CT203 -> CT250\n" +
                    "Weight: 11398\n" +
                    "CT147: \n" +
                    "CT147 -> CT203\n" +
                    "Weight: 9282CT147 -> CT210\n" +
                    "Weight: 10235CT147 -> CT113\n" +
                    "Weight: 12830\n" +
                    "CT250: \n" +
                    "CT250 -> CT203\n" +
                    "Weight: 11398CT250 -> CT238\n" +
                    "Weight: 10335CT250 -> CT110\n" +
                    "Weight: 9726CT250 -> CT285\n" +
                    "Weight: 7642\n" +
                    "CT202: \n" +
                    "CT202 -> CT112\n" +
                    "Weight: 11155CT202 -> CT252\n" +
                    "Weight: 12703CT202 -> CT196\n" +
                    "Weight: 14120CT202 -> CT104\n" +
                    "Weight: 14552CT202 -> CT185\n" +
                    "Weight: 15139\n" +
                    "CT112: \n" +
                    "CT112 -> CT202\n" +
                    "Weight: 11155CT112 -> CT102\n" +
                    "Weight: 13795CT112 -> CT252\n" +
                    "Weight: 5070CT112 -> CT38\n" +
                    "Weight: 11239\n" +
                    "CT320: \n" +
                    "CT320 -> CT323\n" +
                    "Weight: 19577CT320 -> CT153\n" +
                    "Weight: 16004CT320 -> CT255\n" +
                    "Weight: 17382CT320 -> CT68\n" +
                    "Weight: 18500CT320 -> CT187\n" +
                    "Weight: 19469CT320 -> CT211\n" +
                    "Weight: 21862\n" +
                    "CT322: \n" +
                    "CT322 -> CT321\n" +
                    "Weight: 3272CT322 -> CT113\n" +
                    "Weight: 6316CT322 -> CT133\n" +
                    "Weight: 8018CT322 -> CT108\n" +
                    "Weight: 12267\n" +
                    "CT321: \n" +
                    "CT321 -> CT322\n" +
                    "Weight: 3272CT321 -> CT133\n" +
                    "Weight: 7628CT321 -> CT238\n" +
                    "Weight: 8275\n" +
                    "CT133: \n" +
                    "CT133 -> CT322\n" +
                    "Weight: 8018CT133 -> CT321\n" +
                    "Weight: 7628CT133 -> CT108\n" +
                    "Weight: 11506CT133 -> CT228\n" +
                    "Weight: 15117CT133 -> CT238\n" +
                    "Weight: 11038CT133 -> CT113\n" +
                    "Weight: 12785CT133 -> CT136\n" +
                    "Weight: 11746\n" +
                    "CT278: \n" +
                    "CT278 -> CT200\n" +
                    "Weight: 16994CT278 -> CT92\n" +
                    "Weight: 16395CT278 -> CT116\n" +
                    "Weight: 17654CT278 -> CT100\n" +
                    "Weight: 17058CT278 -> CT281\n" +
                    "Weight: 18133\n" +
                    "CT238: \n" +
                    "CT238 -> CT321\n" +
                    "Weight: 8275CT238 -> CT136\n" +
                    "Weight: 5576CT238 -> CT250\n" +
                    "Weight: 10335CT238 -> CT133\n" +
                    "Weight: 11038CT238 -> CT110\n" +
                    "Weight: 12676\n" +
                    "CT90: \n" +
                    "CT90 -> CT288\n" +
                    "Weight: 8236CT90 -> CT142\n" +
                    "Weight: 12134CT90 -> CT91\n" +
                    "Weight: 13389CT90 -> CT166\n" +
                    "Weight: 16378CT90 -> CT218\n" +
                    "Weight: 16901CT90 -> CT178\n" +
                    "Weight: 24588\n" +
                    "CT91: \n" +
                    "CT91 -> CT90\n" +
                    "Weight: 13389CT91 -> CT270\n" +
                    "Weight: 15022CT91 -> CT214\n" +
                    "Weight: 15056CT91 -> CT166\n" +
                    "Weight: 15876CT91 -> CT178\n" +
                    "Weight: 18362\n" +
                    "CT270: \n" +
                    "CT270 -> CT91\n" +
                    "Weight: 15022CT270 -> CT219\n" +
                    "Weight: 16450CT270 -> CT118\n" +
                    "Weight: 24887CT270 -> CT178\n" +
                    "Weight: 15100CT270 -> CT214\n" +
                    "Weight: 23720\n" +
                    "CT94: \n" +
                    "CT94 -> CT245\n" +
                    "Weight: 26733CT94 -> CT56\n" +
                    "Weight: 27850CT94 -> CT22\n" +
                    "Weight: 31971CT94 -> CT296\n" +
                    "Weight: 34602CT94 -> CT73\n" +
                    "Weight: 35208CT94 -> CT180\n" +
                    "Weight: 36445\n" +
                    "CT22: \n" +
                    "CT22 -> CT94\n" +
                    "Weight: 31971CT22 -> CT248\n" +
                    "Weight: 7403CT22 -> CT24\n" +
                    "Weight: 6871CT22 -> CT73\n" +
                    "Weight: 17263\n" +
                    "CT19: \n" +
                    "CT19 -> CT93\n" +
                    "Weight: 3808CT19 -> CT95\n" +
                    "Weight: 8645CT19 -> CT259\n" +
                    "Weight: 6823CT19 -> CT141\n" +
                    "Weight: 7978\n" +
                    "CT217: \n" +
                    "CT217 -> CT21\n" +
                    "Weight: 16646CT217 -> CT119\n" +
                    "Weight: 17107CT217 -> CT284\n" +
                    "Weight: 26489CT217 -> CT161\n" +
                    "Weight: 28732\n" +
                    "CT21: \n" +
                    "CT21 -> CT217\n" +
                    "Weight: 16646CT21 -> CT119\n" +
                    "Weight: 22152CT21 -> CT132\n" +
                    "Weight: 41180CT21 -> CT161\n" +
                    "Weight: 44355\n" +
                    "CT215: \n" +
                    "CT215 -> CT145\n" +
                    "Weight: 16166CT215 -> CT189\n" +
                    "Weight: 19403CT215 -> CT65\n" +
                    "Weight: 23786CT215 -> CT57\n" +
                    "Weight: 24195\n" +
                    "CT28: \n" +
                    "CT28 -> CT109\n" +
                    "Weight: 1698CT28 -> CT232\n" +
                    "Weight: 2195\n" +
                    "CT297: \n" +
                    "CT297 -> CT107\n" +
                    "Weight: 30205CT297 -> CT224\n" +
                    "Weight: 29487CT297 -> CT27\n" +
                    "Weight: 10495CT297 -> CT299\n" +
                    "Weight: 25554CT297 -> CT115\n" +
                    "Weight: 36210\n" +
                    "CT30: \n" +
                    "CT30 -> CT228\n" +
                    "Weight: 11236CT30 -> CT117\n" +
                    "Weight: 1744CT30 -> CT276\n" +
                    "Weight: 11235\n" +
                    "CT291: \n" +
                    "CT291 -> CT227\n" +
                    "Weight: 19329CT291 -> CT156\n" +
                    "Weight: 21178CT291 -> CT10\n" +
                    "Weight: 6048CT291 -> CT186\n" +
                    "Weight: 4691CT291 -> CT53\n" +
                    "Weight: 20471\n" +
                    "CT241: \n" +
                    "CT241 -> CT226\n" +
                    "Weight: 5835CT241 -> CT101\n" +
                    "Weight: 4106CT241 -> CT129\n" +
                    "Weight: 5137CT241 -> CT294\n" +
                    "Weight: 6200CT241 -> CT159\n" +
                    "Weight: 9829CT241 -> CT152\n" +
                    "Weight: 7704\n" +
                    "CT224: \n" +
                    "CT224 -> CT299\n" +
                    "Weight: 15648CT224 -> CT235\n" +
                    "Weight: 21582CT224 -> CT27\n" +
                    "Weight: 28125CT224 -> CT297\n" +
                    "Weight: 29487CT224 -> CT182\n" +
                    "Weight: 31202CT224 -> CT183\n" +
                    "Weight: 32529\n" +
                    "CT235: \n" +
                    "CT235 -> CT224\n" +
                    "Weight: 21582CT235 -> CT183\n" +
                    "Weight: 19104CT235 -> CT234\n" +
                    "Weight: 28260CT235 -> CT182\n" +
                    "Weight: 34978\n" +
                    "CT101: \n" +
                    "CT101 -> CT15\n" +
                    "Weight: 3852CT101 -> CT241\n" +
                    "Weight: 4106CT101 -> CT294\n" +
                    "Weight: 5730CT101 -> CT129\n" +
                    "Weight: 7884CT101 -> CT152\n" +
                    "Weight: 6910CT101 -> CT285\n" +
                    "Weight: 15292\n" +
                    "CT15: \n" +
                    "CT15 -> CT101\n" +
                    "Weight: 3852CT15 -> CT285\n" +
                    "Weight: 12466CT15 -> CT294\n" +
                    "Weight: 7269\n" +
                    "CT294: \n" +
                    "CT294 -> CT101\n" +
                    "Weight: 5730CT294 -> CT129\n" +
                    "Weight: 5129CT294 -> CT241\n" +
                    "Weight: 6200CT294 -> CT15\n" +
                    "Weight: 7269CT294 -> CT206\n" +
                    "Weight: 15628\n" +
                    "CT122: \n" +
                    "CT122 -> CT119\n" +
                    "Weight: 27349CT122 -> CT308\n" +
                    "Weight: 31026CT122 -> CT169\n" +
                    "Weight: 32304CT122 -> CT280\n" +
                    "Weight: 34173\n" +
                    "CT118: \n" +
                    "CT118 -> CT178\n" +
                    "Weight: 16957CT118 -> CT270\n" +
                    "Weight: 24887CT118 -> CT69\n" +
                    "Weight: 34834\n" +
                    "CT178: \n" +
                    "CT178 -> CT118\n" +
                    "Weight: 16957CT178 -> CT270\n" +
                    "Weight: 15100CT178 -> CT91\n" +
                    "Weight: 18362CT178 -> CT69\n" +
                    "Weight: 23622CT178 -> CT90\n" +
                    "Weight: 24588\n" +
                    "CT232: \n" +
                    "CT232 -> CT158\n" +
                    "Weight: 1954CT232 -> CT28\n" +
                    "Weight: 2195\n" +
                    "CT289: \n" +
                    "CT289 -> CT125\n" +
                    "Weight: 10141CT289 -> CT135\n" +
                    "Weight: 5662CT289 -> CT114\n" +
                    "Weight: 15514CT289 -> CT165\n" +
                    "Weight: 16410\n" +
                    "CT244: \n" +
                    "CT244 -> CT191\n" +
                    "Weight: 7534CT244 -> CT144\n" +
                    "Weight: 7546CT244 -> CT141\n" +
                    "Weight: 8041CT244 -> CT11\n" +
                    "Weight: 14712CT244 -> CT179\n" +
                    "Weight: 16633\n" +
                    "CT254: \n" +
                    "CT254 -> CT268\n" +
                    "Weight: 3463CT254 -> CT277\n" +
                    "Weight: 6492\n" +
                    "CT277: \n" +
                    "CT277 -> CT254\n" +
                    "Weight: 6492CT277 -> CT268\n" +
                    "Weight: 6770CT277 -> CT20\n" +
                    "Weight: 9940CT277 -> CT151\n" +
                    "Weight: 10856CT277 -> CT63\n" +
                    "Weight: 11806\n" +
                    "CT282: \n" +
                    "CT282 -> CT269\n" +
                    "Weight: 13862CT282 -> CT145\n" +
                    "Weight: 20043CT282 -> CT151\n" +
                    "Weight: 19508CT282 -> CT57\n" +
                    "Weight: 24874CT282 -> CT13\n" +
                    "Weight: 24957\n" +
                    "CT151: \n" +
                    "CT151 -> CT269\n" +
                    "Weight: 20357CT151 -> CT277\n" +
                    "Weight: 10856CT151 -> CT20\n" +
                    "Weight: 12106CT151 -> CT282\n" +
                    "Weight: 19508\n" +
                    "CT20: \n" +
                    "CT20 -> CT144\n" +
                    "Weight: 10111CT20 -> CT277\n" +
                    "Weight: 9940CT20 -> CT151\n" +
                    "Weight: 12106CT20 -> CT2\n" +
                    "Weight: 9881\n" +
                    "CT263: \n" +
                    "CT263 -> CT264\n" +
                    "Weight: 22316CT263 -> CT31\n" +
                    "Weight: 22541\n" +
                    "CT162: \n" +
                    "CT162 -> CT172\n" +
                    "Weight: 20268CT162 -> CT34\n" +
                    "Weight: 35534CT162 -> CT207\n" +
                    "Weight: 36886\n" +
                    "CT172: \n" +
                    "CT172 -> CT162\n" +
                    "Weight: 20268CT172 -> CT293\n" +
                    "Weight: 15165CT172 -> CT207\n" +
                    "Weight: 21223\n" +
                    "CT11: \n" +
                    "CT11 -> CT179\n" +
                    "Weight: 6357CT11 -> CT244\n" +
                    "Weight: 14712CT11 -> CT52\n" +
                    "Weight: 15623CT11 -> CT141\n" +
                    "Weight: 19253\n" +
                    "CT171: \n" +
                    "CT171 -> CT179\n" +
                    "Weight: 6786CT171 -> CT52\n" +
                    "Weight: 8746\n" +
                    "CT186: \n" +
                    "CT186 -> CT291\n" +
                    "Weight: 4691CT186 -> CT156\n" +
                    "Weight: 22207\n";
        }

        Assertions.assertEquals(expected, distMap.toString());
    }

    @Test
    void BigFileStringCoordMap() throws Exception {
        CoordMap coordMap = new CoordMap();
        File csvCoord = new File("Data/locais_Big.csv");
        coordMap.loadCSVMap(csvCoord);

        String expected;

        {
            expected = "Map: 323 localidades\n" +
                    "Localidade: CT220\n" +
                    "Coordenadas: 41.8078, -8.4194\n" +
                    "Localidade: CT217\n" +
                    "Coordenadas: 40.7833, -7.0667\n" +
                    "Localidade: CT216\n" +
                    "Coordenadas: 41.1632, -7.789\n" +
                    "Localidade: CT215\n" +
                    "Coordenadas: 39.3633, -9.3792\n" +
                    "Localidade: CT214\n" +
                    "Coordenadas: 40.0333, -8.3833\n" +
                    "Localidade: CT213\n" +
                    "Coordenadas: 40.9831, -7.3894\n" +
                    "Localidade: CT212\n" +
                    "Coordenadas: 40.1667, -7.1667\n" +
                    "Localidade: CT211\n" +
                    "Coordenadas: 40.6667, -7.6833\n" +
                    "Localidade: CT210\n" +
                    "Coordenadas: 41.2, -8.2833\n" +
                    "Localidade: CT219\n" +
                    "Coordenadas: 39.9162, -8.6279\n" +
                    "Localidade: CT218\n" +
                    "Coordenadas: 40.2167, -8.25\n" +
                    "Localidade: CT110\n" +
                    "Coordenadas: 41.4144, -8.5222\n" +
                    "Localidade: CT231\n" +
                    "Coordenadas: 37.0695, -8.1006\n" +
                    "Localidade: CT230\n" +
                    "Coordenadas: 39.75, -7.9167\n" +
                    "Localidade: CT228\n" +
                    "Coordenadas: 41.5667, -8.2667\n" +
                    "Localidade: CT107\n" +
                    "Coordenadas: 38.5667, -7.9\n" +
                    "Localidade: CT227\n" +
                    "Coordenadas: 39.6, -8.8167\n" +
                    "Localidade: CT106\n" +
                    "Coordenadas: 38.8422, -7.5881\n" +
                    "Localidade: CT105\n" +
                    "Coordenadas: 38.7057, -9.3977\n" +
                    "Localidade: CT226\n" +
                    "Coordenadas: 41.1495, -8.6108\n" +
                    "Localidade: CT225\n" +
                    "Coordenadas: 37.1333, -8.5333\n" +
                    "Localidade: CT104\n" +
                    "Coordenadas: 40.75, -8.5667\n" +
                    "Localidade: CT103\n" +
                    "Coordenadas: 41.5333, -8.7833\n" +
                    "Localidade: CT224\n" +
                    "Coordenadas: 38.3, -7.7\n" +
                    "Localidade: CT102\n" +
                    "Coordenadas: 41.01, -8.64\n" +
                    "Localidade: CT223\n" +
                    "Coordenadas: 39.3167, -7.4167\n" +
                    "Localidade: CT222\n" +
                    "Coordenadas: 39.25, -8.0167\n" +
                    "Localidade: CT101\n" +
                    "Coordenadas: 41.2133, -8.5472\n" +
                    "Localidade: CT100\n" +
                    "Coordenadas: 39.4667, -8.4667\n" +
                    "Localidade: CT221\n" +
                    "Coordenadas: 41.7667, -8.5833\n" +
                    "Localidade: CT109\n" +
                    "Coordenadas: 38.759, -9.2199\n" +
                    "Localidade: CT108\n" +
                    "Coordenadas: 41.45, -8.1667\n" +
                    "Localidade: CT229\n" +
                    "Coordenadas: 41.3916, -8.7571\n" +
                    "Localidade: CT19\n" +
                    "Coordenadas: 38.6803, -9.1583\n" +
                    "Localidade: CT18\n" +
                    "Coordenadas: 37.8775, -8.1653\n" +
                    "Localidade: CT17\n" +
                    "Coordenadas: 37.3178, -8.8\n" +
                    "Localidade: CT16\n" +
                    "Coordenadas: 41.2764, -7.4749\n" +
                    "Localidade: CT15\n" +
                    "Coordenadas: 41.2395, -8.5244\n" +
                    "Localidade: CT14\n" +
                    "Coordenadas: 41.35, -6.9667\n" +
                    "Localidade: CT13\n" +
                    "Coordenadas: 39.0531, -9.0092\n" +
                    "Localidade: CT12\n" +
                    "Coordenadas: 37.4717, -7.4722\n" +
                    "Localidade: CT11\n" +
                    "Coordenadas: 38.7553, -8.9608\n" +
                    "Localidade: CT10\n" +
                    "Coordenadas: 39.5522, -8.9775\n" +
                    "Localidade: CT316\n" +
                    "Coordenadas: 41.65, -8.4333\n" +
                    "Localidade: CT315\n" +
                    "Coordenadas: 39.65, -7.6667\n" +
                    "Localidade: CT314\n" +
                    "Coordenadas: 37.2, -7.4167\n" +
                    "Localidade: CT313\n" +
                    "Coordenadas: 41.3002, -7.7398\n" +
                    "Localidade: CT312\n" +
                    "Coordenadas: 41.4833, -7.6333\n" +
                    "Localidade: CT311\n" +
                    "Coordenadas: 40.85, -7.7333\n" +
                    "Localidade: CT310\n" +
                    "Coordenadas: 37.7167, -8.7833\n" +
                    "Localidade: CT319\n" +
                    "Coordenadas: 41.8167, -7.0\n" +
                    "Localidade: CT318\n" +
                    "Coordenadas: 41.5667, -6.5167\n" +
                    "Localidade: CT317\n" +
                    "Coordenadas: 38.75, -7.4333\n" +
                    "Localidade: CT29\n" +
                    "Coordenadas: 41.2728, -8.0825\n" +
                    "Localidade: CT28\n" +
                    "Coordenadas: 38.75, -9.2333\n" +
                    "Localidade: CT27\n" +
                    "Coordenadas: 38.25, -7.9833\n" +
                    "Localidade: CT26\n" +
                    "Coordenadas: 39.8333, -8.3833\n" +
                    "Localidade: CT25\n" +
                    "Coordenadas: 39.1974, -7.6589\n" +
                    "Localidade: CT24\n" +
                    "Coordenadas: 39.2593, -8.585\n" +
                    "Localidade: CT23\n" +
                    "Coordenadas: 37.5114, -8.0603\n" +
                    "Localidade: CT22\n" +
                    "Coordenadas: 39.209, -8.6164\n" +
                    "Localidade: CT21\n" +
                    "Coordenadas: 40.7259, -6.9056\n" +
                    "Localidade: CT206\n" +
                    "Coordenadas: 41.2, -8.3333\n" +
                    "Localidade: CT20\n" +
                    "Coordenadas: 38.8475, -9.2714\n" +
                    "Localidade: CT205\n" +
                    "Coordenadas: 40.05, -7.95\n" +
                    "Localidade: CT204\n" +
                    "Coordenadas: 38.5667, -8.9\n" +
                    "Localidade: CT203\n" +
                    "Coordenadas: 41.2833, -8.3833\n" +
                    "Localidade: CT323\n" +
                    "Coordenadas: 40.7231, -8.1122\n" +
                    "Localidade: CT202\n" +
                    "Coordenadas: 40.8597, -8.6253\n" +
                    "Localidade: CT322\n" +
                    "Coordenadas: 41.3828, -8.2647\n" +
                    "Localidade: CT201\n" +
                    "Coordenadas: 37.65, -8.225\n" +
                    "Localidade: CT321\n" +
                    "Coordenadas: 41.3833, -8.3\n" +
                    "Localidade: CT200\n" +
                    "Coordenadas: 39.65, -8.5833\n" +
                    "Localidade: CT320\n" +
                    "Coordenadas: 40.6667, -7.9167\n" +
                    "Localidade: CT209\n" +
                    "Coordenadas: 40.2667, -8.2667\n" +
                    "Localidade: CT208\n" +
                    "Coordenadas: 39.9167, -8.15\n" +
                    "Localidade: CT207\n" +
                    "Coordenadas: 41.9111, -8.5597\n" +
                    "Localidade: CT39\n" +
                    "Coordenadas: 37.1, -8.3667\n" +
                    "Localidade: CT38\n" +
                    "Coordenadas: 41.0167, -8.55\n" +
                    "Localidade: CT37\n" +
                    "Coordenadas: 40.2183, -8.0542\n" +
                    "Localidade: CT36\n" +
                    "Coordenadas: 41.7917, -8.5944\n" +
                    "Localidade: CT35\n" +
                    "Coordenadas: 41.0555, -8.6395\n" +
                    "Localidade: CT34\n" +
                    "Coordenadas: 41.85, -8.4167\n" +
                    "Localidade: CT33\n" +
                    "Coordenadas: 39.9167, -8.4333\n" +
                    "Localidade: CT32\n" +
                    "Coordenadas: 40.4333, -8.4333\n" +
                    "Localidade: CT31\n" +
                    "Coordenadas: 38.6265, -9.1189\n" +
                    "Localidade: CT30\n" +
                    "Coordenadas: 41.6333, -8.35\n" +
                    "Localidade: CT49\n" +
                    "Coordenadas: 41.1667, -8.0333\n" +
                    "Localidade: CT48\n" +
                    "Coordenadas: 39.0667, -8.8667\n" +
                    "Localidade: CT47\n" +
                    "Coordenadas: 39.05, -7.8833\n" +
                    "Localidade: CT46\n" +
                    "Coordenadas: 41.4039, -8.769\n" +
                    "Localidade: CT45\n" +
                    "Coordenadas: 40.6389, -8.6553\n" +
                    "Localidade: CT44\n" +
                    "Coordenadas: 38.9833, -9.0667\n" +
                    "Localidade: CT43\n" +
                    "Coordenadas: 39.1167, -7.2833\n" +
                    "Localidade: CT42\n" +
                    "Coordenadas: 38.7229, -7.9843\n" +
                    "Localidade: CT305\n" +
                    "Coordenadas: 38.95, -8.9833\n" +
                    "Localidade: CT304\n" +
                    "Coordenadas: 41.3067, -7.1522\n" +
                    "Localidade: CT41\n" +
                    "Coordenadas: 40.9289, -8.2436\n" +
                    "Localidade: CT303\n" +
                    "Coordenadas: 41.35, -8.75\n" +
                    "Localidade: CT40\n" +
                    "Coordenadas: 41.1167, -7.6833\n" +
                    "Localidade: CT302\n" +
                    "Coordenadas: 37.0825, -8.9119\n" +
                    "Localidade: CT301\n" +
                    "Coordenadas: 39.6833, -8.15\n" +
                    "Localidade: CT300\n" +
                    "Coordenadas: 41.6333, -8.1333\n" +
                    "Localidade: CT309\n" +
                    "Coordenadas: 41.1333, -8.6167\n" +
                    "Localidade: CT308\n" +
                    "Coordenadas: 41.0833, -7.1333\n" +
                    "Localidade: CT307\n" +
                    "Coordenadas: 41.94, -8.7444\n" +
                    "Localidade: CT306\n" +
                    "Coordenadas: 39.45, -8.4333\n" +
                    "Localidade: CT59\n" +
                    "Coordenadas: 41.6889, -7.665\n" +
                    "Localidade: CT58\n" +
                    "Coordenadas: 38.8056, -7.4547\n" +
                    "Localidade: CT57\n" +
                    "Coordenadas: 39.2672, -9.1581\n" +
                    "Localidade: CT56\n" +
                    "Coordenadas: 38.9833, -8.8167\n" +
                    "Localidade: CT55\n" +
                    "Coordenadas: 40.3583, -7.3514\n" +
                    "Localidade: CT54\n" +
                    "Coordenadas: 38.0333, -7.8833\n" +
                    "Localidade: CT53\n" +
                    "Coordenadas: 39.6603, -8.8247\n" +
                    "Localidade: CT52\n" +
                    "Coordenadas: 38.6631, -9.0725\n" +
                    "Localidade: CT51\n" +
                    "Coordenadas: 38.1307, -6.9761\n" +
                    "Localidade: CT50\n" +
                    "Coordenadas: 41.5347, -8.615\n" +
                    "Localidade: CT199\n" +
                    "Coordenadas: 40.3597, -7.8617\n" +
                    "Localidade: CT69\n" +
                    "Coordenadas: 40.3464, -8.5942\n" +
                    "Localidade: CT68\n" +
                    "Coordenadas: 40.5167, -7.9\n" +
                    "Localidade: CT67\n" +
                    "Coordenadas: 39.0167, -7.0667\n" +
                    "Localidade: CT66\n" +
                    "Coordenadas: 41.8779, -8.8382\n" +
                    "Localidade: CT65\n" +
                    "Coordenadas: 39.4069, -9.1363\n" +
                    "Localidade: CT64\n" +
                    "Coordenadas: 39.25, -9.1\n" +
                    "Localidade: CT63\n" +
                    "Coordenadas: 38.7704, -9.3081\n" +
                    "Localidade: CT62\n" +
                    "Coordenadas: 41.5167, -8.0\n" +
                    "Localidade: CT61\n" +
                    "Coordenadas: 41.8, -6.75\n" +
                    "Localidade: CT60\n" +
                    "Coordenadas: 41.5333, -8.4167\n" +
                    "Localidade: CT187\n" +
                    "Coordenadas: 40.5167, -7.85\n" +
                    "Localidade: CT186\n" +
                    "Coordenadas: 39.6, -9.0667\n" +
                    "Localidade: CT185\n" +
                    "Coordenadas: 40.7369, -8.6386\n" +
                    "Localidade: CT184\n" +
                    "Coordenadas: 41.4, -7.45\n" +
                    "Localidade: CT79\n" +
                    "Coordenadas: 39.4167, -7.45\n" +
                    "Localidade: CT183\n" +
                    "Coordenadas: 38.3333, -7.3667\n" +
                    "Localidade: CT78\n" +
                    "Coordenadas: 41.063, -8.2647\n" +
                    "Localidade: CT182\n" +
                    "Coordenadas: 38.1397, -7.4505\n" +
                    "Localidade: CT77\n" +
                    "Coordenadas: 39.823, -7.4931\n" +
                    "Localidade: CT181\n" +
                    "Coordenadas: 40.3947, -8.2328\n" +
                    "Localidade: CT180\n" +
                    "Coordenadas: 38.9333, -8.15\n" +
                    "Localidade: CT76\n" +
                    "Coordenadas: 40.0, -8.2167\n" +
                    "Localidade: CT75\n" +
                    "Coordenadas: 38.6972, -9.4217\n" +
                    "Localidade: CT74\n" +
                    "Coordenadas: 37.1, -8.4667\n" +
                    "Localidade: CT73\n" +
                    "Coordenadas: 39.1619, -8.7864\n" +
                    "Localidade: CT72\n" +
                    "Coordenadas: 40.4333, -8.0\n" +
                    "Localidade: CT71\n" +
                    "Coordenadas: 41.25, -7.3\n" +
                    "Localidade: CT70\n" +
                    "Coordenadas: 39.75, -8.7\n" +
                    "Localidade: CT179\n" +
                    "Coordenadas: 38.7049, -8.9757\n" +
                    "Localidade: CT299\n" +
                    "Coordenadas: 38.2, -7.8\n" +
                    "Localidade: CT178\n" +
                    "Coordenadas: 40.1667, -8.6833\n" +
                    "Localidade: CT298\n" +
                    "Coordenadas: 41.7, -8.8333\n" +
                    "Localidade: CT177\n" +
                    "Coordenadas: 38.65, -8.2167\n" +
                    "Localidade: CT190\n" +
                    "Coordenadas: 37.5833, -8.6333\n" +
                    "Localidade: CT198\n" +
                    "Coordenadas: 40.5167, -8.5\n" +
                    "Localidade: CT197\n" +
                    "Coordenadas: 40.7314, -8.1767\n" +
                    "Localidade: CT196\n" +
                    "Coordenadas: 40.84, -8.4764\n" +
                    "Localidade: CT195\n" +
                    "Coordenadas: 41.0711, -8.5272\n" +
                    "Localidade: CT194\n" +
                    "Coordenadas: 37.0278, -7.8389\n" +
                    "Localidade: CT89\n" +
                    "Coordenadas: 41.0667, -8.0833\n" +
                    "Localidade: CT193\n" +
                    "Coordenadas: 39.9167, -7.9167\n" +
                    "Localidade: CT88\n" +
                    "Coordenadas: 41.7399, -7.4707\n" +
                    "Localidade: CT192\n" +
                    "Coordenadas: 38.697, -9.3017\n" +
                    "Localidade: CT87\n" +
                    "Coordenadas: 39.3594, -8.4808\n" +
                    "Localidade: CT191\n" +
                    "Coordenadas: 38.8, -9.1833\n" +
                    "Localidade: CT86\n" +
                    "Coordenadas: 41.3869, -8.0022\n" +
                    "Localidade: CT85\n" +
                    "Coordenadas: 40.6333, -7.4\n" +
                    "Localidade: CT84\n" +
                    "Coordenadas: 41.5136, -8.4522\n" +
                    "Localidade: CT83\n" +
                    "Coordenadas: 37.6976, -8.0819\n" +
                    "Localidade: CT82\n" +
                    "Coordenadas: 37.2167, -7.45\n" +
                    "Localidade: CT81\n" +
                    "Coordenadas: 40.9, -7.9333\n" +
                    "Localidade: CT80\n" +
                    "Coordenadas: 41.2008, -8.3306\n" +
                    "Localidade: CT189\n" +
                    "Coordenadas: 39.3585, -9.176\n" +
                    "Localidade: CT188\n" +
                    "Coordenadas: 39.5167, -7.65\n" +
                    "Localidade: CT286\n" +
                    "Coordenadas: 40.6114, -8.4673\n" +
                    "Localidade: CT165\n" +
                    "Coordenadas: 40.4285, -8.7363\n" +
                    "Localidade: CT285\n" +
                    "Coordenadas: 41.3374, -8.5596\n" +
                    "Localidade: CT164\n" +
                    "Coordenadas: 41.1667, -7.8833\n" +
                    "Localidade: CT284\n" +
                    "Coordenadas: 40.7833, -7.35\n" +
                    "Localidade: CT163\n" +
                    "Coordenadas: 37.6333, -7.65\n" +
                    "Localidade: CT283\n" +
                    "Coordenadas: 39.4583, -8.2461\n" +
                    "Localidade: CT162\n" +
                    "Coordenadas: 42.1167, -8.2667\n" +
                    "Localidade: CT161\n" +
                    "Coordenadas: 40.9631, -7.2631\n" +
                    "Localidade: CT282\n" +
                    "Coordenadas: 39.0833, -9.2667\n" +
                    "Localidade: CT281\n" +
                    "Coordenadas: 39.4833, -8.5333\n" +
                    "Localidade: CT160\n" +
                    "Coordenadas: 40.3781, -8.4514\n" +
                    "Localidade: CT280\n" +
                    "Coordenadas: 41.2, -7.1333\n" +
                    "Localidade: CT99\n" +
                    "Coordenadas: 38.88, -7.1628\n" +
                    "Localidade: CT98\n" +
                    "Coordenadas: 38.15, -7.8833\n" +
                    "Localidade: CT97\n" +
                    "Coordenadas: 39.2844, -7.6444\n" +
                    "Localidade: CT96\n" +
                    "Coordenadas: 40.2833, -7.5\n" +
                    "Localidade: CT95\n" +
                    "Coordenadas: 38.6446, -9.2356\n" +
                    "Localidade: CT94\n" +
                    "Coordenadas: 38.9581, -8.5283\n" +
                    "Localidade: CT159\n" +
                    "Coordenadas: 41.2077, -8.6674\n" +
                    "Localidade: CT158\n" +
                    "Coordenadas: 38.7568, -9.2748\n" +
                    "Localidade: CT93\n" +
                    "Coordenadas: 38.65, -9.15\n" +
                    "Localidade: CT279\n" +
                    "Coordenadas: 40.5164, -8.0808\n" +
                    "Localidade: CT278\n" +
                    "Coordenadas: 39.6, -8.4167\n" +
                    "Localidade: CT157\n" +
                    "Coordenadas: 39.3942, -7.3772\n" +
                    "Localidade: CT92\n" +
                    "Coordenadas: 39.4833, -8.3333\n" +
                    "Localidade: CT156\n" +
                    "Coordenadas: 39.7478, -8.9322\n" +
                    "Localidade: CT277\n" +
                    "Coordenadas: 38.8511, -9.3747\n" +
                    "Localidade: CT91\n" +
                    "Coordenadas: 40.1167, -8.5\n" +
                    "Localidade: CT276\n" +
                    "Coordenadas: 41.7167, -8.3\n" +
                    "Localidade: CT155\n" +
                    "Coordenadas: 41.1833, -8.15\n" +
                    "Localidade: CT90\n" +
                    "Coordenadas: 40.2111, -8.4291\n" +
                    "Localidade: CT297\n" +
                    "Coordenadas: 38.3342, -8.0014\n" +
                    "Localidade: CT176\n" +
                    "Coordenadas: 41.8239, -7.79\n" +
                    "Localidade: CT175\n" +
                    "Coordenadas: 39.05, -7.4333\n" +
                    "Localidade: CT296\n" +
                    "Coordenadas: 38.6833, -8.45\n" +
                    "Localidade: CT295\n" +
                    "Coordenadas: 41.6075, -7.31\n" +
                    "Localidade: CT174\n" +
                    "Coordenadas: 41.4, -7.95\n" +
                    "Localidade: CT294\n" +
                    "Coordenadas: 41.1833, -8.5\n" +
                    "Localidade: CT173\n" +
                    "Coordenadas: 37.3167, -8.6\n" +
                    "Localidade: CT293\n" +
                    "Coordenadas: 42.0282, -8.6339\n" +
                    "Localidade: CT172\n" +
                    "Coordenadas: 42.0733, -8.48\n" +
                    "Localidade: CT171\n" +
                    "Coordenadas: 38.65, -8.9833\n" +
                    "Localidade: CT292\n" +
                    "Coordenadas: 40.85, -8.4\n" +
                    "Localidade: CT291\n" +
                    "Coordenadas: 39.5892, -9.0194\n" +
                    "Localidade: CT170\n" +
                    "Coordenadas: 40.9819, -7.6158\n" +
                    "Localidade: CT290\n" +
                    "Coordenadas: 41.0997, -8.6403\n" +
                    "Localidade: CT169\n" +
                    "Coordenadas: 41.3392, -6.72\n" +
                    "Localidade: CT168\n" +
                    "Coordenadas: 41.4833, -7.1833\n" +
                    "Localidade: CT289\n" +
                    "Coordenadas: 40.5553, -8.6814\n" +
                    "Localidade: CT288\n" +
                    "Coordenadas: 40.2756, -8.4528\n" +
                    "Localidade: CT167\n" +
                    "Coordenadas: 41.5, -6.2667\n" +
                    "Localidade: CT287\n" +
                    "Coordenadas: 41.4878, -7.9613\n" +
                    "Localidade: CT166\n" +
                    "Coordenadas: 40.1, -8.3333\n" +
                    "Localidade: CT143\n" +
                    "Coordenadas: 37.144, -8.0235\n" +
                    "Localidade: CT264\n" +
                    "Coordenadas: 38.5243, -8.8926\n" +
                    "Localidade: CT263\n" +
                    "Coordenadas: 38.4437, -9.0996\n" +
                    "Localidade: CT142\n" +
                    "Coordenadas: 40.2594, -8.3168\n" +
                    "Localidade: CT262\n" +
                    "Coordenadas: 39.8008, -8.1003\n" +
                    "Localidade: CT141\n" +
                    "Coordenadas: 38.7452, -9.1604\n" +
                    "Localidade: CT261\n" +
                    "Coordenadas: 37.9333, -7.5833\n" +
                    "Localidade: CT140\n" +
                    "Coordenadas: 39.7444, -8.8072\n" +
                    "Localidade: CT260\n" +
                    "Coordenadas: 40.9003, -7.4942\n" +
                    "Localidade: CT139\n" +
                    "Coordenadas: 41.0833, -7.8667\n" +
                    "Localidade: CT138\n" +
                    "Coordenadas: 37.1, -8.6667\n" +
                    "Localidade: CT259\n" +
                    "Coordenadas: 38.6428, -9.1061\n" +
                    "Localidade: CT258\n" +
                    "Coordenadas: 40.4203, -7.7033\n" +
                    "Localidade: CT137\n" +
                    "Coordenadas: 37.1347, -8.4528\n" +
                    "Localidade: CT136\n" +
                    "Coordenadas: 41.4333, -8.4167\n" +
                    "Localidade: CT257\n" +
                    "Coordenadas: 40.7333, -7.7167\n" +
                    "Localidade: CT256\n" +
                    "Coordenadas: 39.5333, -8.1667\n" +
                    "Localidade: CT135\n" +
                    "Coordenadas: 40.6, -8.6667\n" +
                    "Localidade: CT255\n" +
                    "Coordenadas: 40.75, -8.0667\n" +
                    "Localidade: CT134\n" +
                    "Coordenadas: 39.9167, -7.2333\n" +
                    "Localidade: CT133\n" +
                    "Coordenadas: 41.445, -8.2908\n" +
                    "Localidade: CT254\n" +
                    "Coordenadas: 38.8125, -9.4208\n" +
                    "Localidade: CT275\n" +
                    "Coordenadas: 37.1309, -7.6506\n" +
                    "Localidade: CT154\n" +
                    "Coordenadas: 40.4, -7.5333\n" +
                    "Localidade: CT274\n" +
                    "Coordenadas: 41.0167, -7.7833\n" +
                    "Localidade: CT153\n" +
                    "Coordenadas: 40.6058, -7.7658\n" +
                    "Localidade: CT152\n" +
                    "Coordenadas: 41.2333, -8.6167\n" +
                    "Localidade: CT273\n" +
                    "Coordenadas: 41.1167, -7.5667\n" +
                    "Localidade: CT151\n" +
                    "Coordenadas: 38.9333, -9.3333\n" +
                    "Localidade: CT272\n" +
                    "Coordenadas: 40.3667, -8.0333\n" +
                    "Localidade: CT150\n" +
                    "Coordenadas: 41.1152, -8.6036\n" +
                    "Localidade: CT271\n" +
                    "Coordenadas: 38.9532, -7.6757\n" +
                    "Localidade: CT270\n" +
                    "Coordenadas: 40.05, -8.6333\n" +
                    "Localidade: CT149\n" +
                    "Coordenadas: 41.5333, -6.95\n" +
                    "Localidade: CT269\n" +
                    "Coordenadas: 39.0167, -9.15\n" +
                    "Localidade: CT148\n" +
                    "Coordenadas: 39.5533, -7.9986\n" +
                    "Localidade: CT268\n" +
                    "Coordenadas: 38.7974, -9.3904\n" +
                    "Localidade: CT147\n" +
                    "Coordenadas: 41.2833, -8.2833\n" +
                    "Localidade: CT267\n" +
                    "Coordenadas: 37.9536, -8.8712\n" +
                    "Localidade: CT146\n" +
                    "Coordenadas: 40.1125, -8.2469\n" +
                    "Localidade: CT145\n" +
                    "Coordenadas: 39.2425, -9.3122\n" +
                    "Localidade: CT266\n" +
                    "Coordenadas: 37.1833, -8.4333\n" +
                    "Localidade: CT144\n" +
                    "Coordenadas: 38.8309, -9.1684\n" +
                    "Localidade: CT265\n" +
                    "Coordenadas: 40.7167, -8.3667\n" +
                    "Localidade: CT242\n" +
                    "Coordenadas: 41.2651, -7.5751\n" +
                    "Localidade: CT121\n" +
                    "Coordenadas: 40.6167, -7.5333\n" +
                    "Localidade: CT241\n" +
                    "Coordenadas: 41.1833, -8.5667\n" +
                    "Localidade: CT120\n" +
                    "Coordenadas: 39.9019, -8.275\n" +
                    "Localidade: CT240\n" +
                    "Coordenadas: 39.3333, -8.9333\n" +
                    "Localidade: CT118\n" +
                    "Coordenadas: 40.1508, -8.8618\n" +
                    "Localidade: CT239\n" +
                    "Coordenadas: 41.5167, -7.8\n" +
                    "Localidade: CT238\n" +
                    "Coordenadas: 41.3933, -8.3883\n" +
                    "Localidade: CT117\n" +
                    "Coordenadas: 41.6308, -8.3686\n" +
                    "Localidade: CT116\n" +
                    "Coordenadas: 39.7, -8.2833\n" +
                    "Localidade: CT237\n" +
                    "Coordenadas: 39.4453, -8.5142\n" +
                    "Localidade: CT115\n" +
                    "Coordenadas: 38.05, -8.1\n" +
                    "Localidade: CT236\n" +
                    "Coordenadas: 41.1, -7.95\n" +
                    "Localidade: CT114\n" +
                    "Coordenadas: 40.5667, -8.5167\n" +
                    "Localidade: CT235\n" +
                    "Coordenadas: 38.4167, -7.5333\n" +
                    "Localidade: CT113\n" +
                    "Coordenadas: 41.3667, -8.2\n" +
                    "Localidade: CT234\n" +
                    "Coordenadas: 38.6464, -7.5464\n" +
                    "Localidade: CT112\n" +
                    "Coordenadas: 40.9254, -8.5428\n" +
                    "Localidade: CT233\n" +
                    "Coordenadas: 41.5565, -8.441\n" +
                    "Localidade: CT232\n" +
                    "Coordenadas: 38.7566, -9.2545\n" +
                    "Localidade: CT111\n" +
                    "Coordenadas: 37.0161, -7.935\n" +
                    "Localidade: CT119\n" +
                    "Coordenadas: 40.9, -6.9667\n" +
                    "Localidade: CT2\n" +
                    "Coordenadas: 38.77, -9.2988\n" +
                    "Localidade: CT1\n" +
                    "Coordenadas: 39.4667, -8.2\n" +
                    "Localidade: CT4\n" +
                    "Coordenadas: 40.818, -7.5414\n" +
                    "Localidade: CT3\n" +
                    "Coordenadas: 40.5745, -8.448\n" +
                    "Localidade: CT6\n" +
                    "Coordenadas: 40.6936, -8.4806\n" +
                    "Localidade: CT5\n" +
                    "Coordenadas: 38.7, -7.4\n" +
                    "Localidade: CT8\n" +
                    "Coordenadas: 38.3725, -8.5133\n" +
                    "Localidade: CT7\n" +
                    "Coordenadas: 37.0889, -8.2511\n" +
                    "Localidade: CT132\n" +
                    "Coordenadas: 40.5364, -7.2683\n" +
                    "Localidade: CT253\n" +
                    "Coordenadas: 41.1333, -7.4\n" +
                    "Localidade: CT252\n" +
                    "Coordenadas: 40.9, -8.5\n" +
                    "Localidade: CT131\n" +
                    "Coordenadas: 38.1833, -8.5667\n" +
                    "Localidade: CT9\n" +
                    "Coordenadas: 39.4589, -8.6689\n" +
                    "Localidade: CT251\n" +
                    "Coordenadas: 37.15, -7.8833\n" +
                    "Localidade: CT130\n" +
                    "Coordenadas: 40.5, -7.6\n" +
                    "Localidade: CT250\n" +
                    "Coordenadas: 41.3428, -8.4775\n" +
                    "Localidade: CT129\n" +
                    "Coordenadas: 41.15, -8.5333\n" +
                    "Localidade: CT128\n" +
                    "Coordenadas: 39.4, -8.4833\n" +
                    "Localidade: CT249\n" +
                    "Coordenadas: 38.0167, -8.7\n" +
                    "Localidade: CT248\n" +
                    "Coordenadas: 39.2369, -8.685\n" +
                    "Localidade: CT127\n" +
                    "Coordenadas: 40.15, -8.1167\n" +
                    "Localidade: CT247\n" +
                    "Coordenadas: 41.2, -7.7833\n" +
                    "Localidade: CT126\n" +
                    "Coordenadas: 39.465, -7.9369\n" +
                    "Localidade: CT246\n" +
                    "Coordenadas: 40.3981, -8.1303\n" +
                    "Localidade: CT125\n" +
                    "Coordenadas: 40.6333, -8.7167\n" +
                    "Localidade: CT245\n" +
                    "Coordenadas: 39.0253, -8.7933\n" +
                    "Localidade: CT124\n" +
                    "Coordenadas: 40.1392, -7.5019\n" +
                    "Localidade: CT244\n" +
                    "Coordenadas: 38.7944, -9.1053\n" +
                    "Localidade: CT123\n" +
                    "Coordenadas: 39.05, -7.65\n" +
                    "Localidade: CT243\n" +
                    "Coordenadas: 40.3519, -7.0894\n" +
                    "Localidade: CT122\n" +
                    "Coordenadas: 41.0833, -6.8\n";
        }

        Assertions.assertEquals(expected, coordMap.toString());
    }


}
