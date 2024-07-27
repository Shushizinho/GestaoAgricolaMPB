package org.isep_2dl_g121;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;
import java.nio.file.StandardCopyOption;

public class XLSXtoSQL {

    private static void sqlInsertsOperation(File fileInput) {


        try {

            FileInputStream excelFile = new FileInputStream(fileInput.getName());
            Workbook workbook = new XSSFWorkbook(excelFile);
            writeMain(workbook, "Exploração agrícola", "parcela", new Integer[]{2,3}, "designacao, area", 1, "Parcela");
            writeMain(workbook, "Plantas", "tipoplanta", new Integer[]{3}, "designacao");
            writePlanta(workbook, "Plantas", "planta", new Integer[]{1,2,0,3}, "nome, especie, plantatipoid", "produto");
            writeCultura(workbook, "Culturas", "cultura", new Integer[]{1,2,7,6,4,5}, "ParcelaID, PlantaID, unidadedesignacao, quantidade, data_inicio, data_fim", "planta", "parcela");
            writeMain(workbook, "Fator Produção", "fatorproducao", new Integer[]{0,2,1,3,4}, "nomecomercial, formulacao, fabricante,fatorproducaotipo,aplicacao");
            writeElem(workbook,"Fator Produção", "fichatecnica");
            writeMain(workbook, "Operações", "operacao", new Integer[]{9,2,9,5,6,7,8,1,4,3,4,1}, "datarealizacao, cadernocampoid");
            writeOperacoes(workbook, "Operações", "operacao", new Integer[]{5}, "datarealizacao, cadernocampoid");


            fuseFiles();

            System.out.println("Ficheiro SQL gerado com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeOperacoes(Workbook workbook, String excelTable, String sheetName, Integer[] excelColumns, String dbColumns) {
        int index = workbook.getSheetIndex(excelTable);
        Sheet sheet = workbook.getSheetAt(index);
        try {
            Writer writer = new FileWriter(sheetName+".sql");
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                StringBuilder sql = new StringBuilder("INSERT INTO " + sheetName + "("+dbColumns+") VALUES (");
                Integer count = 0;
                for (Integer j : excelColumns) {
                    Cell cell = sheet.getRow(i).getCell(j);
                    if (cell != null) {
                        if (cell.getCellType() == CellType.STRING) {
                            String a = cell.getStringCellValue().replace("'", "''");
                            sql.append("'").append(convertToLowerCaseExceptFirst(a)).append("'");
                        } else if (cell.getCellType() == CellType.NUMERIC) {
                            if (DateUtil.isCellDateFormatted(cell)) {
                                Date date = cell.getDateCellValue();
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
                                String c = dateFormat.format(date);
                                sql.append("δ'").append(c).append("'ε");
                            } else {
                                sql.append(cell.getNumericCellValue());
                            }
                        }
                    } else {
                        sql.append("null");
                    }
                    if (count!=excelColumns.length-1) sql.append(", ");
                    count++;
                }
                sql.append(",1"+");");
                writer.write(sql.toString() + "\n");
                String type = sheet.getRow(i).getCell(2).getStringCellValue();
                if (type.contains("Plantação")){
                    writer.write("INSERT INTO plantacao(OperacaoID, CulturaID, NumPlantas) VALUES (ψ,"+(getIdFromFile("cultura", sheet.getRow(i).getCell(1).getStringCellValue(), sheet.getRow(i).getCell(4).getStringCellValue()).equals("-1")?"π":getIdFromFile("cultura", sheet.getRow(i).getCell(1).getStringCellValue(), sheet.getRow(i).getCell(4).getStringCellValue()))+","+sheet.getRow(i).getCell(6).getNumericCellValue()+");\n");
                } else if (type.contains("Fertilização") ||type.contains("Aplicação fitofármaco")) {
                    writer.write("INSERT INTO aplicacaofator(OperacaoID) VALUES (ψ);\n");
                    writer.write("INSERT INTO aplicacaofator_fatorproducao(OperacaoID, FatorProducaoID, Quantidade, Unidadedesignacao) VALUES (ψ,"+getIdFromFile("fatorproducao", sheet.getRow(i).getCell(8).getStringCellValue())+","+sheet.getRow(i).getCell(6).getNumericCellValue()+",'"+sheet.getRow(i).getCell(7).getStringCellValue()+"');\n");
                    if (sheet.getRow(i).getCell(4) != null) {
                        if (getIdFromFile("cultura", sheet.getRow(i).getCell(1).getStringCellValue(), sheet.getRow(i).getCell(4).getStringCellValue()).equals("-1")){
                            int index2 = workbook.getSheetIndex("Culturas");
                            Sheet sheet2 = workbook.getSheetAt(index2);
                            for (int c = 1; c <= sheet2.getLastRowNum(); c++) {
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
                                if (sheet2.getRow(c).getCell(1).getStringCellValue().equals(sheet.getRow(i).getCell(1).getStringCellValue()) && sheet2.getRow(c).getCell(2).getStringCellValue().contains(sheet.getRow(i).getCell(4).getStringCellValue()) && sheet2.getRow(c).getCell(4).getDateCellValue().compareTo(sheet.getRow(i).getCell(5).getDateCellValue())==-1) {
                                    writer.write("INSERT INTO afcultura(AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (ψ,"+getIdFromFile("cultura", sheet.getRow(i).getCell(1).getStringCellValue(), sheet2.getRow(c).getCell(2).getStringCellValue(), dateFormat.format(sheet2.getRow(c).getCell(4).getDateCellValue()))+","+(sheet.getRow(i).getCell(3) != null?sheet.getRow(i).getCell(3).getStringCellValue().replace("Solo","1").replace("Foliar","2"): "3")+");\n");
                                    writer.write(sql.toString() + "\n");
                                    writer.write("INSERT INTO aplicacaofator(OperacaoID) VALUES (ψ);\n");
                                    writer.write("INSERT INTO aplicacaofator_fatorproducao(OperacaoID, FatorProducaoID, Quantidade, Unidadedesignacao) VALUES (ψ,"+getIdFromFile("fatorproducao", sheet.getRow(i).getCell(8).getStringCellValue())+","+sheet.getRow(i).getCell(6).getNumericCellValue()+",'"+sheet.getRow(i).getCell(7).getStringCellValue()+"');\n");
                                }
                            }
                            writer.write("ξ\n");
                        } else {
                            writer.write("INSERT INTO afcultura(AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (ψ,"+getIdFromFile("cultura", sheet.getRow(i).getCell(1).getStringCellValue(), sheet.getRow(i).getCell(4).getStringCellValue())+","+(sheet.getRow(i).getCell(3) != null?sheet.getRow(i).getCell(3).getStringCellValue().replace("Solo","1").replace("Foliar","2"): "3")+");\n");
                        }
                    } else {
                        writer.write("INSERT INTO afparcela(AplicacaoFatorOperacaoID,ParcelaID,Area,UnidadeDesignacao) VALUES (ψ,"+getIdFromFile("parcela", sheet.getRow(i).getCell(1).getStringCellValue())+",1,'ha');\n");
                    }
                } else if(type.contains("Semeadura") || type.contains("Sementeira")) {
                    writer.write("INSERT INTO semeadura(OperacaoID, CulturaID, QuantidadeSemente, UnidadeSemente) VALUES (ψ,"+(getIdFromFile("cultura", sheet.getRow(i).getCell(1).getStringCellValue(), sheet.getRow(i).getCell(4).getStringCellValue()).equals("-1")?"π":getIdFromFile("cultura", sheet.getRow(i).getCell(1).getStringCellValue(), sheet.getRow(i).getCell(4).getStringCellValue()))+","+sheet.getRow(i).getCell(6).getNumericCellValue()+",'"+(sheet.getRow(i).getCell(7)!=null?sheet.getRow(i).getCell(7).getStringCellValue():"un")+"');\n");
                } else if(type.contains("Colheita")) {
                    writer.write("INSERT INTO colheita (OperacaoID, ProdutoID, Quantidade, CulturaID, Unidadedesignacao) VALUES (ψ,"+getIdFromFile("produto", getIdFromFile("planta",sheet.getRow(i).getCell(4).getStringCellValue()))+","+sheet.getRow(i).getCell(6).getNumericCellValue()+","+(getIdFromFile("cultura", sheet.getRow(i).getCell(1).getStringCellValue(), sheet.getRow(i).getCell(4).getStringCellValue()).equals("-1")?"π":getIdFromFile("cultura", sheet.getRow(i).getCell(1).getStringCellValue(), sheet.getRow(i).getCell(4).getStringCellValue()))+",'"+sheet.getRow(i).getCell(7).getStringCellValue()+"');\n");
                } else if (type.contains("Rega")) {
                    if (getIdFromFile("cultura", sheet.getRow(i).getCell(1).getStringCellValue(), sheet.getRow(i).getCell(4).getStringCellValue()).equals("-1")){
                        int index2 = workbook.getSheetIndex("Culturas");
                        Sheet sheet2 = workbook.getSheetAt(index2);
                        for (int c = 1; c <= sheet2.getLastRowNum(); c++) {
                            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
                            if (sheet2.getRow(c).getCell(1).getStringCellValue().equals(sheet.getRow(i).getCell(1).getStringCellValue()) && sheet2.getRow(c).getCell(2).getStringCellValue().contains(sheet.getRow(i).getCell(4).getStringCellValue()) && sheet2.getRow(c).getCell(4).getDateCellValue().compareTo(sheet.getRow(i).getCell(5).getDateCellValue())==-1) {
                                writer.write("INSERT INTO rega(OperacaoID, CulturaID, horainicio, duracao) VALUES (ψ,"+getIdFromFile("cultura", sheet.getRow(i).getCell(1).getStringCellValue(), sheet2.getRow(c).getCell(2).getStringCellValue(), dateFormat.format(sheet2.getRow(c).getCell(4).getDateCellValue()))+",'??:??',0);\n");
                                writer.write(sql.toString() + "\n");
                            }

                        }
                    } else {
                        writer.write("INSERT INTO rega(OperacaoID, CulturaID, horainicio, duracao) VALUES (ψ,"+getIdFromFile("cultura", sheet.getRow(i).getCell(1).getStringCellValue(), sheet.getRow(i).getCell(4).getStringCellValue())+",'??:??',0);\n");
                    }
                } else if (type.contains("Poda")) {
                    writer.write("INSERT INTO poda(OperacaoID, Quantidade, UnidadeQuantidade, CulturaID) VALUES (ψ,"+sheet.getRow(i).getCell(6).getNumericCellValue()+",'"+sheet.getRow(i).getCell(7).getStringCellValue()+"',"+getIdFromFile("cultura", sheet.getRow(i).getCell(1).getStringCellValue(), sheet.getRow(i).getCell(4).getStringCellValue())+");\n");
                } else if (type.contains("Incorporação")){
                    writer.write("INSERT INTO IncorporacaoSolo(OperacaoID, quantidade, Unidadedesignacao, CulturaID) VALUES (ψ,"+sheet.getRow(i).getCell(6).getNumericCellValue()+",'"+sheet.getRow(i).getCell(7).getStringCellValue()+"',"+getIdFromFile("cultura", sheet.getRow(i).getCell(1).getStringCellValue(), sheet.getRow(i).getCell(4).getStringCellValue())+");\n");
                }
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\u001B[93m+ '"+sheetName+".sql' ["+Math.round(sizeInKiloBytes(new File(sheetName+".sql")))+" kb]\u001B[0m");
    }
    public static void removeExtraAFCultura(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("ξ")){
                    for (int i = 0; i < 4; i++) {
                        line = reader.readLine();
                    }
                }
                lines.add(line);
            }
        }


        // Write the reversed lines back to the same file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String reversedLine : lines) {
                writer.write(reversedLine);
                writer.newLine();
            }
        }
    }
    public static void reverseFileLines(String filePath) throws IOException {
        // Read lines from the file
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        // Reverse the order of lines
        Collections.reverse(lines);

        // Write the reversed lines back to the same file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String reversedLine : lines) {
                writer.write(reversedLine);
                writer.newLine();
            }
        }
    }
    private static String getIdFromFile(String cultura, String targeta, String targetb, String targetc) {
        boolean found = false;
        int line = 1;
        try (BufferedReader reader = new BufferedReader(new FileReader(cultura+".sql"))) {
            String line_s;
            while (!found && (line_s = reader.readLine()) != null){
                String[] parts = line_s.split(Pattern.quote("VALUES"));
                String[] parts2 = parts[1].split(",");
                int a = Integer.parseInt(getIdFromFile("parcela",targeta));
                int b = Integer.parseInt(getIdFromFile("planta",targetb));
                if (Integer.parseInt(parts2[0].split("\\(")[1]) == a && Integer.parseInt(parts2[1].split(" ")[1]) == b && (parts2[4].split(" ")[1]).contains(targetc)){
                    found = true;
                }
                if (!found) line++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!found) return ""+-1;
        return ""+line;
    }

    private static void writePlanta(Workbook workbook, String excelTable, String sheetName, Integer[] excelColumns, String dbColumns, String sheet2) throws IOException {
        int index = workbook.getSheetIndex(excelTable);
        Sheet sheet = workbook.getSheetAt(index);
        try {
            Writer writer = new FileWriter(sheetName+".sql");
            Writer writer2 = new FileWriter(sheet2+".sql");
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                StringBuilder sql = new StringBuilder("INSERT INTO " + sheetName + "("+dbColumns+") VALUES (");
                StringBuilder sql2 = new StringBuilder("INSERT INTO " + sheet2 + "(nome, plantaid) VALUES (");
                String temp = null;
                String produto = null;
                String treeName = null;
                boolean no = false;
                for (Integer j : excelColumns) {
                    Cell cell = sheet.getRow(i).getCell(j);
                    if (cell != null) {
                        if (cell.getCellType() == CellType.STRING) {
                            if (j == 1) {
                                temp = cell.getStringCellValue().replace("'", "''").replace(" ", "");
                                treeName = temp;
                                no = true;
                            } else {
                                String a = cell.getStringCellValue().replace("'", "''").replace(" ", "");
                                if (j == 2) {
                                    produto = "'"+convertToLowerCaseExceptFirst(findFruit(treeName.toLowerCase()) + " " + a);
                                    a = temp+ " " + a;
                                    no = false;
                                }
                                if (j == 3) {
                                    sql.append(getIdFromFile("tipoplanta", a));
                                } else {
                                    sql.append("'").append(convertToLowerCaseExceptFirst(a)).append("'");
                                }
                            }
                        } else if (cell.getCellType() == CellType.NUMERIC) {
                            if (DateUtil.isCellDateFormatted(cell)) {
                                Date date = cell.getDateCellValue();
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
                                String c = dateFormat.format(date);
                                sql.append("δ'").append(c).append("'ε");
                            } else {
                                sql.append(cell.getNumericCellValue());
                            }
                        }
                    } else {
                        sql.append("null");
                    }
                    if (j.compareTo(excelColumns[excelColumns.length-1])!=0 && !no) sql.append(", ");
                }
                sql.append(");");
                writer.write(sql.toString().replace("'Permanente'","1").replace("'Temporária'","1") + "\n");
                writer2.write(String.valueOf(sql2.append(produto).append("', ").append(i).append(");\n")));
            }
            writer.close();
            writer2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\u001B[93m+ '"+sheetName+".sql' ["+Math.round(sizeInKiloBytes(new File(sheetName+".sql")))+" kb]\u001B[0m");
        removeDuplicatesFromFile(sheetName+".sql");
    }



    private static void writeCultura(Workbook workbook, String excelTable, String sheetName, Integer[] excelColumns, String dbColumns, String planta, String parcela) {
        int index = workbook.getSheetIndex(excelTable);
        Sheet sheet = workbook.getSheetAt(index);
        try {
            Writer writer = new FileWriter(sheetName+".sql");
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                excelValues(sheet, sheetName, excelColumns, i, writer, dbColumns, planta, parcela);
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        removeDuplicatesFromFile(sheetName+".sql");
    }

    private static void excelValues(Sheet sheet, String sheetName, Integer[] columns, int i, Writer writer, String dbColumns, String planta, String parcela) throws IOException {
        StringBuilder sql = new StringBuilder("INSERT INTO " + sheetName + "("+dbColumns+") VALUES (");
        for (Integer j : columns) {
            Cell cell = sheet.getRow(i).getCell(j);
            if (cell != null) {
                switch (j){
                    case 1:
                        sql.append(getIdFromFile(parcela, cell.getStringCellValue().replace("'", "''")));
                        break;
                    case 2:
                        sql.append(getIdFromFile(planta, cell.getStringCellValue().replace("'", "''")));
                        break;
                    default:
                        if (cell.getCellType() == CellType.STRING) {
                            String a = cell.getStringCellValue().replace("'", "''");
                            sql.append("'").append(convertToLowerCaseExceptFirst(a)).append("'");
                        } else if (cell.getCellType() == CellType.NUMERIC) {
                            if (DateUtil.isCellDateFormatted(cell)) {
                                Date date = cell.getDateCellValue();
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
                                String c = dateFormat.format(date);
                                sql.append("δ'").append(c).append("'ε");
                            } else {
                                sql.append(cell.getNumericCellValue());
                            }
                        }
                        break;
                }

            } else {
                sql.append("null");
            }
            if (j.compareTo(columns[columns.length-1])!=0) sql.append(", ");
        }
        sql.append(");");
        writer.write(sql.toString() + "\n");
    }
    private static void excelValues2(Sheet sheet, String sheetName, Integer[] columns, int i, Writer writer, String dbColumns, String culturaparcela) throws IOException {
        StringBuilder sql = new StringBuilder("INSERT INTO " + sheetName + "("+dbColumns+") VALUES (");
        String ae = null;
        for (Integer j : columns) {
            Cell cell = sheet.getRow(i).getCell(j);
            if (cell != null) {
                switch (j){
                    case 1:
                        ae = cell.getStringCellValue().replace("'", "''");
                        break;
                    case 4:
                        sql.append(getIdFromFile(culturaparcela, ae,cell.getStringCellValue().replace("'", "''")));
                        break;
                    default:
                        if (cell.getCellType() == CellType.STRING) {
                            String a = cell.getStringCellValue().replace("'", "''");
                            sql.append("'").append(convertToLowerCaseExceptFirst(a)).append("'");
                        } else if (cell.getCellType() == CellType.NUMERIC) {
                            if (DateUtil.isCellDateFormatted(cell)) {
                                Date date = cell.getDateCellValue();
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
                                String c = dateFormat.format(date);
                                sql.append("δ'").append(c).append("'ε");
                            } else {
                                sql.append(cell.getNumericCellValue());
                            }
                        }
                        break;
                }

            } else {
                sql.append("null");
            }
            if (j.compareTo(columns[columns.length-1])!=0 && j!=1) sql.append(", ");
        }
        sql.append(");");
        writer.write(sql.toString() + "\n");
    }

    private static String getIdFromFile(String cultura, String target) throws FileNotFoundException {
        boolean found = false;
        int line = 1;
        try (BufferedReader reader = new BufferedReader(new FileReader(cultura+".sql"))) {
            String line_s = null;
            while (!found && (line_s = reader.readLine()) != null){
                String[] parts = line_s.split(Pattern.quote("VALUES"));
                String[] parts2 = parts[1].split(",");
                if (Objects.equals(cultura, "produto")){
                    if (parts2[1].split("\\)")[0].split(" ")[1].equalsIgnoreCase(target)) found = true;
                } else {
                    if (parts2[0].split("'")[1].equalsIgnoreCase(target)) found = true;
                }
                if (!found) line++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!found) return ""+-1;
        return ""+line;
    }
    private static String getIdFromFile(String cultura, String targeta, String targetb) throws FileNotFoundException {
        boolean found = false;
        int line = 1;
        try (BufferedReader reader = new BufferedReader(new FileReader(cultura+".sql"))) {
            String line_s;
            while (!found && (line_s = reader.readLine()) != null){
                String[] parts = line_s.split(Pattern.quote("VALUES"));
                String[] parts2 = parts[1].split(",");
                int a = Integer.parseInt(getIdFromFile("parcela",targeta));
                int b = Integer.parseInt(getIdFromFile("planta",targetb));
                    if (Integer.parseInt(parts2[0].split("\\(")[1]) == a && Integer.parseInt(parts2[1].split(" ")[1]) == b){
                    found = true;
                }
                if (!found) line++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!found) return ""+-1;
        return ""+line;
    }

    private static void fuseFiles() {
        try (FileWriter writer = new FileWriter("header.sql")) {
            writer.write("INSERT INTO cadernocampo(nome) VALUES ('Legacy');\n");
            writer.write("INSERT INTO unidade(designacao) VALUES ('un');\n");
            writer.write("INSERT INTO unidade(designacao) VALUES ('m3');\n");
            writer.write("INSERT INTO unidade(designacao) VALUES ('kg');\n");
            writer.write("INSERT INTO unidade(designacao) VALUES ('ha');\n");
            writer.write("INSERT INTO unidade(designacao) VALUES ('m2');\n");
            writer.write("INSERT INTO unidade(designacao) VALUES ('min');\n");
            writer.write("INSERT INTO unidade(designacao) VALUES ('l');\n");
            writer.write("INSERT INTO unidade(designacao) VALUES ('l/ha');\n");
            writer.write("INSERT INTO unidade(designacao) VALUES ('kg/l');\n");
            writer.write("INSERT INTO tipoplanta(designacao) VALUES ('Permanente');\n");
            writer.write("INSERT INTO tipoplanta(designacao) VALUES ('Temporária');\n");
            writer.write("INSERT INTO modoafator(designacao) VALUES ('Solo');\n");
            writer.write("INSERT INTO modoafator(designacao) VALUES ('Foliar');\n");
            writer.write("INSERT INTO modoafator(designacao) VALUES ('Outros');\n");


        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] sourceFiles = {
                "header.sql",
                "tipoplanta.sql",
                "parcela.sql",
                "planta.sql",
                "produto.sql",
                "fatorproducao.sql",
                "fichatecnica.sql",
                "cultura.sql",
                "operacao.sql"
        };
        int kb = 0;
        try (FileWriter writerFull = new FileWriter("import_full.sql", true)) {
            int psi = 0;
            for (String sourceFilePath : sourceFiles) {
                if (sourceFilePath.equals("operacao.sql")){
                    reverseFileLines(sourceFilePath);
                    removeExtraAFCultura(sourceFilePath);
                    reverseFileLines(sourceFilePath);
                }
                try (BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath))) {
                    String line= reader.readLine();
                    String nextLine;
                    while ((nextLine = reader.readLine()) != null) {
                            if (line.startsWith("INSERT INTO operacao(") && nextLine.startsWith("INSERT INTO operacao(")){
                                //do nothing
                            } else {
                                if (line.startsWith("INSERT INTO operacao(")) psi++;
                                line = line.replace("δ", "TO_DATE(");
                                line = line.replace("ε", ",'DD-MM-YYYY')");
                                line = line.replace("ψ", String.valueOf(psi));
                                String linefull = line;
                                writerFull.write(linefull);
                                writerFull.write("\n");
                                kb++;
                            }
                            line = nextLine;
                    }
                    if (line.startsWith("INSERT INTO operacao(")) psi++;
                    line = line.replace("δ", "TO_DATE(");
                    line = line.replace("ε", ",'DD-MM-YYYY')");
                    line = line.replace("ψ", String.valueOf(psi));
                    String linefull = line;
                    writerFull.write(linefull);
                    writerFull.write("\n");
                    kb++;

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("\u001B[92m+ 'import_full.sql' ["+Math.round(sizeInKiloBytes(new File("import_full.sql")))+" kb]\u001B[0m");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Path pastaDestino = Paths.get("docs/sprint3/BDDAD");

        try {
            Path ficheiroOrigem = Paths.get("import_full.sql");
            Files.move(ficheiroOrigem, pastaDestino.resolve(ficheiroOrigem.getFileName()), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("\u001B[32m'import_full.sql' >> 'docs/sprint3/BDDAD/import_full.sql' ["+Math.round(sizeInKiloBytes(new File(pastaDestino+"/"+ficheiroOrigem)))+" kb]\u001B[0m");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String sourceFilePath : sourceFiles) {
            File sourceFile = new File(sourceFilePath);
            if (sourceFile.exists() && sourceFile.isFile()) {
                System.out.println("\u001B[90m- '"+sourceFilePath+"' [0 kb]\u001B[0m");
                if (!sourceFile.delete()) {
                    System.err.println("Failed to delete: " + sourceFilePath);

                }
          }
        }
        System.out.println("\u001B[32mDone\u001B[0m");
    }
    private static double sizeInKiloBytes(File file)
    {
        return (double) file.length() / 1024 ;
    }
    public static void removeDuplicatesFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             Writer writer = new FileWriter(filePath + ".tmp")) {

            Set<String> uniqueLines = new LinkedHashSet<>();
            String line;

            while ((line = reader.readLine()) != null) {
                uniqueLines.add(line);
            }

            for (String uniqueLine : uniqueLines) {
                writer.write(uniqueLine+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\u001B[93m+ '"+filePath+".tmp' ["+Math.round(sizeInKiloBytes(new File(filePath+".tmp")))+" kb]\u001B[0m");
        File originalFile = new File(filePath);
        File tempFile = new File(filePath + ".tmp");

        if (originalFile.exists() && originalFile.isFile()) {
            if (!originalFile.delete()) {
                System.err.println("Failed to delete: " + filePath);

            } else {
                if (!tempFile.renameTo(originalFile)) {
                    System.err.println("Failed to rename the temporary file.");
                }
                System.out.println("\u001B[90m- '"+filePath+"' [0 kb]\u001B[0m");
                System.out.println("\u001B[33m'"+filePath+".tmp' >> '"+filePath+"' ["+Math.round(sizeInKiloBytes(new File(filePath)))+" kb]\u001B[0m");
            }
        }
    }

    private static void writeElem(Workbook workbook, String excelTable, String sheetName) throws IOException {
        int index = workbook.getSheetIndex(excelTable);
        Sheet sheet = workbook.getSheetAt(index);
        Set<String> elementos = new HashSet<>();
        Writer writer2 = new FileWriter(sheetName+".sql");
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            List<Cell> cells = new ArrayList<>();
            Cell cell = sheet.getRow(i).getCell(5);
            Cell cell1 = sheet.getRow(i).getCell(7);
            Cell cell2 = sheet.getRow(i).getCell(9);
            Cell cell3 = sheet.getRow(i).getCell(11);
            elementos.add(convertToLowerCaseExceptFirst(cell.getStringCellValue()));
            cells.add(cell);
            if (cell1 != null) {
                elementos.add(convertToLowerCaseExceptFirst(cell1.getStringCellValue()));
                cells.add(cell1);
            }
            if (cell2 != null) {
                elementos.add(convertToLowerCaseExceptFirst(cell2.getStringCellValue()));
                cells.add(cell2);
            }
            if (cell3 != null) {
                elementos.add(convertToLowerCaseExceptFirst(cell3.getStringCellValue()));
                cells.add(cell3);
            }
            int j = 1;
            for (Cell c : cells) {
                writer2.write("INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (" + getIdFromFile("fatorproducao", sheet.getRow(i).getCell(0).getStringCellValue()) + ",'" + convertToLowerCaseExceptFirst(c.getStringCellValue()) + "'," + sheet.getRow(i).getCell(4 + j * 2) + ");\n");
                j++;
            }
        }
        writer2.close();
        System.out.println("\u001B[93m+ '"+sheetName+".sql' ["+Math.round(sizeInKiloBytes(new File(sheetName+".sql")))+" kb]\u001B[0m");
//        writeAux(elementos, "elementosubstancias");
    }



    private static void writeMain(Workbook workbook, String excelTable, String sheetName, Integer[] excelColumns, String dbColumns) throws IOException {
        int index = workbook.getSheetIndex(excelTable);
        Sheet sheet = workbook.getSheetAt(index);
        try {
            Writer writer = new FileWriter(sheetName+".sql");
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    excelValues(sheet, sheetName, excelColumns, i, writer, dbColumns);
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\u001B[93m+ '"+sheetName+".sql' ["+Math.round(sizeInKiloBytes(new File(sheetName+".sql")))+" kb]\u001B[0m");
        removeDuplicatesFromFile(sheetName+".sql");
    }
    private static void writeMain(Workbook workbook, String excelTable, String sheetName, Integer[] columns, String dbColumns, Integer conditionalCell, String comparator) throws IOException {
        int index = workbook.getSheetIndex(excelTable);
        Sheet sheet = workbook.getSheetAt(index);
        try {
            Writer writer = new FileWriter(sheetName+".sql");
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                if (sheet.getRow(i).getCell(conditionalCell).getStringCellValue().compareTo(comparator) == 0) {
                    excelValues(sheet, sheetName, columns, i, writer, dbColumns);
                }
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\u001B[93m+ '"+sheetName+".sql' ["+Math.round(sizeInKiloBytes(new File(sheetName+".sql")))+" kb]\u001B[0m");
    }
    public static String convertToLowerCaseExceptFirst(String input) {
        return input.charAt(0) + input.substring(1).toLowerCase();
    }
    private static void excelValues(Sheet sheet, String sheetName, Integer[] columns, int i, Writer writer, String dbColumns) throws IOException {
        StringBuilder sql = new StringBuilder("INSERT INTO " + sheetName + "("+dbColumns+") VALUES (");
        Integer count = 0;
        for (Integer j : columns) {
            Cell cell = sheet.getRow(i).getCell(j);
            if (cell != null) {
                if (cell.getCellType() == CellType.STRING) {
                    String a = cell.getStringCellValue().replace("'", "''");
                    sql.append("'").append(convertToLowerCaseExceptFirst(a)).append("'");
                } else if (cell.getCellType() == CellType.NUMERIC) {
                    if (DateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
                        String c = dateFormat.format(date);
                        sql.append("δ'").append(c).append("'ε");
                    } else {
                        sql.append(cell.getNumericCellValue());
                    }
                }
            } else {
                sql.append("null");
            }
            if (count!=columns.length-1) sql.append(", ");
            count++;
        }
        sql.append(");");
        writer.write(sql.toString() + "\n");
    }






    public static void sqlInserts() {
        String folderPath = System.getProperty("user.dir");
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        int answer=0;
        File[] filexlsx = displayFiles(files,countXLSXFiles(files));

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
                        System.out.println("\u001B[90mMust be an Integer cannot be a String\u001B[0m");
                    }
                }

                if(answer!=0){

                    File file = filexlsx[answer-1];
                    System.out.println("\u001B[34m... \u001B[0m");
                    sqlInsertsOperation(file);

                }

            }
        }
    }

    private static int countXLSXFiles(File[] files) {
        int count = 0;

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".xlsx")) {
                    count++;
                }
            }
        }

        return count;
    }

    private static File[] displayFiles(File[] files,int total) {
        int i=1,answer=0;
        if (files != null) {
            File[] filexlsx = filexlsx = new File[total];
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".xlsx")) {
                    System.out.println("\u001B[0m" + i +". " + file.getName() + "\u001B[0m" );
                    filexlsx[i-1] = file;
                    i++;
                }
            }
            return filexlsx;

        }

        if(files == null || i==1) {
            System.out.println("\u001B[90mDoes not existe any CSV file or is not in the directory 'resources'.\u001B[0m");

        }
        return null;
    }






    public static String findFruit(String treeName) {
        try {
            String filePath = "docs/sprint2/BDDAD/usbd22/arvorefruto.json";

            Scanner scanner = new Scanner(new File(filePath));
            StringBuilder jsonContent = new StringBuilder();
            while (scanner.hasNextLine()) {
                jsonContent.append(scanner.nextLine());
            }
            scanner.close();

            String jsonString = jsonContent.toString();
            int treeIndex = jsonString.indexOf("\"" + treeName + "\":");
            if (treeIndex != -1) {
                int startIndex = jsonString.indexOf("\"", treeIndex + treeName.length() + 3);
                int endIndex = jsonString.indexOf("\"", startIndex + 1);
                return jsonString.substring(startIndex + 1, endIndex).toUpperCase();
            } else {
                return treeName.toUpperCase();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return treeName.toUpperCase();
        }
    }







}
