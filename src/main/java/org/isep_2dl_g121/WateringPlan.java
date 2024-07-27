package org.isep_2dl_g121;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Lapr 2.
 */
public class WateringPlan {
    /**
     * The Days.
     */
    static Map<String, List<Parcela>> Days = new HashMap<>();
    private final static int DAYS = 30;

    /**
     * Criar plano rega.
     *
     * @param fileName the file name
     */
    public static void criarPlanoRega(String fileName) {

        String arquivoEntrada = fileName;
        String arquivoSaida = "plano de rega.csv";
        //String separador = ","; // Defina o separador apropriado

        // Define o formato desejado
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try (BufferedReader leitor2 = new BufferedReader(new FileReader(arquivoEntrada))) {
            String linha2;
            int line = 1;
            while ((linha2 = leitor2.readLine()) != null) {
                String[] row = linha2.split(",");

                switch (row.length){

                    case 4:
                        throw new Exception("Está em falta a recorrencia");
                    case 5:
                        if(row[2].equals("I")) throw new Exception("Linha: " + line + " - Não é possivel fazer fetirrega em regularidade Impar");
                        if(row[2].equals("P") && !(Integer.parseInt(row[4])%2==0)) throw new Exception("Linha: " + line + " - Não é possivel fazer fetirrega em regularidade Par com recorrencia impar");
                        if(row[2].equals("3") && !(Integer.parseInt(row[4])%3==0)) throw new Exception("Linha: " + line + " - Não é possivel fazer fetirrega em regularidade 3 em 3 com recorrencia diferente de multiplo de 3");
                        break;
                    default:
                        break;

                }
                line++;


            }

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoSaida))) {
            escritor.write("Dia,Parcela,Minutos,Hora Inicial,Hora Final,Tipo Mix\n");

            for (int i = 0; i <= DAYS; i++) {
                LocalDate data = LocalDate.now().plusDays(i);
                String dataFormatada = data.format(formato);

                List<Parcela> parcelasList = new ArrayList<>();


                PairTime horaInicial = new PairTime();
                String linha;



                // Formata a data no formato especificado
                String[] horas;
                int timers = 0;
                int lenght = 1;
                while(timers<lenght){
                    try (BufferedReader leitor = new BufferedReader(new FileReader(arquivoEntrada))) {
                    int header = 0;



                    while ((linha = leitor.readLine()) != null) {
                        if(header==0){
                            horas = linha.split(",");
                            lenght = horas.length;
                            String[] inicialHora = horas[timers].split(":");

                            horaInicial.setLeft(Integer.parseInt(inicialHora[0]));
                            horaInicial.setRight(Integer.parseInt(inicialHora[1]));
                            header++;
                        }

                        else{

                            String[] row = linha.split(",");

                            boolean mixDays = true;
                            if(row.length>3)  mixDays = verificarMixDay(row[4],i);

                            if(verificar3em3(row[2],i) || verificarPeriodos(row[2],data.getDayOfMonth()) ) {

                                int minutos = Integer.parseInt(row[1]);
                                PairTime horaTerminada = horaInicial.clone();

                                horaTerminada.incrementar(minutos);


                                Parcela parcela = new Parcela(row[0],minutos,horaInicial,horaTerminada);
                                parcelasList.add(parcela);

                                horaInicial = horaTerminada.clone();
                                String dados = dataFormatada + "," + parcela.toString();

                                if (row.length>3 && mixDays) dados += "," + row[3]; //Adicionar mix

                                escritor.write(dados); // Escreve a linha modificada
                                escritor.newLine(); // Move para a próxima linha
                            }

                        }

                    }
                    timers++;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            }
            escritor.close();

            System.out.println("Plano de rega foi criado com o nome: " + arquivoSaida);

        } catch (IOException e) {
            e.printStackTrace();
        }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static boolean verificarMixDay(String s, int i) {
        if (i==0) return false;
        int mix = Integer.parseInt(s);

        return i % mix == 0;

    }

    private static boolean verificarPeriodos(String s, int n) {
        if(s.equals("P")){
            return n%2==0;
        }
        if(s.equals("I")){
            return !(n%2==0);
        }

        return s.equals("T");
    }

    private static boolean verificar3em3(String s, int n) {
        if(s.equals("3")){
            return n%3==0;
        }
        return false;

    }

    /**
     * Rega existe.
     *
     * @param fileName the file name
     */
    public static void regaExiste(String fileName) {
        String arquivoEntrada = fileName;
        Scanner sc = new Scanner(System.in);

        String inputData;
        String inputHora;


        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivoEntrada))) {

            String linha ;
            List<Parcela> listParcel = new ArrayList<>();
            String date = "Dia" ;
            boolean header = false;
            while ((linha = leitor.readLine()) != null) {
                String[] row = linha.split(",");

                if(!date.equals(row[0])){
                    if (!header) header = true;
                    else{
                        Days.put(date,listParcel);
                        listParcel.clear();
                    }
                    date = row[0];

                }
                if(header){
                    String[] split = row[3].split(":");
                    PairTime horaInicial = new PairTime(Integer.parseInt(split[0]),Integer.parseInt(split[1]));
                    String[] split2 = row[4].split(":");
                    PairTime horaFinal = new PairTime(Integer.parseInt(split2[0]),Integer.parseInt(split2[1]));

                    listParcel.add(new Parcela(row[1],Integer.parseInt(row[2]),horaInicial,horaFinal));
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        do {
            System.out.println("Insira a data que quer verificar (dd/mm/yyyy)");
            inputData = sc.nextLine();
            if(inputData.equals("0")) return;
            if(!(Days.containsKey(inputData))) System.out.println("A data inserida não está no plano de rega.");
        } while(!validarFormatoData(inputData) || !(Days.containsKey(inputData)));

        do {

            System.out.println("Insira a hora que quer verificar (hh:mm)");
            inputHora = sc.nextLine();

        } while(!validarFormatoHora(inputHora));



        int count=0;
        if(Days.containsKey(inputData)){
            String[] tempo = inputHora.split(":");
            int hora = Integer.parseInt(tempo[0]);
            int min = Integer.parseInt(tempo[1]);
            for (Parcela parcela : Days.get(inputData)) {
                PairTime inicial = parcela.getHoraInicial();
                PairTime terminado = parcela.getHoraFinal();

                if(inicial.getLeft() > hora || terminado.getLeft() < hora ) continue;
                if(inicial.getLeft() == hora && terminado.getLeft() == hora )  if(!(inicial.getRight()<=min && terminado.getRight()>=min )) continue;

                if(terminado.getLeft() != hora) if(!(terminado.getLeft()>hora && min>=terminado.getRight() && min>= inicial.getRight())) continue;
                if(inicial.getLeft() != hora && terminado.getLeft() == hora) if(!(inicial.getRight()>=min && terminado.getRight()>=min )) continue;

                int falta = terminado.getRight() - min;
                if(!(min <= terminado.getRight())) falta+=60;

                System.out.println(parcela.getParcela() + " - " + parcela.getHoraInicial().toString()  + " - " + parcela.getHoraFinal().toString() + " | Faltam: "+ falta + " minutos." );

                count++;


            }

            if(count!=0) System.out.println("Existe(m) " + count + " setor(es) a serem regados");
            else System.out.println("Não existe nenhum setor a ser regado");


        }
        else{
            System.out.println("Esse dia não está presente no plano fornecido");
        }



    }

    /**
     * Validar formato data boolean.
     *
     * @param data the data
     * @return the boolean
     */
    public static boolean validarFormatoData(String data) {
        // Define o padrão de expressão regular para dd/mm/yyyy
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";

        // Compila o padrão regex
        Pattern pattern = Pattern.compile(regex);

        // Cria um objeto Matcher para a entrada
        Matcher matcher = pattern.matcher(data);

        // Verifica se a entrada corresponde ao padrão
        return matcher.matches();
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
        File[] filexlsx = displayFiles(files,countCSVFiles(files));

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

    /**
     * Rega insert.
     */
    public static void regaInsert() {

        File file = fileInsert();
        if(file!=null) criarPlanoRega(file.getName());

    }

    /**
     * Plano insert.
     */
    public static void planoInsert() {

        File file = fileInsert();
        if(file!=null){

            String caminhoArquivo = file.getName();
            String formatoEsperado = "Dia,Parcela,Minutos,Hora Inicial,Hora Final,Tipo Mix";

            try (BufferedReader br2 = new BufferedReader(new FileReader(caminhoArquivo))) {

                String primeiraLinha = br2.readLine();

                if (primeiraLinha != null && primeiraLinha.equals(formatoEsperado)) {
                    regaExiste(file.getName());


                } else {
                    System.out.println("O cabeçalho não está no formato esperado.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }



    private static int countCSVFiles(File[] files) {
        int count = 0;

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".csv")) {
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
                if (file.isFile() && file.getName().toLowerCase().endsWith(".csv")) {
                    System.out.println("\u001B[0m" + i +". " + file.getName() + "\u001B[0m" );
                    filexlsx[i-1] = file;
                    i++;
                }
            }
            return filexlsx;

        }

        if(files == null || i==1) {
            System.out.println("\u001B[31mDoes not existe any CSV file or is not in the directory 'resources'.\u001B[0m");

        }
        return null;
    }




}
