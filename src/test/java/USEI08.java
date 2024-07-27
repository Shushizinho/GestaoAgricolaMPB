import graph.MyAlgorithms;
import graph.PairHub;
import org.isep_2dl_g121.*;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class USEI08 {

    @AfterEach
    public void tearDown() {
        DistMap.clear();
        CoordMap.clear();
    }


    @Test
    @DisplayName("Test 5 Hubs")

    void Testefivehubs()throws Exception {
        DistMap distMap = new DistMap(false);
        distMap.loadCSVMap(new File("Data/distancias_small.csv"));
        String b = distMap.vertices().get(0);

        ArrayList<Pair<String, Integer>> locPassagem = new ArrayList<>();

        String[] dados = {"CT10:0", "CT1:0", "CT12:0", "CT3:3", "CT16:16", "CT17:17", "CT9:9", "CT5:0", "CT11:0", "CT2:0", "CT14:14", "CT13:0", "CT10:0"};

        for (String dado : dados) {
            String[] partes = dado.split(":");
            String chave = partes[0];
            int valor = Integer.parseInt(partes[1]);
            locPassagem.add(new Pair<>(chave, valor));
        }


        Double[] valores = {110.848, 62.877, 50.467, 68.957, 79.56, 62.879, 90.186, 62.655, 163.996, 114.913, 89.813, 63.448};
        ArrayList<Double> distancias = new ArrayList<>(Arrays.asList(valores));

        double disttot=distancias.stream().mapToDouble(Double::doubleValue).sum();

        String[] carregamentosArray = {"CT9", "CT14"};
        ArrayList<String> carregamentos = new ArrayList<>(Arrays.asList(carregamentosArray));
        double tempPercurso = 759;
        double tempCarregamento = 20;
        double tempDescarga = 50;
        double tempTotal = tempPercurso + tempCarregamento + tempDescarga;



        CircuitInfo expected = new CircuitInfo("CT10",locPassagem,distancias,disttot,carregamentos,carregamentos.size(),tempPercurso,tempCarregamento,tempDescarga,tempTotal);

        CircuitInfo result =  MyAlgorithms.getCircuit(distMap,b, Arrays.asList("CT17", "CT16", "CT3",  "CT9", "CT14"),
                450,80,10,10);

        Assert.assertTrue(expected.equals(result));

    }


    @Test
    @DisplayName("Test 6 Hubs")
    void Testesixhubs()throws Exception {
        DistMap distMap = new DistMap(false);
        distMap.loadCSVMap(new File("Data/distancias_small.csv"));
        String b = distMap.vertices().get(0);

        ArrayList<Pair<String, Integer>> locPassagem = new ArrayList<>();

        String[] dados = {"CT10:0", "CT13:0", "CT7:7", "CT2:0", "CT11:11", "CT5:0", "CT9:9", "CT4:4", "CT3:3", "CT12:12", "CT1:0", "CT10:0"};

        for (String dado : dados) {
            String[] partes = dado.split(":");
            String chave = partes[0];
            int valor = Integer.parseInt(partes[1]);
            locPassagem.add(new Pair<>(chave, valor));
        }


        Double[] valores = {63.448, 111.686, 65.574, 163.996, 62.655, 90.186, 162.527, 157.223, 50.467, 62.877, 110.848};
        ArrayList<Double> distancias = new ArrayList<>(Arrays.asList(valores));

        double disttot=distancias.stream().mapToDouble(Double::doubleValue).sum();

        String[] carregamentosArray = {"CT2", "CT9", "CT3"};
        ArrayList<String> carregamentos = new ArrayList<>(Arrays.asList(carregamentosArray));
        double tempPercurso = 691.578947368421;
        double tempCarregamento = 45;
        double tempDescarga = 90;
        double tempTotal = tempPercurso + tempCarregamento + tempDescarga;



        CircuitInfo expected = new CircuitInfo("CT10",locPassagem,distancias,disttot,carregamentos,carregamentos.size(),tempPercurso,tempCarregamento,tempDescarga,tempTotal);

        CircuitInfo result =  MyAlgorithms.getCircuit(distMap,b, Arrays.asList("CT11", "CT12", "CT7", "CT3", "CT4", "CT9"),
                350,95,15,15);

        Assert.assertTrue(expected.equals(result));

    }

    @Test
    @DisplayName("Test 7 Hubs")
    void Testesevenhubs()throws Exception {
        DistMap distMap = new DistMap(false);
        distMap.loadCSVMap(new File("Data/distancias_small.csv"));
        String b = distMap.vertices().get(0);

        ArrayList<Pair<String, Integer>> locPassagem = new ArrayList<>();

        String[] dados = {"CT10:0", "CT11:11", "CT5:0", "CT9:9", "CT17:17", "CT16:16", "CT4:4", "CT3:3", "CT12:12", "CT1:0", "CT10:0"};

        for (String dado : dados) {
            String[] partes = dado.split(":");
            String chave = partes[0];
            int valor = Integer.parseInt(partes[1]);
            locPassagem.add(new Pair<>(chave, valor));
        }


        Double[] valores = {142.47, 62.655, 90.186, 62.879, 79.56, 110.133, 157.223, 50.467, 62.877, 110.848};
        ArrayList<Double> distancias = new ArrayList<>(Arrays.asList(valores));

        double disttot=distancias.stream().mapToDouble(Double::doubleValue).sum();

        String[] carregamentosArray = {"CT4"};
        ArrayList<String> carregamentos = new ArrayList<>(Arrays.asList(carregamentosArray));
        double tempPercurso = 792;
        double tempCarregamento = 15;
        double tempDescarga = 105;
        double tempTotal = tempPercurso + tempCarregamento + tempDescarga;



        CircuitInfo expected = new CircuitInfo("CT10",locPassagem,distancias,disttot,carregamentos,carregamentos.size(),tempPercurso,tempCarregamento,tempDescarga,tempTotal);

        CircuitInfo result =  MyAlgorithms.getCircuit(distMap,b, Arrays.asList("CT17", "CT12", "CT16", "CT3", "CT4", "CT9","CT11"),
                550,70,15,15);

        Assert.assertTrue(expected.equals(result));

    }


    @Test
    @DisplayName("Second Test 5 Hubs ")
    void TesteSFivehubs()throws Exception {
        DistMap distMap = new DistMap(false);
        distMap.loadCSVMap(new File("Data/distancias_small.csv"));
        String b = distMap.vertices().get(0);

        ArrayList<Pair<String, Integer>> locPassagem = new ArrayList<>();

        String[] dados = {"CT10:0", "CT1:0", "CT12:0", "CT3:3", "CT16:16", "CT9:9", "CT5:5", "CT11:0", "CT13:13", "CT10:0"};;

        for (String dado : dados) {
            String[] partes = dado.split(":");
            String chave = partes[0];
            int valor = Integer.parseInt(partes[1]);
            locPassagem.add(new Pair<>(chave, valor));
        }


        Double[] valores = {110.848, 62.877, 50.467, 68.957, 103.704, 90.186, 62.655, 121.584, 63.448};
        ArrayList<Double> distancias = new ArrayList<>(Arrays.asList(valores));

        double disttot=distancias.stream().mapToDouble(Double::doubleValue).sum();

        String[] carregamentosArray = {"CT11"};
        ArrayList<String> carregamentos = new ArrayList<>(Arrays.asList(carregamentosArray));
        double tempPercurso = 624.8571428571429;
        double tempCarregamento = 20;
        double tempDescarga = 75;
        double tempTotal = tempPercurso + tempCarregamento + tempDescarga;



        CircuitInfo expected = new CircuitInfo("CT10",locPassagem,distancias,disttot,carregamentos,carregamentos.size(),tempPercurso,tempCarregamento,tempDescarga,tempTotal);

        CircuitInfo result = MyAlgorithms.getCircuit(distMap, b, Arrays.asList("CT16", "CT3", "CT9", "CT13", "CT5"),
                600, 70, 20, 15);

        Assert.assertTrue(expected.equals(result));

    }


    @Test
    @DisplayName("Test 5 Hubs Low Speed ")
    void TesteSFivehubslowspeed()throws Exception {
        DistMap distMap = new DistMap(false);
        distMap.loadCSVMap(new File("Data/distancias_small.csv"));
        String b = distMap.vertices().get(0);

        ArrayList<Pair<String, Integer>> locPassagem = new ArrayList<>();

        String[] dados = {"CT10:0", "CT1:0", "CT12:0", "CT3:3", "CT16:16", "CT9:9", "CT5:5", "CT11:0", "CT13:13", "CT10:0"};;

        for (String dado : dados) {
            String[] partes = dado.split(":");
            String chave = partes[0];
            int valor = Integer.parseInt(partes[1]);
            locPassagem.add(new Pair<>(chave, valor));
        }


        Double[] valores = {110.848, 62.877, 50.467, 68.957, 103.704, 90.186, 62.655, 121.584, 63.448};
        ArrayList<Double> distancias = new ArrayList<>(Arrays.asList(valores));

        double disttot=distancias.stream().mapToDouble(Double::doubleValue).sum();

        String[] carregamentosArray = {"CT10", "CT1", "CT12", "CT3", "CT16", "CT9", "CT5", "CT11", "CT13"};;
        ArrayList<String> carregamentos = new ArrayList<>(Arrays.asList(carregamentosArray));
        double tempPercurso = 4374;
        double tempCarregamento = 45;
        double tempDescarga = 25;
        double tempTotal = tempPercurso + tempCarregamento + tempDescarga;



        CircuitInfo expected = new CircuitInfo("CT10",locPassagem,distancias,disttot,carregamentos,carregamentos.size(),tempPercurso,tempCarregamento,tempDescarga,tempTotal);

        CircuitInfo result = MyAlgorithms.getCircuit(distMap, b, Arrays.asList("CT16", "CT3", "CT9", "CT13", "CT5"),
                10, 10, 5, 5);

        Assert.assertTrue(expected.equals(result));

    }


    @Test
    @DisplayName("Test 7 Hubs High Speed")
    void TestesevenhubsHigh() throws Exception {
        DistMap distMap = new DistMap(false);
        distMap.loadCSVMap(new File("Data/distancias_small.csv"));
        String b = distMap.vertices().get(0);

        ArrayList<Pair<String, Integer>> locPassagem = new ArrayList<>();

        String[] dados = {"CT10:0", "CT1:0", "CT12:12", "CT15:15", "CT3:0", "CT4:4", "CT16:16", "CT17:17", "CT9:9", "CT5:0","CT11:11", "CT10:0"};

        for (String dado : dados) {
            String[] partes = dado.split(":");
            String chave = partes[0];
            int valor = Integer.parseInt(partes[1]);
            locPassagem.add(new Pair<>(chave, valor));
        }

        Double[] valores = {110.848, 62.877, 70.717, 43.598, 157.223, 110.133, 79.56, 62.879, 90.186, 62.655, 142.47};
        ArrayList<Double> distancias = new ArrayList<>(Arrays.asList(valores));

        double disttot=distancias.stream().mapToDouble(Double::doubleValue).sum();

        String[] carregamentosArray = {"CT5"};
        ArrayList<String> carregamentos = new ArrayList<>(Arrays.asList(carregamentosArray));
        double tempPercurso = 586.3366336633663;
        double tempCarregamento = 35;
        double tempDescarga = 245;
        double tempTotal = tempPercurso + tempCarregamento + tempDescarga;



        CircuitInfo expected = new CircuitInfo("CT10",locPassagem,distancias,disttot,carregamentos,carregamentos.size(),tempPercurso,tempCarregamento,tempDescarga,tempTotal);

        CircuitInfo result =  MyAlgorithms.getCircuit(distMap,b, Arrays.asList("CT15", "CT12", "CT9", "CT16", "CT4", "CT17","CT11"),
                850,101,35,35);

        Assert.assertTrue(expected.equals(result));

    }

    @Test
    @DisplayName("Test 7 Hubs Low Autonomy")
    void Testesevenhubslowautonomy()throws Exception {
        DistMap distMap = new DistMap(false);
        distMap.loadCSVMap(new File("Data/distancias_small.csv"));
        String b = distMap.vertices().get(0);

        ArrayList<Pair<String, Integer>> locPassagem = new ArrayList<>();

        String[] dados = {"CT10:0", "CT13:13", "CT7:0", "CT2:2", "CT11:0", "CT5:0", "CT9:0", "CT4:4", "CT3:0", "CT15:15", "CT12:12", "CT1:1", "CT6:6", "CT10:0"};

        for (String dado : dados) {
            String[] partes = dado.split(":");
            String chave = partes[0];
            int valor = Integer.parseInt(partes[1]);
            locPassagem.add(new Pair<>(chave, valor));
        }


        Double[] valores = {63.448, 111.686, 65.574, 163.996, 62.655, 90.186, 162.527, 157.223, 43.598, 70.717, 62.877, 56.717, 67.584};
        ArrayList<Double> distancias = new ArrayList<>(Arrays.asList(valores));

        double disttot=distancias.stream().mapToDouble(Double::doubleValue).sum();

        String[] carregamentosArray = {"CT13","CT7","CT2","CT11","CT5","CT9","CT4","CT3","CT15","CT12","CT1","CT6"};
        ArrayList<String> carregamentos = new ArrayList<>(Arrays.asList(carregamentosArray));
        double tempPercurso = 1003.7142857142857;
        double tempCarregamento = 180;
        double tempDescarga = 105;
        double tempTotal = tempPercurso + tempCarregamento + tempDescarga;



        CircuitInfo expected = new CircuitInfo("CT10",locPassagem,distancias,disttot,carregamentos,carregamentos.size(),tempPercurso,tempCarregamento,tempDescarga,tempTotal);

        CircuitInfo result =  MyAlgorithms.getCircuit(distMap,b, Arrays.asList("CT4", "CT12", "CT6", "CT13", "CT15", "CT2","CT1"),
                100,70,15,15);

        Assert.assertTrue(expected.equals(result));

    }


    @Test
    @DisplayName("Test 5 Hubs Mid File ")
    void Testefivehubsmid()throws Exception {
        DistMap distMap = new DistMap(false);
        distMap.loadCSVMap(new File("Data/distancias_mid.csv"));
        String b = distMap.vertices().get(0);

        ArrayList<Pair<String, Integer>> locPassagem = new ArrayList<>();

        String[] dados = {"CT32:0", "CT36:36", "CT50:50", "CT31:0", "CT199:199", "CT38:0", "CT193:193", "CT197:0", "CT192:192","CT32:0"};

        for (String dado : dados) {
            String[] partes = dado.split(":");
            String chave = partes[0];
            int valor = Integer.parseInt(partes[1]);
            locPassagem.add(new Pair<>(chave, valor));
        }


        Double[] valores = {3.237, 16.237, 2.352, 16.649, 7.012, 8.427, 17.873, 6.123, 7.791};
        ArrayList<Double> distancias = new ArrayList<>(Arrays.asList(valores));

        double disttot=distancias.stream().mapToDouble(Double::doubleValue).sum();

        String[] carregamentosArray = {};
        ArrayList<String> carregamentos = new ArrayList<>(Arrays.asList(carregamentosArray));
        double tempPercurso = 70.28571428571429;
        double tempCarregamento = 0;
        double tempDescarga = 75;
        double tempTotal = tempPercurso + tempCarregamento + tempDescarga;



        CircuitInfo expected = new CircuitInfo("CT32",locPassagem,distancias,disttot,carregamentos,carregamentos.size(),tempPercurso,tempCarregamento,tempDescarga,tempTotal);

        CircuitInfo result =  MyAlgorithms.getCircuit(distMap,b, Arrays.asList("CT199","CT193","CT50","CT192","CT36"),
                600,70,15,15);

        System.out.println();

        Assert.assertTrue(expected.equals(result));

    }

    @Test
    @DisplayName("Test 7 Hubs Mid File ")
    void Testesevenhubsmid()throws Exception {
        DistMap distMap = new DistMap(false);
        distMap.loadCSVMap(new File("Data/distancias_mid.csv"));
        String b = distMap.vertices().get(0);

        ArrayList<Pair<String, Integer>> locPassagem = new ArrayList<>();

        String[] dados = {"CT32:0", "CT36:36", "CT50:50", "CT31:0", "CT199:199", "CT38:0", "CT193:193", "CT34:34", "CT198:0", "CT51:0", "CT195:0", "CT190:190", "CT192:192", "CT32:0"};

        for (String dado : dados) {
            String[] partes = dado.split(":");
            String chave = partes[0];
            int valor = Integer.parseInt(partes[1]);
            locPassagem.add(new Pair<>(chave, valor));
        }


        Double[] valores = {3.237, 16.237, 2.352, 16.649, 7.012, 8.427, 17.857, 15.15, 8.615, 8.943, 11.102, 21.99, 7.791};
        ArrayList<Double> distancias = new ArrayList<>(Arrays.asList(valores));

        double disttot=distancias.stream().mapToDouble(Double::doubleValue).sum();

        String[] carregamentosArray = {};
        ArrayList<String> carregamentos = new ArrayList<>(Arrays.asList(carregamentosArray));
        double tempPercurso = 104.25;
        double tempCarregamento = 0;
        double tempDescarga = 35;
        double tempTotal = tempPercurso + tempCarregamento + tempDescarga;



        CircuitInfo expected = new CircuitInfo("CT32",locPassagem,distancias,disttot,carregamentos,carregamentos.size(),tempPercurso,tempCarregamento,tempDescarga,tempTotal);

        CircuitInfo result =  MyAlgorithms.getCircuit(distMap,b, Arrays.asList("CT199","CT34","CT193","CT50","CT192","CT36","CT190"),
                500,80,5,5);

        System.out.println();

        Assert.assertTrue(expected.equals(result));

    }







}
