package org.isep_2dl_g121.ui;

import org.isep_2dl_g121.controller.CulturaListController;
import org.isep_2dl_g121.controller.OperacaoAgricolaRegisterController;
import org.isep_2dl_g121.domain.Cultura;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OperacaoAgricolaRegisterFatorProduçãoUI implements Runnable {

    private OperacaoAgricolaRegisterController controller;
    private CulturaListController culturaController;


    public OperacaoAgricolaRegisterFatorProduçãoUI() {
        controller = new OperacaoAgricolaRegisterController();
        culturaController = new CulturaListController();
    }

    public void run() {
        try {
            System.out.println("Registar uma nova Operação Agricola");

            Scanner scanner = new Scanner(System.in);
            //System.out.print("Tipo Operação: ");
            //String tipoOperacao = "Aplicação de fator produção";

            System.out.print("Caderno de Campo id: ");
            int id_caderno_campo = scanner.nextInt();

            System.out.print("Data de realização (dd-mm-yyyy): ");
            String strData = scanner.next();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date data_operacao = formatter.parse(strData);
            scanner.nextLine();

            System.out.print("Parcela Nome: ");
            String parcela_nome = scanner.nextLine();

            System.out.print("Fator Produção Nome: ");
            String fator_nome = scanner.nextLine();

            System.out.print("Quantidade Operação: ");
            double quantidade_operacao = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Unidade Operação: ");
            String unidade_operacao = scanner.nextLine();;

            System.out.print("Quantidade Fator Produção: ");
            double quantidade_fator= scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Unidade Fator Produção: ");
            String unidade_fator = scanner.nextLine();

            List<Cultura> culturaList = culturaController.getCulturasByParcelaOnly(parcela_nome,data_operacao);

            int answer = 1;
            if(culturaList.size()>1){
                int i = 1;
                answer = 0;
                while(answer<1 || answer> culturaList.size()){
                    for (Cultura cultura: culturaList) {
                        Date dataFim = cultura.getData_Fim();

                        if(dataFim == null) {
                            System.out.println(i + ". ID: " + cultura.getID() + " - Quantidade: " + cultura.getQuantidade() + " " + cultura.getUnidade()
                                    + " - Data Inicio: " + cultura.getData_Inicio().toString()
                                    + " - Data Fim: Indeterminado");
                        }
                        else{
                            System.out.println(i + ". ID: " + cultura.getID() + " - Quantidade: " + cultura.getQuantidade() + " " + cultura.getUnidade()
                                    + " - Data Inicio: " + cultura.getData_Inicio().toString()
                                    + " - Data Fim: " + cultura.getData_Fim().toString());
                        }
                        i++;
                    }
                    System.out.print("Opção: ");
                    answer = scanner.nextInt();
                }

            }
            if (culturaList.size() == 0){
                throw new IllegalArgumentException("Não existe culturas com essa parcela");
            }
            int cultura_id = culturaList.get(answer-1).getID();

//            System.out.println("id_caderno_campo: " + id_caderno_campo);
//            System.out.println("data_operacao: " + data_operacao);
//            System.out.println("quantidade_operacao: " + quantidade_operacao);
//            System.out.println("unidade_operacao: " + unidade_operacao);
//            System.out.println("quantidade_fator: " + quantidade_fator);
//            System.out.println("unidade_fator: " + unidade_fator);
//            System.out.println("cultura_id: " + cultura_id);
//            System.out.println("fator_nome: " + fator_nome);
//            System.out.println("parcela_nome: " + parcela_nome);


            controller.operacaoAgricolaRegisterFatorProdução(id_caderno_campo,data_operacao, quantidade_operacao,
                    unidade_operacao, quantidade_fator,unidade_fator,cultura_id,fator_nome,parcela_nome);

            System.out.println("\nOperacao Agricola registered.");;


        }
        catch (IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        catch (ParseException|SQLException e ) {
            System.out.println("\nOperacao Agricola not registered!\n" + e.getMessage());
        }
    }
}
