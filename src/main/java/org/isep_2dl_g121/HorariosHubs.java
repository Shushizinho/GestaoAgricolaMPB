package org.isep_2dl_g121;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HorariosHubs {
    public static void dadosHorariosHubs() throws FileNotFoundException {
        File file = fileInsert();

        ArrayList<String> listHubs = new ArrayList<>(List.of("CT1", "CT214"));

        String StringHubs = null;

        String message = changeHorariosHubs(file, listHubs);

        StringHubs = DistMap.mapHorariosToString();

        System.out.println(StringHubs + "\n" + message);

    }

    /**
     * File insert file.
     *
     * @return the file
     */
    public static File fileInsert() {
        //display the task categories as a menu with number options to select
        //String folderPath = "src\\main\\resources\\";; // The folder path
        String folderPath = System.getProperty("user.dir");
        File folder = new File(folderPath); // Create a new File object with the folder path
        File[] files = folder.listFiles();
        int answer=0;
        File[] filexlsx = displayFiles(files,countTXTFiles(files));

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

                    return file;

                }

            }
        }
        return null;
    }

    private static int countTXTFiles(File[] files) {
        int count = 0;

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".txt")) {
                    count++;
                }
            }
        }

        return count;
    }

    private static File[] displayFiles(File[] files,int total) {
        // Get an array of File objects representing the files in the folder
        int i=1,answer=0;
        if (files != null) {
            File[] filexlsx = filexlsx = new File[total];
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".txt")) {
                    System.out.println("\u001B[0m" + i +". " + file.getName() + "\u001B[0m" );
                    filexlsx[i-1] = file;
                    i++;
                }
            }
            return filexlsx;

        }

        if(files == null || i==1) {
            System.out.println("\u001B[31mDoes not existe any TXT file or is not in the directory 'resources'.\u001B[0m");

        }
        return null;
    }

    public static String changeHorariosHubs(File txt, ArrayList<String> listHubs) throws FileNotFoundException {
        String reply = "Sem dados";
        Scanner sc = new Scanner(txt);

        try {
            while (sc.hasNextLine()) {

                String line = sc.nextLine();
                String[] strings = line.split(",");

                if (strings.length < 3 || strings[0].equals(" ")) {
                    return "\u001B[31mErro, as linhas do seu ficheiro não se encontram segundo o formato 'CT#, hh:mm, hh:mm'.\u001B[0m";
                }

                String hub = strings[0];

                if (validarFormatoHora(strings[1]) && validarFormatoHora(strings[2])){
                    String[] horarioInicio = strings[1].split(":");
                    PairTime inicio = new PairTime(Integer.parseInt(horarioInicio[0]),Integer.parseInt(horarioInicio[1]));

                    String[] horarioFim = strings[2].split(":");
                    PairTime fim = new PairTime(Integer.parseInt(horarioFim[0]),Integer.parseInt(horarioFim[1]));

                    if (validarHoras(inicio, fim)){

                        if (listHubs.contains(hub)) {
                            PairHorario horario = new PairHorario(inicio, fim);
                            if (DistMap.mapHorarios.containsKey(hub)) DistMap.mapHorarios.replace(hub, horario);
                            DistMap.mapHorarios.put(hub, horario);

                            reply = "\u001B[34mOperação bem sucedida!\u001B[0m";
                        } else {

                            reply = "\u001B[31mErro, o hub não se encontra no sistema!\u001B[0m";
                            break;
                        }
                    }else {

                        reply = "\u001B[31mErro, as datas definidas não são válidas!\u001B[0m";
                        break;
                    }

                }else{

                    reply = "\u001B[31mErro, as horas definidas não estão no formato hh:mm!\u001B[0m";
                    break;
                }
            }

        }catch (Exception e){

            reply = "\u001B[31mErro, as linhas do seu ficheiro não se encontram segundo o formato 'CT#, hh:mm, hh:mm'.\u001B[0m";
        }

        return reply;
    }

    private static boolean validarHoras(PairTime inicio, PairTime fim) {
        boolean valid = inicio.getLeft() < fim.getLeft();

        if (inicio.getLeft() == fim.getLeft()){
            if (inicio.getRight() < fim.getRight()){
                valid = true;
            }
            valid = false;
        }

        return valid;
    }

    /**
     * Validar formato hora boolean.
     *
     * @param hora the hora
     * @return the boolean
     */
    public static boolean validarFormatoHora(String hora) {
        // Define o padrão de expressão regular para h:mm ou hh:mm
        String regex = "^(0?[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$";

        // Compila o padrão regex
        Pattern pattern = Pattern.compile(regex);

        // Cria um objeto Matcher para a entrada
        Matcher matcher = pattern.matcher(hora);

        // Verifica se a entrada corresponde ao padrão
        return matcher.matches();
    }
}
