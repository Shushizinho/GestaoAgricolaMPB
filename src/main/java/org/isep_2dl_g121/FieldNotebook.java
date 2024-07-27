package org.isep_2dl_g121;

import org.isep_2dl_g121.controller.OperacaoAgricolaRegisterController;

import java.io.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldNotebook {


    private static final OperacaoAgricolaRegisterController controller = new OperacaoAgricolaRegisterController();;


    /**
     * Rega existe.
     *
     * @param fileName the file name
     */
    public static void inserirCaderno(String fileName, String regaName) {

        String arquivoEntrada = fileName;

        File file = new File(regaName);
        boolean existStart = false;
        String Line;
        String finalLine = "";

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoEntrada))) {
            int count = 0;
            while ((Line = br.readLine()) != null ) {
                finalLine = Line;
                count++;
            }
            if(count>1) existStart = true;

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoEntrada, true))) {

            try (BufferedReader leitor = new BufferedReader(new FileReader(file.getName()))) {

                String linha ;
                String date = "Dia" ;

                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy/HH:mm");
                LocalDateTime data = LocalDateTime.now();
                String dataFormatada = data.format(formato);
                String[] actualDay = dataFormatada.split("/");
                String[] actualHours = actualDay[3].split(":");


                boolean today = false;
                boolean hour = false;

                while ((linha = leitor.readLine()) != null && (!today || !hour)) {

                    String[] row = linha.split(",");
                    if(!date.equals(row[0])){
                        String[] rowFinale = finalLine.split(",");
                        String[] rowDate = row[0].split("/");
                        String[] rowDateF = rowFinale[1].split("/");
                        String[] horaFinal = row[4].split(":");
                        String[] horaFinalF = rowFinale[6].split(":");


                        if(Integer.parseInt(actualHours[0])==Integer.parseInt(horaFinal[0]) && Integer.parseInt(actualHours[1])>Integer.parseInt(horaFinal[1])) hour = true;
                        if(Integer.parseInt(actualHours[0])>Integer.parseInt(horaFinal[0])) hour = true;
                        if((today = verifyDateIsTrue(rowDate[0], rowDate[1], rowDate[2], actualDay[0], actualDay[1], actualDay[2])) && hour) continue;

                        if(existStart) {

                            boolean pass = verifyDateIsTrue(rowDate[0],rowDate[1],rowDate[2],rowDateF[0],rowDateF[1],rowDateF[2]);

                            if(verifySameDate(rowDate[0],rowDate[1],rowDate[2],rowDateF[0],rowDateF[1],rowDateF[2])){
                                if(Integer.parseInt(horaFinalF[0])==Integer.parseInt(horaFinal[0]) && Integer.parseInt(horaFinalF[1])<Integer.parseInt(horaFinal[1])) pass = true;
                                if(Integer.parseInt(horaFinalF[0])<Integer.parseInt(horaFinal[0])) pass = true;
                            }


                            if (!pass) continue;
                        }

                        String mixType = "NULL";

                        if (row.length >= 6) mixType = row[5];


                        String tipoOper;

                        if(mixType.equals("NULL")) tipoOper = "Rega";
                        else tipoOper = "Fertirrega";


                        String unidade = "Min";
                        String dados = tipoOper + ","+ row[0] +","+row[2]+","+unidade+","+ row[1] +","+ row[3] +","+ row[4] ;

                        if (row.length >= 6) dados+= "," + row[5];

                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

                        controller.operacaoRegisterRega( Integer.toString(extractNumbers(row[1])) , 1, formatter.parse(row[0]),row[3] , Integer.parseInt(row[2]),extractNumbers(mixType));

                        escritor.newLine(); // Move para a próxima linha
                        escritor.write(dados); // Escreve a linha modificada


                        
                    }

                }

                    escritor.close();

            System.out.println("\u001B[36mArquivo de campo modificado:\u001B[0m " + arquivoEntrada);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException | ParseException e) {
                if (e.getMessage().contains("ORA-17067")) {
                    System.out.println("\nErro ORA-17067: Não está conectado a base de dados");
                } else {
                    e.printStackTrace();
                }
        }

        } catch (IOException e) {
        e.printStackTrace();
    }



    }
    
    
    private static boolean verifyDateIsTrue (String row, String row2, String row3, String rowDate, String rowDate2, String rowDate3){
        
        if(Integer.parseInt(row)>Integer.parseInt(rowDate) && Integer.parseInt(row2)==Integer.parseInt(rowDate2) && Integer.parseInt(row3)==Integer.parseInt(rowDate3)) return true;
        if(Integer.parseInt(row)<Integer.parseInt(rowDate) && Integer.parseInt(row2)>Integer.parseInt(rowDate2) && Integer.parseInt(row3)==Integer.parseInt(rowDate3)) return true;
        if(Integer.parseInt(row)<Integer.parseInt(rowDate) && Integer.parseInt(row2)<Integer.parseInt(rowDate2) && Integer.parseInt(row3)>Integer.parseInt(rowDate3)) return true;
        return false;
    }

    private static boolean verifySameDate(String row, String row2, String row3, String rowDate, String rowDate2, String rowDate3){
        if(Integer.parseInt(row)==Integer.parseInt(rowDate) && Integer.parseInt(row2)==Integer.parseInt(rowDate2) && Integer.parseInt(row3)==Integer.parseInt(rowDate3)) return true;
        return false;
    }

    public static int extractNumbers(String input) {
        // Definindo um padrão para encontrar números na string
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);

        // Verificando se há um número na string
        if (matcher.find()) {
            // Convertendo o número encontrado para inteiro e retornando
            return Integer.parseInt(matcher.group());
        } else {
            return -1;
        }
    }


    /**
     * File insert file.
     *
     * @return the file
     */
    public static File fileInsert(String text) {
        //display the task categories as a menu with number options to select
        //String folderPath = "src\\main\\resources\\";; // The folder path
        String folderPath = System.getProperty("user.dir");
        File folder = new File(folderPath); // Create a new File object with the folder path
        File[] files = folder.listFiles();
        int answer=0;
        int csv = countCSVFiles(files);
        File[] filexlsx = displayFiles(files,csv);
        boolean cc = text.equals("'Caderno de Campo'");

        if(cc) System.out.println("\u001B[32m"+ (csv + 1)+". Create new 'Caderno de Campo'\u001B[0m");

        System.out.println("\n\u001B[0m0. Cancel\u001B[0m");

        if (filexlsx != null){
            if (filexlsx.length>0){
                while(answer < 1 || answer > filexlsx.length  ){
                    Scanner input = new Scanner(System.in);
                    System.out.print("\u001B[35m\nSelect a "+ text + ": \u001B[0m");

                    try{
                        answer = input.nextInt();

                        if (answer == 0 || (answer == csv+1 && cc)) break;


                    }
                    catch (Exception e){
                        System.out.println("\u001B[31mMust be an Integer cannot be a String\u001B[0m");
                    }
                }

                if(answer!=0){
                    System.out.println("\u001B[34m... \u001B[0m");
                    File file;
                    if (cc && answer == csv+1){

                        System.out.print("\u001B[35m\nThe new file will be named 'cadernoCampo'.\n\u001B[0m");

                            file = new File("cadernoCampo.csv");
                            try {
                                file.createNewFile();
                                System.out.println("\u001B[34m'cadernoCampo.csv' created successfully.\u001B[0m");

                                FileWriter writer = new FileWriter(file);
                                writer.write("TipoOperação,DataRealização,Duração,Unidade,SetorNome,HoraInicio,HoraFim,Tipo Mix");
                                writer.close();

                                return file;
                            } catch (IOException e) {
                                System.out.println("\u001B[31mError creating 'cadernoCampo.csv'.\u001B[0m");
                            }

                    }
                    else{
                        file = filexlsx[answer-1];

                    }


                    return file;

                }

            }
        }
        return null;
    }

    /**
     * Plano insert.
     */
    public static void planoInsert() {

        File file = fileInsert("'Plano de Rega'");
        if(file!=null) {

            String caminhoArquivo = file.getName();
            String formatoEsperado = "Dia,Parcela,Minutos,Hora Inicial,Hora Final,Tipo Mix";



            try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {

                String primeiraLinha = br.readLine();

                if (primeiraLinha != null && primeiraLinha.equals(formatoEsperado)) {

                    File file2 = fileInsert("'Caderno de Campo'");

                    if(file2!=null){

                        caminhoArquivo = file2.getName();
                        formatoEsperado = "TipoOperação,DataRealização,Duração,Unidade,SetorNome,HoraInicio,HoraFim,Tipo Mix";

                        try (BufferedReader br2 = new BufferedReader(new FileReader(caminhoArquivo))) {

                            primeiraLinha = br2.readLine();

                            if (primeiraLinha != null && primeiraLinha.equals(formatoEsperado)) {

                                inserirCaderno(file2.getName(),file.getName());


                            } else {
                                System.out.println("O cabeçalho caderno de campo não está no formato esperado.");
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                } else {
                    System.out.println("O cabeçalho do plano de rega não está no formato esperado.");
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
