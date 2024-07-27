import graph.MyAlgorithms;
import org.isep_2dl_g121.CoordMap;
import org.isep_2dl_g121.DistMap;
import org.isep_2dl_g121.MinimumDistanceNetwork;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class USEI04 {

    private Comparator<Double> c = new Comparator<Double>() {
        @Override
        public int compare(Double o1, Double o2) {
            return (int) (o1-o2);
        }
    };

    private MyAlgorithms e = new MyAlgorithms();

    @AfterEach
    public void tearDown() {
        DistMap.clear();
        CoordMap.clear();
    }



    @Test
    void NullEdgeToDistMap() throws Exception {

        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_MultipleLines.csv");


        distMap.loadCSVMap(csvDist);


        assertNotNull(distMap, "DistMap should not be null");

    }

    @Test
    void testKruskallOneLine() throws Exception {

        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_OneLine.csv");
        distMap.loadCSVMap(csvDist);

        MinimumDistanceNetwork result = e.kruskallAlgorithm(distMap,c);

        DistMap expected = new DistMap(false);
        String vOrig = "CT10";
        String vDest = "CT13";
        Double dist = 63.448;
        expected.addEdge(vOrig, vDest, dist);

        MinimumDistanceNetwork expected1 = new MinimumDistanceNetwork(expected, 63.448);

        Assertions.assertEquals(expected1.toString(), result.toString());
    }

    @Test
    void testKruskallMultipleLines() throws Exception {

        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_MultipleLines.csv");
        distMap.loadCSVMap(csvDist);



        MinimumDistanceNetwork result = e.kruskallAlgorithm(distMap, c);

        String ex;

        {
             ex = "MinimumDistanceNetwork{mapVertices=Graph: 7 vertices, 12 edges\n" +
                     "CT10: \n" +
                     "CT10 -> CT13\n" +
                     "Weight: 63.448CT10 -> CT6\n" +
                     "Weight: 67.584CT10 -> CT1\n" +
                     "Weight: 110.848CT10 -> CT5\n" +
                     "Weight: 125.041\n" +
                     "CT13: \n" +
                     "CT13 -> CT10\n" +
                     "Weight: 63.448\n" +
                     "CT6: \n" +
                     "CT6 -> CT10\n" +
                     "Weight: 67.584\n" +
                     "CT1: \n" +
                     "CT1 -> CT12\n" +
                     "Weight: 62.877CT1 -> CT10\n" +
                     "Weight: 110.848\n" +
                     "CT5: \n" +
                     "CT5 -> CT10\n" +
                     "Weight: 125.041\n" +
                     "CT12: \n" +
                     "CT12 -> CT3\n" +
                     "Weight: 50.467CT12 -> CT1\n" +
                     "Weight: 62.877\n" +
                     "CT3: \n" +
                     "CT3 -> CT12\n" +
                     "Weight: 50.467\n" +
                     "TotalDist=480.2649999999999}";
        }

        Assertions.assertEquals(ex, result.toString());
    }

    @Test
    void testKruskallSmall() throws Exception {

        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_Small.csv");
        distMap.loadCSVMap(csvDist);

        MinimumDistanceNetwork result = e.kruskallAlgorithm(distMap, c);

        String ex;

        {
            ex = "MinimumDistanceNetwork{mapVertices=Graph: 17 vertices, 32 edges\n" +
                    "CT10: \n" +
                    "CT10 -> CT13\n" +
                    "Weight: 63.448CT10 -> CT6\n" +
                    "Weight: 67.584\n" +
                    "CT13: \n" +
                    "CT13 -> CT10\n" +
                    "Weight: 63.448CT13 -> CT14\n" +
                    "Weight: 89.813\n" +
                    "CT6: \n" +
                    "CT6 -> CT1\n" +
                    "Weight: 56.717CT6 -> CT10\n" +
                    "Weight: 67.584\n" +
                    "CT1: \n" +
                    "CT1 -> CT6\n" +
                    "Weight: 56.717CT1 -> CT12\n" +
                    "Weight: 62.877CT1 -> CT17\n" +
                    "Weight: 69.282\n" +
                    "CT5: \n" +
                    "CT5 -> CT11\n" +
                    "Weight: 62.655CT5 -> CT9\n" +
                    "Weight: 90.186\n" +
                    "CT12: \n" +
                    "CT12 -> CT3\n" +
                    "Weight: 50.467CT12 -> CT1\n" +
                    "Weight: 62.877\n" +
                    "CT3: \n" +
                    "CT3 -> CT15\n" +
                    "Weight: 43.598CT3 -> CT12\n" +
                    "Weight: 50.467CT3 -> CT16\n" +
                    "Weight: 68.957\n" +
                    "CT15: \n" +
                    "CT15 -> CT3\n" +
                    "Weight: 43.598\n" +
                    "CT11: \n" +
                    "CT11 -> CT5\n" +
                    "Weight: 62.655\n" +
                    "CT14: \n" +
                    "CT14 -> CT13\n" +
                    "Weight: 89.813CT14 -> CT7\n" +
                    "Weight: 95.957\n" +
                    "CT7: \n" +
                    "CT7 -> CT2\n" +
                    "Weight: 65.574CT7 -> CT14\n" +
                    "Weight: 95.957\n" +
                    "CT2: \n" +
                    "CT2 -> CT7\n" +
                    "Weight: 65.574CT2 -> CT8\n" +
                    "Weight: 125.105\n" +
                    "CT8: \n" +
                    "CT8 -> CT2\n" +
                    "Weight: 125.105\n" +
                    "CT16: \n" +
                    "CT16 -> CT3\n" +
                    "Weight: 68.957CT16 -> CT4\n" +
                    "Weight: 110.133\n" +
                    "CT17: \n" +
                    "CT17 -> CT9\n" +
                    "Weight: 62.879CT17 -> CT1\n" +
                    "Weight: 69.282\n" +
                    "CT9: \n" +
                    "CT9 -> CT17\n" +
                    "Weight: 62.879CT9 -> CT5\n" +
                    "Weight: 90.186\n" +
                    "CT4: \n" +
                    "CT4 -> CT16\n" +
                    "Weight: 110.133\n" +
                    "TotalDist=1185.2319999999997}";
        }

        Assertions.assertEquals(ex, result.toString());
    }

    @Test
    void testKruskallBig() throws Exception {

        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_Big.csv");
        distMap.loadCSVMap(csvDist);

        MinimumDistanceNetwork result = e.kruskallAlgorithm(distMap, c);

        String ex;

        {
            ex = "MinimumDistanceNetwork{mapVertices=Graph: 323 vertices, 644 edges\n" +
                    "CT32: \n" +
                    "CT32 -> CT160\n" +
                    "Weight: 6.992CT32 -> CT198\n" +
                    "Weight: 12.014\n" +
                    "CT160: \n" +
                    "CT160 -> CT32\n" +
                    "Weight: 6.992CT160 -> CT288\n" +
                    "Weight: 12.596CT160 -> CT69\n" +
                    "Weight: 13.987\n" +
                    "CT198: \n" +
                    "CT198 -> CT114\n" +
                    "Weight: 6.341CT198 -> CT32\n" +
                    "Weight: 12.014\n" +
                    "CT3: \n" +
                    "CT3 -> CT286\n" +
                    "Weight: 4.882CT3 -> CT114\n" +
                    "Weight: 6.514\n" +
                    "CT31: \n" +
                    "CT31 -> CT259\n" +
                    "Weight: 2.352CT31 -> CT93\n" +
                    "Weight: 4.163CT31 -> CT263\n" +
                    "Weight: 22.541\n" +
                    "CT259: \n" +
                    "CT259 -> CT31\n" +
                    "Weight: 2.352CT259 -> CT52\n" +
                    "Weight: 4.087\n" +
                    "CT93: \n" +
                    "CT93 -> CT31\n" +
                    "Weight: 4.163CT93 -> CT19\n" +
                    "Weight: 3.808CT93 -> CT95\n" +
                    "Weight: 8.278\n" +
                    "CT34: \n" +
                    "CT34 -> CT220\n" +
                    "Weight: 5.19CT34 -> CT207\n" +
                    "Weight: 15.15\n" +
                    "CT220: \n" +
                    "CT220 -> CT34\n" +
                    "Weight: 5.19CT220 -> CT276\n" +
                    "Weight: 15.701\n" +
                    "CT207: \n" +
                    "CT207 -> CT34\n" +
                    "Weight: 15.15CT207 -> CT36\n" +
                    "Weight: 15.011CT207 -> CT293\n" +
                    "Weight: 15.923\n" +
                    "CT36: \n" +
                    "CT36 -> CT221\n" +
                    "Weight: 3.237CT36 -> CT207\n" +
                    "Weight: 15.011\n" +
                    "CT221: \n" +
                    "CT221 -> CT36\n" +
                    "Weight: 3.237\n" +
                    "CT276: \n" +
                    "CT276 -> CT30\n" +
                    "Weight: 11.235CT276 -> CT220\n" +
                    "Weight: 15.701\n" +
                    "CT33: \n" +
                    "CT33 -> CT26\n" +
                    "Weight: 11.293CT33 -> CT219\n" +
                    "Weight: 18.428\n" +
                    "CT26: \n" +
                    "CT26 -> CT33\n" +
                    "Weight: 11.293CT26 -> CT120\n" +
                    "Weight: 13.278\n" +
                    "CT214: \n" +
                    "CT214 -> CT166\n" +
                    "Weight: 9.459\n" +
                    "CT120: \n" +
                    "CT120 -> CT208\n" +
                    "Weight: 11.975CT120 -> CT26\n" +
                    "Weight: 13.278\n" +
                    "CT219: \n" +
                    "CT219 -> CT270\n" +
                    "Weight: 16.45CT219 -> CT33\n" +
                    "Weight: 18.428\n" +
                    "CT76: \n" +
                    "CT76 -> CT208\n" +
                    "Weight: 12.029CT76 -> CT146\n" +
                    "Weight: 14.118\n" +
                    "CT35: \n" +
                    "CT35 -> CT290\n" +
                    "Weight: 5.431CT35 -> CT102\n" +
                    "Weight: 5.591\n" +
                    "CT290: \n" +
                    "CT290 -> CT35\n" +
                    "Weight: 5.431CT290 -> CT309\n" +
                    "Weight: 4.675\n" +
                    "CT102: \n" +
                    "CT102 -> CT35\n" +
                    "Weight: 5.591CT102 -> CT38\n" +
                    "Weight: 8.427\n" +
                    "CT150: \n" +
                    "CT150 -> CT309\n" +
                    "Weight: 2.536\n" +
                    "CT38: \n" +
                    "CT38 -> CT102\n" +
                    "Weight: 8.427CT38 -> CT195\n" +
                    "Weight: 7.012CT38 -> CT112\n" +
                    "Weight: 11.239\n" +
                    "CT195: \n" +
                    "CT195 -> CT38\n" +
                    "Weight: 7.012\n" +
                    "CT37: \n" +
                    "CT37 -> CT127\n" +
                    "Weight: 10.254CT37 -> CT272\n" +
                    "Weight: 18.341\n" +
                    "CT127: \n" +
                    "CT127 -> CT37\n" +
                    "Weight: 10.254CT127 -> CT146\n" +
                    "Weight: 13.125CT127 -> CT205\n" +
                    "Weight: 19.978\n" +
                    "CT272: \n" +
                    "CT272 -> CT72\n" +
                    "Weight: 8.761CT272 -> CT246\n" +
                    "Weight: 9.908CT272 -> CT199\n" +
                    "Weight: 16.168CT272 -> CT37\n" +
                    "Weight: 18.341\n" +
                    "CT218: \n" +
                    "CT218 -> CT209\n" +
                    "Weight: 6.343CT218 -> CT146\n" +
                    "Weight: 12.809\n" +
                    "CT39: \n" +
                    "CT39 -> CT137\n" +
                    "Weight: 9.485CT39 -> CT7\n" +
                    "Weight: 11.46\n" +
                    "CT137: \n" +
                    "CT137 -> CT74\n" +
                    "Weight: 4.478CT137 -> CT266\n" +
                    "Weight: 6.272CT137 -> CT225\n" +
                    "Weight: 7.921CT137 -> CT39\n" +
                    "Weight: 9.485\n" +
                    "CT74: \n" +
                    "CT74 -> CT137\n" +
                    "Weight: 4.478\n" +
                    "CT7: \n" +
                    "CT7 -> CT39\n" +
                    "Weight: 11.46CT7 -> CT231\n" +
                    "Weight: 15.006\n" +
                    "CT266: \n" +
                    "CT266 -> CT137\n" +
                    "Weight: 6.272CT266 -> CT173\n" +
                    "Weight: 23.17\n" +
                    "CT199: \n" +
                    "CT199 -> CT272\n" +
                    "Weight: 16.168CT199 -> CT258\n" +
                    "Weight: 16.649\n" +
                    "CT72: \n" +
                    "CT72 -> CT272\n" +
                    "Weight: 8.761CT72 -> CT279\n" +
                    "Weight: 12.728CT72 -> CT68\n" +
                    "Weight: 13.897\n" +
                    "CT258: \n" +
                    "CT258 -> CT130\n" +
                    "Weight: 13.783CT258 -> CT199\n" +
                    "Weight: 16.649\n" +
                    "CT187: \n" +
                    "CT187 -> CT68\n" +
                    "Weight: 4.694CT187 -> CT153\n" +
                    "Weight: 13.495\n" +
                    "CT68: \n" +
                    "CT68 -> CT187\n" +
                    "Weight: 4.694CT68 -> CT72\n" +
                    "Weight: 13.897CT68 -> CT320\n" +
                    "Weight: 18.5\n" +
                    "CT114: \n" +
                    "CT114 -> CT198\n" +
                    "Weight: 6.341CT114 -> CT3\n" +
                    "Weight: 6.514\n" +
                    "CT286: \n" +
                    "CT286 -> CT3\n" +
                    "Weight: 4.882CT286 -> CT6\n" +
                    "Weight: 10.177\n" +
                    "CT197: \n" +
                    "CT197 -> CT323\n" +
                    "Weight: 6.123CT197 -> CT265\n" +
                    "Weight: 17.873\n" +
                    "CT323: \n" +
                    "CT323 -> CT197\n" +
                    "Weight: 6.123CT323 -> CT255\n" +
                    "Weight: 5.388\n" +
                    "CT265: \n" +
                    "CT265 -> CT6\n" +
                    "Weight: 11.033CT265 -> CT197\n" +
                    "Weight: 17.873\n" +
                    "CT41: \n" +
                    "CT41 -> CT78\n" +
                    "Weight: 16.596CT41 -> CT292\n" +
                    "Weight: 17.523\n" +
                    "CT292: \n" +
                    "CT292 -> CT196\n" +
                    "Weight: 7.241CT292 -> CT41\n" +
                    "Weight: 17.523\n" +
                    "CT196: \n" +
                    "CT196 -> CT292\n" +
                    "Weight: 7.241CT196 -> CT252\n" +
                    "Weight: 7.696CT196 -> CT104\n" +
                    "Weight: 13.91\n" +
                    "CT252: \n" +
                    "CT252 -> CT112\n" +
                    "Weight: 5.07CT252 -> CT196\n" +
                    "Weight: 7.696CT252 -> CT202\n" +
                    "Weight: 12.703\n" +
                    "CT104: \n" +
                    "CT104 -> CT185\n" +
                    "Weight: 6.916CT104 -> CT6\n" +
                    "Weight: 10.631CT104 -> CT196\n" +
                    "Weight: 13.91\n" +
                    "CT129: \n" +
                    "CT129 -> CT294\n" +
                    "Weight: 5.129CT129 -> CT241\n" +
                    "Weight: 5.137\n" +
                    "CT194: \n" +
                    "CT194 -> CT111\n" +
                    "Weight: 9.575CT194 -> CT251\n" +
                    "Weight: 15.639CT194 -> CT275\n" +
                    "Weight: 22.452\n" +
                    "CT111: \n" +
                    "CT111 -> CT194\n" +
                    "Weight: 9.575\n" +
                    "CT251: \n" +
                    "CT251 -> CT143\n" +
                    "Weight: 13.808CT251 -> CT194\n" +
                    "Weight: 15.639\n" +
                    "CT275: \n" +
                    "CT275 -> CT82\n" +
                    "Weight: 22.363CT275 -> CT194\n" +
                    "Weight: 22.452\n" +
                    "CT143: \n" +
                    "CT143 -> CT231\n" +
                    "Weight: 11.89CT143 -> CT251\n" +
                    "Weight: 13.808\n" +
                    "CT193: \n" +
                    "CT193 -> CT205\n" +
                    "Weight: 16.684\n" +
                    "CT205: \n" +
                    "CT205 -> CT193\n" +
                    "Weight: 16.684CT205 -> CT127\n" +
                    "Weight: 19.978\n" +
                    "CT230: \n" +
                    "CT230 -> CT262\n" +
                    "Weight: 18.509CT230 -> CT315\n" +
                    "Weight: 26.744\n" +
                    "CT208: \n" +
                    "CT208 -> CT120\n" +
                    "Weight: 11.975CT208 -> CT76\n" +
                    "Weight: 12.029CT208 -> CT262\n" +
                    "Weight: 15.004\n" +
                    "CT262: \n" +
                    "CT262 -> CT208\n" +
                    "Weight: 15.004CT262 -> CT301\n" +
                    "Weight: 15.189CT262 -> CT230\n" +
                    "Weight: 18.509\n" +
                    "CT192: \n" +
                    "CT192 -> CT158\n" +
                    "Weight: 7.791CT192 -> CT105\n" +
                    "Weight: 9.309\n" +
                    "CT158: \n" +
                    "CT158 -> CT2\n" +
                    "Weight: 2.822CT158 -> CT232\n" +
                    "Weight: 1.954CT158 -> CT192\n" +
                    "Weight: 7.791\n" +
                    "CT95: \n" +
                    "CT95 -> CT93\n" +
                    "Weight: 8.278\n" +
                    "CT191: \n" +
                    "CT191 -> CT144\n" +
                    "Weight: 4.058CT191 -> CT109\n" +
                    "Weight: 6.147CT191 -> CT244\n" +
                    "Weight: 7.534\n" +
                    "CT144: \n" +
                    "CT144 -> CT191\n" +
                    "Weight: 4.058CT144 -> CT44\n" +
                    "Weight: 21.122\n" +
                    "CT109: \n" +
                    "CT109 -> CT28\n" +
                    "Weight: 1.698CT109 -> CT191\n" +
                    "Weight: 6.147CT109 -> CT141\n" +
                    "Weight: 5.973\n" +
                    "CT141: \n" +
                    "CT141 -> CT109\n" +
                    "Weight: 5.973CT141 -> CT19\n" +
                    "Weight: 7.978\n" +
                    "CT190: \n" +
                    "CT190 -> CT310\n" +
                    "Weight: 21.99CT190 -> CT173\n" +
                    "Weight: 32.923\n" +
                    "CT310: \n" +
                    "CT310 -> CT190\n" +
                    "Weight: 21.99CT310 -> CT267\n" +
                    "Weight: 30.348\n" +
                    "CT173: \n" +
                    "CT173 -> CT17\n" +
                    "Weight: 19.629CT173 -> CT266\n" +
                    "Weight: 23.17CT173 -> CT190\n" +
                    "Weight: 32.923\n" +
                    "CT17: \n" +
                    "CT17 -> CT173\n" +
                    "Weight: 19.629\n" +
                    "CT201: \n" +
                    "CT201 -> CT83\n" +
                    "Weight: 15.151\n" +
                    "CT267: \n" +
                    "CT267 -> CT249\n" +
                    "Weight: 18.369CT267 -> CT310\n" +
                    "Weight: 30.348\n" +
                    "CT78: \n" +
                    "CT78 -> CT41\n" +
                    "Weight: 16.596\n" +
                    "CT89: \n" +
                    "CT89 -> CT49\n" +
                    "Weight: 13.135\n" +
                    "CT40: \n" +
                    "CT40 -> CT273\n" +
                    "Weight: 10.849CT40 -> CT216\n" +
                    "Weight: 11.376\n" +
                    "CT273: \n" +
                    "CT273 -> CT40\n" +
                    "Weight: 10.849CT273 -> CT253\n" +
                    "Weight: 15.64CT273 -> CT170\n" +
                    "Weight: 17.18\n" +
                    "CT216: \n" +
                    "CT216 -> CT247\n" +
                    "Weight: 4.552CT216 -> CT164\n" +
                    "Weight: 8.779CT216 -> CT40\n" +
                    "Weight: 11.376\n" +
                    "CT247: \n" +
                    "CT247 -> CT216\n" +
                    "Weight: 4.552CT247 -> CT313\n" +
                    "Weight: 12.954\n" +
                    "CT43: \n" +
                    "CT43 -> CT175\n" +
                    "Weight: 16.541CT43 -> CT67\n" +
                    "Weight: 24.129\n" +
                    "CT175: \n" +
                    "CT175 -> CT43\n" +
                    "Weight: 16.541CT175 -> CT123\n" +
                    "Weight: 20.771\n" +
                    "CT67: \n" +
                    "CT67 -> CT99\n" +
                    "Weight: 19.162CT67 -> CT43\n" +
                    "Weight: 24.129\n" +
                    "CT223: \n" +
                    "CT223 -> CT157\n" +
                    "Weight: 10.241CT223 -> CT97\n" +
                    "Weight: 22.107\n" +
                    "CT99: \n" +
                    "CT99 -> CT67\n" +
                    "Weight: 19.162\n" +
                    "CT157: \n" +
                    "CT157 -> CT79\n" +
                    "Weight: 7.475CT157 -> CT223\n" +
                    "Weight: 10.241\n" +
                    "CT123: \n" +
                    "CT123 -> CT271\n" +
                    "Weight: 12.148CT123 -> CT25\n" +
                    "Weight: 18.136CT123 -> CT175\n" +
                    "Weight: 20.771CT123 -> CT47\n" +
                    "Weight: 22.363\n" +
                    "CT42: \n" +
                    "CT42 -> CT107\n" +
                    "Weight: 20.849CT42 -> CT177\n" +
                    "Weight: 24.114CT42 -> CT180\n" +
                    "Weight: 30.377\n" +
                    "CT107: \n" +
                    "CT107 -> CT42\n" +
                    "Weight: 20.849\n" +
                    "CT177: \n" +
                    "CT177 -> CT296\n" +
                    "Weight: 22.853CT177 -> CT42\n" +
                    "Weight: 24.114\n" +
                    "CT180: \n" +
                    "CT180 -> CT47\n" +
                    "Weight: 29.326CT180 -> CT42\n" +
                    "Weight: 30.377\n" +
                    "CT106: \n" +
                    "CT106 -> CT58\n" +
                    "Weight: 13.595CT106 -> CT271\n" +
                    "Weight: 16.032\n" +
                    "CT271: \n" +
                    "CT271 -> CT123\n" +
                    "Weight: 12.148CT271 -> CT106\n" +
                    "Weight: 16.032\n" +
                    "CT45: \n" +
                    "CT45 -> CT135\n" +
                    "Weight: 4.897CT45 -> CT125\n" +
                    "Weight: 5.795CT45 -> CT185\n" +
                    "Weight: 12.143\n" +
                    "CT135: \n" +
                    "CT135 -> CT45\n" +
                    "Weight: 4.897CT135 -> CT289\n" +
                    "Weight: 5.662\n" +
                    "CT125: \n" +
                    "CT125 -> CT45\n" +
                    "Weight: 5.795\n" +
                    "CT185: \n" +
                    "CT185 -> CT104\n" +
                    "Weight: 6.916CT185 -> CT45\n" +
                    "Weight: 12.143\n" +
                    "CT44: \n" +
                    "CT44 -> CT269\n" +
                    "Weight: 8.983CT44 -> CT305\n" +
                    "Weight: 8.989CT44 -> CT13\n" +
                    "Weight: 10.197CT44 -> CT144\n" +
                    "Weight: 21.122\n" +
                    "CT269: \n" +
                    "CT269 -> CT44\n" +
                    "Weight: 8.983CT269 -> CT282\n" +
                    "Weight: 13.862\n" +
                    "CT305: \n" +
                    "CT305 -> CT44\n" +
                    "Weight: 8.989\n" +
                    "CT13: \n" +
                    "CT13 -> CT44\n" +
                    "Weight: 10.197CT13 -> CT48\n" +
                    "Weight: 13.76\n" +
                    "CT47: \n" +
                    "CT47 -> CT123\n" +
                    "Weight: 22.363CT47 -> CT222\n" +
                    "Weight: 27.704CT47 -> CT180\n" +
                    "Weight: 29.326\n" +
                    "CT222: \n" +
                    "CT222 -> CT47\n" +
                    "Weight: 27.704\n" +
                    "CT25: \n" +
                    "CT25 -> CT97\n" +
                    "Weight: 10.781CT25 -> CT123\n" +
                    "Weight: 18.136\n" +
                    "CT46: \n" +
                    "CT46 -> CT229\n" +
                    "Weight: 1.871CT46 -> CT103\n" +
                    "Weight: 15.954\n" +
                    "CT229: \n" +
                    "CT229 -> CT46\n" +
                    "Weight: 1.871CT229 -> CT303\n" +
                    "Weight: 5.153\n" +
                    "CT103: \n" +
                    "CT103 -> CT50\n" +
                    "Weight: 15.564CT103 -> CT46\n" +
                    "Weight: 15.954CT103 -> CT298\n" +
                    "Weight: 20.996\n" +
                    "CT49: \n" +
                    "CT49 -> CT155\n" +
                    "Weight: 11.041CT49 -> CT236\n" +
                    "Weight: 11.284CT49 -> CT89\n" +
                    "Weight: 13.135\n" +
                    "CT155: \n" +
                    "CT155 -> CT49\n" +
                    "Weight: 11.041CT155 -> CT29\n" +
                    "Weight: 12.655CT155 -> CT210\n" +
                    "Weight: 12.56\n" +
                    "CT236: \n" +
                    "CT236 -> CT139\n" +
                    "Weight: 8.022CT236 -> CT49\n" +
                    "Weight: 11.284CT236 -> CT164\n" +
                    "Weight: 10.276\n" +
                    "CT48: \n" +
                    "CT48 -> CT245\n" +
                    "Weight: 8.684CT48 -> CT13\n" +
                    "Weight: 13.76CT48 -> CT73\n" +
                    "Weight: 13.999\n" +
                    "CT245: \n" +
                    "CT245 -> CT56\n" +
                    "Weight: 5.627CT245 -> CT48\n" +
                    "Weight: 8.684CT245 -> CT94\n" +
                    "Weight: 26.733\n" +
                    "CT56: \n" +
                    "CT56 -> CT245\n" +
                    "Weight: 5.627\n" +
                    "CT73: \n" +
                    "CT73 -> CT248\n" +
                    "Weight: 13.379CT73 -> CT48\n" +
                    "Weight: 13.999\n" +
                    "CT50: \n" +
                    "CT50 -> CT84\n" +
                    "Weight: 15.28CT50 -> CT103\n" +
                    "Weight: 15.564\n" +
                    "CT84: \n" +
                    "CT84 -> CT60\n" +
                    "Weight: 4.077CT84 -> CT136\n" +
                    "Weight: 10.401CT84 -> CT50\n" +
                    "Weight: 15.28\n" +
                    "CT233: \n" +
                    "CT233 -> CT60\n" +
                    "Weight: 3.631CT233 -> CT316\n" +
                    "Weight: 11.509\n" +
                    "CT110: \n" +
                    "CT110 -> CT250\n" +
                    "Weight: 9.726CT110 -> CT136\n" +
                    "Weight: 10.043\n" +
                    "CT60: \n" +
                    "CT60 -> CT84\n" +
                    "Weight: 4.077CT60 -> CT233\n" +
                    "Weight: 3.631\n" +
                    "CT52: \n" +
                    "CT52 -> CT259\n" +
                    "Weight: 4.087CT52 -> CT171\n" +
                    "Weight: 8.746CT52 -> CT204\n" +
                    "Weight: 20.424\n" +
                    "CT51: \n" +
                    "CT51 -> CT183\n" +
                    "Weight: 45.326\n" +
                    "CT183: \n" +
                    "CT183 -> CT235\n" +
                    "Weight: 19.104CT183 -> CT182\n" +
                    "Weight: 25.139CT183 -> CT51\n" +
                    "Weight: 45.326\n" +
                    "CT182: \n" +
                    "CT182 -> CT183\n" +
                    "Weight: 25.139CT182 -> CT261\n" +
                    "Weight: 28.458\n" +
                    "CT261: \n" +
                    "CT261 -> CT182\n" +
                    "Weight: 28.458CT261 -> CT163\n" +
                    "Weight: 37.436\n" +
                    "CT54: \n" +
                    "CT54 -> CT98\n" +
                    "Weight: 14.342CT54 -> CT115\n" +
                    "Weight: 21.162\n" +
                    "CT98: \n" +
                    "CT98 -> CT299\n" +
                    "Weight: 10.15CT98 -> CT54\n" +
                    "Weight: 14.342CT98 -> CT27\n" +
                    "Weight: 15.657\n" +
                    "CT115: \n" +
                    "CT115 -> CT54\n" +
                    "Weight: 21.162CT115 -> CT18\n" +
                    "Weight: 22.129\n" +
                    "CT299: \n" +
                    "CT299 -> CT98\n" +
                    "Weight: 10.15CT299 -> CT224\n" +
                    "Weight: 15.648\n" +
                    "CT27: \n" +
                    "CT27 -> CT297\n" +
                    "Weight: 10.495CT27 -> CT98\n" +
                    "Weight: 15.657\n" +
                    "CT53: \n" +
                    "CT53 -> CT227\n" +
                    "Weight: 7.449CT53 -> CT140\n" +
                    "Weight: 10.468\n" +
                    "CT227: \n" +
                    "CT227 -> CT53\n" +
                    "Weight: 7.449CT227 -> CT10\n" +
                    "Weight: 16.389\n" +
                    "CT140: \n" +
                    "CT140 -> CT53\n" +
                    "Weight: 10.468CT140 -> CT70\n" +
                    "Weight: 10.199CT140 -> CT156\n" +
                    "Weight: 11.873\n" +
                    "CT156: \n" +
                    "CT156 -> CT140\n" +
                    "Weight: 11.873\n" +
                    "CT70: \n" +
                    "CT70 -> CT140\n" +
                    "Weight: 10.199CT70 -> CT200\n" +
                    "Weight: 16.552\n" +
                    "CT10: \n" +
                    "CT10 -> CT291\n" +
                    "Weight: 6.048CT10 -> CT227\n" +
                    "Weight: 16.389\n" +
                    "CT55: \n" +
                    "CT55 -> CT96\n" +
                    "Weight: 16.746CT55 -> CT243\n" +
                    "Weight: 24.665\n" +
                    "CT96: \n" +
                    "CT96 -> CT154\n" +
                    "Weight: 14.683CT96 -> CT55\n" +
                    "Weight: 16.746CT96 -> CT124\n" +
                    "Weight: 17.71\n" +
                    "CT154: \n" +
                    "CT154 -> CT130\n" +
                    "Weight: 13.799CT154 -> CT96\n" +
                    "Weight: 14.683\n" +
                    "CT132: \n" +
                    "CT132 -> CT85\n" +
                    "Weight: 17.165\n" +
                    "CT243: \n" +
                    "CT243 -> CT55\n" +
                    "Weight: 24.665CT243 -> CT212\n" +
                    "Weight: 23.891\n" +
                    "CT130: \n" +
                    "CT130 -> CT258\n" +
                    "Weight: 13.783CT130 -> CT154\n" +
                    "Weight: 13.799CT130 -> CT121\n" +
                    "Weight: 15.641\n" +
                    "CT212: \n" +
                    "CT212 -> CT243\n" +
                    "Weight: 23.891\n" +
                    "CT58: \n" +
                    "CT58 -> CT317\n" +
                    "Weight: 7.137CT58 -> CT106\n" +
                    "Weight: 13.595\n" +
                    "CT317: \n" +
                    "CT317 -> CT58\n" +
                    "Weight: 7.137CT317 -> CT5\n" +
                    "Weight: 6.932\n" +
                    "CT234: \n" +
                    "CT234 -> CT5\n" +
                    "Weight: 15.566CT234 -> CT235\n" +
                    "Weight: 28.26\n" +
                    "CT57: \n" +
                    "CT57 -> CT64\n" +
                    "Weight: 5.942CT57 -> CT189\n" +
                    "Weight: 11.349CT57 -> CT145\n" +
                    "Weight: 15.039\n" +
                    "CT64: \n" +
                    "CT64 -> CT57\n" +
                    "Weight: 5.942CT64 -> CT240\n" +
                    "Weight: 18.932\n" +
                    "CT189: \n" +
                    "CT189 -> CT65\n" +
                    "Weight: 7.051CT189 -> CT57\n" +
                    "Weight: 11.349\n" +
                    "CT145: \n" +
                    "CT145 -> CT57\n" +
                    "Weight: 15.039CT145 -> CT215\n" +
                    "Weight: 16.166CT145 -> CT282\n" +
                    "Weight: 20.043\n" +
                    "CT59: \n" +
                    "CT59 -> CT88\n" +
                    "Weight: 18.975CT59 -> CT176\n" +
                    "Weight: 20.205\n" +
                    "CT88: \n" +
                    "CT88 -> CT59\n" +
                    "Weight: 18.975CT88 -> CT295\n" +
                    "Weight: 22.026\n" +
                    "CT176: \n" +
                    "CT176 -> CT59\n" +
                    "Weight: 20.205\n" +
                    "CT239: \n" +
                    "CT239 -> CT312\n" +
                    "Weight: 15.963CT239 -> CT287\n" +
                    "Weight: 15.336\n" +
                    "CT312: \n" +
                    "CT312 -> CT239\n" +
                    "Weight: 15.963\n" +
                    "CT295: \n" +
                    "CT295 -> CT168\n" +
                    "Weight: 19.25CT295 -> CT88\n" +
                    "Weight: 22.026\n" +
                    "CT61: \n" +
                    "CT61 -> CT319\n" +
                    "Weight: 23.114\n" +
                    "CT319: \n" +
                    "CT319 -> CT61\n" +
                    "Weight: 23.114CT319 -> CT149\n" +
                    "Weight: 35.135\n" +
                    "CT318: \n" +
                    "CT318 -> CT167\n" +
                    "Weight: 24.538CT318 -> CT169\n" +
                    "Weight: 33.676\n" +
                    "CT149: \n" +
                    "CT149 -> CT168\n" +
                    "Weight: 22.429CT149 -> CT14\n" +
                    "Weight: 22.576CT149 -> CT319\n" +
                    "Weight: 35.135\n" +
                    "CT136: \n" +
                    "CT136 -> CT238\n" +
                    "Weight: 5.576CT136 -> CT84\n" +
                    "Weight: 10.401CT136 -> CT110\n" +
                    "Weight: 10.043\n" +
                    "CT117: \n" +
                    "CT117 -> CT30\n" +
                    "Weight: 1.744CT117 -> CT316\n" +
                    "Weight: 6.423\n" +
                    "CT63: \n" +
                    "CT63 -> CT2\n" +
                    "Weight: 0.896CT63 -> CT268\n" +
                    "Weight: 8.586\n" +
                    "CT2: \n" +
                    "CT2 -> CT158\n" +
                    "Weight: 2.822CT2 -> CT63\n" +
                    "Weight: 0.896CT2 -> CT20\n" +
                    "Weight: 9.881\n" +
                    "CT62: \n" +
                    "CT62 -> CT287\n" +
                    "Weight: 5.044\n" +
                    "CT287: \n" +
                    "CT287 -> CT62\n" +
                    "Weight: 5.044CT287 -> CT174\n" +
                    "Weight: 10.84CT287 -> CT239\n" +
                    "Weight: 15.336\n" +
                    "CT86: \n" +
                    "CT86 -> CT174\n" +
                    "Weight: 5.096CT86 -> CT29\n" +
                    "Weight: 15.87\n" +
                    "CT108: \n" +
                    "CT108 -> CT113\n" +
                    "Weight: 10.687\n" +
                    "CT300: \n" +
                    "CT300 -> CT228\n" +
                    "Weight: 14.787\n" +
                    "CT65: \n" +
                    "CT65 -> CT189\n" +
                    "Weight: 7.051\n" +
                    "CT240: \n" +
                    "CT240 -> CT64\n" +
                    "Weight: 18.932\n" +
                    "CT66: \n" +
                    "CT66 -> CT307\n" +
                    "Weight: 11.513\n" +
                    "CT307: \n" +
                    "CT307 -> CT66\n" +
                    "Weight: 11.513CT307 -> CT293\n" +
                    "Weight: 14.842\n" +
                    "CT298: \n" +
                    "CT298 -> CT103\n" +
                    "Weight: 20.996\n" +
                    "CT69: \n" +
                    "CT69 -> CT160\n" +
                    "Weight: 13.987CT69 -> CT165\n" +
                    "Weight: 16.748\n" +
                    "CT288: \n" +
                    "CT288 -> CT90\n" +
                    "Weight: 8.236CT288 -> CT160\n" +
                    "Weight: 12.596\n" +
                    "CT165: \n" +
                    "CT165 -> CT69\n" +
                    "Weight: 16.748\n" +
                    "CT153: \n" +
                    "CT153 -> CT211\n" +
                    "Weight: 10.755CT153 -> CT187\n" +
                    "Weight: 13.495\n" +
                    "CT279: \n" +
                    "CT279 -> CT72\n" +
                    "Weight: 12.728\n" +
                    "CT309: \n" +
                    "CT309 -> CT150\n" +
                    "Weight: 2.536CT309 -> CT226\n" +
                    "Weight: 2.064CT309 -> CT290\n" +
                    "Weight: 4.675\n" +
                    "CT226: \n" +
                    "CT226 -> CT309\n" +
                    "Weight: 2.064CT226 -> CT241\n" +
                    "Weight: 5.835CT226 -> CT159\n" +
                    "Weight: 8.88\n" +
                    "CT308: \n" +
                    "CT308 -> CT280\n" +
                    "Weight: 14.341\n" +
                    "CT280: \n" +
                    "CT280 -> CT304\n" +
                    "Weight: 13.231CT280 -> CT308\n" +
                    "Weight: 14.341\n" +
                    "CT161: \n" +
                    "CT161 -> CT213\n" +
                    "Weight: 12.032\n" +
                    "CT253: \n" +
                    "CT253 -> CT273\n" +
                    "Weight: 15.64\n" +
                    "CT71: \n" +
                    "CT71 -> CT304\n" +
                    "Weight: 15.379CT71 -> CT16\n" +
                    "Weight: 16.562\n" +
                    "CT213: \n" +
                    "CT213 -> CT161\n" +
                    "Weight: 12.032CT213 -> CT260\n" +
                    "Weight: 14.103\n" +
                    "CT119: \n" +
                    "CT119 -> CT217\n" +
                    "Weight: 17.107CT119 -> CT122\n" +
                    "Weight: 27.349\n" +
                    "CT293: \n" +
                    "CT293 -> CT307\n" +
                    "Weight: 14.842CT293 -> CT207\n" +
                    "Weight: 15.923CT293 -> CT172\n" +
                    "Weight: 15.165\n" +
                    "CT306: \n" +
                    "CT306 -> CT100\n" +
                    "Weight: 3.787CT306 -> CT92\n" +
                    "Weight: 10.37\n" +
                    "CT100: \n" +
                    "CT100 -> CT306\n" +
                    "Weight: 3.787CT100 -> CT237\n" +
                    "Weight: 5.235\n" +
                    "CT237: \n" +
                    "CT237 -> CT100\n" +
                    "Weight: 5.235CT237 -> CT281\n" +
                    "Weight: 5.013CT237 -> CT128\n" +
                    "Weight: 6.299\n" +
                    "CT128: \n" +
                    "CT128 -> CT87\n" +
                    "Weight: 4.996CT128 -> CT237\n" +
                    "Weight: 6.299\n" +
                    "CT92: \n" +
                    "CT92 -> CT283\n" +
                    "Weight: 8.86CT92 -> CT306\n" +
                    "Weight: 10.37CT92 -> CT278\n" +
                    "Weight: 16.395\n" +
                    "CT304: \n" +
                    "CT304 -> CT280\n" +
                    "Weight: 13.231CT304 -> CT71\n" +
                    "Weight: 15.379CT304 -> CT14\n" +
                    "Weight: 18.002\n" +
                    "CT14: \n" +
                    "CT14 -> CT304\n" +
                    "Weight: 18.002CT14 -> CT149\n" +
                    "Weight: 22.576CT14 -> CT169\n" +
                    "Weight: 22.915\n" +
                    "CT168: \n" +
                    "CT168 -> CT295\n" +
                    "Weight: 19.25CT168 -> CT149\n" +
                    "Weight: 22.429\n" +
                    "CT184: \n" +
                    "CT184 -> CT16\n" +
                    "Weight: 15.359\n" +
                    "CT1: \n" +
                    "CT1 -> CT283\n" +
                    "Weight: 4.513CT1 -> CT256\n" +
                    "Weight: 8.776\n" +
                    "CT283: \n" +
                    "CT283 -> CT1\n" +
                    "Weight: 4.513CT283 -> CT92\n" +
                    "Weight: 8.86\n" +
                    "CT256: \n" +
                    "CT256 -> CT1\n" +
                    "Weight: 8.776CT256 -> CT148\n" +
                    "Weight: 16.189\n" +
                    "CT148: \n" +
                    "CT148 -> CT126\n" +
                    "Weight: 12.343CT148 -> CT256\n" +
                    "Weight: 16.189\n" +
                    "CT303: \n" +
                    "CT303 -> CT229\n" +
                    "Weight: 5.153\n" +
                    "CT285: \n" +
                    "CT285 -> CT250\n" +
                    "Weight: 7.642CT285 -> CT15\n" +
                    "Weight: 12.466\n" +
                    "CT152: \n" +
                    "CT152 -> CT159\n" +
                    "Weight: 5.663\n" +
                    "CT159: \n" +
                    "CT159 -> CT152\n" +
                    "Weight: 5.663CT159 -> CT226\n" +
                    "Weight: 8.88\n" +
                    "CT302: \n" +
                    "CT302 -> CT138\n" +
                    "Weight: 24.232\n" +
                    "CT138: \n" +
                    "CT138 -> CT225\n" +
                    "Weight: 13.749CT138 -> CT302\n" +
                    "Weight: 24.232\n" +
                    "CT301: \n" +
                    "CT301 -> CT116\n" +
                    "Weight: 12.829CT301 -> CT262\n" +
                    "Weight: 15.189\n" +
                    "CT116: \n" +
                    "CT116 -> CT301\n" +
                    "Weight: 12.829CT116 -> CT278\n" +
                    "Weight: 17.654\n" +
                    "CT4: \n" +
                    "CT4 -> CT260\n" +
                    "Weight: 11.029CT4 -> CT284\n" +
                    "Weight: 18.398\n" +
                    "CT260: \n" +
                    "CT260 -> CT4\n" +
                    "Weight: 11.029CT260 -> CT213\n" +
                    "Weight: 14.103CT260 -> CT170\n" +
                    "Weight: 15.147\n" +
                    "CT311: \n" +
                    "CT311 -> CT257\n" +
                    "Weight: 14.425CT311 -> CT81\n" +
                    "Weight: 19.666\n" +
                    "CT284: \n" +
                    "CT284 -> CT4\n" +
                    "Weight: 18.398CT284 -> CT217\n" +
                    "Weight: 26.489\n" +
                    "CT257: \n" +
                    "CT257 -> CT211\n" +
                    "Weight: 8.764CT257 -> CT311\n" +
                    "Weight: 14.425\n" +
                    "CT170: \n" +
                    "CT170 -> CT273\n" +
                    "Weight: 17.18CT170 -> CT260\n" +
                    "Weight: 15.147\n" +
                    "CT211: \n" +
                    "CT211 -> CT257\n" +
                    "Weight: 8.764CT211 -> CT153\n" +
                    "Weight: 10.755\n" +
                    "CT228: \n" +
                    "CT228 -> CT30\n" +
                    "Weight: 11.236CT228 -> CT300\n" +
                    "Weight: 14.787\n" +
                    "CT5: \n" +
                    "CT5 -> CT317\n" +
                    "Weight: 6.932CT5 -> CT234\n" +
                    "Weight: 15.566\n" +
                    "CT6: \n" +
                    "CT6 -> CT286\n" +
                    "Weight: 10.177CT6 -> CT104\n" +
                    "Weight: 10.631CT6 -> CT265\n" +
                    "Weight: 11.033\n" +
                    "CT231: \n" +
                    "CT231 -> CT143\n" +
                    "Weight: 11.89CT231 -> CT7\n" +
                    "Weight: 15.006\n" +
                    "CT8: \n" +
                    "CT8 -> CT131\n" +
                    "Weight: 23.819\n" +
                    "CT131: \n" +
                    "CT131 -> CT8\n" +
                    "Weight: 23.819CT131 -> CT249\n" +
                    "Weight: 24.221\n" +
                    "CT296: \n" +
                    "CT296 -> CT177\n" +
                    "Weight: 22.853\n" +
                    "CT264: \n" +
                    "CT264 -> CT204\n" +
                    "Weight: 5.259\n" +
                    "CT204: \n" +
                    "CT204 -> CT264\n" +
                    "Weight: 5.259CT204 -> CT52\n" +
                    "Weight: 20.424\n" +
                    "CT9: \n" +
                    "CT9 -> CT281\n" +
                    "Weight: 13.264\n" +
                    "CT281: \n" +
                    "CT281 -> CT237\n" +
                    "Weight: 5.013CT281 -> CT9\n" +
                    "Weight: 13.264\n" +
                    "CT200: \n" +
                    "CT200 -> CT70\n" +
                    "Weight: 16.552CT200 -> CT278\n" +
                    "Weight: 16.994\n" +
                    "CT246: \n" +
                    "CT246 -> CT272\n" +
                    "Weight: 9.908CT246 -> CT181\n" +
                    "Weight: 9.648\n" +
                    "CT16: \n" +
                    "CT16 -> CT242\n" +
                    "Weight: 9.404CT16 -> CT184\n" +
                    "Weight: 15.359CT16 -> CT71\n" +
                    "Weight: 16.562\n" +
                    "CT225: \n" +
                    "CT225 -> CT137\n" +
                    "Weight: 7.921CT225 -> CT138\n" +
                    "Weight: 13.749\n" +
                    "CT248: \n" +
                    "CT248 -> CT22\n" +
                    "Weight: 7.403CT248 -> CT73\n" +
                    "Weight: 13.379\n" +
                    "CT146: \n" +
                    "CT146 -> CT166\n" +
                    "Weight: 8.301CT146 -> CT218\n" +
                    "Weight: 12.809CT146 -> CT76\n" +
                    "Weight: 14.118CT146 -> CT127\n" +
                    "Weight: 13.125\n" +
                    "CT166: \n" +
                    "CT166 -> CT214\n" +
                    "Weight: 9.459CT166 -> CT146\n" +
                    "Weight: 8.301\n" +
                    "CT75: \n" +
                    "CT75 -> CT105\n" +
                    "Weight: 2.536\n" +
                    "CT105: \n" +
                    "CT105 -> CT75\n" +
                    "Weight: 2.536CT105 -> CT192\n" +
                    "Weight: 9.309\n" +
                    "CT268: \n" +
                    "CT268 -> CT254\n" +
                    "Weight: 3.463CT268 -> CT63\n" +
                    "Weight: 8.586CT268 -> CT277\n" +
                    "Weight: 6.77\n" +
                    "CT210: \n" +
                    "CT210 -> CT80\n" +
                    "Weight: 4.647CT210 -> CT147\n" +
                    "Weight: 10.235CT210 -> CT155\n" +
                    "Weight: 12.56\n" +
                    "CT77: \n" +
                    "CT77 -> CT315\n" +
                    "Weight: 26.892CT77 -> CT134\n" +
                    "Weight: 27.168\n" +
                    "CT315: \n" +
                    "CT315 -> CT188\n" +
                    "Weight: 16.461CT315 -> CT230\n" +
                    "Weight: 26.744CT315 -> CT77\n" +
                    "Weight: 26.892\n" +
                    "CT134: \n" +
                    "CT134 -> CT77\n" +
                    "Weight: 27.168\n" +
                    "CT124: \n" +
                    "CT124 -> CT96\n" +
                    "Weight: 17.71\n" +
                    "CT188: \n" +
                    "CT188 -> CT315\n" +
                    "Weight: 16.461CT188 -> CT79\n" +
                    "Weight: 22.685\n" +
                    "CT79: \n" +
                    "CT79 -> CT157\n" +
                    "Weight: 7.475CT79 -> CT188\n" +
                    "Weight: 22.685\n" +
                    "CT97: \n" +
                    "CT97 -> CT25\n" +
                    "Weight: 10.781CT97 -> CT223\n" +
                    "Weight: 22.107\n" +
                    "CT167: \n" +
                    "CT167 -> CT318\n" +
                    "Weight: 24.538\n" +
                    "CT169: \n" +
                    "CT169 -> CT14\n" +
                    "Weight: 22.915CT169 -> CT318\n" +
                    "Weight: 33.676\n" +
                    "CT316: \n" +
                    "CT316 -> CT117\n" +
                    "Weight: 6.423CT316 -> CT233\n" +
                    "Weight: 11.509\n" +
                    "CT126: \n" +
                    "CT126 -> CT148\n" +
                    "Weight: 12.343\n" +
                    "CT314: \n" +
                    "CT314 -> CT82\n" +
                    "Weight: 3.863\n" +
                    "CT82: \n" +
                    "CT82 -> CT314\n" +
                    "Weight: 3.863CT82 -> CT275\n" +
                    "Weight: 22.363CT82 -> CT12\n" +
                    "Weight: 31.413\n" +
                    "CT12: \n" +
                    "CT12 -> CT163\n" +
                    "Weight: 26.402CT12 -> CT82\n" +
                    "Weight: 31.413\n" +
                    "CT313: \n" +
                    "CT313 -> CT247\n" +
                    "Weight: 12.954CT313 -> CT242\n" +
                    "Weight: 15.888\n" +
                    "CT242: \n" +
                    "CT242 -> CT16\n" +
                    "Weight: 9.404CT242 -> CT313\n" +
                    "Weight: 15.888\n" +
                    "CT164: \n" +
                    "CT164 -> CT216\n" +
                    "Weight: 8.779CT164 -> CT236\n" +
                    "Weight: 10.276\n" +
                    "CT249: \n" +
                    "CT249 -> CT267\n" +
                    "Weight: 18.369CT249 -> CT131\n" +
                    "Weight: 24.221\n" +
                    "CT81: \n" +
                    "CT81 -> CT311\n" +
                    "Weight: 19.666\n" +
                    "CT274: \n" +
                    "CT274 -> CT139\n" +
                    "Weight: 11.288\n" +
                    "CT255: \n" +
                    "CT255 -> CT323\n" +
                    "Weight: 5.388\n" +
                    "CT139: \n" +
                    "CT139 -> CT236\n" +
                    "Weight: 8.022CT139 -> CT274\n" +
                    "Weight: 11.288\n" +
                    "CT80: \n" +
                    "CT80 -> CT206\n" +
                    "Weight: 0.27CT80 -> CT210\n" +
                    "Weight: 4.647\n" +
                    "CT206: \n" +
                    "CT206 -> CT80\n" +
                    "Weight: 0.27\n" +
                    "CT83: \n" +
                    "CT83 -> CT201\n" +
                    "Weight: 15.151CT83 -> CT23\n" +
                    "Weight: 22.979CT83 -> CT18\n" +
                    "Weight: 23.559\n" +
                    "CT23: \n" +
                    "CT23 -> CT83\n" +
                    "Weight: 22.979\n" +
                    "CT18: \n" +
                    "CT18 -> CT115\n" +
                    "Weight: 22.129CT18 -> CT83\n" +
                    "Weight: 23.559\n" +
                    "CT163: \n" +
                    "CT163 -> CT12\n" +
                    "Weight: 26.402CT163 -> CT261\n" +
                    "Weight: 37.436\n" +
                    "CT85: \n" +
                    "CT85 -> CT121\n" +
                    "Weight: 12.657CT85 -> CT132\n" +
                    "Weight: 17.165\n" +
                    "CT121: \n" +
                    "CT121 -> CT85\n" +
                    "Weight: 12.657CT121 -> CT130\n" +
                    "Weight: 15.641\n" +
                    "CT87: \n" +
                    "CT87 -> CT128\n" +
                    "Weight: 4.996CT87 -> CT24\n" +
                    "Weight: 15.82\n" +
                    "CT24: \n" +
                    "CT24 -> CT22\n" +
                    "Weight: 6.871CT24 -> CT87\n" +
                    "Weight: 15.82\n" +
                    "CT174: \n" +
                    "CT174 -> CT86\n" +
                    "Weight: 5.096CT174 -> CT287\n" +
                    "Weight: 10.84\n" +
                    "CT29: \n" +
                    "CT29 -> CT155\n" +
                    "Weight: 12.655CT29 -> CT86\n" +
                    "Weight: 15.87\n" +
                    "CT113: \n" +
                    "CT113 -> CT322\n" +
                    "Weight: 6.316CT113 -> CT108\n" +
                    "Weight: 10.687CT113 -> CT147\n" +
                    "Weight: 12.83\n" +
                    "CT209: \n" +
                    "CT209 -> CT142\n" +
                    "Weight: 4.803CT209 -> CT218\n" +
                    "Weight: 6.343\n" +
                    "CT142: \n" +
                    "CT142 -> CT209\n" +
                    "Weight: 4.803CT142 -> CT90\n" +
                    "Weight: 12.134\n" +
                    "CT181: \n" +
                    "CT181 -> CT246\n" +
                    "Weight: 9.648\n" +
                    "CT179: \n" +
                    "CT179 -> CT11\n" +
                    "Weight: 6.357CT179 -> CT171\n" +
                    "Weight: 6.786\n" +
                    "CT203: \n" +
                    "CT203 -> CT147\n" +
                    "Weight: 9.282\n" +
                    "CT147: \n" +
                    "CT147 -> CT203\n" +
                    "Weight: 9.282CT147 -> CT210\n" +
                    "Weight: 10.235CT147 -> CT113\n" +
                    "Weight: 12.83\n" +
                    "CT250: \n" +
                    "CT250 -> CT285\n" +
                    "Weight: 7.642CT250 -> CT110\n" +
                    "Weight: 9.726\n" +
                    "CT202: \n" +
                    "CT202 -> CT252\n" +
                    "Weight: 12.703\n" +
                    "CT112: \n" +
                    "CT112 -> CT252\n" +
                    "Weight: 5.07CT112 -> CT38\n" +
                    "Weight: 11.239\n" +
                    "CT320: \n" +
                    "CT320 -> CT68\n" +
                    "Weight: 18.5\n" +
                    "CT322: \n" +
                    "CT322 -> CT321\n" +
                    "Weight: 3.272CT322 -> CT113\n" +
                    "Weight: 6.316CT322 -> CT133\n" +
                    "Weight: 8.018\n" +
                    "CT321: \n" +
                    "CT321 -> CT322\n" +
                    "Weight: 3.272CT321 -> CT238\n" +
                    "Weight: 8.275\n" +
                    "CT133: \n" +
                    "CT133 -> CT322\n" +
                    "Weight: 8.018\n" +
                    "CT278: \n" +
                    "CT278 -> CT200\n" +
                    "Weight: 16.994CT278 -> CT92\n" +
                    "Weight: 16.395CT278 -> CT116\n" +
                    "Weight: 17.654\n" +
                    "CT238: \n" +
                    "CT238 -> CT136\n" +
                    "Weight: 5.576CT238 -> CT321\n" +
                    "Weight: 8.275\n" +
                    "CT90: \n" +
                    "CT90 -> CT288\n" +
                    "Weight: 8.236CT90 -> CT142\n" +
                    "Weight: 12.134CT90 -> CT91\n" +
                    "Weight: 13.389\n" +
                    "CT91: \n" +
                    "CT91 -> CT90\n" +
                    "Weight: 13.389\n" +
                    "CT270: \n" +
                    "CT270 -> CT219\n" +
                    "Weight: 16.45CT270 -> CT178\n" +
                    "Weight: 15.1\n" +
                    "CT94: \n" +
                    "CT94 -> CT245\n" +
                    "Weight: 26.733\n" +
                    "CT22: \n" +
                    "CT22 -> CT24\n" +
                    "Weight: 6.871CT22 -> CT248\n" +
                    "Weight: 7.403\n" +
                    "CT19: \n" +
                    "CT19 -> CT93\n" +
                    "Weight: 3.808CT19 -> CT141\n" +
                    "Weight: 7.978\n" +
                    "CT217: \n" +
                    "CT217 -> CT21\n" +
                    "Weight: 16.646CT217 -> CT119\n" +
                    "Weight: 17.107CT217 -> CT284\n" +
                    "Weight: 26.489\n" +
                    "CT21: \n" +
                    "CT21 -> CT217\n" +
                    "Weight: 16.646\n" +
                    "CT215: \n" +
                    "CT215 -> CT145\n" +
                    "Weight: 16.166\n" +
                    "CT28: \n" +
                    "CT28 -> CT109\n" +
                    "Weight: 1.698CT28 -> CT232\n" +
                    "Weight: 2.195\n" +
                    "CT297: \n" +
                    "CT297 -> CT27\n" +
                    "Weight: 10.495\n" +
                    "CT30: \n" +
                    "CT30 -> CT117\n" +
                    "Weight: 1.744CT30 -> CT276\n" +
                    "Weight: 11.235CT30 -> CT228\n" +
                    "Weight: 11.236\n" +
                    "CT291: \n" +
                    "CT291 -> CT186\n" +
                    "Weight: 4.691CT291 -> CT10\n" +
                    "Weight: 6.048\n" +
                    "CT241: \n" +
                    "CT241 -> CT101\n" +
                    "Weight: 4.106CT241 -> CT129\n" +
                    "Weight: 5.137CT241 -> CT226\n" +
                    "Weight: 5.835\n" +
                    "CT224: \n" +
                    "CT224 -> CT299\n" +
                    "Weight: 15.648CT224 -> CT235\n" +
                    "Weight: 21.582\n" +
                    "CT235: \n" +
                    "CT235 -> CT183\n" +
                    "Weight: 19.104CT235 -> CT224\n" +
                    "Weight: 21.582CT235 -> CT234\n" +
                    "Weight: 28.26\n" +
                    "CT101: \n" +
                    "CT101 -> CT241\n" +
                    "Weight: 4.106CT101 -> CT15\n" +
                    "Weight: 3.852\n" +
                    "CT15: \n" +
                    "CT15 -> CT101\n" +
                    "Weight: 3.852CT15 -> CT285\n" +
                    "Weight: 12.466\n" +
                    "CT294: \n" +
                    "CT294 -> CT129\n" +
                    "Weight: 5.129\n" +
                    "CT122: \n" +
                    "CT122 -> CT119\n" +
                    "Weight: 27.349\n" +
                    "CT118: \n" +
                    "CT118 -> CT178\n" +
                    "Weight: 16.957\n" +
                    "CT178: \n" +
                    "CT178 -> CT270\n" +
                    "Weight: 15.1CT178 -> CT118\n" +
                    "Weight: 16.957\n" +
                    "CT232: \n" +
                    "CT232 -> CT158\n" +
                    "Weight: 1.954CT232 -> CT28\n" +
                    "Weight: 2.195\n" +
                    "CT289: \n" +
                    "CT289 -> CT135\n" +
                    "Weight: 5.662\n" +
                    "CT244: \n" +
                    "CT244 -> CT191\n" +
                    "Weight: 7.534\n" +
                    "CT254: \n" +
                    "CT254 -> CT268\n" +
                    "Weight: 3.463\n" +
                    "CT277: \n" +
                    "CT277 -> CT268\n" +
                    "Weight: 6.77CT277 -> CT151\n" +
                    "Weight: 10.856\n" +
                    "CT282: \n" +
                    "CT282 -> CT269\n" +
                    "Weight: 13.862CT282 -> CT145\n" +
                    "Weight: 20.043\n" +
                    "CT151: \n" +
                    "CT151 -> CT277\n" +
                    "Weight: 10.856\n" +
                    "CT20: \n" +
                    "CT20 -> CT2\n" +
                    "Weight: 9.881\n" +
                    "CT263: \n" +
                    "CT263 -> CT31\n" +
                    "Weight: 22.541\n" +
                    "CT162: \n" +
                    "CT162 -> CT172\n" +
                    "Weight: 20.268\n" +
                    "CT172: \n" +
                    "CT172 -> CT293\n" +
                    "Weight: 15.165CT172 -> CT162\n" +
                    "Weight: 20.268\n" +
                    "CT11: \n" +
                    "CT11 -> CT179\n" +
                    "Weight: 6.357\n" +
                    "CT171: \n" +
                    "CT171 -> CT179\n" +
                    "Weight: 6.786CT171 -> CT52\n" +
                    "Weight: 8.746\n" +
                    "CT186: \n" +
                    "CT186 -> CT291\n" +
                    "Weight: 4.691\n" +
                    "TotalDist=4255.931000000002}";
        }

        Assertions.assertEquals(ex, result.toString());


    }

}
