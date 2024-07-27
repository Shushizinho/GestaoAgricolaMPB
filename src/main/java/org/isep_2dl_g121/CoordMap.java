package org.isep_2dl_g121;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CoordMap {
    private static Map<String, PairCoord> coordenadas = new HashMap<>();

    public static void clear() {
        coordenadas = new HashMap<>();
    }


    @Override
    public String toString() {
        String s;
        if (coordenadas.size() == 0) {
            s = "\nMap not defined!!";
        } else {
            s = "Map: " + coordenadas.size() + " localidades\n";
            for (String key : coordenadas.keySet()){
                s += "Localidade: " + key +"\n" + "Coordenadas: " + coordenadas.get(key).getLeft() + ", " + coordenadas.get(key).getRight() + "\n";
            }
        }
        return s;
    }

    public Map<String, PairCoord> getCoordenadas() {
        return coordenadas;
    }

    public static void setCoordenadas(Map<String, PairCoord> coordenadas) {
        CoordMap.coordenadas = coordenadas;
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
            PairCoord coord = new PairCoord(Double.parseDouble(strings[1]), Double.parseDouble(strings[2]));
            coordenadas.put(strings[0], coord);
        }
    }




    public static String generateChecksum(CoordMap coordMap) {
        if (coordMap == null || coordMap.getCoordenadas().isEmpty()) {
            return "0"; // Return a default checksum for an empty map.
        }

        long checksum = 0;

        // Traverse the coordenadas map and calculate checksum
        for (Map.Entry<String, PairCoord> entry : coordMap.getCoordenadas().entrySet()) {
            checksum += calculateEntryChecksum(entry);
        }

        return Long.toString(checksum);
    }



    private static long calculateEntryChecksum(Map.Entry<String, PairCoord> entry) {
        long entryChecksum = entry.getKey().hashCode(); // Include key information in the checksum

        PairCoord coordinates = entry.getValue();
        entryChecksum += coordinates.hashCode();

        return entryChecksum;
    }
}
