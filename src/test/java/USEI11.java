import graph.MyAlgorithms;
import org.isep_2dl_g121.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.*;

public class USEI11 {
    public static Map<String, PairHorario> mapH= new HashMap<>();


    @AfterEach
    public void tearDown() {
        DistMap.clear();
        CoordMap.clear();
    }

    /*
    Testa a função sem hubs e horários
     */
    @Test
    void testLocalidadeVazia() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_Null.csv");
        distMap.loadCSVMap(csvDist);

        ArrayList<String> hubs = new ArrayList<>(List.of("CT3"));

        File horarioFile = new File("Data/Horarios_LocalidadeVazia.txt");
        String result = HorariosHubs.changeHorariosHubs(horarioFile, hubs);

        String expected = "\u001B[31mErro, as linhas do seu ficheiro não se encontram segundo o formato 'CT#, hh:mm, hh:mm'.\u001B[0m";
        Assertions.assertEquals(expected, result);
    }

    /*
    Testa o caso de sucesso com o ficheiro de distâncias big.
     */
    @Test
    void testBigFile() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_big.csv");
        distMap.loadCSVMap(csvDist);

        ArrayList<String> hubs = new ArrayList<>(List.of("CT1", "CT214"));

        File horarioFile = new File("Data/Horarios.txt");

        Scanner sc = new Scanner(horarioFile);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] strings = line.split(",");

            String hub = strings[0];
            DistMap.loadHubsHorarios(hub);
            String[] horarioInicio = strings[1].split(":");
            PairTime inicio = new PairTime(Integer.parseInt(horarioInicio[0]),Integer.parseInt(horarioInicio[1]));
            String[] horarioFim = strings[2].split(":");
            PairTime fim = new PairTime(Integer.parseInt(horarioFim[0]),Integer.parseInt(horarioFim[1]));
            PairHorario horario = new PairHorario(inicio, fim);
            mapH.put(hub, horario);
        }

        String result = HorariosHubs.changeHorariosHubs(horarioFile, hubs);

        for (String hub : mapH.keySet()) {
            Assertions.assertEquals(mapH.get(hub).toString(), DistMap.mapHorarios.get(hub).toString());
        }

        String expected = "\u001B[34mOperação bem sucessida\u001B[0m";
        Assertions.assertEquals(expected, result);
    }

    /*
    Testa os hubs
     */
    @Test
    void testErrorMessage() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_OneLine.csv");
        distMap.loadCSVMap(csvDist);

        ArrayList<String> hubs = new ArrayList<>(List.of("CT3"));

        File horarioFile = new File("Data/Horarios_ErrorMessage.txt");
        String result = HorariosHubs.changeHorariosHubs(horarioFile, hubs);

        String expected = "\u001B[31mErro, o hub não se encontra no sistema!\u001B[0m";
        Assertions.assertEquals(expected, result);
    }

    /*
    Testa a mensagem de erro emitida quando a ordem dos parametros estão trocados
     */
    @Test
    void testCatchMessage() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_small.csv");
        distMap.loadCSVMap(csvDist);

        ArrayList<String> hubs = new ArrayList<>(List.of("CT3"));

        File horarioFile = new File("Data/Horarios_WrongParametersOrder.txt");
        String result = HorariosHubs.changeHorariosHubs(horarioFile, hubs);

        String expected = "\u001B[31mErro, as horas definidas não estão no formato hh:mm!\u001B[0m";
        Assertions.assertEquals(expected, result);
    }

    /*
    Testa a mensagem de erro emitida quando a ordem dos parametros não são suficientes
     */
    @Test
    void testCatchMessage2() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_small.csv");
        distMap.loadCSVMap(csvDist);

        ArrayList<String> hubs = new ArrayList<>(List.of("CT3"));

        File horarioFile = new File("Data/Horarios_NotEnoughtParameters.txt");
        String result = HorariosHubs.changeHorariosHubs(horarioFile, hubs);

        String expected = "\u001B[31mErro, as linhas do seu ficheiro não se encontram segundo o formato 'CT#, hh:mm, hh:mm'.\u001B[0m";
        Assertions.assertEquals(expected, result);
    }

    /*
   Testa a mensagem de erro emitida quando os parametros não estão separados por vírgula
    */
    @Test
    void testCatchMessage3() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_small.csv");
        distMap.loadCSVMap(csvDist);

        ArrayList<String> hubs = new ArrayList<>(List.of("CT3"));

        File horarioFile = new File("Data/Horarios_WithoutComma.txt");
        String result = HorariosHubs.changeHorariosHubs(horarioFile, hubs);

        String expected = "\u001B[31mErro, as linhas do seu ficheiro não se encontram segundo o formato 'CT#, hh:mm, hh:mm'.\u001B[0m";
        Assertions.assertEquals(expected, result);
    }


    /*
   Testa a mensagem de erro emitida quando os parametros não estão separados por vírgula
    */
    @Test
    void testCatchMessage4() throws Exception {
        DistMap distMap = new DistMap(false);
        File csvDist = new File("Data/distancias_big.csv");
        distMap.loadCSVMap(csvDist);

        ArrayList<String> hubs = new ArrayList<>(List.of("CT3"));

        File horarioFile = new File("Data/Horarios_WrongHours.txt");
        String result = HorariosHubs.changeHorariosHubs(horarioFile, hubs);

        String expected = "\u001B[31mErro, as horas definidas não estão no formato hh:mm!\u001B[0m";
        Assertions.assertEquals(expected, result);
    }

}