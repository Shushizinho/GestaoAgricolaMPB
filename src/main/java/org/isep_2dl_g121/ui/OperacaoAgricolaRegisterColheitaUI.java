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

public class OperacaoAgricolaRegisterColheitaUI implements Runnable {

    private OperacaoAgricolaRegisterController controller;

    private CulturaListController culturaController;

    public OperacaoAgricolaRegisterColheitaUI() {
        controller = new OperacaoAgricolaRegisterController();
        culturaController = new CulturaListController();
    }

    public void run() {
        try {
            System.out.println("Registar uma nova Operação Agricola");

            Scanner scanner = new Scanner(System.in);
            //System.out.print("Tipo Operação: ");
            String tipoOperacao = "Colheita";

            System.out.print("Caderno de Campo id: ");
            int id_caderno_campo = scanner.nextInt();

            System.out.print("Data de realização (dd-mm-yyyy): ");
            String strData = scanner.next();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date data_operacao = formatter.parse(strData);
            scanner.nextLine();



            //Não é necessario devido a poder ir buscar a cultura, mas por enquanto deixar para testes
            System.out.print("Parcela Nome: ");
            String parcela_nome = scanner.nextLine();

            System.out.print("Produto Agricola Nome: ");
            String produto_agricola_nome = scanner.nextLine();
            List<Cultura> culturaList = culturaController.getCulturasByParcela(parcela_nome,produto_agricola_nome,data_operacao);

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

            int cultura_id = 0;

                if (culturaList.size() == 0) throw new IllegalArgumentException("Não existe culturas com essa parcela e produto");

                cultura_id = culturaList.get(answer-1).getID();



            System.out.print("Quantidade do Produto: ");
            int quantidade_produto = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Unidade do Produto: ");
            String unidade_produto = scanner.next();

//            System.out.println();
//            System.out.println("tipoOperacao: " + tipoOperacao);
//            System.out.println("id_caderno_campo: " + id_caderno_campo);
//            System.out.println("data_operacao: " + data_operacao);
//            System.out.println("parcela_nome: " + parcela_nome);
//            System.out.println("produto_agricola_nome: " + produto_agricola_nome);
//            System.out.println("cultura_id: " + cultura_id);
//            System.out.println("quantidade_produto: " + quantidade_produto);
//            System.out.println("unidade_produto: " + unidade_produto);

            controller.operacaoAgricolaRegisterColheita(tipoOperacao, id_caderno_campo,data_operacao, parcela_nome,produto_agricola_nome,cultura_id,quantidade_produto,unidade_produto);
            System.out.println("\nOperacao Agricola registered.");;

        }
        catch (IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        catch ( ParseException | SQLException e ) {
            System.out.println("\nOperacao Agricola not registered!\n" + e.getMessage());
        }
    }
}
